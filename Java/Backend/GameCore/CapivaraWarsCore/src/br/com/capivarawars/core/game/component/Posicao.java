package br.com.capivarawars.core.game.component;

//<editor-fold defaultstate="collapsed" desc="imports...">
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
public class Posicao extends Component{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private float x, y;
    private boolean exibirToStringBasico;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    public static final Posicao ZERO = new Posicao();
    public static final Posicao CIMA = new Posicao(0, 1);
    public static final Posicao BAIXO = new Posicao(0, -1);
    public static final Posicao DIREITA = new Posicao(1, 0);
    public static final Posicao ESQUERDA = new Posicao(-1, 0);
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Posicao() {
        super();
    }
    
    public Posicao(boolean exibirToStringBasico){
        this();
        this.exibirToStringBasico = exibirToStringBasico;
    }
    
    public Posicao(float x, float y) {
        this();
        set(x, y);
    }
    
    public Posicao(boolean exibirToStringBasico, float x, float y){
        this(x, y);
        this.exibirToStringBasico = exibirToStringBasico;
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

    public void incrementarX(float x) {
        setX(getX() + x);
    }

    public void incrementarY(float y) {
        setY(getY() + y);
    }

    public void incrementar(float x, float y) {
        incrementarX(x);
        incrementarY(y);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        if (exibirToStringBasico) {
            return String.valueOf(x) + ", " + String.valueOf(y);
        }
        
        return "Posicao{ " + x + ", " + y + " }";
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
