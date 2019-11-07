package br.com.capivarawars.core.game.component;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.component.patterns.TipoAcessorio;
import br.com.capivarawars.core.primitive.Component;
import br.com.capivarawars.core.primitive.patterns.ImprovableToString;
import br.com.capivarawars.core.primitive.patterns.Listable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 01/10/2019, 21:20:41
 * Last update: -
 *///</editor-fold>
public class Pedacos extends Component implements Listable<Pedaco>{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private List<Pedaco> lista;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Pedacos(int quantidadePedacos){
        super();
        
        lista = new ArrayList<>(quantidadePedacos);        
        for (int cont = 0; cont < quantidadePedacos; cont++) {
            lista.add(cont, new Pedaco());
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Pedacos.class.getSimpleName())
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
            finalText.append(super.toStringWithAttibutesOnly_ComponentDemo(tabSizeForEachAttribute));
        }
                
        StringBuilder tabSpace = new StringBuilder();        
        for (int count = 0; count < tabSizeForEachAttribute; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("Pedacos: ")
                .append(length())
                .append(": ")
                .append("inteiros")
        
                .append('\n')
                .append(tabSpace)
                .append("isCanoaDestruida: ")
                .append(isTodosDestruidos());
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="Pedacos ArrayList  methods...">    
    @Override
    public int length() {
        return lista.size();
    }
    
    @Override
    public void add(Pedaco newItem) {
        lista.add(newItem);
    }

    @Override
    public void add(Pedaco... newItems) {
        lista.addAll(Arrays.asList(newItems));
    }
    
    @Override
    public void addAt(int index, Pedaco newItem) {
        lista.add(index, newItem);
    }
    
    @Override
    public Pedaco get(int indexOfItem) {
        if (indexOfItem >= 0 && indexOfItem < length()) {
            return lista.get(indexOfItem);
        }
        
        return null;
    }
    
    @Override
    public <I> I get(Class<I> classTypeOfItem) {
        for (Pedaco element : lista) {
            try {
                return classTypeOfItem.cast(element);
            } catch (Exception e) {}
        }

        return null;
    }

    @Override
    public <I> I get(Class<I> classTypeOfItem, int indexOfItem) {
        try {
            return classTypeOfItem.cast(get(indexOfItem));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pedaco> getAll() {
        return lista;
    }

    @Override
    public <I> List<I> getAll(Class<I> classTypeOfItem) {
        List<I> tempList = new ArrayList<>(length());
        
        for (Pedaco element : lista) {
            try {
                tempList.add(classTypeOfItem.cast(element));
            } catch (Exception e) {}
        }
        
        if (tempList.size() <= 0) {
            return null;
        }
        
        return tempList;
    }
    
    @Override
    public boolean isExists(Pedaco searchedItem) {
        return lista.contains(searchedItem);
    }

    @Override
    public int indexOf(Pedaco searchedItem) {
        return lista.indexOf(searchedItem);
    }
    
    @Override
    public boolean remove(int indexOfItem) {
        if (indexOfItem >= 0 && indexOfItem < length()) {
            return lista.remove(indexOfItem) != null;
        }
        
        return false;
    }

    @Override
    public boolean remove(Pedaco searchedItem) {
        return lista.remove(searchedItem);
    }
    
    @Override
    public void removeAll() {
        lista.clear();
    }
    
    @Override
    public boolean update(int indexOfItem, Pedaco newItem) {
        if (indexOfItem >= 0 && indexOfItem < length()) {
            return lista.set(indexOfItem, newItem) != null;
        }
        
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">    
    public int lengthOfInteiros(){
        int contPedacosInteiros = 0;
        for (int cont = 0; cont < length(); cont++) {
            if (!get(cont).isDestruido()) {
                contPedacosInteiros++;
            }
        }
        
        return contPedacosInteiros;
    }
        
    public int lengthOfMarcados(){
        int contPedacosMarcados = 0;
        for (int cont = 0; cont < length(); cont++) {
            if (get(cont).isMarcado()) {
                contPedacosMarcados++;
            }
        }
        
        return contPedacosMarcados;
    }
    
    public boolean isTodosDestruidos(){
        boolean destruido = true;
        
        for (int cont = 0; cont < length(); cont++) {
            destruido &= get(cont).isDestruido();
        }
        
        return destruido;
    }
    
    public boolean isDestruido(int indicePedaco){
        return get(indicePedaco).isDestruido();
    }    
    
    public boolean isTodosMarcados(){
        boolean marcado = true;
        
        for (int cont = 0; cont < length(); cont++) {
            marcado &= get(cont).isMarcado();
        }
        
        return marcado;
    }
    
    public boolean isMarcado(int indicePedaco){
        return get(indicePedaco).isMarcado();
    }    
    //</editor-fold>
    
    //</editor-fold>
    
}//class
