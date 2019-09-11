package br.com.CapivaraWars.core;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAcessorios {
	
	private List<TipoAcessorio> lista;
	
	public ListaDeAcessorios() {
		lista = new ArrayList<>();
	}
	
	public void adicionar(TipoAcessorio novoAcessorio) {
		lista.add(novoAcessorio);
	}
	
	public void adicionar(TipoAcessorio... variosAcessorios) {
		for (TipoAcessorio acessorio : variosAcessorios) {
			lista.add(acessorio);
		}
	}
	
	public TipoAcessorio get(int indiceProcurado) {
		return lista.get(indiceProcurado);
	}
	
	public void remover(int indiceProcurado) {
		lista.remove(indiceProcurado);
	}
	
	public void remover(TipoAcessorio acessorioProcurado) {
		lista.remove(acessorioProcurado);
	}
	
	public int length() {
		return lista.size();
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{ ");
		
		for (int cont = 0; cont < length(); cont++) {
			if ((cont + 1) >= length()) {
				stringBuffer.append(get(cont).getNomeAcessorio() + " }");
			}
			else {
				stringBuffer.append(get(cont).getNomeAcessorio() + ", ");
			}
		}
		
		return stringBuffer.toString();
	}
	
	
	
}
