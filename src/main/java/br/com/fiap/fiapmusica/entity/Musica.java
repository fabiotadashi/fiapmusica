package br.com.fiap.fiapmusica.entity;

import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;

import javax.persistence.*;

@Entity
@Table(name = "TB_MUSICA")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private int duracao;

    private String autor;

    public Musica(){}

    public Musica(NovaMusicaDTO novaMusicaDTO) {
        this.titulo = novaMusicaDTO.getTitulo();
        this.autor = novaMusicaDTO.getAutor();
        this.duracao = novaMusicaDTO.getDuracao();
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
