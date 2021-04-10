package br.com.fiap.springkotlin.service

import br.com.fiap.springkotlin.dto.CreatePessoaDTO
import br.com.fiap.springkotlin.dto.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PessoaService {

    fun create(createPessoaDTO: CreatePessoaDTO): Mono<PessoaDTO>
    fun findAll(): Flux<PessoaDTO>

}