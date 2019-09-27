package br.com.capivarawars.core.game.gameobject;


//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.primitive.Coordinates;
import br.com.capivarawars.core.game.component.BarraDeEnergia;
import br.com.capivarawars.core.primitive.GameObject;
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.game.component.Acessorios;
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
    private String nome;
    private CorPadrao corPadrao;
    
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
        super();
        
        //Component 0 = default
        super.getComponent(Coordinates.class).set(x, y);
        setNome(nome);
        setCorPadrao(corPadrao);
        
        //Component 1 = Acessorios
        super.addComponent(new Acessorios());
        
        //Component 2 = BarraDeEnergia
        super.addComponent( new BarraDeEnergia<Integer>(
                    BARRA_ENERGIA_MIN_VALOR, 
                    BARRA_ENERGIA_MAX_VALOR, 
                    BARRA_ENERGIA_TEMPO_RECUPERACAO, 
                    regeneracaoAutomatica
                )                
        );        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public Coordinates getPosicao() {
        return super.getComponent(Coordinates.class);
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

    public Acessorios getAcessorios() {
        return super.getComponent(Acessorios.class);
    }

    public BarraDeEnergia<Integer> getBarraDeEnergia() {
        return super.getComponent(BarraDeEnergia.class);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuffer textoFinal = new StringBuffer();
        
        textoFinal
                .append(Capivara.class.getSimpleName())
                .append(" { ");
        textoFinal.append("\n  Posicao: ").append(getPosicao());
        textoFinal.append("\n  nome: ").append(nome);
        textoFinal.append("\n  corPadrao: ").append(corPadrao);
        textoFinal.append("\n  Acessorios: ").append(getAcessorios());
        textoFinal.append("\n  BarraDeEnergia: ")
                .append(getValorAtualBarraDeEnergia())
                .append("/")
                .append(BARRA_ENERGIA_MAX_VALOR)
                .append("  Regenerando? ")
                .append(barraDeEnergiaIniciouTempoRegeneracao())
                .append("  ");
        
        if (barraDeEnergiaIniciouTempoRegeneracao()) {
            textoFinal.append(getTempoEsperaAtualParaRegenerar())
                    .append("s/")
                    .append(BARRA_ENERGIA_TEMPO_RECUPERACAO)
                    .append("s");
        }
        
        textoFinal.append(super.toString());
        textoFinal.append("\n}");
        
        return textoFinal.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public Integer getValorAtualBarraDeEnergia(){
        return getBarraDeEnergia().getValorAtual();
    }
    
    public void receberDano(){
        getBarraDeEnergia().incrementarValorAtual(-1);
    }
    
    public boolean barraDeEnergiaIniciouTempoRegeneracao(){
        return getBarraDeEnergia().iniciouTempoRegeneracao();
    }
    
    public boolean barraDeEnergiaTerminouTempoRegeneracao(){
        return getBarraDeEnergia().terminouTempoRegeneracao();
    }
    
    public Integer getTempoEsperaAtualParaRegenerar(){
        return getBarraDeEnergia().getTempoDecorridoParaRegeneracaoComoInteger();
    }
    //</editor-fold>
    
    //</editor-fold>
    
}//class
