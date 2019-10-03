package br.com.capivarawars.core.game.gameobject;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.*;
import br.com.capivarawars.core.game.component.*;
import br.com.capivarawars.core.primitive.*;
import br.com.capivarawars.core.primitive.patterns.*;
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
    private String nome;
    private CorPadrao cor;
    private Pedacos pedacos;    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
   
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Canoa(String nome, CorPadrao cor, int tamanho){
        super(Canoa.class);
        this.nome = nome;
        
        pedacos = new Pedacos(tamanho); 
                
        this.cor = cor;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
    public CorPadrao getCor(){
        return cor;
    }
    
    public void setCor(CorPadrao novaCor){
        cor = novaCor;
        
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            getPedaco(cont).setCor(novaCor);
        }
    }
    
    public Pedaco getPedaco(int indicePedaco){
        if (indicePedaco >= 0 && indicePedaco < lengthOfPedacos()) {
            return pedacos.get(indicePedaco);
        }
        
        return null;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Canoa.class.getSimpleName())
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
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Pedacos(")
                .append(lengthOfPedacos())
                .append("): ");
        
        for (int count = 0; count < lengthOfPedacos(); count++) {
            if (getPedaco(count).isDestruido()) {
                finalText.append("[~]");
            }
            else{
                finalText.append("[O]");
            }
        }
        
        finalText
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("isDestruida: ")
                .append(isDestruida());
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public int lengthOfPedacos(){
        return pedacos.length();
    }
    
    public int lengthOfPedacosInteiros(){
        int contPedacosInteiros = 0;
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            if (!getPedaco(cont).isDestruido()) {
                contPedacosInteiros++;
            }
        }
        
        return contPedacosInteiros;
    }
    
    public boolean isDestruida(){
        boolean destruida = true;
        
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            destruida &= getPedaco(cont).isDestruido();
        }
        
        return destruida;
    }
    
    public boolean destruirPedaco(int indicePedaco){
        if (indicePedaco >= 0 && indicePedaco < lengthOfPedacos()
                && !getPedaco(indicePedaco).isDestruido()) {
            getPedaco(indicePedaco).destruir();
            Pedaco pedacoTemp = pedacos.get(indicePedaco);
            pedacos.remove(indicePedaco);
            pedacos.add(pedacoTemp);
            return true;
        }
        
        return false;
    }
    
    public void destruirTodosPedacos(){
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            pedacos.get(cont).destruir();
        }
    }
    
    public void reconstruirTodosPedacos(){
        for (int cont = 0; cont < lengthOfPedacos(); cont++) {
            pedacos.get(cont).construir();
        }
    }
    
    public boolean reconstruirPedaco(int indicePedaco){
        if (indicePedaco >= 0 && indicePedaco < lengthOfPedacos()
                && pedacos.get(indicePedaco).isDestruido()) {
            pedacos.get(indicePedaco).construir();
            Pedaco pedacoTemp = pedacos.get(indicePedaco);
            pedacos.remove(indicePedaco);
            pedacos.addAt(0, pedacoTemp);
            return true;
        }
        
        return false;
    }
    //</editor-fold>
    
    //</editor-fold>
    
}//class
