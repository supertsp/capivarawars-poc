package br.com.capivarawars.core;

public enum TipoCoroa7 {

    REGIONAL("Regional"),
    ESTADUAL("Estadual"),
    NACIONAL("Nacional"),
    MUNDIAL("Mundial"),
    NATAL("Natal"),
    HALLOWEEN("Halloween"),
    DIANAMORADOS("Dia dos Namorados"),
    CAPRICORNIO("Capricórnio");

    private String texto;

    private TipoCoroa7(String textoEnum) {
        texto = textoEnum;
    }

    public String getTexto() {
        return texto;
    }

}
