package br.com.capivarawars.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credencial {
	
	@JsonProperty
	private String usuario;
	
	@JsonProperty
	private String senha;
	
	public Credencial() {
		
	}
	
	public Credencial(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
		
}
