package br.com.capivarawars.endpoint.handler;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.endpoint.EndpointsMapping;
import static br.com.capivarawars.endpoint.EndpointsMapping.*;
import br.com.capivarawars.model.Jogador;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 09/11/2019, 22:21:29 Last update: -
 *///</editor-fold>
@RestController
@RequestMapping(API_AUTHENTICATION)
public class AuthenticationEndpoint {

	//<editor-fold defaultstate="collapsed" desc="attributes...">
	private RestTemplate restTemplate;

	//</editor-fold>
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="constructors...">
	public AuthenticationEndpoint() {
		restTemplate = new RestTemplate();
	}
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="methods...">

	/**
	 * CREATE
	 *
	 */
	/**
	 * SEARCH
	 *
	 */
	/**
	 * UPDATE
	 *
	 */
	/**
	 * DELETE
	 *
	 */
	/**
	 * CHECK
	 *
	 */
	@PostMapping(API_AUTHENTICATION_LOGIN)
	public ResponseEntity<Jogador> login(@RequestHeader String nick, @RequestHeader String senha) {
		String urlCheckCredentials = URL_DATABASE_API_CHECK_ONE_BY_NICK_AND_SENHA;
		String urlSearchJogador = URL_DATABASE_API_SEARCH_ONE_BY_NICK + nick;

		//adicionando Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("nick", nick);
		headers.add("senha", senha);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<Boolean> respostaLogin = restTemplate.exchange(urlCheckCredentials, HttpMethod.GET, entity, Boolean.class);

		if (respostaLogin.getBody() != null) {
			Jogador jogadorProcurado = restTemplate.getForEntity(urlSearchJogador, Jogador.class).getBody();

			if (jogadorProcurado.isOnline()) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
			} else {
				String urlSetJogadorOnline = String.format(
						URL_DATABASE_API_UPDATE_ONE_ONLINE,
						jogadorProcurado.getIdJogador(), "true"
				);
				System.out.println("\n\n" + urlSetJogadorOnline + "\n");
				
				RestTemplate tempRestTemplate = new RestTemplate();
				tempRestTemplate.put(urlSetJogadorOnline, null);
				
				
				
				
				
//				RestTemplate tempRestTemplate = new RestTemplate();
//				Boolean sucess = tempRestTemplate.patchForObject(urlSetJogadorOnline, null, Boolean.class);
				
				
//				restTemplate = new RestTemplate();
//				String response = restTemplate.exchange(urlCheckCredentials, HttpMethod.PATCH, entity, String.class).getBody();
				

//				HttpHeaders httpHeaders = new HttpHeaders();
//				MediaType mediaType = new MediaType("application", "merge-patch+json");
//				httpHeaders.setContentType(mediaType);
//				
//				Boolean sucess = null;
//				
//				HttpEntity<Boolean> httpEntity = new HttpEntity<>(sucess, httpHeaders);
//				HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//				RestTemplate restTemplateForPatch = new RestTemplate(requestFactory);
//
//				restTemplateForPatch.exchange(urlSetJogadorOnline, HttpMethod.PATCH, httpEntity, Void.class);
//				System.out.println("\n\nResponse: " + sucess + "\n");
//				
				
				System.out.println("\n\nResponse: OK\n");
//				System.out.println("\n\nResponse: " + response + "\n");

				return ResponseEntity.ok(jogadorProcurado);
			}

		}

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}

	//</editor-fold>
}//class
