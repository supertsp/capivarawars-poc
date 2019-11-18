package br.com.capivarawars.core.game.gameobject;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.game.MarcadorDeTempo;
import br.com.capivarawars.core.primitive.GameObject;
import br.com.capivarawars.core.primitive.patterns.ImprovableToString;
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
 * @author tiago, 03/10/2019, 16:58:35 Last update: -
 *///</editor-fold>
public class Partida extends GameObject {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private Jogadores jogadores;
    private boolean iniciou;
    private int indiceJogadorAtual;
    private int turnoAtual;
    private MarcadorDeTempo tempoDecorrido;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    //</editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Partida(Jogadores jogadores){
        super(Partida.class);
        this.jogadores = jogadores;
        indiceJogadorAtual = -1;
        tempoDecorrido = new MarcadorDeTempo(true);
    }
    
    public Partida(Jogador... jogadores) {
        super(Partida.class);

        this.jogadores = new Jogadores();
        addJogadores(jogadores);

        indiceJogadorAtual = -1;
        tempoDecorrido = new MarcadorDeTempo(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="methods...">
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public boolean isIniciou() {
        return iniciou;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }
    
    public void incrementaTurno(){
        turnoAtual++;
    }
    
//    public void setTurnoAtual(int turnoAtual) {
//        this.turnoAtual = turnoAtual;
//    }
    
    public Float getTempoDecorrido(){
        return tempoDecorrido.getTempoDecorrido();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Partida.class.getSimpleName())
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
                .append(jogadores.toStringWithAttibutesOnly(tabSizeForEachAttribute, false))
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("iniciou: ")
                .append(isIniciou())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("indiceJogadorAtual: ")
                .append(getIndiceJogadorAtual())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("turnoAtual: ")
                .append(getTurnoAtual())
                
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("tempoDecorrido: ")
                .append(getTempoDecorrido())
                
                .append(toStringWithRiverStatusOnly(tabSizeForEachAttribute));
      
        return finalText.toString();
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Jogadores Handler methods...">   
    public int lengthOfJogadores() {
        return jogadores.length();
    }

    public void addJogador(Jogador newItem) {
        jogadores.add(newItem);
    }

    public void addJogadores(Jogador... newItems) {
        jogadores.add(newItems);
    }

    public void addJogadorAt(int index, Jogador newItem) {
        jogadores.addAt(index, newItem);
    }

    public Jogador getJogador(int indexOfItem) {
        return jogadores.get(indexOfItem);
    }

    public <I> I getJogador(Class<I> classTypeOfItem) {
        return jogadores.get(classTypeOfItem);
    }

    public <I> I getJogador(Class<I> classTypeOfItem, int indexOfItem) {
        return jogadores.get(classTypeOfItem, indexOfItem);
    }

    public List<Jogador> getAllJogadores() {
        return jogadores.getAll();
    }

    public <I> List<I> getAllJogadores(Class<I> classTypeOfItem) {
        return jogadores.getAll(classTypeOfItem);
    }

    public boolean isJogadorExists(Jogador searchedItem) {
        return jogadores.isExists(searchedItem);
    }

    public int indexOfJogador(Jogador searchedItem) {
        return jogadores.indexOf(searchedItem);
    }

    public boolean removeJogador(int indexOfItem) {
        return jogadores.remove(indexOfItem);
    }

    public boolean removeJogador(Jogador searchedItem) {
        return jogadores.remove(searchedItem);
    }

    public void removeAllJogadores() {
        jogadores.removeAll();
    }

    public boolean updateJogador(int indexOfItem, Jogador newItem) {
        return jogadores.update(indexOfItem, newItem);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="main methods...">    
    public void iniciar() {
        if (lengthOfJogadores() >= 2) {
            iniciou = true;
            indiceJogadorAtual = 0;
            tempoDecorrido.iniciarTempo();
        }
    }

    public void terminar() {
        if (iniciou) {
            iniciou = false;
            indiceJogadorAtual = -1;
            jogadores.reiniciarCanoas();
            jogadores.aplicarDanoNasCapivaras();
            turnoAtual = 0;
            tempoDecorrido.pararTempo();
        }
    }

    public int getIndiceJogadorAtual() {
        return indiceJogadorAtual;
    }

    public void moverCanoaAtual(int posicaoNoRio) {
        if (iniciou) {
            getJogador(indiceJogadorAtual).moverCanoa(posicaoNoRio);
            indiceJogadorAtual++;
            indiceJogadorAtual = indiceJogadorAtual < lengthOfJogadores() ? indiceJogadorAtual : 0;
        }
    }

    public void atirarNoInimigo(int indiceJogadorInimigo, int posicaoTiro) {
        if (iniciou) {
            if (indiceJogadorInimigo >= 0 && indiceJogadorInimigo < lengthOfJogadores()) {
                if (indiceJogadorInimigo != indiceJogadorAtual) {
                    getJogador(indiceJogadorAtual).atirar(getJogador(indiceJogadorInimigo), posicaoTiro);
                } else {
                    indiceJogadorInimigo++;
                    indiceJogadorInimigo = indiceJogadorInimigo < lengthOfJogadores() ? indiceJogadorInimigo : 0;
                    getJogador(indiceJogadorAtual).atirar(getJogador(indiceJogadorInimigo), posicaoTiro);
                }
            } else {
                if (indiceJogadorInimigo < 0) {
                    indiceJogadorInimigo = 0;
                } else {
                    indiceJogadorInimigo = lengthOfJogadores() - 1;
                }

                if (indiceJogadorInimigo != indiceJogadorAtual) {
                    getJogador(indiceJogadorAtual).atirar(getJogador(indiceJogadorInimigo), posicaoTiro);
                } else {
                    indiceJogadorInimigo++;
                    indiceJogadorInimigo = indiceJogadorInimigo < lengthOfJogadores() ? indiceJogadorInimigo : 0;
                    getJogador(indiceJogadorAtual).atirar(getJogador(indiceJogadorInimigo), posicaoTiro);
                }
            }

            indiceJogadorAtual++;
            
            if (indiceJogadorAtual >= lengthOfJogadores()) {
                indiceJogadorAtual = 0;
                incrementaTurno();
            }
        }
    }
    
    
    public boolean terminou(){
        if (iniciou) {
            int contPerdeu = 0;
            for (int cont = 0; cont < lengthOfJogadores(); cont++) {
                if (getJogador(cont).perdeuCanoa()) {
                    contPerdeu++;
                }
            }

            return contPerdeu == lengthOfJogadores() || (contPerdeu + 1) == lengthOfJogadores();
        }

        return false;
    }
    
    
    public Jogador alguemGanhou() {
        if (iniciou) {            
            Jogador jogadorVencedor = null;
            int indiceJogadorVencedor = -1;

            for (int cont = 0; cont < lengthOfJogadores(); cont++) {
                if (!getJogador(cont).perdeuCanoa()) {
                    jogadorVencedor = getJogador(cont);
                    indiceJogadorVencedor = cont;
                }
            }

            if (jogadorVencedor != null) {
                for (int cont = 0; cont < lengthOfJogadores(); cont++) {
                    if (indiceJogadorVencedor == cont) {
                        getJogador(cont).incrementarVitorias(1);
                    }
                    else{
                        getJogador(cont).incrementarDerrotas(1);
                    }
                }

                terminar();
                return jogadorVencedor;
            }

            return null;
        }

        return null;
    }

    public boolean houveEmpate() {
        if (iniciou) {
            int contPerdeu = 0;
            for (int cont = 0; cont < lengthOfJogadores(); cont++) {
                if (getJogador(cont).perdeuCanoa()) {
                    contPerdeu++;
                }
            }

            boolean houveEmpate = contPerdeu == lengthOfJogadores();
            
            if (houveEmpate) {
                for (int cont = 0; cont < lengthOfJogadores(); cont++) {
                    getJogador(cont).incrementarEmpates(1);
                }
                
                terminar();                
            }
            
            return houveEmpate;
        }

        return false;
    }
    
    public String toStringWithRiverStatusOnly(int tabSizeForEachRiver) {
        StringBuilder finalText = new StringBuilder(200);
        
        StringBuilder tabSpace = new StringBuilder();        
        for (int count = 0; count < tabSizeForEachRiver; count++) {
            tabSpace.append(' ');
        }
        
        finalText
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append("Rios:");
        
        for (int count = 0; count < lengthOfJogadores(); count++) {
            finalText
                .append(ImprovableToString.ATTRIBUTE_SEPARATOR)
                .append('\n')
                .append(tabSpace)
                .append(tabSpace)
                .append(getJogador(count).getRio().toStringWithJustTheDrawing())
                .append("  -> ")
                .append(getJogador(count).getNomeCompleto());
        }
        
        return finalText.toString();
    }
    //</editor-fold>

    //</editor-fold>
}//class
