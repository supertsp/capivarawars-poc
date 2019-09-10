package br.com.kingsofriver;

public class PlayGame {

	public static void main(String[] args) {
		
		BarraEnergia<Float> barra = new BarraEnergia<>(10f, 50f);
		System.out.println(barra);
		
		barra.incrementarValorAtual();
		System.out.println(barra);
		
		
	}

}
