const Validator = require('../tool/Validator');

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 30/11/2019, 19:47:29
 * Last update: -
 */

class BarraDeVida{
		
	vida;
	valorMaximo;	
	
	constructor(valorMaximo){
		if (Validator.isNumber(valorMaximo)) {
			this.valorMaximo = valorMaximo;
			this.vida = valorMaximo;			
		}
		
		//Construtor sem parâmetros
		if (Validator.isUndefined(valorMaximo)) {
			this.valorMaximo = 10;
			this.vida = 10;		
		}
	}
	
	getVida(){
		this.vida = this.vida > this.getValorMaximo() ? this.getValorMaximo() : this.vida;
		this.vida = this.vida < 0 ? 0 : this.vida;
		return this.vida;
	}
	
	getValorMaximo(){
		return this.valorMaximo;
	}
		
	diminuir(valorDecremento){
		if (Validator.isNumber(valorDecremento)) {
			this.vida -= valorDecremento;
			this.vida = this.vida < 0 ? 0 : this.vida;
		}
		
		if (Validator.isUndefined(valorDecremento)) {
			this.vida--;
			this.vida = this.vida < 0 ? 0 : this.vida;
		}
	}
	
	aumentar(valorIncremento){
		if (Validator.isNumber(valorIncremento)) {
			this.vida += valorIncremento;
			this.vida = this.vida > this.getValorMaximo() ? this.getValorMaximo() : this.vida;
		}
		
		if (Validator.isUndefined(valorIncremento)) {
			this.vida++;
			this.vida = this.vida > this.getValorMaximo() ? this.getValorMaximo() : this.vida;
		}
	}
	
	zerar(){
		this.vida = 0;
	}
	
	encher(){
		this.vida = this.valorMaximo;
	}
	
	isVazia(){
		return this.vida === 0;
	}
	
	isCheia(){
		return this.vida === this.valorMaximo;
	}
	
}

module.exports = BarraDeVida;