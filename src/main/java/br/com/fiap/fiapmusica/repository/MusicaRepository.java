package br.com.fiap.fiapmusica.repository;

import br.com.fiap.fiapmusica.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {

    List<Musica> findAllByTituloLike(String titulo);

    @Query(value = "select m " +
            "from Musica m " +
            "where m.titulo like :titulo")
    List<Musica> buscarMusicasPorTitulo(String titulo);

}
