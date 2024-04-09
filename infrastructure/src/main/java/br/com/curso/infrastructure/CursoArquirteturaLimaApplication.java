package br.com.curso.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CursoArquirteturaLimaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CursoArquirteturaLimaApplication.class, args);
    }
}