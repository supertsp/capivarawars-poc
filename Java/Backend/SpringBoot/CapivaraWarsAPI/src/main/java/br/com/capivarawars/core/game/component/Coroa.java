package br.com.capivarawars.core.game.component;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.TipoCoroa;
import br.com.capivarawars.core.game.component.patterns.TipoAcessorio;
import br.com.capivarawars.core.primitive.Component;
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
 * @author Tiago Penha Pedroso, 23 de set de 2019, 09:14:26 Last update: -
 *///</editor-fold>
public class Coroa extends Component{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    protected String nome;
    protected TipoCoroa tipoCoroa;
    protected int xp;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Coroa(String nome, TipoCoroa tipoCoroa, int xp) {
        this.nome = nome;
        this.tipoCoroa = tipoCoroa;
        this.xp = xp;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getNome() {
        return nome;
    }

    public TipoCoroa getTipoCoroa() {
        return tipoCoroa;
    }

    public int getXp() {
        return xp;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        return "Coroa{ "
                + " nome= " + nome
                + ", tipoCoroa= " + tipoCoroa + " \"" + tipoCoroa.getTexto() + "\""
                + ", xp=" + xp
                + "}";
    }
    
    @Override
    public String toStringWithAttibutesOnly(int tabSizeForEachAttribute, boolean includeParentAttributes) {
        StringBuilder finalText = new StringBuilder(200);
        
        if (includeParentAttributes) {
            finalText.append(super.toStringWithAttibutesOnly_ComponentDemo(tabSizeForEachAttribute));
        }
        
        return null;
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    
    //</editor-fold>
    
    //</editor-fold>

}//class
