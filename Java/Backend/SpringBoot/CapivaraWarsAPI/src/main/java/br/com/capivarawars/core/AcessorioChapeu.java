package br.com.capivarawars.core;

public class AcessorioChapeu implements TipoAcessorio{
	
	private Posicao posicao;
	private String nome;	
	
	public AcessorioChapeu(int x, int y, String nome) {
		this.posicao = new Posicao(x, y);
		this.nome = nome;
	}

	@Override
	public Posicao getPosicao() {
		return posicao;
	}
	
	@Override
	public String getNomeAcessorio() {
		return nome;
	}

	

}
