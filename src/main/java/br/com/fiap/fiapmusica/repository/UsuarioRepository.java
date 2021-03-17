package br.com.fiap.fiapmusica.repository;

import br.com.fiap.fiapmusica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findFirstByNome(String nome);

}
