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
    private String name;
    private boolean gameObjectActive;
    private List<Component> components;
    private Coordinates coordinates;
    private GameObject parent;
    private List<GameObject> children;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    protected GameObject(Class classTypeForNameAttribute){
        setName(classTypeForNameAttribute.getSimpleName());
        setGameObjectActive(true);
        components = new ArrayList<>(10);
        coordinates = new Coordinates(true);
        addComponent(coordinates);
        setParent(null);
        children = new ArrayList<>(10);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getName(){
        return name;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public boolean isGameObjectActive(){
        return gameObjectActive;
    }
    
    public void setGameObjectActive(boolean newStatus){
        this.gameObjectActive = newStatus;
    }
    
    public Coordinates getCoordinates(){
        return coordinates;
    }
    
    public GameObject getParent(){
        return parent;
    }
    
    public void setParent(GameObject newGameObject){
        parent = newGameObject;
    }
    
    public static GameObject getInstance(){
        return new GameObject(GameObject.class) {
            @Override
            public String toStringWithAttibutesOnly(int tabSizeForEachAttribute) {
                return "";
            }
        };
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Components ArrayList  methods...">
    public int lengthOfComponents(){
        return components.size();
    }
    
    public void addComponent(Component newComponent){
        components.add(newComponent);
        newComponent.setGameObjectOwner(this);
    }
    
    public void addComponent(Component... newComponents){
        for (Component singleComponent : newComponents) {
            addComponent(singleComponent);
            singleComponent.setGameObjectOwner(this);
        }
    }
    
    public Component getComponent(int indexOfComponent){
        if (indexOfComponent >= 0 && indexOfComponent < lengthOfComponents()) {
            return components.get(indexOfComponent);
        }
        
        return null;
    }
    
    public <T> T getComponent(Class<T> classTypeOfComponent){
        for (Component element : components) {
            try {
                return classTypeOfComponent.cast(element);
            } catch (Exception e) {}
        }

        return null;
    }
    
    public <T> T getComponent(Class<T> classTypeOfComponent, int indexOfComponent){
        try {
            return classTypeOfComponent.cast(getComponent(indexOfComponent));
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Component> getComponents(){
        return components;
    }
    
    public <T> List<T> getComponents(Class<T> classTypeOfComponent){
        List<T> componentsList = new ArrayList<>(lengthOfComponents());
        
        for (Component element : components) {
            try {
                componentsList.add(classTypeOfComponent.cast(element));
            } catch (Exception e) {}
        }
        
        if (componentsList.size()<= 0) {
            return null;
        }
        
        return componentsList;
    }
    
    public <T> T getComponentInChild(int indexOfChild, Class<T> classTypeOfComponent){
        try {
            return getChild(indexOfChild).getComponent(classTypeOfComponent);
        } catch (Exception e) {
            return null;
        }
    }
    
    public <T> T getComponentInParent(Class<T> classTypeOfComponent){
        try {
            return getParent().getComponent(classTypeOfComponent);
        } catch (Exception e) {
            return null;
        }
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
    
    public boolean removeComponent(Component searchedComponent){        
            return components.remove(searchedComponent);
    }
    
    public boolean updateComponent(int indexOfComponent, Component newComponent){
        if (indexOfComponent >= 0 && indexOfComponent < lengthOfComponents()) {
            return components.set(indexOfComponent, newComponent) != null;
        }
        
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GameObject ArrayList  methods...">
    public int lengthOfChildren(){
        return children.size();
    }
    
    public void addChild(GameObject newChild){
        children.add(newChild);
        newChild.setParent(this);
    }
    
    public void addChild(GameObject... newChildren){
        for (GameObject singleChild : newChildren) {
            addChild(singleChild);
            singleChild.setParent(this);
        }
    }
    
    public GameObject getChild(int indexOfChild){
        if (indexOfChild >= 0 && indexOfChild < lengthOfChildren()) {
            return children.get(indexOfChild);
        }
        
        return null;
    }
    
    public <T> T getChild(Class<T> classTypeOfChild){
        for (GameObject element : children) {
            try {
                return classTypeOfChild.cast(element);
            } catch (Exception e) {}
        }

        return null;
    }
    
    public <T> T getChild(Class<T> classTypeOfChild, int indexOfChild){
        try {
            return classTypeOfChild.cast(getChild(indexOfChild));
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<GameObject> getChildren(){
        return children;
    }
    
    public <T> List<T> getChildren(Class<T> classTypeChild){
        List<T> childrenList = new ArrayList<>(lengthOfChildren());
        
        for (GameObject element : children) {
            try {
                childrenList.add(classTypeChild.cast(element));
            } catch (Exception e) {}
        }
        
        if (childrenList.size() <= 0) {
            return null;
        }
        
        return childrenList;
    }
    
    public boolean isExistsChild(GameObject searchedChild){
        return children.contains(searchedChild);
    }
    
    public int indexOfChild(GameObject searchedChild){
        return children.indexOf(searchedChild);
    }
    
    public boolean removeChild(int indexOfChild){
        if (indexOfChild >= 0 && indexOfChild < lengthOfChildren()) {
            return children.remove(indexOfChild) != null;
        }
        
        return false;
    }
    
    public boolean removeChild(GameObject searchedChild){        
        return children.remove(searchedChild);
    }
    
    public boolean updateChild(int indexOfChild, GameObject newChild){
        if (indexOfChild >= 0 && indexOfChild < lengthOfChildren()) {
            return children.set(indexOfChild, newChild) != null;
        }
        
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder(200);
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
        StringBuilder finalText = new StringBuilder(200);
        
        StringBuilder tabSpace = new StringBuilder();        
        for (int count = 0; count < tabSizeForEachAttribute; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("name: ")
                .append(getName())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("isGameObjectActive: ")
                .append(isGameObjectActive())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Coordinates: ")
                .append(getCoordinates().getX())
                .append(", ")
                .append(getCoordinates().getY())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Components(")
                .append(lengthOfComponents())
                .append("): ")
                .append(toStringWithComponentsOnly())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("parent: ");
        
        if (parent != null) {
            finalText.append(parent.getClass().getSimpleName());
        }
        else{
            finalText.append("null");
        }
        
        finalText
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Children(")
                .append(lengthOfChildren())
                .append("): ")
                .append(toStringWithChildrenOnly());
                
        return finalText.toString();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public String toStringWithComponentsOnly(){
        StringBuilder finalText = new StringBuilder(lengthOfComponents() * 10);
        
        if (lengthOfComponents()> 0) {
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
        } else{
            finalText.append("null");
        }
        
        return finalText.toString();
    }
    
    public String toStringWithChildrenOnly(){
        StringBuilder finalText = new StringBuilder(lengthOfChildren()* 10);
        
        if (lengthOfChildren() > 0) {
            for (int count = 0; count < lengthOfChildren(); count++) {
                if (count + 1 < lengthOfChildren()) {
                    finalText
                            .append(getChild(count).getClass().getSimpleName())
                            .append(" (")
                            .append(getChild(count).isGameObjectActive())
                            .append("), ");
                }
                else{
                    finalText
                            .append(getChild(count).getClass().getSimpleName())
                            .append(" (")
                            .append(getChild(count).isGameObjectActive())
                            .append(")");
                }
            }
        } else{
            finalText.append("null");
        }
        
        return finalText.toString();
    }
    
    //</editor-fold>
    
    //</editor-fold>
        
}//class
