package br.com.fiap.springkotlin.entity

import br.com.fiap.springkotlin.dto.CreatePessoaDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PessoaEntity (

        @Id
        val id: String? = null,

        val nome: String

)