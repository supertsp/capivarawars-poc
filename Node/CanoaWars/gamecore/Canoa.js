/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 28/11/2019, 19:48:17
 * Last update: -
 */

class Canoa{
	
	tamanho;
	pedacos;
	
	constructor(tamanho){
		this.tamanho = tamanho;
		this.pedacos = new Array(this.tamanho);
		this.reiniciarCanoa(tamanho);
	}
	
	reiniciarCanoa(){
		for (var cont = 0; cont < this.tamanho; cont++) {
			this.pedacos[cont] = true;
		}
	}
	
	lengthOfPedacos(){
		return this.pedacos.length;
	}
	
	getPedaco(indice){
		if (indice >= 0 && indice < this.pedacos.length) {
			return this.pedacos[indice];
		}
		
		return null;
	}
	
	isDestruida(){
		let destruida = true;
        
        for (let cont = 0; cont < this.lengthOfPedacos(); cont++) {
            destruida &= this.getPedaco(cont).isDestruido();
        }
        
        return destruida;
	}
	
	destruirPedaco(indicePedaco){
        if (indicePedaco >= 0 
				&& indicePedaco < this.lengthOfPedacos()
                && this.pedacos[indicePedaco]) {
			
			this.pedacos.pop();
//			const pedacoTemp = this.pedacos.
			
//            Pedaco pedacoTemp = pedacos.get(indicePedaco);
//            pedacos.remove(indicePedaco);
//            pedacos.add(pedacoTemp);
            return true;
        }
        
        return false;
    }
	
}

module.exports = Canoa;