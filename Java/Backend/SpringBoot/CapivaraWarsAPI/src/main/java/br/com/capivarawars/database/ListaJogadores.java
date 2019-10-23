package br.com.capivarawars.database;

import java.util.ArrayList;
import java.util.List;

import br.com.capivarawars.controller.Credencial;

public class ListaJogadores {

//    private List<Jogador> lista;
//
//    public ListaJogadores() {
//        lista = new ArrayList<>();
//
//        //Lista inicial
//        adicionar(
//                new Jogador("Paulo Victor", "paulov", "superpaulo", "paulo123"),
//                new Jogador("Matheus Lemes", "mathlemes", "superlemes", "lemes123"),
//                new Jogador("Igor Inácio", "igorin", "superigor", "igor123"),
//                new Jogador("Joshua Sousa", "joshsousa", "superjosh", "josh123"),
//                new Jogador("Leonardo Ohashi", "leotakai", "superleo", "leonardo123"),
//                new Jogador("Tiago Pedroso", "tpedroso", "supertsp", "tiago123")
//        );
//    }
//
//    public void adicionar(Jogador novoJogador) {
//        lista.add(novoJogador);
//    }
//
//    public void adicionar(Jogador... variosJogadores) {
//        for (Jogador acessorio : variosJogadores) {
//            lista.add(acessorio);
//        }
//    }
//
//    public Jogador get(int indiceProcurado) {
//        return lista.get(indiceProcurado);
//    }
//
//    public void remover(int indiceProcurado) {
//        lista.remove(indiceProcurado);
//    }
//
//    public void remover(Jogador jogadorProcurado) {
//        lista.remove(jogadorProcurado);
//    }
//
//    public Jogador procurar(Jogador jogadorProcurado) {
//        int indice = lista.indexOf(jogadorProcurado);
//
//        if (indice != -1) {
//            return get(indice);
//        }
//
//        return null;
//    }
//
//    public Jogador procurarPorUsuario(String usuario) {
//        for (int cont = 0; cont < length(); cont++) {
//            if (get(cont).getUsuario().equals(usuario)) {
//                return get(cont);
//            }
//        }
//
//        return null;
//    }
//
//    public Jogador procurarPorSenha(String senha) {
//        for (int cont = 0; cont < length(); cont++) {
//            if (get(cont).getSenha().equals(senha)) {
//                return get(cont);
//            }
//        }
//
//        return null;
//    }
//
//    public Jogador procurar(String usuario, String senha) {
//        for (int cont = 0; cont < length(); cont++) {
//            if (get(cont).getUsuario().equals(usuario) && get(cont).getSenha().equals(senha)) {
//                return get(cont);
//            }
//        }
//
//        return null;
//    }
//
//    public Jogador procurar(Credencial credencialProcurada) {
//        return procurar(credencialProcurada.getUsuario(), credencialProcurada.getSenha());
//    }
//
//    public int length() {
//        return lista.size();
//    }
//
//    @Override
//    public String toString() {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("{ ");
//
//        for (int cont = 0; cont < length(); cont++) {
//            if ((cont + 1) >= length()) {
//                stringBuffer.append(get(cont).getNome() + " }");
//            } else {
//                stringBuffer.append(get(cont).getNome() + ", ");
//            }
//        }
//
//        return stringBuffer.toString();
//    }

}
