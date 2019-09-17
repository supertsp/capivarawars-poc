package br.com.capivarawars.core;

import br.com.capivarawars.core.game.Posicao;

public class AcessorioChapeu7 implements TipoAcessorio7 {

    private Posicao posicao;
    private String nome;

    public AcessorioChapeu7(int x, int y, String nome) {
        this.posicao = new Posicao(x, y);
        this.nome = nome;
    }

    @Override
    public Posicao getPosicao() {
        return posicao;
    }

    @Override
    public String getNomeAcessorio() {
        return nome;
    }

}
