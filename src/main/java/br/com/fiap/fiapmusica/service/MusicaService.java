package br.com.fiap.fiapmusica.service;

import br.com.fiap.fiapmusica.dto.MusicaDTO;
import br.com.fiap.fiapmusica.dto.MusicaTituloDTO;
import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;

import java.util.List;

public interface MusicaService {

        List<SimpleMusicaDTO> getMusica(String titulo);
        MusicaDTO getMusicaById(int id);
        MusicaDTO criarMusica(NovaMusicaDTO novaMusicaDTO);
        MusicaDTO atualizarMusica(int id, NovaMusicaDTO novaMusicaDTO);
        MusicaDTO atualizarTitulo(int id, MusicaTituloDTO musicaTituloDTO);
        void deletarMusica(int id);

}
