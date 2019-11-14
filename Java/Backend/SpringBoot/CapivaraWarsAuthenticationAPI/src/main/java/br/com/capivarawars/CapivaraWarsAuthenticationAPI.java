package br.com.capivarawars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapivaraWarsAuthenticationAPI {

    public static void main(String[] args) {
        SpringApplication.run(CapivaraWarsAuthenticationAPI.class, args);

        System.out.println(
                "\n\n" +
                "         ^_^    +---------+        \n" +
                "  .-----/  0\\   | SIGN IN |       \n" +
                " /  \\     __/   +---------+       \n" +
                " \\  /_- -/      |  NICK   |       \n" +
                "  \\\\\\  \\\\\\      |  PASS   |  \n" +
                "~~~~~~~~~~~~~~~~+~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                ">>> NOW, RUNNING A CAPIVARA SERVER DATABASE ON A RIVER API ;)\n"
        );
    }

}
