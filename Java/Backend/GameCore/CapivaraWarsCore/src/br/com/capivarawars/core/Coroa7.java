package br.com.capivarawars.core;

public class Coroa7 {

    protected String nome;
    protected TipoCoroa7 tipoCoroa;
    protected int xp;

    public Coroa7(String nome, TipoCoroa7 tipoCoroa, int xp) {
        this.nome = nome;
        this.tipoCoroa = tipoCoroa;
        this.xp = xp;
    }

    public String getNome() {
        return nome;
    }

    public TipoCoroa7 getTipoCoroa() {
        return tipoCoroa;
    }

    public int getXp() {
        return xp;
    }

    @Override
    public String toString() {
        return "Coroa{ "
                + " nome= " + nome
                + ", tipoCoroa= " + tipoCoroa + " \"" + tipoCoroa.getTexto() + "\""
                + ", xp=" + xp
                + "}";
    }

}
