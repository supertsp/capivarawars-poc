package br.com.capivarawars.core.game.gameobject;


//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.*;
import br.com.capivarawars.core.game.component.*;
import br.com.capivarawars.core.primitive.*;
import br.com.capivarawars.core.primitive.patterns.*;
import java.time.LocalDateTime;
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
    private CorPadrao cor;
    private LocalDateTime dataHoraCriacao;
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
    public Capivara(String nome, CorPadrao cor) {
        this(0, 0, nome, cor, true);
    }
    
    public Capivara(String nome, CorPadrao cor, boolean regeneracaoAutomatica) {
        this(0, 0, nome, cor, regeneracaoAutomatica);
    }
    
    public Capivara(int x, int y, String nome, CorPadrao cor){
        this(x, y, nome, cor, true);
    }
    
    public Capivara(int x, int y, String nome, CorPadrao cor, boolean regeneracaoAutomatica) {
        super(Capivara.class);
        
        //Component 0 = default
        super.getComponent(Coordinates.class).set(x, y);
        setNome(nome);
        setCor(cor);
        
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
    public String getNome() {
        return nome;
    }

    public Capivara setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CorPadrao getCor() {
        return cor;
    }

    public Capivara setCor(CorPadrao novaCor) {
        this.cor = novaCor;
        return this;
    }

    public Acessorios getAcessorios() {
        return super.getComponent(Acessorios.class);
    }

    public BarraDeEnergia<Integer> getBarraDeEnergia() {
        return super.getComponent(BarraDeEnergia.class);
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public Capivara setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
        return this;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Capivara.class.getSimpleName())
                .append(' ')
                .append(ImprovableToString.CLASS_OPENING_CHAR)
                .append(toStringWithAttibutesOnly(ImprovableToString.TAB_SIZE, true))
                .append('\n')
                .append(ImprovableToString.CLASS_CLOSING_CHAR);
        
        return finalText.toString();
    }
        
    @Override
    public String toStringWithAttibutesOnly(int tabSizeForEachAttribute, boolean includeParentAttributes) {
        StringBuilder finalText = new StringBuilder(200);
        
        if (includeParentAttributes) {
            finalText.append(super.toStringWithAttibutesOnly_GameObjectDemo(tabSizeForEachAttribute));
        }
        
        StringBuilder tabSpace = new StringBuilder();        
        for (int count = 0; count < tabSizeForEachAttribute; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("nome: ")
                .append(getNome())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("cor: ")
                .append(getCor())
                
                .append(getComponent(Acessorios.class).toStringWithAttibutesOnly(tabSizeForEachAttribute, false))                
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("BarraDeEnergia: ")
                .append(getValorAtualBarraDeEnergia())
                .append("/")
                .append(BARRA_ENERGIA_MAX_VALOR)
                .append("  Regenerando? ")
                .append(barraDeEnergiaIniciouTempoRegeneracao())
                .append("  ");
                
        if (barraDeEnergiaIniciouTempoRegeneracao()) {
            finalText
                    .append(getTempoEsperaAtualParaRegenerar())
                    .append("s/")
                    .append(BARRA_ENERGIA_TEMPO_RECUPERACAO)
                    .append("s");
        }
                
        return finalText.toString();
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
