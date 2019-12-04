import Validator from '../tool/Validator';

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 28/11/2019, 19:48:17
 * Last update: -
 */

export default class Canoa {

	tamanhoMax;
	tamanhoAtual;
	destruida;
	pedacos;

	constructor(tamanho) {
		if (Validator.isInteger(tamanho)) {
			this.tamanhoMax = tamanho;
			this.reiniciar();

			//atualiza atributo da classe
			this.isDestruida();
		}

		//Construtor sem parâmetros
		if (Validator.isUndefined(tamanho)) {
			this.tamanhoMax = 4;
			this.reiniciar();

			//atualiza atributo da classe
			this.isDestruida();
		}
	}

	reiniciar() {
		this.pedacos = new Array(this.getTamanhoMax());

		for (var cont = 0; cont < this.getTamanhoMax(); cont++) {
			this.pedacos[cont] = true;
		}

		this.tamanhoAtual = this.pedacos.length;

		this.destruida = false;
	}

	getTamanhoMax() {
		return this.tamanhoMax;
	}

	getTamanhoAtual() {
		this.tamanhoAtual = this.pedacos.length;
		return this.tamanhoAtual;
	}

	isDestruida() {
		if (this.getTamanhoAtual() === 0) {
			this.destruida = true;
		}
		else {
			this.destruida = false;
		}

		return this.destruida;
	}

	getPedaco(indicePedaco) {
		if (Validator.isInteger(indicePedaco)
			&& indicePedaco >= 0
			&& indicePedaco < this.getTamanhoAtual()) {

			return this.pedacos[indicePedaco];
		}

		return null;
	}

	destruirPedaco() {
		if (!this.isDestruida()) {
			this.pedacos.pop();

			//atualiza atributo da classe
			this.isDestruida();

			return true;
		}

		//atualiza atributo da classe
		this.isDestruida();
		return false;
	}

	destruirTodosPedacos() {
		this.pedacos = [];

		//atualiza atributo da classe
		this.isDestruida();

		this.destruida = true;
	}

	reconstruirTodosPedacos() {
		this.reiniciar();

		//atualiza atributo da classe
		this.isDestruida();

		this.destruida = false;
	}

	reconstruirPedaco() {
		if (this.getTamanhoAtual() < this.getTamanhoMax()) {
			this.pedacos.push(true);
		}

		//atualiza atributo da classe
		this.isDestruida();
	}

}