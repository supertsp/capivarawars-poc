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
 * @author Tiago Penha Pedroso, 23 de set de 2019, 09:14:26 Last update: -
 *///</editor-fold>
public class Acessorios extends Component implements Listable<TipoAcessorio>{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
     private List<TipoAcessorio> lista;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Acessorios() {
        lista = new ArrayList<>();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Acessorios ArrayList  methods...">    
    @Override
    public int length() {
        return lista.size();
    }
    
    @Override
    public void add(TipoAcessorio newItem) {
        lista.add(newItem);
    }

    @Override
    public void add(TipoAcessorio... newItems) {
        lista.addAll(Arrays.asList(newItems));
    }

    @Override
    public TipoAcessorio get(int indexOfItem) {
        if (indexOfItem >= 0 && indexOfItem < length()) {
            return lista.get(indexOfItem);
        }
        
        return null;
    }
    
    @Override
    public <I> I get(Class<I> classTypeOfItem) {
        for (TipoAcessorio element : lista) {
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
    public List<TipoAcessorio> getAll() {
        return lista;
    }

    @Override
    public <I> List<I> getAll(Class<I> classTypeOfItem) {
        List<I> tempList = new ArrayList<>(length());
        
        for (TipoAcessorio element : lista) {
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
    public boolean isExists(TipoAcessorio searchedItem) {
        return lista.contains(searchedItem);
    }

    @Override
    public int indexOf(TipoAcessorio searchedItem) {
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
    public boolean remove(TipoAcessorio searchedItem) {
        return lista.remove(searchedItem);
    }
    
    @Override
    public void removeAll() {
        lista.clear();
    }
    
    @Override
    public boolean update(int indexOfItem, TipoAcessorio newItem) {
        if (indexOfItem >= 0 && indexOfItem < length()) {
            return lista.set(indexOfItem, newItem) != null;
        }
        
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Acessorios.class.getSimpleName())
                .append(' ')
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
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Acessorios(")
                .append(length())
                .append("): ");
        
        if (length()> 0) {
            for (int count = 0; count < length(); count++) {
                if (count + 1 < length()) {
                    finalText
                            .append(get(count).getClass().getSimpleName())
                            .append(" (")
                            .append(((Component)get(count)).isComponentActive())
                            .append("), ");
                }
                else{
                    finalText
                            .append(get(count).getClass().getSimpleName())
                            .append(" (")
                            .append(((Component)get(count)).isComponentActive())
                            .append(")");
                }
            }
        } else{
            finalText.append("null");
        }
        
        return finalText.toString();
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
