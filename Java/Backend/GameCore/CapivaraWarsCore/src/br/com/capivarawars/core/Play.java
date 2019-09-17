package br.com.capivarawars.core;

//<editor-fold defaultstate="collapsed" desc="imports...">
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Scanner;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author TPEDROSO, 17/09/2019, 10:47:45
 *///</editor-fold>
public class Play {

    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    public static Scanner scanner = new Scanner(System.in);
    //</editor-fold>

    //<editor-fold desc="executable method...">
    public static void main(String[] args) {
        
        Jogador jogador = new Jogador();
        System.out.println(jogador);
        System.out.println("oi");

    }//main
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="static and auxiliary methods...">
    public static void print(Object message) {
        System.out.print(message);
    }

    public static void println(Object message) {
        System.out.println(message);
    }

    public static String readLine(Object message) {
        print(message);
        String readValue = "";
        try {
            readValue = scanner.nextLine();
        } catch (Exception e) {
        }
        print("");
        return readValue;
    }
    
    public static void showMessageDialog(Object message){
        JOptionPane.showMessageDialog(null, message, "Write Operation", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static String showInputDialog(Object message){
        String readValue = "";
        try {
            readValue = JOptionPane.showInputDialog(null, message, "Read Operation", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
        }
        return readValue;
    }
    //</editor-fold>

}//class
