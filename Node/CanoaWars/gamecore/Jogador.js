const Validator = require('../tool/Validator');
const Canoa = require('./Canoa');
const Rio = require('./Rio');
const Capivara = require('./Capivara');

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 30/11/2019, 19:47:29
 * Last update: -
 */

class Jogador{
	
	id;
	nick;
	pontos;
	capivara;
	rio;	
	
	constructor(nick, nomeCapivara, tamanhoRio, tamanhoCanoa){
		if (Validator.isString(nick)
				&& Validator.isInteger(tamanhoRio)
				&& Validator.isInteger(tamanhoCanoa)
				&& Validator.isString(nomeCapivara)) {
			
			this.setId(0);
			this.nick = nick;
			this.pontos = 0;
			this.capivara = new Capivara(nomeCapivara, 7);
			this.rio = new Rio(tamanhoRio, new Canoa(tamanhoCanoa));
		}
		
		//Construtor sem parâmetros
		if (Validator.isUndefined(nick) 
				|| Validator.isUndefined(nomeCapivara)
				|| Validator.isUndefined(tamanhoRio)
				|| Validator.isUndefined(tamanhoCanoa)) {
			
			this.setId(0);
			this.nick = 'nick' + parseInt(Math.random() * 1000);
			this.pontos = 0;
			this.capivara = new Capivara();
			this.rio = new Rio(tamanhoRio, new Canoa());
		}
	}
	
	reiniciarCanoa(){
		this.rio.reiniciar();
	}
	
	getId(){
		return this.id;
	}
	
	setId(novoId){
		if (Validator.isInteger(novoId)) {
			this.id = novoId;
		}
		else{
			this.id = 0;
		}
		
		return this;
	}
	
	getNick(){
		return this.nick;
	}
	
	getPontos(){
		return this.pontos;
	}
	
	incrementarPontos(){
		this.pontos++;
		return this;
	}
	
	decrementarPontos(){
		this.pontos--;
		this.pontos = this.pontos < 0 ? 0 : this.pontos;
		return this;
	}
	
	getCapivara(){
		return this.capivara;
	}
	
	isCapivaraMorta(){
		return this.capivara.isMorta();
	}
	
	getVidaCapivara(){
		return this.capivara.getVida();
	}
	
	getRio(){
		return this.rio;
	}
	
	getCanoa(){
		return this.rio.getCanoa();
	}
	
	isCanoaDestruida(){
		return this.rio.isVazio();
	}
	
	moverCanoa(posicaoNoRio){
		this.rio.moverCanoa(posicaoNoRio);
	}
	
	atirarNoInimigo(posicaoDoTiro, jogadorInimigo){
		if (Validator.isInteger(posicaoDoTiro) && jogadorInimigo instanceof Jogador) {
			return jogadorInimigo.getRio().receberTiro(posicaoDoTiro);
		}
		
		return false;
	}
	
	toString(){
		let jogadorTxt = `Jogador ${this.getId()}: '${this.getNick()}'   -  Pontos: ${this.getPontos()}\n`;
		let capivaraTxt = `   Capivara '${this.getCapivara().getNome()}'  - Vida: ${this.getVidaCapivara()}  - Está morta? ${this.isCapivaraMorta()} \n`;
		let rioTxt = `   Rio (${this.getRio().getTamanhoAtual()}): `;
		let canoaTxt = `   Canoa (${this.getCanoa().getTamanhoAtual()}): `;
		let canoaDestruidaTxt = `   -   Está Destruida? ${this.isCanoaDestruida()}`;
		
		for (let cont = 0; cont < this.getRio().getTamanhoAtual(); cont++) {
			if (this.getRio().getParte(cont)) {
				rioTxt += '[O]';
			}
			else{
				rioTxt += '[~]';
			}
		}
		rioTxt += '\n';
		
		for (let cont = 0; cont < this.getCanoa().getTamanhoAtual(); cont++) {
			if (this.getCanoa().getPedaco(cont)) {
				canoaTxt += '[O]';
			}
			else{
				canoaTxt += '[~]';
			}
		}
		canoaTxt += canoaDestruidaTxt;
		
		return jogadorTxt + capivaraTxt + rioTxt + canoaTxt;
	}
}

module.exports = Jogador;