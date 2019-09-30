package br.com.capivarawars.core.game.component;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
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
 * @author TPEDROSO, 27/09/2019, 12:50:44
 * Last update: -
 *///</editor-fold>
public class Pedaco extends Component{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private boolean destruido;
    private CorPadrao cor;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Pedaco(CorPadrao cor){
        super();
        setCor(cor);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public boolean isDestruido() {
        return destruido;
    }
    
    public CorPadrao getCor() {
        return cor;
    }

    public void setCor(CorPadrao cor) {
        this.cor = cor;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public void destruir(){
        destruido = false;
    }
    
    public void construir(){
        destruido = true;
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
