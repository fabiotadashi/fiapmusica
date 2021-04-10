package br.com.fiap.fiapmusica.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    public static final String BEARER = "Bearer ";
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserService userService;
    private Logger logger = Logger.getLogger(JwtRequestFilter.class.getName());

    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil,
                            JwtUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");
        String username = null;
        String jwtToken;

        if (headerToken != null && headerToken.startsWith(BEARER)) {
            jwtToken = headerToken.replace(BEARER, "");
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException illegalArgumentException) {
                logger.info("Erro ao fazer parse do token");
            } catch (ExpiredJwtException expiredJwtException) {
                logger.info("Token expirado");
            }
        } else {
            logger.info("Token é nulo ou não tem o padrão Bearer");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

        filterChain.doFilter(request, response);
    }
}
