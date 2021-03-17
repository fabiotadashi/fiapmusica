package br.com.fiap.fiapmusica.config;

import br.com.fiap.fiapmusica.component.MusicaValidator;
import br.com.fiap.fiapmusica.component.MusicaValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfiguration {

    @Bean
    public MusicaValidator musicaValidator(){
        return new MusicaValidatorImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
