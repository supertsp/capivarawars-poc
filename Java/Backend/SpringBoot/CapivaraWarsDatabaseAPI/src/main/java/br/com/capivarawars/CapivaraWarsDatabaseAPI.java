package br.com.capivarawars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapivaraWarsDatabaseAPI {

    public static void main(String[] args) {
        SpringApplication.run(CapivaraWarsDatabaseAPI.class, args);

        System.out.println(
                "\n\n" +
                "         ^_^      ____    \n" +
                "  .-----/  0\\    (____)   \n" +
                " /  \\     __/    | DB |   \n" +
                " \\  /_- -/       (____)   \n" +
                "  \\\\\\  \\\\\\           \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                ">>> NOW, RUNNING A CAPIVARA SERVER DATABASE ON A RIVER API ;)\n"
        );
    }

}
