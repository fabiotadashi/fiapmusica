package br.com.fiap.fiapmusica.service;

import br.com.fiap.fiapmusica.component.MusicaValidator;
import br.com.fiap.fiapmusica.dto.MusicaDTO;
import br.com.fiap.fiapmusica.dto.MusicaTituloDTO;
import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements MusicaService {

    private final MusicaValidator musicaValidator;

    public MusicaServiceImpl(MusicaValidator musicaValidator){
        this.musicaValidator = musicaValidator;
    }

    @Override
    public List<SimpleMusicaDTO> getMusica(String titulo) {
        return null;
    }

    @Override
    public MusicaDTO getMusicaById(int id) {
        return null;
    }

    @Override
    public MusicaDTO criarMusica(NovaMusicaDTO novaMusicaDTO) {
        return null;
    }

    @Override
    public MusicaDTO atualizarMusica(int id, NovaMusicaDTO novaMusicaDTO) {
        return null;
    }

    @Override
    public MusicaDTO atualizarTitulo(int id, MusicaTituloDTO musicaTituloDTO) {
        return null;
    }

    @Override
    public void deletarMusica(int id) {

    }
}
