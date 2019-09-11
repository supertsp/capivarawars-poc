package br.com.CapivaraWars.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.CapivaraWars.core.Jogador;

public class LoginControllerTest {
	private AcessoController controller;
	
	@Before
	public void setup() {
		controller = new AcessoController();
	}
	
	@Test
	public void loginWithSuccess() {
//		ResponseEntity<String> response = controller.validateLogin(new Jogador("teste", "teste"));
//		
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals("Success", response.getBody());
	}
	
	@Test
	public void loginWithFail() {
//		ResponseEntity<String> response = controller.validateLogin(new Jogador("login", "senha"));
//		
//		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	}
}
