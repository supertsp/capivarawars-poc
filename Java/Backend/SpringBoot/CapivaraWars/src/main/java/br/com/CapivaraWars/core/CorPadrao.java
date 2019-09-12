package br.com.CapivaraWars.core;

public enum CorPadrao {
	
	MARROM("803300ff"),
	BRANCO("ffffffff"),
	PRETO("1a1a1aff"),
	VERMELHO("ff0035ff"),
	AZUL("1498ccff"),
	AMARELO("fff319ff"),
	ROXO("aa00d4ff"),
	TRANSPARENTE("ffffff00");
	
	private String codigoHexa;
	
	private CorPadrao(String codigoHexa) {
		this.codigoHexa = codigoHexa;
	}
	
	public String getCodigoHexa() {
		return codigoHexa;
	}
	
}