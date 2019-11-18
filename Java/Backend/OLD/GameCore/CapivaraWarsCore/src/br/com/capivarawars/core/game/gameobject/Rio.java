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
 * @author TPEDROSO, 01/10/2019, 08:59:19
 * Last update: -
 *///</editor-fold>
public class Rio extends GameObject{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private List<Pedaco> pedacos;
    private Canoa canoa;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private int ultimaPosicaoCanoa;
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Rio(int tamanho, Canoa canoa){
        super(Rio.class);
        
        pedacos = new ArrayList<>(tamanho);        
        for (int cont = 0; cont < tamanho; cont++) {
            pedacos.add(cont, new Pedaco());
        }
        
        setCanoa(canoa);
        
        moverCanoa(0);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    private Pedaco getPedaco(int indicePedaco){
        if (indicePedaco >= 0 && indicePedaco < lengthOfPedacos()) {
            return pedacos.get(indicePedaco);
        }
        
        return null;
    }
    
    public Canoa getCanoa(){
        return canoa;
    }
    
    public void setCanoa(Canoa novaCanoa){
        canoa = novaCanoa;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Rio.class.getSimpleName())
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
                .append('\n')
                .append(tabSpace)
                .append("Pedacos(")
                .append(lengthOfPedacos())
                .append("): ");
        
        for (int count = 0; count < lengthOfPedacos(); count++) {
            if (getPedaco(count).isMarcado()) {
                finalText.append("[O]");
            }
            else{
                finalText.append("[~]");
            }
        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("isCanoaDestruida: ")
                .append(isCanoaDestruida());
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private void copiarCanoaParaRio(){
        int contCanoa = 0;
        for (int contRio = 0; contRio < lengthOfPedacos(); contRio++) {
            if (contRio >= ultimaPosicaoCanoa && contRio < (ultimaPosicaoCanoa + canoa.lengthOfPedacosInteiros())) {
                if (canoa.getPedaco(contCanoa).isDestruido()) {
                    getPedaco(contRio).desmarcar();
                }
                else{
                    getPedaco(contRio).marcar();
                }
                contCanoa++;
            }
            else{
                getPedaco(contRio).desmarcar();
            }
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public int lengthOfPedacos(){
        return pedacos.size();
    }
    
    public void moverCanoa(int indiceNoRio){
        ultimaPosicaoCanoa = 
                indiceNoRio >= 0 &&
                indiceNoRio <= (lengthOfPedacos() - canoa.lengthOfPedacosInteiros()) ?
                indiceNoRio :
                    indiceNoRio < 0 ?
                    0 : (lengthOfPedacos() - canoa.lengthOfPedacosInteiros());
        
        copiarCanoaParaRio();
    }
    
    public boolean receberTiro(int indiceNoRio){
        if (indiceNoRio >= 0 && indiceNoRio < lengthOfPedacos() && getPedaco(indiceNoRio).isMarcado()) {
            getPedaco(indiceNoRio).desmarcar();
            canoa.destruirPedaco(indiceNoRio - ultimaPosicaoCanoa);
            copiarCanoaParaRio();
            return true;
        }
        
        return false;
    }
    
    public boolean isCanoaDestruida(){
        return canoa.isDestruida();
    }
    
    public void reconstruirCanoa(){
        canoa.reconstruirTodosPedacos();
    }
    
    public void reconstruirPedacoDaCanoa(int indicePedaco){
        canoa.reconstruirPedaco(indicePedaco);
    }
    
    public String toStringWithJustTheDrawing(){
        StringBuilder finalText = new StringBuilder(200);
        
        for (int count = 0; count < lengthOfPedacos(); count++) {
            if (getPedaco(count).isMarcado()) {
                finalText.append("[O]");
            }
            else{
                finalText.append("[~]");
            }
        }
        
        finalText                
                .append("   isCanoaDestruida: ")
                .append(isCanoaDestruida());
        
        return finalText.toString();
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
