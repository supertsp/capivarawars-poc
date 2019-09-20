package br.com.capivarawars.core.game;

import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.ListaDeAcessorios;
import br.com.capivarawars.core.game.BarraEnergia;
import br.com.capivarawars.core.game.Posicao;

public class Capivara {

    private Posicao posicao;
    private String nome;
    private CorPadrao corPadrao;
    private ListaDeAcessorios listaDeAcessorios;
    private BarraEnergia<Integer> barraEnergia;

    public static final int BARRA_ENERGIA_MIN_VALOR = 0;
    public static final int BARRA_ENERGIA_MAX_VALOR = 7;
    public static final int BARRA_ENERGIA_TEMPO_RECUPERACAO = 60;

    public Capivara(String nome, CorPadrao corPadrao) {
        this(0, 0, nome, corPadrao);
    }

    public Capivara(int x, int y, String nome, CorPadrao corPadrao) {
        posicao = new Posicao(x, y);
        setNome(nome);
        setCorPadrao(corPadrao);
        listaDeAcessorios = new ListaDeAcessorios();
        barraEnergia = new BarraEnergia<Integer>(BARRA_ENERGIA_MIN_VALOR, BARRA_ENERGIA_MAX_VALOR, BARRA_ENERGIA_TEMPO_RECUPERACAO);
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CorPadrao getCorPadrao() {
        return corPadrao;
    }

    public void setCorPadrao(CorPadrao corPadrao) {
        this.corPadrao = corPadrao;
    }

    public ListaDeAcessorios getListaDeAcessorios() {
        return listaDeAcessorios;
    }

    public BarraEnergia<Integer> getBarraEnergia() {
        return barraEnergia;
    }

    @Override
    public String toString() {
        return "Capivara { "
                + "\n posicao = " + posicao
                + "\n nome = " + nome
                + "\n corPadrao = " + corPadrao
                + "\n listaDeAcessorios = " + listaDeAcessorios
                + "\n barraEnergia = " + barraEnergia.getValorAtual()
                + "\n}";
    }

}
