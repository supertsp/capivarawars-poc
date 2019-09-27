package br.com.capivarawars.core.game.component;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.primitive.Component;
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
public class Acessorios extends Component {
    
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
    public void adicionar(TipoAcessorio novoAcessorio) {
        lista.add(novoAcessorio);
    }

    public void adicionar(TipoAcessorio... variosAcessorios) {
        lista.addAll(Arrays.asList(variosAcessorios));
    }

    public TipoAcessorio get(int indiceProcurado) {
        return lista.get(indiceProcurado);
    }

    public void remover(int indiceProcurado) {
        lista.remove(indiceProcurado);
    }

    public void remover(TipoAcessorio acessorioProcurado) {
        lista.remove(acessorioProcurado);
    }

    public int length() {
        return lista.size();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();        

        for (int cont = 0; cont < length(); cont++) {
            if ((cont + 1) >= length()) {
                stringBuffer.append(get(cont).getNomeAcessorio());
            } else {
                stringBuffer.append(get(cont).getNomeAcessorio() + ", ");
            }
        }

        return stringBuffer.toString();
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
