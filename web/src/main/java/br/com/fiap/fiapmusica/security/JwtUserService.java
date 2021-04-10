package br.com.fiap.fiapmusica.security;

import br.com.fiap.fiapmusica.entity.Usuario;
import br.com.fiap.fiapmusica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public JwtUserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findFirstByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado " + username);
        }
        return new User(
                usuario.getNome(),
                usuario.getSenha(),
                new ArrayList<>()); // ROLES
    }

}
