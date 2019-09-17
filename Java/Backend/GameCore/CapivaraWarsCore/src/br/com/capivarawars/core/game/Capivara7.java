package br.com.capivarawars.core.game;

import br.com.capivarawars.core.CorPadrao7;
import br.com.capivarawars.core.ListaDeAcessorios7;
import br.com.capivarawars.core.game.BarraEnergia7;
import br.com.capivarawars.core.game.Posicao;

public class Capivara7 {

    private Posicao posicao;
    private String nome;
    private CorPadrao7 corPadrao;
    private ListaDeAcessorios7 listaDeAcessorios;
    private BarraEnergia7<Integer> barraEnergia;

    public static final int BARRA_ENERGIA_MIN_VALOR = 0;
    public static final int BARRA_ENERGIA_MAX_VALOR = 7;
    public static final int BARRA_ENERGIA_TEMPO_RECUPERACAO = 60;

    public Capivara7(String nome, CorPadrao7 corPadrao) {
        this(0, 0, nome, corPadrao);
    }

    public Capivara7(int x, int y, String nome, CorPadrao7 corPadrao) {
        posicao = new Posicao(x, y);
        setNome(nome);
        setCorPadrao(corPadrao);
        listaDeAcessorios = new ListaDeAcessorios7();
        barraEnergia = new BarraEnergia7<Integer>(BARRA_ENERGIA_MIN_VALOR, BARRA_ENERGIA_MAX_VALOR, BARRA_ENERGIA_TEMPO_RECUPERACAO);
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

    public CorPadrao7 getCorPadrao() {
        return corPadrao;
    }

    public void setCorPadrao(CorPadrao7 corPadrao) {
        this.corPadrao = corPadrao;
    }

    public ListaDeAcessorios7 getListaDeAcessorios() {
        return listaDeAcessorios;
    }

    public BarraEnergia7<Integer> getBarraEnergia() {
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
