import Validator from '../tool/Validator';
import Player from './Player';




/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 01/12/2019, 01:43:36
 * Last update: -
 */

export default class Partida {

	limiteDeJogadores;
	qtdAtualDeJogadores;
	turnoAtual;
	iniciou;
	terminou;
	indiceJogadorAtual;
	ultimasPosicoesMovimento;
	ultimasPosicoesTiro;

	//jogadores na partida
	jogadoresCadastradosNaPartida;
	jogadoresAtuaisNaPartida;

	//constantes
	static get PONTOS_EMPATE() {
		return 1;
	}

	static get PONTOS_VITORIA() {
		return 2;
	}

	//auxs
	empatou;
	empatantes;
	vencedor;

	constructor(limiteDeJogadores) {
		if (Validator.isInteger(limiteDeJogadores)) {
			this.setLimiteDeJogadores(limiteDeJogadores);
			this.jogadoresCadastradosNaPartida = [];
			this.reiniciarCampos();
		}

		//Construtor sem parâmetros
		if (Validator.isUndefined(limiteDeJogadores)) {
			this.setLimiteDeJogadores(2);
			this.jogadoresCadastradosNaPartida = [];
			this.reiniciarCampos();
		}
	}

	reiniciarCampos() {
		this.turnoAtual = 1;
		this.iniciou = false;
		this.terminou = false;
		this.indiceJogadorAtual = 0;

		this.jogadoresAtuaisNaPartida = [];

		for (let cont = 0; cont < this.getQtdAtualDeJogadores(); cont++) {
			this.getJogador(cont).restartBoat();
			this.jogadoresAtuaisNaPartida.push(this.getJogador(cont));
		}

		//Atualizando atributo
		this.getQtdAtualDeJogadores();



		this.ultimasPosicoesMovimento = [];
		this.ultimasPosicoesTiro = [];

		this.empatou = false;
		this.empatantes = [];
		this.vencedor = null;
	}

	getLimiteDeJogadores() {
		return this.limiteDeJogadores;
	}

	setLimiteDeJogadores(novoLimiteDeJogadores) {
		if (Validator.isInteger(novoLimiteDeJogadores)
			&& novoLimiteDeJogadores >= 2) {
			this.limiteDeJogadores = novoLimiteDeJogadores;
		}
		else {
			this.limiteDeJogadores = 2;
		}
	}

	getQtdAtualDeJogadores() {
		this.qtdAtualDeJogadores = this.jogadoresCadastradosNaPartida.length;
		return this.qtdAtualDeJogadores;
	}

	getTurnoAtual() {
		return this.turnoAtual;
	}

	incrementarTurnoAtual() {
		if (this.iniciou && !this.terminou) {
			this.turnoAtual++;
		}
	}

	isIniciou() {
		return this.iniciou;
	}


	//INICIAR
	iniciar() {
		if (!this.iniciou && !this.terminou
			&& this.getQtdAtualDeJogadores() >= 2) {
			this.iniciou = true;
			this.ultimasPosicoesMovimento = new Array(this.getQtdAtualDeJogadores());
			this.ultimasPosicoesTiro = new Array(this.getQtdAtualDeJogadores());
		}
	}

	isTerminou() {
		return this.terminou;
	}


	//TERMINAR
	terminar() {
		if (this.iniciou && !this.terminou) {
			this.terminou = true;
		}
	}

	getIndiceJogadorAtual() {
		//procura um jogador que não tenha sido removido
		let contJogador = 1;

		if (this.jogadoresAtuaisNaPartida.length > 0) {
			while (Validator.isUndefined(this.jogadoresAtuaisNaPartida[this.indiceJogadorAtual])) {
				this.incrementarIndiceJogadorAtual();

				//trava de seguranção para não rodar indefinidamente
				contJogador++;

				//chegou no limite de execução E todos jogadores foram removidos?
				if (contJogador === this.jogadoresAtuaisNaPartida.length) {
					return -1;
				}
			}
		}

		return this.indiceJogadorAtual;
	}

