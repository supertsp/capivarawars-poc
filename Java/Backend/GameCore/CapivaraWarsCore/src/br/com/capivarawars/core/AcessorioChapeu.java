package br.com.capivarawars.core;

import br.com.capivarawars.core.game.component.patterns.TipoAcessorio;
import br.com.capivarawars.core.primitive.Component;
import br.com.capivarawars.core.primitive.Coordinates;

public class AcessorioChapeu extends Component implements TipoAcessorio {

    private Coordinates posicao;
    private String nome;

    public AcessorioChapeu(int x, int y, String nome) {
        this.posicao = new Coordinates(x, y);
        this.nome = nome;
    }

    @Override
    public Coordinates getPosicao() {
        return posicao;
    }

    @Override
    public String getNomeAcessorio() {
        return nome;
    }

    @Override
    public String toStringWithAttibutesOnly(int tabSizeForEachAttribute) {
        return null;
    }

}
