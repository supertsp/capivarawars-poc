package br.com.capivarawars;

//<editor-fold defaultstate="collapsed" desc="imports...">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import feign.Client;
import org.springframework.cloud.openfeign.EnableFeignClients;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 *///</editor-fold>
@SpringBootApplication
@EnableFeignClients
public class CapivaraWarsExampleServiceAPI {

	public static void main(String[] args) {
		SpringApplication.run(CapivaraWarsExampleServiceAPI.class, args);

		System.out.println(
				"\n\n"
				+ "         ^_^    +---------+        \n"
				+ "  .-----/  0\\   | SIGN IN |       \n"
				+ " /  \\     __/   +---------+       \n"
				+ " \\  /_- -/      |  NICK   |       \n"
				+ "  \\\\\\  \\\\\\      |  PASS   |  \n"
				+ "~~~~~~~~~~~~~~~~+~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ " >>> NOW, RUNNING A " + CapivaraWarsExampleServiceAPI.class.getSimpleName() + " ON A RIVER API ;)\n"
		);
	}

}//class
