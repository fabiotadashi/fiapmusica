package br.com.fiap.fiapmusica.controller;

import br.com.fiap.fiapmusica.dto.MusicaDTO;
import br.com.fiap.fiapmusica.dto.MusicaTituloDTO;
import br.com.fiap.fiapmusica.dto.NovaMusicaDTO;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;
import br.com.fiap.fiapmusica.service.MusicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("musicas")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService){
        this.musicaService = musicaService;
    }

    @GetMapping
    @ApiOperation(value = "Busca musicas e filtra, opcionalmente, por titulo")
    public List<SimpleMusicaDTO> getMusicas(
            @RequestParam(required = false) String titulo
    ) {
        return musicaService.getMusica(titulo);
    }

    @GetMapping("{id}")
    public MusicaDTO getMusicaById(
            @PathVariable int id
    ) {
        return musicaService.getMusicaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDTO criarMusica(
            @RequestBody NovaMusicaDTO novaMusica
    ) {
        return musicaService.criarMusica(novaMusica);
    }

    @PutMapping("{id}")
    public MusicaDTO atualizarMusica(
            @PathVariable int id,
            @RequestBody NovaMusicaDTO novaMusicaDTO
    ) {
        return musicaService.atualizarMusica(id, novaMusicaDTO);
    }

    @PatchMapping("{id}")
    public MusicaDTO atualizarTitulo(
            @PathVariable int id,
            @RequestBody MusicaTituloDTO musicaTituloDTO
    ) {
        return musicaService.atualizarTitulo(id, musicaTituloDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMusica(
            @PathVariable int id
    ){
        musicaService.deletarMusica(id);
    }

}
