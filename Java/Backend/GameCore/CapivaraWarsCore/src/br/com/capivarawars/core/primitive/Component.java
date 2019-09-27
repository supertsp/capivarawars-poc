package br.com.capivarawars.core.primitive;

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
 * @author TPEDROSO, 26/09/2019, 11:04:29
 * Last update: -
 *///</editor-fold>
public abstract class Component {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private boolean componentActive;
    private GameObject parentGameObject;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Component(){
        componentActive = true;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public boolean isComponentActive() {
        return componentActive;
    }

    public void setComponentActive(boolean newStatus) {
        this.componentActive = newStatus;
    }

    public GameObject getParentGameObject() {
        return parentGameObject;
    }
    
    public <T> T getParentGameObject(Class<T> classType) {
        try {
            return classType.cast(getParentGameObject());
        } catch (Exception e) {
            return null;
        }
    }

    void setParentGameObject(GameObject parentGameObject) {
        this.parentGameObject = parentGameObject;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public Coordinates getGameObjectCoordinates(){
        return parentGameObject.getCoordinates();
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
