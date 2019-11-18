package br.com.capivarawars;

//<editor-fold defaultstate="collapsed" desc="imports...">
import java.util.List;
import java.util.ArrayList;
import smartlog.LogFileHandler;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 23/10/2019, 19:10:35
 * Last update: -
 *///</editor-fold>
public class ListaAcessos {
    
    
    private static List<String> listaNick = new ArrayList<>();
    private static LogFileHandler logAcesso = new LogFileHandler("./", "savedLogs", "listaAcessos", "csv");
    
    public static void addNick(String novoNick){
        listaNick.add(novoNick);
        logAcesso.addLine(novoNick);
    }
    
    public static String getNick(int indice){
        return listaNick.get(indice);
    }
    
    public static int lengthOfNicks(){
        return listaNick.size();
    }
    
//    public static void salvarArquivoLog(){
//        for (String nick : listaNick) {
//            
//        }
//        
//    }
    
        
}//class
