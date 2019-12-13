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

	idPlayer;
	nick;
	gender;
	online;
	score;
	wins;
	losses;
	draws;
	capybaraName;
	capybaraColor;
	capybaraLife;

	//aux
	capybara;
	river;

	constructor(
		idPlayer, nick, gender, online, score, wins, losses, draws,
		capybaraName, capybaraColor, capybaraLife, riverSize, boatSize) {

		if (Validator.isInteger(idPlayer)
			&& Validator.isString(nick)
			&& Validator.isString(gender)
			&& Validator.isBoolean(online)
			&& Validator.isInteger(score)
			&& Validator.isInteger(wins)
			&& Validator.isInteger(losses)
			&& Validator.isInteger(draws)
			&& Validator.isString(capybaraName)
			&& Validator.isString(capybaraColor)
			&& Validator.isString(capybaraLife)
			&& Validator.isInteger(riverSize)
			&& Validator.isInteger(boatSize)) {

			this.setIdPlayer(0);
			this.nick = nick;
			this.score = 0;
			this.capybara = new Capivara(capybaraName, 7);
			this.river = new Rio(riverSize, new Canoa(boatSize));


		}

		//Construtor sem parâmetros
		if (Validator.isUndefined(nick)
			|| Validator.isUndefined(capybaraName)
			|| Validator.isUndefined(riverSize)
			|| Validator.isUndefined(boatSize)) {

			this.setIdPlayer(0);
			this.nick = 'nick' + parseInt(Math.random() * 1000);
			this.score = 0;
			this.capybara = new Capivara();
			this.river = new Rio(riverSize, new Canoa());


		}
	}

	restartBoat() {
		this.river.reiniciar();
	}


	//ID PLAYER
	getIdPlayer() {
		return this.idPlayer;
	}

	setIdPlayer(newIdPlayer) {
		if (Validator.isInteger(newIdPlayer)) {
			this.idPlayer = newIdPlayer;
		}
		else {
			this.idPlayer = 0;
		}

		return this;
	}


	//NICK
	getNick() {
		return this.nick;
	}

	setNick(newNick) {
		if (Validator.isString(newNick)) {
			this.nick = newNick;
		}
	}


	//GENDER
	getGender() {
		return this.gender;
	}

	setGender(newGender) {
		this.gender = newGender;
	}


	//ONLINE
	isOnline() {
		return this.online;
	}

	setOnline(status) {
		if (Validator.isBoolean(status)) {
			this.online = status;
		}

		return this;
	}


	//SCORE
	getScore() {
		return this.score;
	}

	setScore(newScore) {
		if (Validator.isInteger(newScore)) {
			this.score = newScore;
		}
		else {
			this.score = 0;
		}

		return this;
	}

	incrementScore() {
		this.score++;
		return this;
	}

	decrementScore() {
		this.score--;
		this.score = this.score < 0 ? 0 : this.score;
		return this;
	}


	//WINS
	getWins() {
		if (Validator.isUndefined(this.wins)) {
			this.wins = 0;
		}

		return this.wins;
	}

	setWins(newValue) {
		if (Validator.isInteger(newValue)) {
			this.wins = newValue;
		}

		return this;
	}

	incrementWins() {
		if (Validator.isUndefined(this.wins)) {
			this.wins = 0;
		}

		this.wins++;
	}


	//LOSSES
	getLosses() {
		if (Validator.isUndefined(this.losses)) {
			this.losses = 0;
		}

		return this.losses;
	}

	setLosses(newValue) {
		if (Validator.isInteger(newValue)) {
			this.losses = newValue;
		}

		return this;
	}

	incrementLosses() {
		if (Validator.isUndefined(this.losses)) {
			this.losses = 0;
		}

		this.losses++;
	}


	//DRAWS
	getDraws() {
		if (Validator.isUndefined(this.draws)) {
			this.draws = 0;
		}

		return this.draws;
	}

	setDraws(newValue) {
		if (Validator.isInteger(newValue)) {
			this.draws = newValue;
		}

		return this;
	}

	incrementDraws() {
		if (Validator.isUndefined(this.draws)) {
			this.draws = 0;
		}

		this.draws++;
	}


	//CAPYBARA
	getCapybara() {
		return this.capybara;
	}

	setCapybara(newCapybara) {
		if (newCapybara instanceof Capivara) {
			this.capybara = newCapybara;
		}

		return this;
	}


	getCapybaraName() {
		return this.capybara.getNome();
	}

	setCapybaraName(newName) {
		if (Validator.isString(newName)) {
			this.capybaraName = newName;
			this.capybara.setNome(newName);
		}
	}

	getCapybaraColor() {
		return this.capybara.getCor();
	}

	setCapybaraColor(colorName) {
		if (Validator.isString(colorName)) {
			this.capybaraColor = colorName
			this.capybara.setCor(colorName);
		}

		return this;
	}

	getCapybaraLife() {
		return this.getCapybara().getVida();
	}

	setCapybaraLife(newLife) {
		if (Validator.isInteger(newLife)) {
			this.capybaraLife = newLife;
			this.getCapybara().setVida(newLife);
		}
	}



	reduzirVidaCapivara() {
		this.getCapybara().receberDano();
	}


	/**
	 *
		capybaraName;
		capybaraColor;
		capybaraLife;
	 * 
	 */






	getRio() {
		return this.river;
	}

	getCanoa() {
		return this.river.getCanoa();
	}

	isCanoaDestruida() {
		return this.river.isVazio();
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
		let jogadorTxt = `Jogador ${this.getIdPlayer()}: '${this.getNick()}'   -  Pontos: ${this.getScore()}\n`;
		let capivaraTxt = `   Capivara '${this.getCapybara().getNome()}'  - Vida: ${this.getCapybaraLife()}  - Está morta? ${this.isCapybaraDeath()} \n`;
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
