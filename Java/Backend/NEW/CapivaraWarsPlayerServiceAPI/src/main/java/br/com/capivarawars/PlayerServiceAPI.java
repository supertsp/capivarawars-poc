package br.com.capivarawars;

// <editor-fold defaultstate="collapsed" desc="imports...">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;

import feign.Client;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
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
@EnableSwagger2
public class PlayerServiceAPI {	
	
	private static String apiName = "Player Service";
	private static int serverPort = 8082;
		
	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceAPI.class, args);
		 
		System.out.println("\n\n"
				+ "                                                                        \n"
				+ "                       //                                               \n"
				+ "         ^_^        ///-\\\\\\                                             \n"
				+ "  .-----/  0\\       |O   O|                                             \n"
				+ " /  \\     __/       |  ^  |                                             \n"
				+ " \\  /_- -/           \\ O /                                              \n"
				+ "  \\\\\\  \\\\\\            | |                                               \n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "\\    Now, Running a    <" + apiName + ":" + serverPort + ">    On a River API ;)\n"
				+ " \\   " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n"
				+ "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n\n\n"
		);
	}
	
	@Bean
	public Docket swaggerConfigurations(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
//				.paths(PathSelectors.ant(API_PLAYER_SERVICE + "/*"))
				.apis(RequestHandlerSelectors.basePackage("br.com.capivarawars.endpoint"))			
				.build()
				.apiInfo(createApiInfo());
	}
	
	private ApiInfo createApiInfo(){
		return new ApiInfo(
				"Player Service API", 
				"Manage player data: CRUD and Login", 
				API_VERSION, 
				"Free to use", 
				new Contact(
						"Tiago Penha Pedroso", 
						"https://github.com/supertsp", 
						"tiago.souza.pedroso@gmail.com"), 
				"GNU LESSER GENERAL PUBLIC LICENSE", 
				"https://www.gnu.org/licenses/lgpl-3.0.txt", 
				Collections.emptyList()
		);
	}
	
	
}//class
