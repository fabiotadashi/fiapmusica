package br.com.fiap.fiapmusica.dto;

import br.com.fiap.fiapmusica.entity.Usuario;

import java.util.Date;

public class UserDTO {

    private int id;
    private String nome;
    private Date dataCriacao;
    private Date dataAtualizacao;

    public UserDTO(){}

    public UserDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataCriacao = usuario.getDataCriacao();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
