package br.com.CapivaraWars.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
	private LoginController controller;
	
	@Before
	public void setup() {
		controller = new LoginController();
	}
	
	@Test
	public void loginWithSuccess() {
		ResponseEntity<String> response = controller.validateLogin(new Credenciais("teste", "teste"));
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Success", response.getBody());
	}
	
	@Test
	public void loginWithFail() {
		ResponseEntity<String> response = controller.validateLogin(new Credenciais("login", "senha"));
		
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		assertEquals("Error", response.getBody());
	}
}
