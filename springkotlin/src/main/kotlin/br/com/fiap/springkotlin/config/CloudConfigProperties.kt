package br.com.fiap.springkotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(value = "propriedade")
class CloudConfigProperties {

    var remoteFile: String? = null

}
