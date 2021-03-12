package br.com.fiap.fiapmusica;

import br.com.fiap.fiapmusica.controller.MusicaController;
import br.com.fiap.fiapmusica.dto.SimpleMusicaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FiapmusicaUnitTest {

    @Test
    public void getMusicaDeveRetornarApenasUmaMusicaComTitulo(){
        MusicaController musicaController = new MusicaController();

        List<SimpleMusicaDTO> musicaList = musicaController.getMusicas("Voce");

        Assertions.assertEquals(1, musicaList.size());
        Assertions.assertEquals(2 ,musicaList.get(0).getId());
    }

}
