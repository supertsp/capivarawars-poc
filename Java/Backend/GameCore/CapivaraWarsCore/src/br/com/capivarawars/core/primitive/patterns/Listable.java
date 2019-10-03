package br.com.capivarawars.core.primitive.patterns;

//<editor-fold defaultstate="collapsed" desc="imports...">

import java.util.List;

//import ...
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ... 
 * 
 * @version 1.0.0
 * @author TPEDROSO, 02/10/2019, 13:53:13
 * Last update: -
 * @param <T>
 *///</editor-fold>
public interface Listable<T> {
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">
    public int length();
    
    public void add(T newItem);
    
    public void add(T... newItems);
    
    public void addAt(int index, T newItem);
    
    public T get(int indexOfItem);
    
    public <I> I get(Class<I> classTypeOfItem);
    
    public <I> I get(Class<I> classTypeOfItem, int indexOfItem);
    
    public List<T> getAll();
    
    public <I> List<I> getAll(Class<I> classTypeOfItem);
    
    public boolean isExists(T searchedItem);
    
    public int indexOf(T searchedItem);
    
    public boolean remove(int indexOfItem);
    
    public boolean remove(T searchedItem);
    
    public void removeAll();
    
    public boolean update(int indexOfItem, T newItem);
    //</editor-fold>
    
}//interface
