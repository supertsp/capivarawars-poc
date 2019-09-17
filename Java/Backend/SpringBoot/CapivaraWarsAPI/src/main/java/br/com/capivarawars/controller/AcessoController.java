package br.com.capivarawars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.capivarawars.core.Jogador;
import br.com.capivarawars.database.ListaJogadores;

@RestController
public class AcessoController {
	
	private ListaJogadores listaJogadores = new ListaJogadores();
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Jogador> cadastrarJogador(@RequestBody Jogador jogador) {
		listaJogadores.adicionar(jogador);
		return ResponseEntity.ok(jogador);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credencial credencial) {
		Jogador procurado = listaJogadores.procurarPorUsuario(credencial.getUsuario());
		
		if (procurado == null) { 			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					"Infelizmente esse usuário não existe... :(  Tente cadastrar um novo Jogador"
					);
		}
		
		procurado = listaJogadores.procurar(credencial);
		
		if (procurado == null) { 			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					"Infelizmente sua senha está errada... :'(  Tente digitar novamente"
			);
		}
		
		if (procurado.isOnline()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					procurado.getUsuario() + ", você já está online... 8)"
			);
		}
		procurado.setOnline(true);
		return ResponseEntity.ok("Login Efetuado :)");
	}
	
	@PostMapping("/logout/{usuario}")
	public ResponseEntity<String> validarLogout(@PathVariable("usuario") String usuario) {
		Jogador procurado = listaJogadores.procurarPorUsuario(usuario);
		
		if (procurado != null) {
			if (procurado.isOnline()) {
				procurado.setOnline(false);
				return ResponseEntity.ok("Logout Efetuado :)");
			}
			else {
				return ResponseEntity.ok("Esse usuário ainda não efetuou o login :O");
			}
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
				"Infelizmente esse usuário não existe... :(  Tente cadastrar um novo Jogador"
		);
	}
	
}
