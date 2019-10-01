package br.com.capivarawars.core.primitive;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.primitive.Component;
import br.com.capivarawars.core.primitive.patterns.ImprovableToString;
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
public class Coordinates extends Component{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private float x, y;    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    public static final Coordinates ZERO = new Coordinates();
    public static final Coordinates UP = new Coordinates(0, 1);
    public static final Coordinates DOWN = new Coordinates(0, -1);
    public static final Coordinates RIGHT = new Coordinates(1, 0);
    public static final Coordinates LEFT = new Coordinates(-1, 0);
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private boolean showSimpleToString;
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Coordinates() {
        super();
    }
    
    public Coordinates(boolean showSimpleToString){
        this();
        this.showSimpleToString = showSimpleToString;
    }
    
    public Coordinates(float x, float y) {
        this();
        set(x, y);
    }
    
    public Coordinates(boolean showSimpleToString, float x, float y){
        this(x, y);
        this.showSimpleToString = showSimpleToString;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public float getX() {
        return x;
    }

    public int getIntX() {
        return (int) x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public float getIntY() {
        return (int) y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void set(float x, float y) {
        setX(x);
        setY(y);
    }

    public void incrementX(float x) {
        setX(getX() + x);
    }

    public void incrementY(float y) {
        setY(getY() + y);
    }

    public void increment(float x, float y) {
        incrementX(x);
        incrementY(y);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        if (showSimpleToString) {
            return String.valueOf(x) + ", " + String.valueOf(y);
        }
        
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Coordinates.class.getSimpleName())
                .append(" ")
                .append(ImprovableToString.CLASS_OPENING_CHAR)
                .append(toStringWithAttibutesOnly(ImprovableToString.TAB_SIZE))
                .append('\n')
                .append(ImprovableToString.CLASS_CLOSING_CHAR);
        
        return finalText.toString();        
    }
    
    @Override
    public String toStringWithAttibutesOnly(int tabSizeForEachAttribute) {
        StringBuilder finalText = new StringBuilder(200);
        finalText.append(super.toStringWithAttibutesOnly_ComponentDemo(tabSizeForEachAttribute));
        
        StringBuilder tabSpace = new StringBuilder();        
        for (int count = 0; count < tabSizeForEachAttribute; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("x: ")
                .append(getX())
                               
                .append("   y: ")
                .append(getY());
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public float calculateDistance(Coordinates otherCoordinates){
        return (float)Math.sqrt(
                Math.pow(otherCoordinates.x - this.x, 2) + 
                Math.pow(otherCoordinates.y - this.y, 2)
        );
    }
    //</editor-fold>
    
    //</editor-fold>
    
}//class
