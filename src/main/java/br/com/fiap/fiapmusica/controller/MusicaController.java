package br.com.fiap.fiapmusica.controller;

import br.com.fiap.fiapmusica.dto.MusicaDTO;
import br.com.fiap.fiapmusica.dto.MusicaTituloDTO;
import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musicas")
public class MusicaController {

    private List<MusicaDTO> musicaMockList = new ArrayList<>();

    public MusicaController() {
        MusicaDTO musicaDTO1 = new MusicaDTO();
        musicaDTO1.setId(1);
        musicaDTO1.setTitulo("Sozinho");
        musicaDTO1.setDuracao(180);
        musicaDTO1.setAutor("Caetano Veloso");

        MusicaDTO musicaDTO2 = new MusicaDTO();
        musicaDTO2.setId(2);
        musicaDTO2.setTitulo("Voce");
        musicaDTO2.setDuracao(190);
        musicaDTO2.setAutor("Tim Maia");

        musicaMockList.add(musicaDTO1);
        musicaMockList.add(musicaDTO2);
    }

    @GetMapping
    public List<SimpleMusicaDTO> getMusicas(
            @RequestParam(required = false) String titulo
    ) {
        return musicaMockList.stream()
                .filter(musicaDTO -> titulo == null || musicaDTO.getTitulo().contains(titulo))
                .map(musicaDTO -> new SimpleMusicaDTO(musicaDTO))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MusicaDTO getMusicaById(
            @PathVariable int id
    ) {
        return getMusicaEncontradaDTO(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDTO criarMusica(
            @RequestBody NovaMusicaDTO novaMusica
    ) {
        MusicaDTO musicaDTO = new MusicaDTO();
        musicaDTO.setId(musicaMockList.size() + 1);
        musicaDTO.setTitulo(novaMusica.getTitulo());
        musicaDTO.setDuracao(novaMusica.getDuracao());
        musicaDTO.setAutor(novaMusica.getAutor());

        musicaMockList.add(musicaDTO);
        return musicaDTO;
    }

    @PutMapping("{id}")
    public MusicaDTO atualizarMusica(
            @PathVariable int id,
            @RequestBody NovaMusicaDTO novaMusicaDTO
    ) {
        MusicaDTO musicaEncontradaDTO = getMusicaEncontradaDTO(id);

        musicaEncontradaDTO.setAutor(novaMusicaDTO.getAutor());
        musicaEncontradaDTO.setTitulo(novaMusicaDTO.getTitulo());
        musicaEncontradaDTO.setDuracao(novaMusicaDTO.getDuracao());

        return musicaEncontradaDTO;
    }

    @PatchMapping("{id}")
    public MusicaDTO atualizarTitulo(
            @PathVariable int id,
            @RequestBody MusicaTituloDTO musicaTituloDTO
    ) {
        MusicaDTO musicaEncontradaDTO = getMusicaEncontradaDTO(id);
        musicaEncontradaDTO.setTitulo(musicaTituloDTO.getTitulo());

        return musicaEncontradaDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMusica(
            @PathVariable int id
    ){
        MusicaDTO musicaEncontradaDTO = getMusicaEncontradaDTO(id);
        musicaMockList.remove(musicaEncontradaDTO);
    }

    private MusicaDTO getMusicaEncontradaDTO(@PathVariable int id) {
        return musicaMockList.stream()
                .filter(musicaDTO -> musicaDTO.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
