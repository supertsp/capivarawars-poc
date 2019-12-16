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
			this.gender = gender;
			this.online = online;
			this.score = 0;
			this.wins = wins;
			this.losses = losses;
			this.draws = draws;
			this.capybara = new Capivara(capybaraName, 7);
			this.setCapybaraName(capybaraName);
			this.setCapybaraColor(capybaraColor);
			this.setCapybaraLife(capybaraLife);
			this.river = new Rio(riverSize, new Canoa(boatSize));
		}

		//Construtor sem parâmetros
		if (Validator.isUndefined(nick)
			|| Validator.isUndefined(capybaraName)
			|| Validator.isUndefined(riverSize)
			|| Validator.isUndefined(boatSize)) {

			this.capybara = new Capivara('', 7);
			this.river = new Rio(10, new Canoa(4));
		}
	}

	setJsonFields(jsonPlayerObject) {
		if (jsonPlayerObject instanceof Object) {
			this.setIdPlayer(jsonPlayerObject.idPlayer);
			this.setNick(jsonPlayerObject.nick);
			this.setGender(jsonPlayerObject.gender);
			this.setOnline(jsonPlayerObject.online);
			this.setScore(jsonPlayerObject.score);
			this.setWins(jsonPlayerObject.wins);
			this.setLosses(jsonPlayerObject.losses);
			this.setDraws(jsonPlayerObject.draws);
			this.setCapybaraName(jsonPlayerObject.capybaraName);
			this.setCapybaraColor(jsonPlayerObject.capybaraColor);
			this.setCapybaraLife(jsonPlayerObject.capybaraLife);
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

		return this;
	}


	//GENDER
	getGender() {
		return this.gender;
	}

	setGender(newGender) {
		this.gender = newGender;

		return this;
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

	incrementScore(scorePoints = 0) {
		if (Validator.isInteger(scorePoints)) {
			this.score += scorePoints;
		}

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

		return this;
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

		return this;
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
		this.capybaraName = this.capybara.getNome();
		return this.capybaraName;
	}

	setCapybaraName(newName) {
		if (Validator.isString(newName)) {
			this.capybaraName = newName;
			this.capybara.setNome(newName);
		}

		return this;
	}

	getCapybaraColor() {
		this.capybaraColor = this.capybara.getCor();
		return this.capybaraColor;
	}

	setCapybaraColor(colorName) {
		if (Validator.isString(colorName)) {
			this.capybaraColor = colorName
			this.capybara.setCor(colorName);
		}

		return this;
	}

	getCapybaraLife() {
		this.capybaraLife = this.getCapybara().getVida();
		return this.capybaraLife;
	}

	setCapybaraLife(newLife) {
		if (Validator.isInteger(newLife)) {
			this.capybaraLife = newLife;
			this.capybara.setVida(newLife);
		}

		return this;
	}

	setDamageToCapybara() {
		this.capybara.receberDano();

		//update field
		this.getCapybaraLife();

		return this;
	}

	isCapybaraDeath() {
		return this.capybara.isMorta();
	}

	//RIVER
	getRiver() {
		return this.river;
	}

	getRiverParts() {
		return this.river.getPartes();
	}

	getRiverLength() {
		return this.getRiver().getTamanhoAtual();
	}

	getBoatPositionOnRiver() {
		return this.getRiver().getPosicaoAtualCanoa();
	}

	//BOAT
	getBoat() {
		return this.river.getCanoa();
	}

	getBoatPieces() {
		return this.getBoat().getPedacos();
	}

	getBoatLength() {
		return this.getBoat().getTamanhoAtual();
	}

	isBoatDestroyed() {
		return this.river.isVazio();
	}


	//RIO + CANOA
	moveBoat(posicaoNoRio) {
		this.river.moverCanoa(posicaoNoRio);
	}

	shootAtEnemy(posicaoDoTiro, jogadorInimigo) {
		if (Validator.isInteger(posicaoDoTiro) && jogadorInimigo instanceof Player) {
			return jogadorInimigo.getRiver().receberTiro(posicaoDoTiro);
		}

		return false;
	}

	toString() {
		let jogadorTxt =
			`       Player '${this.getNick()}'\n` +
			` id: ${this.getIdPlayer()}   score: ${this.getScore()}\n`;
		let capivaraTxt =
			`\n       Capybara '${this.getCapybaraName()}'\n` +
			` life: ${this.getCapybaraLife()}  death: ${this.isCapybaraDeath()} \n`;
		let rioTxt = `\nRiver (${this.getRiver().getTamanhoAtual()}): `;
		let canoaTxt = `Boat   (${this.getBoat().getTamanhoAtual()}): `;
		let canoaDestruidaTxt = ` - destroyed: ${this.isBoatDestroyed()}`;

		for (let cont = 0; cont < this.getRiver().getTamanhoAtual(); cont++) {
			if (this.getRiver().getParte(cont)) {
				rioTxt += '[O]';
			}
			else {
				rioTxt += '[~]';
			}
		}
		rioTxt += '\n';

		for (let cont = 0; cont < this.getBoat().getTamanhoAtual(); cont++) {
			if (this.getBoat().getPedaco(cont)) {
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
