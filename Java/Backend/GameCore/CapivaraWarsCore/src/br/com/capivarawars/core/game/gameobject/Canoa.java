package br.com.capivarawars.core.game.gameobject;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.game.component.Pedaco;
import br.com.capivarawars.core.primitive.GameObject;
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
 * @author TPEDROSO, 27/09/2019, 12:22:57
 * Last update: -
 *///</editor-fold>
public class Canoa extends GameObject{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private List<Pedaco> pedacos;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private int quantidadePedadosInicial;
    private CorPadrao corInicial;
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Canoa(int quantidadePedacos, CorPadrao cor){
        super();
        this.quantidadePedadosInicial = quantidadePedacos;
        this.corInicial = cor;
        pedacos = new ArrayList<>(quantidadePedacos);
        criarPedacos();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public Pedaco getPedaco(int indicePedaco){
        if (indicePedaco >= 0 && indicePedaco < lengthOfPedacos()) {
            return pedacos.get(indicePedaco);
        }
        
        return null;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private void criarPedacos(){
        for (int cont = 0; cont < quantidadePedadosInicial; cont++) {
            pedacos.add(cont, new Pedaco(corInicial));
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public int lengthOfPedacos(){
        return pedacos.size();
    }
    
    public boolean destruirPedaco(int indicePedaco){
        if (indicePedaco >= 0 && indicePedaco < lengthOfPedacos()) {
            
        }
        
        return false;
    }
    
    public void destruirPedacos(){
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            pedacos.get(cont).destruir();
        }
    }
    
    public void reiniciarPedacos(){
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            pedacos.get(cont).construir();
        }
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
