import Validator from '../tool/Validator';
import Canoa from './Canoa';
import Rio from './Rio';
import Capivara from './Capivara';

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 30/11/2019, 19:47:29
 * Last update: -
 */

export default class Player {

	id;
	nick;
	score;
	capybara;
	gender;
	river;
	vitorias;
	derrotas;
	empates

	constructor(id, nick, genero, pontos, nomeCapivara, tamanhoRio, tamanhoCanoa) {
		console.log(nick);
		console.log(nomeCapivara);
		console.log(tamanhoRio);
		console.log(tamanhoCanoa);

		if (Validator.isString(nick)
			&& Validator.isInteger(tamanhoRio)
			&& Validator.isInteger(tamanhoCanoa)
			&& Validator.isString(nomeCapivara)) {

			this.setId(0);
			this.nick = nick;
			this.score = 0;
			this.capybara = new Capivara(nomeCapivara, 7);
			this.river = new Rio(tamanhoRio, new Canoa(tamanhoCanoa));


		}

		//Construtor sem parâmetros
		if (Validator.isUndefined(nick)
			|| Validator.isUndefined(nomeCapivara)
			|| Validator.isUndefined(tamanhoRio)
			|| Validator.isUndefined(tamanhoCanoa)) {

			this.setId(0);
			this.nick = 'nick' + parseInt(Math.random() * 1000);
			this.score = 0;
			this.capybara = new Capivara();
			this.river = new Rio(tamanhoRio, new Canoa());


		}
	}

	reiniciarCanoa() {
		this.river.reiniciar();
	}

	getId() {
		return this.id;
	}

	setId(novoId) {
		if (Validator.isInteger(novoId)) {
			this.id = novoId;
		}
		else {
			this.id = 0;
		}

		return this;
	}

	getNick() {
		return this.nick;
	}

	getPontos() {
		return this.score;
	}

	setPontos(novosPontos) {
		if (Validator.isInteger(novosPontos)) {
			this.score = novosPontos;
		}
		else {
			this.id = 0;
		}

		return this;
	}

	incrementarPontos() {
		this.score++;
		return this;
	}

	decrementarPontos() {
		this.score--;
		this.score = this.score < 0 ? 0 : this.score;
		return this;
	}

	getCapivara() {
		return this.capybara;
	}

	isCapivaraMorta() {
		return this.getCapivara().isMorta();
	}

	setCorCapivara(nomeDaCor) {
		this.capybara.setCor(nomeDaCor);
	}

	getNomeCapivara() {
		return this.capybara.getNome();
	}

	getCorCapivara() {
		return this.capybara.getCor();
	}

	getVidaCapivara() {
		return this.getCapivara().getVida();
	}

	reduzirVidaCapivara() {
		this.getCapivara().receberDano();
	}

	setGenero(genero) {
		this.gender = genero;
	}

	getGenero() {
		return this.gender;
	}

	getRio() {
		return this.river;
	}

	getCanoa() {
		return this.river.getCanoa();
	}

	isCanoaDestruida() {
		return this.river.isVazio();
	}


	//VITÓRIAS
	getVitorias() {
		if (Validator.isUndefined(this.vitorias)) {
			this.vitorias = 0;
		}

		return this.vitorias;
	}

	setVitorias(novoValor) {
		if (Validator.isInteger(novoValor)) {
			this.vitorias = novoValor;
		}

		return this;
	}

	incrementarVitorias() {
		if (Validator.isUndefined(this.vitorias)) {
			this.vitorias = 0;
		}

		this.vitorias++;
	}

	//DERROTAS
	getDerrotas() {
		if (Validator.isUndefined(this.derrotas)) {
			this.derrotas = 0;
		}

		return this.derrotas;
	}

	setDerrotas(novoValor) {
		if (Validator.isInteger(novoValor)) {
			this.derrotas = novoValor;
		}

		return this;
	}

	incrementarDerrotas() {
		if (Validator.isUndefined(this.derrotas)) {
			this.derrotas = 0;
		}

		this.derrotas++;
	}

	//EMPATES
	getEmpates() {
		if (Validator.isUndefined(this.empates)) {
			this.empates = 0;
		}

		return this.empates;
	}

	setEmpates(novoValor) {
		if (Validator.isInteger(novoValor)) {
			this.empates = novoValor;
		}

		return this;
	}

	incrementarEmpates() {
		if (Validator.isUndefined(this.empates)) {
			this.empates = 0;
		}

		this.empates++;
	}



	//RIO + CANOA
	moverCanoa(posicaoNoRio) {
		this.river.moverCanoa(posicaoNoRio);
	}

	atirarNoInimigo(posicaoDoTiro, jogadorInimigo) {
		if (Validator.isInteger(posicaoDoTiro) && jogadorInimigo instanceof Player) {
			return jogadorInimigo.getRio().receberTiro(posicaoDoTiro);
		}

		return false;
	}

	toString() {
		let jogadorTxt = `Jogador ${this.getId()}: '${this.getNick()}'   -  Pontos: ${this.getPontos()}\n`;
		let capivaraTxt = `   Capivara '${this.getCapivara().getNome()}'  - Vida: ${this.getVidaCapivara()}  - Está morta? ${this.isCapivaraMorta()} \n`;
		let rioTxt = `   Rio (${this.getRio().getTamanhoAtual()}): `;
		let canoaTxt = `   Canoa (${this.getCanoa().getTamanhoAtual()}): `;
		let canoaDestruidaTxt = `   -   Está Destruida? ${this.isCanoaDestruida()}`;

		for (let cont = 0; cont < this.getRio().getTamanhoAtual(); cont++) {
			if (this.getRio().getParte(cont)) {
				rioTxt += '[O]';
			}
			else {
				rioTxt += '[~]';
			}
		}
		rioTxt += '\n';

		for (let cont = 0; cont < this.getCanoa().getTamanhoAtual(); cont++) {
			if (this.getCanoa().getPedaco(cont)) {
				canoaTxt += '[O]';
			}
			else {
				canoaTxt += '[~]';
			}
		}
		canoaTxt += canoaDestruidaTxt;

		return jogadorTxt + capivaraTxt + rioTxt + canoaTxt;
	}
}
