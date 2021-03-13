package br.com.fiap.fiapmusica.config;

import br.com.fiap.fiapmusica.component.MusicaValidator;
import br.com.fiap.fiapmusica.component.MusicaValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public MusicaValidator musicaValidator(){
        return new MusicaValidatorImpl();
    }

}
