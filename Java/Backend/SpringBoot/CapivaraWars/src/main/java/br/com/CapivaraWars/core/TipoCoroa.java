package br.com.CapivaraWars.core;

public enum TipoCoroa {
	
	REGIONAL("Regional"),
	ESTADUAL("Estadual"),
	NACIONAL("Nacional"),
	MUNDIAL("Mundial"),
	NATAL("Natal"),
	HALLOWEEN("Halloween"),
	DIANAMORADOS("Dia dos Namorados"),
	CAPRICORNIO("Capric�rnio");
	
	
	private String texto;
	
	private TipoCoroa(String textoEnum) {
		texto = textoEnum;
	}
	
	public String getTexto() {
		return texto;
	}
	
}
