package br.com.fiap.fiapmusica.entity;

import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MUSICA")
@EntityListeners(AuditingEntityListener.class)
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private int duracao;

    private String autor;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CreatedDate
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    @LastModifiedDate
    private Date dataAtualizacao;

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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCricao) {
        this.dataCriacao = dataCricao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
