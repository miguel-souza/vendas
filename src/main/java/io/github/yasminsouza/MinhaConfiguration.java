package io.github.yasminsouza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Dev
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("EXECUTANDO A CONFIGURAÇÃO EM DESENVOLVIMENTO");
        };
    }
}
