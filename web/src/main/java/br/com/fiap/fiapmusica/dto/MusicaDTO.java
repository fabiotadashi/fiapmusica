package br.com.fiap.fiapmusica.dto;

import br.com.fiap.fiapmusica.entity.Musica;

import java.util.Date;

public class MusicaDTO {

    private int id;
    private String titulo;
    private int duracao;
    private String autor;
    private Date dataCriacao;
    private Date dataAtualizacao;

    public MusicaDTO(){}

    public MusicaDTO(Musica musica) {
        this.id = musica.getId();
        this.titulo = musica.getTitulo();
        this.autor = musica.getAutor();
        this.duracao = musica.getDuracao();
        this.dataCriacao = musica.getDataCriacao();
        this.dataAtualizacao = musica.getDataAtualizacao();
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
