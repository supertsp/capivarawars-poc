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
 * @author TPEDROSO, 26/09/2019, 11:02:32
 * Last update: -
 *///</editor-fold>
public abstract class GameObject implements ImprovableToString{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private boolean gameObjectActive;
    private List<Component> components;
    private Coordinates coordinates;
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
        coordinates = new Coordinates(true);
        addComponent(coordinates);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public boolean isGameObjectActive(){
        return gameObjectActive;
    }
    
    public void setGameObjectActive(boolean newStatus){
        this.gameObjectActive = newStatus;
    }
    
    public Coordinates getCoordinates(){
        return coordinates;
    }
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
        StringBuffer finalText = new StringBuffer(200);
        finalText
                .append(GameObject.class.getSimpleName())
                .append(" ")
                .append(ImprovableToString.CLASS_OPENING_CHAR)
                .append(toStringWithAttibutesOnly_GameObjectDemo(ImprovableToString.TAB_SIZE))
                .append('\n')
                .append(ImprovableToString.CLASS_CLOSING_CHAR);
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">    
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    protected String toStringWithAttibutesOnly_GameObjectDemo(int tabSizeForEachAttribute){
        StringBuffer finalText = new StringBuffer(200);
        
        StringBuffer tabSpace = new StringBuffer();        
        for (int count = 0; count < tabSizeForEachAttribute; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("isGameObjectActive: ")
                .append(isGameObjectActive())
                
                .append('\n')
                .append(tabSpace)
                .append("Coordinates: ")
                .append(getCoordinates().getX())
                .append(", ")
                .append(getCoordinates().getY())
                
                .append('\n')
                .append(tabSpace)
                .append("AttachedComponents(")
                .append(lengthOfComponents())
                .append("): ")
                .append(componentsToString());
        
        return finalText.toString();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public String componentsToString(){
        StringBuffer finalText = new StringBuffer(lengthOfComponents() * 10);
        
        for (int count = 0; count < lengthOfComponents(); count++) {
            if (count + 1 < lengthOfComponents()) {
                finalText
                        .append(getComponent(count).getClass().getSimpleName())
                        .append(" (")
                        .append(getComponent(count).isComponentActive())
                        .append("), ");
            }
            else{
                finalText
                        .append(getComponent(count).getClass().getSimpleName())
                        .append(" (")
                        .append(getComponent(count).isComponentActive())
                        .append(")");
            }
        }
        return finalText.toString();
    }
    
    //</editor-fold>
    
    //</editor-fold>
        
}//class
