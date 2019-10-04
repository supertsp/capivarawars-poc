package br.com.capivarawars.core;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.component.Acessorios;
import br.com.capivarawars.core.game.component.BarraDeEnergia;
import br.com.capivarawars.core.game.gameobject.Capivara;
import br.com.capivarawars.core.game.component.Coroa;
import br.com.capivarawars.core.game.component.Evolucao;
import br.com.capivarawars.core.game.component.Pedaco;
import br.com.capivarawars.core.game.component.Pedacos;
import br.com.capivarawars.core.game.gameobject.Canoa;
import br.com.capivarawars.core.game.gameobject.Jogador;
import br.com.capivarawars.core.game.gameobject.Partida;
import br.com.capivarawars.core.game.gameobject.Rio;
import br.com.capivarawars.core.primitive.*;
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
        //<editor-fold defaultstate="collapsed" desc="TESTES: CAPIVARA">
//        Capivara capis = new Capivara("capis", CorPadrao.BRANCO);
//        capis.addComponent(new BarraDeEnergia(new Integer(0), new Integer(10), 3));
//        capis.addComponent(new BarraDeEnergia(new Integer(100), new Integer(1000), 50));
//        capis.addComponent(new Coroa("Coroa Azul", TipoCoroa.NACIONAL, 10));
//        System.out.println(capis);
//        Coordinates coor =  new Coordinates(10, 5);
//        System.out.println(coor);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="TESTES: CANOA E RIO">
//        Canoa canoa = new Canoa("Banana", CorPadrao.ROXO, 4);
//        Rio rio = new Rio(10, canoa);
//        
//        int posicaoCanoa = 0;
//        int posicaoTiro = 0;
//        System.out.println("iniciando: Rio e Canoa...");
//        System.out.println(rio + "\n");
//        
//        
//        posicaoCanoa = 10;
//        posicaoTiro = 2;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//       
//        
//        posicaoCanoa = 10;
//        posicaoTiro = 8;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//       
//        
//        posicaoCanoa = 8;
//        posicaoTiro = 8;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//        
//        
//        posicaoCanoa = 8;
//        posicaoTiro = 6;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//       
//        posicaoCanoa = 1;
//        posicaoTiro = 1;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//       
//        posicaoCanoa = 9;
//        posicaoTiro = 1;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//       
//        
//        posicaoCanoa = 9;
//        posicaoTiro = 10;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//               
//        
//        posicaoCanoa = 9;
//        posicaoTiro = 9;
//        System.out.println("  >>>> movendo para " + posicaoCanoa);
//        rio.moverCanoa(posicaoCanoa);        
//        System.out.println("   -> atirando em " + posicaoTiro + ". Acertou? " + rio.receberTiro(posicaoTiro));
//        System.out.println(rio + "\n");
//       
//        System.out.println(canoa);
//        
//        rio.reconstruirCanoa();
//        
//        System.out.println(canoa);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="TESTES: ADD CHILD & ADD COMPONENTS">
//        
//        //Components
//        BarraDeEnergia<Integer> barraDeEnergia = new BarraDeEnergia(0, 10, 5.3f);
//        Coroa coroa = new Coroa("Coroa Mágica", TipoCoroa.CAPRICORNIO, 50);
//        Evolucao evolucao = new Evolucao();
//        Pedacos pedacos = new Pedacos(50);
//        
//        //Component -> Acessorio
//        AcessorioChapeu chapeu1 = new AcessorioChapeu(0, 0, "chapeu magico");
//        AcessorioChapeu chapeu2 = new AcessorioChapeu(0, 0, "chapeu peludo");
//        AcessorioChapeu chapeu3 = new AcessorioChapeu(0, 0, "chapeu azul");
//        AcessorioChapeu chapeu4 = new AcessorioChapeu(0, 0, "chapeu nacional");
//        
//        Acessorios acessorios = new Acessorios();
//        acessorios.add(chapeu1);
//        acessorios.add(chapeu2);
//        acessorios.add(chapeu3);        
//        System.out.println(acessorios);
//        
//        //GameObjects
//        Canoa canoa = new Canoa("Popye", CorPadrao.ROXO, 4);
////        System.out.println(canoa);
//        
//        Capivara capivara = new Capivara("capis", CorPadrao.BRANCO);
//        capivara.getAcessorios().add(chapeu1, chapeu2);
//        
//        Capivara capivaraNova = new Capivara("happy", CorPadrao.AMARELO);
//        
//        
//        System.out.println(capivara);
//
//        Rio rio = new Rio(10, canoa);
//        rio.setCanoa(canoa);
//        rio.addChild(capivara);
//        System.out.println(rio);
//        
//        //Add testes
//        GameObject gameObject = GameObject.instantiate();
//        //                       0       1       2      3
//        gameObject.addChildren(canoa, capivara, rio, capivaraNova);
//        gameObject.addComponents(barraDeEnergia, coroa, evolucao, pedacos);
//        
//        //parent testes
//        gameObject.setParent(rio);
//        
//        
//        System.out.println(gameObject);
//        
////        System.out.println(gameObject.getChildren(Capivara.class));
//        
////        gameObject.removeChild(capivara);
//        gameObject.updateChild(0, capivaraNova);
//        System.out.println(gameObject.getChild(0));
//        System.out.println(gameObject);
////        System.out.println(gameObject.isExistsChild(capivara));
//        
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="TESTES: PARTIDA">
        Partida partida = new Partida();
        int qtdJogadores = 2;
        int tamanhoRio = 10;
        int tamanhoCanoa = 4;
        String nomeJogador = "";
        String nomeCapivara = "";
        Jogador jogTemp = null;
        int posicaoEscolhida = 0;
        String mensagem = "";

        for (int indice = 0; indice < qtdJogadores; indice++) {
            nomeJogador = showInputDialog("JOGADOR " + (indice + 1) + "\n\nQual é o seu nome?");
            nomeCapivara = showInputDialog("JOGADOR " + (indice + 1) + "\n\nQual é nome da sua Capivara?");
            jogTemp = new Jogador(nomeJogador, nomeJogador, new Capivara(nomeCapivara, CorPadrao.TRANSPARENTE), tamanhoRio, tamanhoCanoa);
            partida.addJogador(jogTemp);
        }

        partida.iniciar();

        do {
            
            //MOVENDO CANOAS
            for (int indice = 0; indice < qtdJogadores; indice++) {
                try {
                    posicaoEscolhida = Integer.parseInt(showInputDialog(
                            partida.getJogador(indice).getNome() + " (J" + (indice + 1)
                            + ")\n\nQual nova posição da sua canoa?"
                    ));
                } catch (Exception e) {
                    posicaoEscolhida = 0;
                }

                partida.moverCanoaAtual(posicaoEscolhida);
            }
            
            //ATIRANDO NO INIMIGO
            for (int indice = 0; indice < qtdJogadores; indice++) {
                try {
                    posicaoEscolhida = Integer.parseInt(showInputDialog(
                            partida.getJogador(indice).getNome() + " (J" + (indice + 1)
                            + ")\n\nQual posição você quer ATIRAR?"
                    ));
                } catch (Exception e) {
                    posicaoEscolhida = 0;
                }

                partida.atirarNoInimigo(posicaoEscolhida + 1, posicaoEscolhida);
            }
            
            //Exibindo Resultados
            
        } while (!partida.terminou());

        System.out.println(partida);
        //</editor-fold>

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

    public static void showMessageDialog(Object message) {
        JOptionPane.showMessageDialog(null, message, "Write Operation", JOptionPane.PLAIN_MESSAGE);
    }

    public static String showInputDialog(Object message) {
        String readValue = "";
        try {
            readValue = JOptionPane.showInputDialog(null, message, "Read Operation", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
        }
        return readValue;
    }

    public static void iniciarTimerRegenercao() {
        int tempoEsperaAtualizaEmMili = 500;

        new Thread(() -> {
            while (true) {

                System.out.println("\n" + capivara);

                try {
                    Thread.sleep(tempoEsperaAtualizaEmMili);
                } catch (Exception e) {
                }
            }
        }).start();
    }
    //</editor-fold>

}//class
