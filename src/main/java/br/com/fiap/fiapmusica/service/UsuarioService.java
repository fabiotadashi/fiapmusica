package br.com.fiap.fiapmusica.service;

import br.com.fiap.fiapmusica.dto.CreateUserDTO;
import br.com.fiap.fiapmusica.dto.JwtDTO;
import br.com.fiap.fiapmusica.dto.LoginDTO;
import br.com.fiap.fiapmusica.dto.UserDTO;

public interface UsuarioService {

    JwtDTO login(LoginDTO loginDTO) throws Exception;
    UserDTO create(CreateUserDTO createUserDTO);

}
