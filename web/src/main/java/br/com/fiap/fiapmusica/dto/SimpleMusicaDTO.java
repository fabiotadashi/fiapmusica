package br.com.fiap.fiapmusica.dto;

import br.com.fiap.fiapmusica.entity.Musica;

public class SimpleMusicaDTO {

    private int id;
    private String titulo;

    public SimpleMusicaDTO(){}

    public SimpleMusicaDTO(Musica musica) {
        this.id = musica.getId();
        this.titulo = musica.getTitulo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
