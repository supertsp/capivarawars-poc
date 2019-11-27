package br.com.capivarawars.endpoint.config;

// <editor-fold defaultstate="collapsed" desc="imports...">
import java.util.List;
import java.util.ArrayList;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 25/11/2019, 22:04:17
 * Last update: -
 */// </editor-fold>
@Configuration
public class EnableCORS implements WebMvcConfigurer{	
	
	/**
	 * https://en.wikipedia.org/wiki/Cross-origin_resource_sharing
	 * https://cursos.alura.com.br/forum/topico-cors-error-89874
	 * http://andreybleme.com/2016-11-27/cors-spring/
	 */
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}
	
	
}//class
