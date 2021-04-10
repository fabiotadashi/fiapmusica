package br.com.fiap.fiapmusica.service;

import br.com.fiap.fiapmusica.component.MusicaValidator;
import br.com.fiap.fiapmusica.dto.MusicaDTO;
import br.com.fiap.fiapmusica.dto.MusicaTituloDTO;
import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;
import br.com.fiap.fiapmusica.entity.Musica;
import br.com.fiap.fiapmusica.repository.MusicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaServiceImpl implements MusicaService {

    private final MusicaValidator musicaValidator;
    private final MusicaRepository musicaRepository;

    public MusicaServiceImpl(MusicaValidator musicaValidator,
                             MusicaRepository musicaRepository) {
        this.musicaValidator = musicaValidator;
        this.musicaRepository = musicaRepository;
    }

    @Override
    public List<SimpleMusicaDTO> getMusica(String titulo) {
        List<Musica> musicaList;

        if (titulo == null) {
            musicaList = musicaRepository.findAll();
        } else {
            musicaList = musicaRepository.findAllByTituloLike("%" + titulo + "%");
        }

        return musicaList.stream()
                .map(SimpleMusicaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public MusicaDTO getMusicaById(int id) {
        Musica musica = findMusicaById(id);
        return new MusicaDTO(musica);
    }

    @Override
    public MusicaDTO criarMusica(NovaMusicaDTO novaMusicaDTO) {
        Musica musica = new Musica(novaMusicaDTO);
        Musica musicaSalva = musicaRepository.save(musica);
        return new MusicaDTO(musicaSalva);
    }

    @Override
    public MusicaDTO atualizarMusica(int id, NovaMusicaDTO novaMusicaDTO) {
        Musica musica = findMusicaById(id);
        musica.setTitulo(novaMusicaDTO.getTitulo());
        musica.setAutor(novaMusicaDTO.getAutor());
        musica.setDuracao(novaMusicaDTO.getDuracao());

        Musica musicaSalva = musicaRepository.save(musica);

        return new MusicaDTO(musicaSalva);
    }

    @Override
    public MusicaDTO atualizarTitulo(int id, MusicaTituloDTO musicaTituloDTO) {
        Musica musica = findMusicaById(id);
        musica.setTitulo(musicaTituloDTO.getTitulo());
        Musica musicaSalva = musicaRepository.save(musica);
        return new MusicaDTO(musicaSalva);
    }

    @Override
    public void deletarMusica(int id) {
        findMusicaById(id);
        musicaRepository.deleteById(id);
    }

    private Musica findMusicaById(int id) {
        return musicaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
