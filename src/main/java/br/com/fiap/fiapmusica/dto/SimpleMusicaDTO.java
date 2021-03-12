package br.com.fiap.fiapmusica.dto;

public class SimpleMusicaDTO {

    private int id;
    private String titulo;

    public SimpleMusicaDTO(){}

    public SimpleMusicaDTO(MusicaDTO musicaDTO){
        this.id = musicaDTO.getId();
        this.titulo = musicaDTO.getTitulo();
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