	getUltimoIndiceValidoParaJogadorAtual() {
		let ultimoIndiceValido = -1;

		//procura um jogador que não tenha sido removido		
		for (let indiceJogador = 0; indiceJogador < this.jogadoresAtuaisNaPartida.length; indiceJogador++) {
			if (!Validator.isUndefined(this.jogadoresAtuaisNaPartida[indiceJogador])) {
				ultimoIndiceValido = indiceJogador;
			}
		}

		return ultimoIndiceValido;
	}

	incrementarIndiceJogadorAtual() {
		this.indiceJogadorAtual++;
		this.indiceJogadorAtual = this.indiceJogadorAtual % this.getQtdAtualDeJogadores();
		// this.indiceJogadorAtual = this.indiceJogadorAtual >= this.getQtdAtualDeJogadores() ? 0 : this.indiceJogadorAtual;
	}

	addJogador(novoJogador) {
		if (this.getQtdAtualDeJogadores() <= this.getLimiteDeJogadores()
			&& novoJogador instanceof Player
			&& !this.iniciou && !this.terminou) {

			this.jogadoresCadastradosNaPartida.push(novoJogador);
			this.jogadoresAtuaisNaPartida.push(novoJogador);
		}

		//Atualizando atributo
		this.getQtdAtualDeJogadores();

		return this;
	}

	getJogador(indiceJogador) {
		if (Validator.isInteger(indiceJogador)
			&& indiceJogador >= 0
			&& indiceJogador < this.getQtdAtualDeJogadores()) {

			return this.jogadoresCadastradosNaPartida[indiceJogador];
		}

		return null;
	}

	getJogadorAtual() {
		const indiceTemp = this.getIndiceJogadorAtual();

		if (indiceTemp === -1) {
			return null;
		}

		return this.jogadoresAtuaisNaPartida[indiceTemp];
	}


	//ULTIMAS POSIÇÕES
	getUltimasPosicoesMovimento() {
		return this.ultimasPosicoesMovimento;
	}

	getUltimasPosicoesTiro() {
		return this.ultimasPosicoesTiro;
	}

	//MOVER
	moverCanoaDoJogadorAtual(indicePosicaoNoRio) {
		//evita strings dos forms
		try {
			indicePosicaoNoRio = parseInt(indicePosicaoNoRio);
		} catch (error) { }

		if (Validator.isInteger(indicePosicaoNoRio)
			&& this.iniciou && !this.terminou) {

			this.getJogadorAtual().moveBoat(indicePosicaoNoRio);

			this.ultimasPosicoesMovimento[this.getIndiceJogadorAtual()] = indicePosicaoNoRio;

			this.incrementarIndiceJogadorAtual();
		}
	}


	//ATIRAR
	atirarNoInimigoDoJogadorAtual(indicePosicaoDoTiro, jogadorInimigo) {
		//evita strings dos forms
		try {
			indicePosicaoDoTiro = parseInt(indicePosicaoDoTiro);
		} catch (error) { }

		if (Validator.isInteger(indicePosicaoDoTiro)
			&& jogadorInimigo instanceof Player
			&& this.iniciou && !this.terminou) {

			let tiroCerteiro = this.getJogadorAtual().shootAtEnemy(
				indicePosicaoDoTiro,
				jogadorInimigo
			);

			this.ultimasPosicoesTiro[this.indiceJogadorAtual] = indicePosicaoDoTiro;

			this.validarFechamentoDeTurno();

			this.incrementarIndiceJogadorAtual();

			return tiroCerteiro;
		}

		return false;
	}

