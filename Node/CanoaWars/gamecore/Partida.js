const Validator = require('../tool/Validator');
const Canoa = require('./Canoa');
const Rio = require('./Rio');
const Capivara = require('./Capivara');
const Jogador = require('./Jogador');

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 01/12/2019, 01:43:36
 * Last update: -
 */

class Partida{
	
	limiteDeJogadores;
	qtdAtualDeJogadores;
	turnoAtual;
	iniciou;
	terminou;
	indiceJogadorAtual;
	jogadores;
	
	constructor(limiteDeJogadores){
		if (Validator.isInteger(limiteDeJogadores)) {
			this.setLimiteDeJogadores(limiteDeJogadores);
			this.jogadores = [];
			this.reiniciar();
		}
		
		//Construtor sem parâmetros
		if (Validator.isUndefined(limiteDeJogadores)) {
			this.setLimiteDeJogadores(2);
			this.jogadores = [];
			this.reiniciar();
		}
	}

	reiniciar(){
		this.turnoAtual = 0;
		this.iniciou = false;
		this.terminou = false;
		this.indiceJogadorAtual = 0;
		
		for (let cont = 0; cont < this.getQtdAtualDeJogadores(); cont++) {console.log("qtdJogadores: " + this.getQtdAtualDeJogadores());
			this.getJogador(cont).reiniciarCanoa();
		}
		
		//Atualizando atributo
		this.getQtdAtualDeJogadores();
	}
	
	getLimiteDeJogadores(){
		return this.limiteDeJogadores;
	}
	
	setLimiteDeJogadores(novoLimiteDeJogadores){
		if (Validator.isInteger(novoLimiteDeJogadores)
				&& novoLimiteDeJogadores >= 2) {
			this.limiteDeJogadores = novoLimiteDeJogadores;
		}
		else{
			this.limiteDeJogadores = 2;
		}
	}
	
	getQtdAtualDeJogadores(){
		this.qtdAtualDeJogadores = this.jogadores.length;
		return this.qtdAtualDeJogadores;
	}
	
	getTurnoAtual(){
		return this.turnoAtual;
	}
	
	incrementarTurnoAtual(){
		if (this.isIniciou() && !this.isTerminou()) {
			this.turnoAtual++;
		}
	}
	
	isIniciou(){
		return this.iniciou;
	}
	
	iniciar(){
		if (!this.isIniciou() && !this.isTerminou()
				&& this.getQtdAtualDeJogadores() >= 2) {
			this.iniciou = true;
		}
	}
	
	isTerminou(){
		return this.terminou;
	}
	
	terminar(){
		if (this.isIniciou() && !this.isTerminou()
				&& this.getQtdAtualDeJogadores() >= 2) {
			this.terminou = true;
		}
	}
	
	getIndiceJogadorAtual(){
		return this.indiceJogadorAtual;
	}
	
	addJogador(novoJogador){
		if (this.getQtdAtualDeJogadores() <= this.getLimiteDeJogadores()
				&& novoJogador instanceof Jogador
				&& !this.isIniciou() && !this.isTerminou()) {
			
			this.jogadores.push(novoJogador);			
		}
		
		//Atualizando atributo
		this.getQtdAtualDeJogadores();
		
		return this;
	}
	
	getJogador(indiceJogador){
		if (Validator.isInteger(indiceJogador)
				&& indiceJogador >= 0
				&& indiceJogador < this.getQtdAtualDeJogadores()) {
			
			return this.jogadores[indiceJogador];
		}
		
		return null;
	}
	
	getJogadorAtual(){
		return this.getJogador(this.getIndiceJogadorAtual());
	}
	
	moverCanoaDoJogadorAtual(indicePosicaoNoRio){
		if (Validator.isInteger(indicePosicaoNoRio)
				&& this.isIniciou() && !this.isTerminou()){
			
			this.getJogadorAtual().moverCanoa(indicePosicaoNoRio);
			this.indiceJogadorAtual++;
			this.indiceJogadorAtual = this.indiceJogadorAtual % this.getQtdAtualDeJogadores();
		}
	}
	
	atirarNoInimigoDoJogadorAtual(indicePosicaoDoTiro, jogadorInimigo){
		if (Validator.isInteger(indicePosicaoDoTiro)
				&& jogadorInimigo instanceof Jogador
				&& this.isIniciou() && !this.isTerminou()){
			
			let tiroCerteiro = this.getJogadorAtual()
										.atirarNoInimigo(indicePosicaoDoTiro, jogadorInimigo);
			
			if (this.getIndiceJogadorAtual() === 0) {
				this.incrementarTurnoAtual();
			}
						
			//Descobrindo se o jogo pode terminar após o último jogar
			if ((this.getIndiceJogadorAtual() + 1) === this.getQtdAtualDeJogadores()) {
				let contCanoasDestruidas = 0;
				
				for (let cont = 0; cont < this.getQtdAtualDeJogadores(); cont++) {
					if (this.getJogador(cont).isCanoaDestruida()) {
						contCanoasDestruidas++;
					}
				}
				
				//houve empate ou sobrou apenas 1 jogador?
				if (contCanoasDestruidas ===  this.getQtdAtualDeJogadores()
						|| contCanoasDestruidas === (this.getQtdAtualDeJogadores() - 1)) {
					this.terminar();
				}
			}
			
			this.indiceJogadorAtual++;
			this.indiceJogadorAtual = this.indiceJogadorAtual % this.getQtdAtualDeJogadores();
			
			return tiroCerteiro;
		}
		
		return false;
	}
	
	isEmpatou(){
		if (this.isIniciou() && this.isTerminou()){
			let contVencedores = 0;
			
			for (let cont = 0; cont < this.getQtdAtualDeJogadores(); cont++) {
				if (!this.getJogador(cont).isCanoaDestruida()) {
					contVencedores++;
				}
			}
			
			return contVencedores >= 2;
		}
		
		return false;
	}
	
	getEmpatantes(){
		if (this.isIniciou() && this.isTerminou()){
			let vencedores = [];
			
			for (let cont = 0; cont < this.getQtdAtualDeJogadores(); cont++) {
				if (!this.getJogador(cont).isCanoaDestruida()) {
					vencedores.push(this.getJogador(cont));
				}
				else{
					this.getJogador(cont).reduzirVidaCapivara();
				}
			}
			
			return vencedores;
		}
		
		return null;
	}
	
	getVencedor(){
		if (this.isIniciou() && this.isTerminou() && !this.isEmpatou()){
			let vencedor = null;
			
			for (let cont = 0; cont < this.getQtdAtualDeJogadores(); cont++) {
				if (!this.getJogador(cont).isCanoaDestruida()) {
					vencedor = this.getJogador(cont);
					break;
				}
			}
			
			return vencedor;
		}
		
		return null;
	}
	
}

module.exports = Partida;