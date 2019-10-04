package br.com.capivarawars.core.game.gameobject;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.primitive.GameObject;
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
 * @author TPEDROSO, 03/10/2019, 14:08:56 Last update: -
 *///</editor-fold>
public class Jogadores extends GameObject implements Listable<Jogador> {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private List<Jogador> lista;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    //</editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Jogadores() {
        super(Jogador.class);
        lista = new ArrayList<>(10);
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
                .append(Jogadores.class.getSimpleName())
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
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Jogadores(")
                .append(length())
                .append("): ");

        if (length() > 0) {
            for (int count = 0; count < length(); count++) {
                if (count + 1 < length()) {
                    finalText
                            .append(get(count).getNome())
                            .append(" \"")
                            .append(get(count).getNick())
                            .append("\" [")
                            .append(get(count).getVitorias())
                            .append("V, ")
                            .append(get(count).getEmpates())
                            .append("E, ")
                            .append(get(count).getDerrotas())
                            .append("D")
                            .append("], ");
                } else {
                    finalText
                            .append(get(count).getNome())
                            .append(" \"")
                            .append(get(count).getNick())
                            .append("\" [")
                            .append(get(count).getVitorias())
                            .append("V, ")
                            .append(get(count).getEmpates())
                            .append("E, ")
                            .append(get(count).getDerrotas())
                            .append("D")
                            .append("]");
                }
            }
        } else {
            finalText.append("null");
        }

        return finalText.toString();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Jogadores ArrayList  methods...">    
    @Override
    public int length() {
        return lista.size();
    }

    @Override
    public void add(Jogador newItem) {
        lista.add(newItem);
    }

    @Override
    public void add(Jogador... newItems) {
        lista.addAll(Arrays.asList(newItems));
    }

    @Override
    public void addAt(int index, Jogador newItem) {
        lista.add(index, newItem);
    }

    @Override
    public Jogador get(int indexOfItem) {
        if (indexOfItem >= 0 && indexOfItem < length()) {
            return lista.get(indexOfItem);
        }

        return null;
    }

    @Override
    public <I> I get(Class<I> classTypeOfItem) {
        for (Jogador element : lista) {
            try {
                return classTypeOfItem.cast(element);
            } catch (Exception e) {
            }
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
    public List<Jogador> getAll() {
        return lista;
    }

    @Override
    public <I> List<I> getAll(Class<I> classTypeOfItem) {
        List<I> tempList = new ArrayList<>(length());

        for (Jogador element : lista) {
            try {
                tempList.add(classTypeOfItem.cast(element));
            } catch (Exception e) {
            }
        }

        if (tempList.size() <= 0) {
            return null;
        }

        return tempList;
    }

    @Override
    public boolean isExists(Jogador searchedItem) {
        return lista.contains(searchedItem);
    }

    @Override
    public int indexOf(Jogador searchedItem) {
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
    public boolean remove(Jogador searchedItem) {
        return lista.remove(searchedItem);
    }

    @Override
    public void removeAll() {
        lista.clear();
    }

    @Override
    public boolean update(int indexOfItem, Jogador newItem) {
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
    public void reiniciarCanoas() {
        for (int cont = 0; cont < length(); cont++) {
            get(cont).reiniciarCanoa();
        }
    }

    public void aplicarDanoNasCapivaras() {
        for (int cont = 0; cont < length(); cont++) {
            get(cont).getCapivara().receberDano();
        }
    }
    //</editor-fold>

    //</editor-fold>
}//class
