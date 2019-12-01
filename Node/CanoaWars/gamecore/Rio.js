const Validator = require('../tool/Validator');
const Canoa = require('./Canoa');

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 30/11/2019, 19:48:17
 * Last update: -
 */

class Rio{
	
	tamanhoMax;
	tamanhoAtual;
	vazio;
	posicaoAtualCanoa;
	partes;
	canoa;
	
		
	constructor(tamanho, canoa){
		if (Validator.isInteger(tamanho)				
				&& canoa instanceof Canoa) {
			
			this.tamanhoMax = (tamanho / 2.5) >= canoa.getTamanhoMax() ?
						tamanho :	
						parseInt(canoa.getTamanhoMax() * 2.5);
							
			this.canoa = canoa;
			
			this.reiniciar();			
			
			//atualiza atributo da classe
			this.isVazio();
		}
		
		//Construtor sem parâmetros
		if (Validator.isUndefined(tamanho) || Validator.isUndefined(canoa)) {
			this.tamanhoMax = 10;
			this.canoa = new Canoa();
			
			this.reiniciar();			
			
			//atualiza atributo da classe
			this.isVazio();
		}
	}
	
	reiniciar(){
		this.posicaoAtualCanoa = 0;
		
		this.partes = new Array(this.getTamanhoMax());
		
		for (var cont = 0; cont < this.getTamanhoMax(); cont++) {
			this.partes[cont] = false;
		}
		
		this.tamanhoAtual = this.partes.length;
		
		this.canoa.reiniciar();
		this.moverCanoa(0);
		
		this.vazio = false;
	}
	
	getTamanhoMax(){
		return this.tamanhoMax;
	}
	
	getTamanhoAtual(){
		this.tamanhoAtual = this.partes.length;
		return this.tamanhoAtual;
	}
	
	isVazio(){
		if (this.canoa.isDestruida()) {			
			this.vazio = true;
			this.posicaoAtualCanoa = -1;
		}
		else{
			this.vazio = false;
		}
		
		return this.vazio;
	}
	
	getPosicaoAtualCanoa(){
		return this.posicaoAtualCanoa;
	}
	
	getParte(indiceParte){
		if (Validator.isInteger(indiceParte) 
				&& indiceParte >= 0 
				&& indiceParte < this.getTamanhoAtual()) {
			
			return this.partes[indiceParte];
		}
		
		return null;
	}
	
	getCanoa(){
		return this.canoa;
	}
	
	destruirParte(){
        if (!this.isVazio() && (this.getTamanhoAtual() / 2.5) >= this.canoa.getTamanhoAtual()) {		
			this.moverCanoa(0);
			
			this.partes.pop();
			
			if (this.getTamanhoAtual() === 0) {
				this.canoa.destruirTodosPedacos();
				this.posicaoAtualCanoa = -1;
			}
			
            return true;
        }
		
        //atualiza atributo da classe
		this.isVazio();
        return false;
    }
	
	destruirTodasPartes(){
		this.partes = [];
		this.canoa.destruirTodosPedacos();
		this.posicaoAtualCanoa = -1;
		
		//atualiza atributo da classe
		this.isVazio();
		
		this.vazio = true;
	}
	
	reconstruirTodosPedacos(){
		this.reiniciar();
		
		//atualiza atributo da classe
		this.isVazio();
		
		this.vazio = false;
	}
	
	reconstruirPedaco(){
		if (this.getTamanhoAtual() < this.getTamanhoMax()) {
			this.partes.push(false);
		}
		
		//atualiza atributo da classe
		this.isVazio();
	}
	
	receberTiro(indiceParteDoRio){
        if (Validator.isInteger(indiceParteDoRio) 
				&& indiceParteDoRio >= 0 
				&& indiceParteDoRio < this.getTamanhoAtual()) {		
			
//			const indiceNaCanoa = indiceParteDoRio % this.canoa.getTamanhoMax();
			let destruiu = false;
			
			if (indiceParteDoRio >= this.getPosicaoAtualCanoa()
					&& indiceParteDoRio < (this.getPosicaoAtualCanoa() + this.canoa.getTamanhoAtual())) {
				
				destruiu = this.canoa.destruirPedaco();
			}
			
			if (destruiu) {
				this.moverCanoa(this.getPosicaoAtualCanoa());
			}
			
			//atualiza atributo da classe
			this.isVazio();	
			
			return destruiu;
        }
		
        //atualiza atributo da classe
		this.isVazio();		
        return false;
    }
	
	moverCanoa(indiceParteDoRio){
		if (Validator.isInteger(indiceParteDoRio)
				&& indiceParteDoRio >= 0
				&& indiceParteDoRio < this.getTamanhoAtual()){
			
			if (indiceParteDoRio <= (this.getTamanhoAtual() - this.canoa.getTamanhoAtual())) {
				this.posicaoAtualCanoa = indiceParteDoRio;
			}
			else{
				this.posicaoAtualCanoa = this.getTamanhoAtual() - this.canoa.getTamanhoAtual();
			}
			
			for (let cont = 0; cont < this.getTamanhoAtual(); cont++) {
				if (cont >= this.getPosicaoAtualCanoa()
						&& cont < (this.getPosicaoAtualCanoa() + this.canoa.getTamanhoAtual())) {
					
					this.partes[cont] = true;
				}
				else{
					this.partes[cont] = false;
				}
			}
		}
	}
		
}

module.exports = Rio;