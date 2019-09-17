package br.com.capivarawars.core;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAcessorios7 {

    private List<TipoAcessorio7> lista;

    public ListaDeAcessorios7() {
        lista = new ArrayList<>();
    }

    public void adicionar(TipoAcessorio7 novoAcessorio) {
        lista.add(novoAcessorio);
    }

    public void adicionar(TipoAcessorio7... variosAcessorios) {
        for (TipoAcessorio7 acessorio : variosAcessorios) {
            lista.add(acessorio);
        }
    }

    public TipoAcessorio7 get(int indiceProcurado) {
        return lista.get(indiceProcurado);
    }

    public void remover(int indiceProcurado) {
        lista.remove(indiceProcurado);
    }

    public void remover(TipoAcessorio7 acessorioProcurado) {
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
            } else {
                stringBuffer.append(get(cont).getNomeAcessorio() + ", ");
            }
        }

        return stringBuffer.toString();
    }

}
