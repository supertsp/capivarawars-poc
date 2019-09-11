package br.com.CapivaraWars.core;

public class Posicao {
	
	private float x, y;
	
	public static final Posicao ZERO = new Posicao(); 
	public static final Posicao CIMA = new Posicao(0, 1); 
	public static final Posicao BAIXO = new Posicao(0, -1); 
	public static final Posicao DIREITA = new Posicao(1, 0); 
	public static final Posicao ESQUERDA = new Posicao(-1, 0); 
	
	
	public Posicao() {
		
	}
	
	public Posicao(float x, float y) {
		this();
		set(x, y);
	}

	public float getX() {
		return x;
	}
	
	public int getIntX() {
		return (int)x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}
	
	public float getIntY() {
		return (int)y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void set(float x, float y) {
		setX(x);
		setY(y);
	}
	
	public void incrementarX(float x) {
		setX(getX() + x);
	}
	
	public void incrementarY(float y) {
		setY(getY() + y);
	}
	
	public void incrementar(float x, float y) {
		incrementarX(x);
		incrementarY(y);
	}

	@Override
	public String toString() {
		return "Posicao{ " + x + ", " + y + " }";
	}
	
	
	
}
