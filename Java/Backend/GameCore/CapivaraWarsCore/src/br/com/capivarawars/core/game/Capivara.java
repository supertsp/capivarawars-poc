package br.com.capivarawars.core.game;


//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.ListaDeAcessorios;
import java.util.List;
import java.util.ArrayList;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 23 de set de 2019, 09:14:26
 * Last update: -
 *///</editor-fold>
public class Capivara extends GameObject{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private Posicao posicao;
    private String nome;
    private CorPadrao corPadrao;
    private ListaDeAcessorios listaDeAcessorios;
    private BarraDeEnergia<Integer> barraDeEnergia;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int BARRA_ENERGIA_MIN_VALOR = 0;
    public static final int BARRA_ENERGIA_MAX_VALOR = 7;
    public static final int BARRA_ENERGIA_TEMPO_RECUPERACAO = 10;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Capivara(String nome, CorPadrao corPadrao) {
        this(0, 0, nome, corPadrao, true);
    }
    
    public Capivara(String nome, CorPadrao corPadrao, boolean regeneracaoAutomatica) {
        this(0, 0, nome, corPadrao, regeneracaoAutomatica);
    }
    
    public Capivara(int x, int y, String nome, CorPadrao corPadrao){
        this(x, y, nome, corPadrao, true);
    }
    
    public Capivara(int x, int y, String nome, CorPadrao corPadrao, boolean regeneracaoAutomatica) {
        posicao = new Posicao(x, y);
        setNome(nome);
        setCorPadrao(corPadrao);
        listaDeAcessorios = new ListaDeAcessorios();
        barraDeEnergia = new BarraDeEnergia<Integer>(
                BARRA_ENERGIA_MIN_VALOR, BARRA_ENERGIA_MAX_VALOR, 
                BARRA_ENERGIA_TEMPO_RECUPERACAO, regeneracaoAutomatica
        );
        barraDeEnergia.setRegeneracaoAutomatica(regeneracaoAutomatica);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
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

    public BarraDeEnergia<Integer> getBarraDeEnergia() {
        return barraDeEnergia;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        return "Capivara { "
                + "\n posicao = " + posicao
                + "\n nome = " + nome
                + "\n corPadrao = " + corPadrao
                + "\n listaDeAcessorios = " + listaDeAcessorios
                + "\n barraEnergia (valor) = " + getValorAtualBarraEnergia()
                + "\n barraEnergia (regenerando) = " + barraDeEnergiaIniciouTempoRegeneracao()
                + "\n barraEnergia (tempo regeneracao) = " + getTempoEsperaAtualParaRegenerar()
                + "\n components = " + super.componentsToString()
                + "\n}";
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public Integer getValorAtualBarraEnergia(){
        return barraDeEnergia.getValorAtual();
    }
    
    public void receberDano(){
        barraDeEnergia.incrementarValorAtual(-1);
    }
    
    public boolean barraDeEnergiaIniciouTempoRegeneracao(){
        return barraDeEnergia.iniciouTempoRegeneracao();
    }
    
    public boolean barraDeEnergiaTerminouTempoRegeneracao(){
        return barraDeEnergia.terminouTempoRegeneracao();
    }
    
    public Integer getTempoEsperaAtualParaRegenerar(){
        return barraDeEnergia.getTempoDecorridoParaRegeneracaoComoInteger();
    }
    //</editor-fold>
    
    //</editor-fold>
    
}//class
