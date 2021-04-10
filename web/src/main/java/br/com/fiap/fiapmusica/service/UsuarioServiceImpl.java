package br.com.fiap.fiapmusica.service;

import br.com.fiap.fiapmusica.dto.CreateUserDTO;
import br.com.fiap.fiapmusica.dto.JwtDTO;
import br.com.fiap.fiapmusica.dto.LoginDTO;
import br.com.fiap.fiapmusica.dto.UserDTO;
import br.com.fiap.fiapmusica.entity.Usuario;
import br.com.fiap.fiapmusica.repository.UsuarioRepository;
import br.com.fiap.fiapmusica.security.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(
            AuthenticationManager authenticationManager,
            JwtTokenUtil jwtTokenUtil,
            PasswordEncoder passwordEncoder,
            UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public JwtDTO login(LoginDTO loginDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getNome(),
                            loginDTO.getSenha()
                    )
            );
        } catch (DisabledException disabledException) {
            throw new Exception("Usuario desabilitado", disabledException);
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Credenciais Inválidas", badCredentialsException);
        }

        String token = jwtTokenUtil.generateToken(loginDTO.getNome());

        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setToken(token);

        return jwtDTO;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(createUserDTO.getNome());
        usuario.setSenha(passwordEncoder.encode(createUserDTO.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UserDTO(usuarioSalvo);
    }
}
