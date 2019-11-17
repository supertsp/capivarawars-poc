package br.com.capivarawarsmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapivaraWarsMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapivaraWarsMongoApplication.class, args);
        System.out.println("\n\n API Rest com MongoDB funcionando!!! :)\n\n");
    }

}
