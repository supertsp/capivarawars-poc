package br.com.capivarawars.core.game;

//<editor-fold defaultstate="collapsed" desc="imports...">
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
 * @author TPEDROSO, 26/09/2019, 11:02:32
 * Last update: -
 *///</editor-fold>
public class GameObject {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private List<Component> components;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public GameObject(){
        components = new ArrayList<>(10);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public void addComponent(Component newComponent){
        components.add(newComponent);
        newComponent.setParentGameObject(this);
    }
    
    public void addComponent(Component... newComponents){
        for (Component singleComponent : newComponents) {
            addComponent(singleComponent);
            singleComponent.setParentGameObject(this);
        }
    }
    
    public Component getComponent(int indexOfComponent){
        if (indexOfComponent >= 0 && indexOfComponent < lengthOfComponents()) {
            return components.get(indexOfComponent);
        }
        
        return null;
    }
    
    public <T> T getComponent(Class<T> mappedClassToResults, int indexOfComponent){
       return (T) getComponent(indexOfComponent);
    }
    
    public boolean isExistsComponent(Component searchedComponent){
        return components.contains(searchedComponent);
    }
    
    public int indexOfComponent(Component searchedComponent){
        return components.indexOf(searchedComponent);
    }
    
    public boolean removeComponent(int indexOfComponent){
        if (indexOfComponent >= 0 && indexOfComponent < lengthOfComponents()) {
            return components.remove(indexOfComponent) != null;
        }
        
        return false;
    }
    
    public boolean removeComponent(Component searchedComponentt){        
            return components.remove(searchedComponentt);
    }
    
    public int lengthOfComponents(){
        return components.size();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public String componentsToString(){
        return components.toString();
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
