package br.com.capivarawars.core.primitive;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.component.Posicao;
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
public abstract class GameObject {
    
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
        Posicao posicao = new Posicao(true);
        addComponent(posicao);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Component ArrayList  methods...">
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
    
    public <T> T getComponent(Class<T> classType){
        for (Component element : components) {
            try {
                return classType.cast(element);
            } catch (Exception e) {}
        }

        return null;
    }
    
    public <T> T getComponent(Class<T> classType, int indexOfComponent){
        try {
            return classType.cast(getComponent(indexOfComponent));
        } catch (Exception e) {
            return null;
        }
    }
    
    public <T> List<T> getComponents(Class<T> classType){
        List<T> componentsList = new ArrayList<>(lengthOfComponents());
        
        for (Component element : components) {
            try {
                componentsList.add(classType.cast(element));
            } catch (Exception e) {}
        }
        
        if (componentsList.size()<= 0) {
            return null;
        }
        
        return componentsList;
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
    @Override
    public String toString() {
        StringBuffer textoFinal = new StringBuffer();
        
        textoFinal.append("\n  Todos Components: { ")
                .append(componentsToString())
                .append(" }");
        
        return textoFinal.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public String componentsToString(){
        StringBuffer finalText = new StringBuffer(lengthOfComponents() * 10);
        
        for (int count = 0; count < lengthOfComponents(); count++) {
            if (count + 1 < lengthOfComponents()) {
                finalText.append(getComponent(count).getClass().getSimpleName());
                finalText.append(", ");
            }
            else{
                finalText.append(getComponent(count).getClass().getSimpleName());
            }
        }
        return finalText.toString();
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
