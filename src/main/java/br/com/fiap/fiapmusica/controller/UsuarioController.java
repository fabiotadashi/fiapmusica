package br.com.fiap.fiapmusica.controller;

import br.com.fiap.fiapmusica.dto.CreateUserDTO;
import br.com.fiap.fiapmusica.dto.JwtDTO;
import br.com.fiap.fiapmusica.dto.LoginDTO;
import br.com.fiap.fiapmusica.dto.UserDTO;
import br.com.fiap.fiapmusica.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("login")
    public JwtDTO login(
            @RequestBody LoginDTO loginDTO
    ) throws Exception {
        return usuarioService.login(loginDTO);
    }

    @PostMapping
    public UserDTO create(
            @RequestBody CreateUserDTO createUserDTO
    ) {
        return usuarioService.create(createUserDTO);
    }

}
