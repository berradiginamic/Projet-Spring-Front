package fr.diginamic.projetspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication

public class ProjetSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringApplication.class, args);
    }
}

