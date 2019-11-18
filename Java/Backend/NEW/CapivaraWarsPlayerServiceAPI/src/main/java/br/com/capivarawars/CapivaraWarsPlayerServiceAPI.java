package br.com.capivarawars;

// <editor-fold defaultstate="collapsed" desc="imports...">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import feign.Client;
import org.springframework.cloud.openfeign.EnableFeignClients;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 */// </editor-fold>
@SpringBootApplication
@EnableFeignClients
public class CapivaraWarsPlayerServiceAPI {

	public static void main(String[] args) {
		SpringApplication.run(CapivaraWarsPlayerServiceAPI.class, args);

		System.out.println("\n\n"
				+ "         ^_^         _                                                  \n"
				+ "  .-----/  0\\       / \\                                                 \n"
				+ " /  \\     __/      °***°                                                \n"
				+ " \\  /_- -/        ( 0 0 )                                               \n"
				+ "  \\\\\\  \\\\\\         \\ = /                                                \n"
				+ "~~~~~~~~~~~~~~~~~~~~¨¨¨~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ " >>> NOW, RUNNING A " + CapivaraWarsPlayerServiceAPI.class.getSimpleName() + " ON A RIVER API ;)\n"
		);
	}

}//class
