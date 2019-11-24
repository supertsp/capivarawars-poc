package br.com.capivarawars;

// <editor-fold defaultstate="collapsed" desc="imports...">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;

import feign.Client;
import java.time.LocalDateTime;
import java.util.Collections;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
				+ " >>> " + LocalDateTime.now() + "\n\n"
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
