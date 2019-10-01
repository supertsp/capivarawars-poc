package br.com.capivarawars.core;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.component.BarraDeEnergia;
import br.com.capivarawars.core.game.gameobject.Capivara;
import br.com.capivarawars.core.game.component.Coroa;
import br.com.capivarawars.core.game.gameobject.Canoa;
import br.com.capivarawars.core.game.gameobject.Jogador;
import br.com.capivarawars.core.primitive.Coordinates;
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
    public static Capivara capivara;
    //</editor-fold>

    //<editor-fold desc="executable method...">
    public static void main(String[] args) {
        
        //<editor-fold defaultstate="collapsed" desc="TESTES: BARRA DE ENERGIA">
//        System.out.println("\n>>> Iniciando Capivara"); //7
//        capivara = new Capivara("Tidinha", CorPadrao.BRANCO);
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //6
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //5
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //4
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //3
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //2
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //1
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //0
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //0
//        capivara.receberDano();
//        System.out.println(capivara);
//        
//        System.out.println("\n>>> Recebendo -1 de dado"); //0
//        capivara.receberDano();
//        System.out.println(capivara);
        //</editor-fold>
        
//        iniciarTimerRegenercao();
        
//        Capivara capis = new Capivara("capis", CorPadrao.BRANCO);
//        capis.addComponent(new BarraDeEnergia(new Integer(0), new Integer(10), 3));
//        capis.addComponent(new BarraDeEnergia(new Integer(100), new Integer(1000), 50));
//        capis.addComponent(new Coroa("Coroa Azul", TipoCoroa.NACIONAL, 10));
        
//        System.out.println(capis);
        
//        Coordinates coor =  new Coordinates(10, 5);
//        System.out.println(coor);
        
        Canoa canoa = new Canoa("Banana", CorPadrao.ROXO, 4);
        System.out.println(canoa);
        
        canoa.destruirPedaco(3);
        System.out.println(canoa);
        
        canoa.destruirPedaco(2);
        System.out.println(canoa);
        
        canoa.destruirPedaco(2);
        System.out.println(canoa);
        
        canoa.destruirPedaco(1);
        System.out.println(canoa);
        
        canoa.destruirPedaco(0);
        System.out.println(canoa);
        
        canoa.reconstruirPedaco(1);
        System.out.println(canoa);
        
        canoa.reconstruirTodosPedacos();
        System.out.println(canoa);
        
        
//        
//        System.out.println("-------------");
//        BarraDeEnergia teste = capis.getComponent(BarraDeEnergia.class, 1);
//        BarraDeEnergia teste = (BarraDeEnergia) capis.getComponent(1);
//        System.out.println(teste);
//        System.out.println(capis.getComponents(BarraDeEnergia.class));
        
//        System.out.println(capis.getComponent(BarraDeEnergia.class, 1).getParentGameObject().lengthOfComponents());
//        System.out.println(capis.getComponent(BarraDeEnergia.class, 2).getParentGameObject(Capivara.class));
//        capis.getComponent(1).setComponentStatus(true);
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
    
    public static void iniciarTimerRegenercao(){
        int tempoEsperaAtualizaEmMili = 500;
        
        new Thread(()->{
            while (true) {                
                
                System.out.println("\n" + capivara);
                
                try {
                    Thread.sleep(tempoEsperaAtualizaEmMili);
                } catch (Exception e) {}
            }
        }).start();
    }
    //</editor-fold>

}//class
