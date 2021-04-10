package br.com.fiap.springkotlin

import br.com.fiap.springkotlin.dto.CreatePessoaDTO
import br.com.fiap.springkotlin.service.PessoaService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("pessoas")
class PessoaController (
        private val pessoaService: PessoaService
){

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findAll() = pessoaService.findAll()

    @PostMapping
    fun create(@RequestBody createPessoaDTO: CreatePessoaDTO) = pessoaService.create(createPessoaDTO)

}