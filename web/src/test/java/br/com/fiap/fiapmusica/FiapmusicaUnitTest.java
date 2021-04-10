package br.com.fiap.fiapmusica;

import br.com.fiap.fiapmusica.component.MusicaValidatorImpl;
import br.com.fiap.fiapmusica.controller.MusicaController;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;
import br.com.fiap.fiapmusica.service.MusicaService;
import br.com.fiap.fiapmusica.service.MusicaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

public class FiapmusicaUnitTest {

    @Mock
    private MusicaService musicaService;

    @Test
    public void getMusicaDeveRetornarApenasUmaMusicaComTitulo(){
        MusicaController musicaController = new MusicaController(musicaService);

        List<SimpleMusicaDTO> musicaList = musicaController.getMusicas("Voce");

        Assertions.assertEquals(1, musicaList.size());
        Assertions.assertEquals(2 ,musicaList.get(0).getId());
    }

}
