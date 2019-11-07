package br.com.capivarawars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapivaraWars {

    public static void main(String[] args) {
        SpringApplication.run(CapivaraWars.class, args);

        System.out.println(
                "\n"
                + "╔═╗\n"
                + "║ ║   NOW, RUNNING A CAPIVARA SERVER  ;)    \n"
                + "╚════════════════════════════════════════════════╝\n"
        );
    }

}
