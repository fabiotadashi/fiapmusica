package br.com.fiap.springkotlin.service

import br.com.fiap.springkotlin.config.CloudConfigProperties
import br.com.fiap.springkotlin.dto.CreatePessoaDTO
import br.com.fiap.springkotlin.dto.PessoaDTO
import br.com.fiap.springkotlin.entity.PessoaEntity
import br.com.fiap.springkotlin.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class PessoaServiceImpl(
        val pessoaRepository: PessoaRepository,
        val cloudConfigProperties: CloudConfigProperties
) : PessoaService {

    override fun create(createPessoaDTO: CreatePessoaDTO) = Mono.just(createPessoaDTO)
            .map { PessoaEntity(nome = it.nome) }
            .flatMap { pessoaRepository.save(it) }
            .map { PessoaDTO(id = it.id ?: throw Exception("Entity sem id"), nome = it.nome) }

    override fun findAll() = pessoaRepository.findAll()
            .map {
                PessoaDTO(
                        id = it.id ?: throw Exception("Entity sem id"),
                        nome = "${cloudConfigProperties.remoteFile} ${it.nome}"
                )
            }
            .delayElements(Duration.ofSeconds(1))

}
