package br.com.CapivaraWars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@PostMapping("/login")
	public ResponseEntity<String> validateLogin(@RequestBody Credenciais credenciais){
		if(credenciais.getSenha().equals(credenciais.getLogin())) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}
}
