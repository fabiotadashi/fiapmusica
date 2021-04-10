package br.com.fiap.springkotlin

import br.com.fiap.springkotlin.config.CloudConfigProperties
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [CloudConfigProperties::class])
class SpringkotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringkotlinApplication>(*args)
}
