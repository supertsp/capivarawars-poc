package br.com.CapivaraWars.core;

public class Coroa {
	
	protected String nome;
	protected TipoCoroa tipoCoroa;
	protected int xp;
	
	public Coroa(String nome, TipoCoroa tipoCoroa, int xp) {
		this.nome = nome;
		this.tipoCoroa = tipoCoroa;
		this.xp = xp;
	}

	public String getNome() {
		return nome;
	}

	public TipoCoroa getTipoCoroa() {
		return tipoCoroa;
	}

	public int getXp() {
		return xp;
	}

	@Override
	public String toString() {
		return "Coroa{ "
				+ " nome= " + nome 
				+ ", tipoCoroa= " + tipoCoroa + " \"" + tipoCoroa.getTexto() + "\"" 
				+ ", xp=" + xp 
				+ "}";
	}
	
	
}
