package br.com.fiap.springkotlin.repository

import br.com.fiap.springkotlin.entity.PessoaEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PessoaRepository : ReactiveMongoRepository<PessoaEntity, String>