package br.com.capivarawars.core.primitive;

//<editor-fold defaultstate="collapsed" desc="imports...">
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
 * @author TPEDROSO, 26/09/2019, 11:04:29
 * Last update: -
 *///</editor-fold>
public abstract class Component implements ImprovableToString{
    
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
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Component.class.getSimpleName())
                .append(" ")
                .append(ImprovableToString.CLASS_OPENING_CHAR)
                .append(toStringWithAttibutesOnly_ComponentDemo(ImprovableToString.TAB_SIZE))
                .append('\n')
                .append(ImprovableToString.CLASS_CLOSING_CHAR);
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">    
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    protected String toStringWithAttibutesOnly_ComponentDemo(int tabSizeForEachAttribute){
        StringBuilder finalText = new StringBuilder(200);
        
        StringBuilder tabSpace = new StringBuilder();        
        for (int count = 0; count < tabSizeForEachAttribute; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("isComponentActive: ")
                .append(isComponentActive())
                
                .append('\n')
                .append(tabSpace)
                .append("parentGameObject: ");
        
        if (parentGameObject != null) {
            finalText.append(getParentGameObject().getClass().getSimpleName());
        }
        else{
            finalText.append("null");
        }
        
        return finalText.toString();
    }
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
