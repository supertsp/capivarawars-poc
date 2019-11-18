package br.com.capivarawars.core.game.component.patterns;

//<editor-fold defaultstate="collapsed" desc="imports...">

import br.com.capivarawars.core.primitive.Coordinates;

//import ...
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author TPEDROSO, 27/09/2019, 11:00:40
 * Last update: -
 *///</editor-fold>
public interface TipoAcessorio {
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">
    Coordinates getPosicao();

    String getNomeAcessorio();
    //</editor-fold>

}//class
