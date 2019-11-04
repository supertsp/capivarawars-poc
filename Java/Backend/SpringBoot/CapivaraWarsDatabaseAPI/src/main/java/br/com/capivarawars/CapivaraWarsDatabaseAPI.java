package br.com.capivarawars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapivaraWarsDatabaseAPI {

    public static void main(String[] args) {
        SpringApplication.run(CapivaraWarsDatabaseAPI.class, args);

        System.out.println(
                "\n\n" +
                "         ^_^\n" +
                "  .-----/  0\\\n" +
                " /  \\     __/ \n" +
                " \\  /_- -/ \n" +
                "  \\\\\\  \\\\\\ \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                ">>> NOW, RUNNING A CAPIVARA SERVER ON A RIVER  ;)\n"
        );
    }

}
