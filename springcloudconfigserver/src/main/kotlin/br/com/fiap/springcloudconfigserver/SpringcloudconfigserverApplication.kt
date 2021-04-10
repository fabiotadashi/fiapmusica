package br.com.fiap.springcloudconfigserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class SpringcloudconfigserverApplication

fun main(args: Array<String>) {
	runApplication<SpringcloudconfigserverApplication>(*args)
}
