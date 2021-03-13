package br.com.fiap.fiapmusica.dto;

import br.com.fiap.fiapmusica.entity.Musica;

public class MusicaDTO {

    private int id;
    private String titulo;
    private int duracao;
    private String autor;

    public MusicaDTO(){}

    public MusicaDTO(Musica musica) {
        this.id = musica.getId();
        this.titulo = musica.getTitulo();
        this.autor = musica.getAutor();
        this.duracao = musica.getDuracao();
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