	validarFechamentoDeTurno() {
		const ultimoIndiceValido = this.getUltimoIndiceValidoParaJogadorAtual();

		//é o último jogador?
		if (ultimoIndiceValido !== -1 && ultimoIndiceValido === this.indiceJogadorAtual) {
			this.incrementarTurnoAtual();

			//procurando baixas
			this.empatantes = [];
			let jogadoresRestantes = [];
			let indiceJogadorVencedor = -1;

			for (let indiceJogador = 0; indiceJogador < this.jogadoresAtuaisNaPartida.length; indiceJogador++) {
				if (!Validator.isUndefined(this.jogadoresAtuaisNaPartida[indiceJogador])
					&& this.jogadoresAtuaisNaPartida[indiceJogador].isBoatDestroyed()) {

					delete this.jogadoresAtuaisNaPartida[indiceJogador];
					this.jogadoresCadastradosNaPartida[indiceJogador].setDamageToCapybara();

					//adiciona possíveis empatantes
					this.empatantes.push(this.jogadoresCadastradosNaPartida[indiceJogador]);
				}
				else if (!Validator.isUndefined(this.jogadoresAtuaisNaPartida[indiceJogador])
					&& !this.jogadoresAtuaisNaPartida[indiceJogador].isBoatDestroyed()) {

					//adiciona possível vitorioso
					jogadoresRestantes.push(this.jogadoresCadastradosNaPartida[indiceJogador]);
					indiceJogadorVencedor = indiceJogador;
				}
			}

			//houve empate?
			if (jogadoresRestantes.length === 0) {
				this.terminar();
				this.empatou = true;
				let acheiEmpatante = false;

				for (let indiceJogador = 0; indiceJogador < this.jogadoresCadastradosNaPartida.length; indiceJogador++) {
					for (let indiceJogadorEmpatante = 0; indiceJogadorEmpatante < this.empatantes.length; indiceJogadorEmpatante++) {

						if (this.empatantes[indiceJogadorEmpatante].getNick() ===
							this.jogadoresCadastradosNaPartida[indiceJogador].getNick()) {

							acheiEmpatante = true;
							break;
						}
						else {
							acheiEmpatante = false;
						}
					}

					if (acheiEmpatante) {
						this.jogadoresCadastradosNaPartida[indiceJogador].incrementDraws();
						this.jogadoresCadastradosNaPartida[indiceJogador].incrementScore(Partida.PONTOS_EMPATE);
					}
					else {
						this.jogadoresCadastradosNaPartida[indiceJogador].incrementLosses();
					}
				}

			}//houve 1 vencedor
			else if (jogadoresRestantes.length === 1) {
				this.terminar();
				this.vencedor = jogadoresRestantes[0];

				for (let indiceJogador = 0; indiceJogador < this.jogadoresCadastradosNaPartida.length; indiceJogador++) {
					if (this.jogadoresCadastradosNaPartida[indiceJogador].getNick() ===
						this.vencedor.getNick()) {
						this.jogadoresCadastradosNaPartida[indiceJogador].incrementWins();
						this.jogadoresCadastradosNaPartida[indiceJogador].incrementScore(Partida.PONTOS_VITORIA);
					}
					else {
						this.jogadoresCadastradosNaPartida[indiceJogador].incrementLosses();
					}
				}
			}
		}
	}

	isEmpatou() {
		if (this.iniciou && this.terminou && this.empatou) {
			return true;
		}

		return false;
	}

	getEmpatantes() {
		if (this.iniciou && this.terminou && this.empatou) {
			return this.empatantes;
		}

		return null;
	}

	getVencedor() {
		if (this.iniciou && this.terminou && !this.empatou) {
			return this.vencedor;
		}

		return null;
	}

	toString() {
		let text =
			`\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n` +
			`       PARTIDA\n` +
			`   Turno: ${this.getTurnoAtual()}\n` +
			`   Iniciou? ${this.isIniciou()}\n` +
			`   Terminou? ${this.isTerminou()}\n`;

		for (
			let contJogador = 0;
			contJogador < this.getQtdAtualDeJogadores();
			contJogador++
		) {
			text +=
				`` +
				`\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n` +
				`${this.getJogador(contJogador).toString()}\n` +
				`Mov.: ${this.ultimasPosicoesMovimento[contJogador]}\n` +
				`Tiro: ${this.ultimasPosicoesTiro[contJogador]}\n`;
		}

		text += `\n`;

		return text;
	}

}