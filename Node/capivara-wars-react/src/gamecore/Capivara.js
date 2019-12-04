import Validator from '../tool/Validator';
import BarraDeVida from './BarraDeVida';

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 30/11/2019, 19:47:29
 * Last update: -
 */

export default class Capivara {

	nome;
	corRGBA;
	morta;
	barraDeVida;

	constructor(nome, valorMaxParaVida) {
		if (Validator.isString(nome)
			&& Validator.isNumber(valorMaxParaVida)) {

			this.nome = nome;
			this.setCorRGBA();
			this.morta = false;
			this.barraDeVida = new BarraDeVida(valorMaxParaVida);
		}

		//Construtor sem parâmetros
		if (Validator.isUndefined(nome) || Validator.isUndefined(valorMaxParaVida)) {
			this.nome = "Capii";
			this.setCorRGBA();
			this.morta = false;
			this.barraDeVida = new BarraDeVida(7);
		}
	}

	getNome() {
		return this.nome;
	}

	getCorRGBA() {
		return this.corRGBA;
	}

	setCorRGBA(novaCorRGBA) {
		if (Validator.isRgbaValue(novaCorRGBA)) {
			this.this.corRGBA = novaCorRGBA;
		}
		else {
			this.corRGBA = '#a05a2cff'; //marrom
		}
	}

	getVida() {
		return this.barraDeVida.getVida();
	}

	receberDano() {
		this.barraDeVida.diminuir();

		//Atualiza atributo
		this.isMorta();
	}

	morrer() {
		this.barraDeVida.zerar();

		//Atualiza atributo
		this.isMorta();
	}

	regenerarPontoDeVida() {
		this.barraDeVida.aumentar();

		//Atualiza atributo
		this.isMorta();
	}

	regenerar() {
		this.barraDeVida.encher();

		//Atualiza atributo
		this.isMorta();
	}

	isMorta() {
		if (this.barraDeVida.isVazia()) {
			this.morta = true;
			return this.morta;
		}

		this.morta = false;
		return this.morta;
	}

	isViva() {
		if (this.barraDeVida.getVida() > 0) {
			this.morta = false;
			return true;
		}

		this.morta = true;
		return false;
	}

}
