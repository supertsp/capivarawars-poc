package br.com.capivarawars.core.primitive.patterns;

//<editor-fold defaultstate="collapsed" desc="imports...">
//import ...
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author TPEDROSO, 30/09/2019, 14:17:55
 * Last update: -
 *///</editor-fold>
public interface ImprovableToString {
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int TAB_SIZE = 3;
    public static final char CLASS_OPENING_CHAR = '{';
    public static final char CLASS_CLOSING_CHAR = '}';
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">
    public abstract String toStringWithAttibutesOnly(int tabSizeForEachAttribute);
    //</editor-fold>
    
}//interface
