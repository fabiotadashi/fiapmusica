package br.com.fiap.fiapmusica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FiapmusicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapmusicaApplication.class, args);
    }

}
