package br.com.kingsofriver;

public enum TipoCoroa {
	
	REGIONAL("Regional"),
	ESTADUAL("Estadual"),
	NACIONAL("Nacional"),
	MUNDIAL("Mundial"),
	NATAL("Natal"),
	HALLOWEEN("Halloween"),
	DIANAMORADOS("Dia dos Namorados"),
	CAPRICORNIO("Capricórnio");
	
	
	private String texto;
	
	private TipoCoroa(String textoEnum) {
		texto = textoEnum;
	}
	
	public String getTexto() {
		return texto;
	}
	
}
