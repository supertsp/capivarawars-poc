package br.com.capivarawars.endpoint.handler;

import br.com.capivarawars.endpoint.service.DataBaseAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
@EnableFeignClients
public class FeignClientConfiguration {

	@Value("${apidatabase.url}")
	private String urlDatabaseAPI;

//	@Bean
//	public RequestInterceptor requestInterceptor() {
//		return new RequestInterceptor() {
//			@Override
//			public void apply(RequestTemplate template) {
//				template.header("access_token", accessToken);
//				template.header("client_id", clientId);
//			}
//		};
//	}
	@Bean
	public DataBaseAPIClient dataBaseAPIClient() {
//	public DataBaseAPIClient dataBaseAPIClient(@Autowired RequestInterceptor requestInterceptor) {
		return Feign.builder().encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(DataBaseAPIClient.class, urlDatabaseAPI);
	}

}
