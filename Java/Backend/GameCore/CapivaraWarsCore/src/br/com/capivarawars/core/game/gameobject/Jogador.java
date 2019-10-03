package br.com.capivarawars.core.game.gameobject;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.*;
import br.com.capivarawars.core.game.component.*;
import br.com.capivarawars.core.primitive.*;
import br.com.capivarawars.core.primitive.patterns.*;
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
 * @author Tiago Penha Pedroso, 23 de set de 2019, 09:14:26
 * Last update: -
 *///</editor-fold>
public class Jogador extends GameObject{
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private String nome;
    private String nick;
    private Credencial credencial;
    private boolean online;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int qtdTirosCerteiros;
    private int qtdTirosRuins;
    private int qtdTirosRecebidos;
    private int qtdMovimentos;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int INDICE_CHILD_CAPIVARA = 0;
    public static final int INDICE_CHILD_RIO = 1;
    public static final int INDICE_CHILD_CANOA = 2;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Jogador(String nome, String nick, Capivara novaCapivara, int tamanhoRio, Canoa novaCanoa) {
        super(Jogador.class);
        this.nome = nome;
        this.nick = nick;
        credencial = new Credencial();
        Rio rio = new Rio(tamanhoRio, novaCanoa);
        
        super.addChild(novaCapivara);        
        super.addChild(rio);
        super.addChild(novaCanoa);
    }
    
    public Jogador(String nome, String nick, Capivara novaCapivara, int tamanhoRio, int tamanhoCanoa){
        this(nome, nick, novaCapivara, tamanhoRio, new Canoa("Vermelha", CorPadrao.VERMELHO, tamanhoCanoa));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
    
    public void setOnline(boolean estaOnline) {
        online = estaOnline;
    }

    public boolean isOnline() {
        return online;
    }

    public int getVitorias() {
        return vitorias;
    }
    
    public void incrementarVitorias(int valorIncremento) {
        vitorias += valorIncremento;
    }

//    public void setVitorias(int vitorias) {
//        this.vitorias = vitorias;
//    }

    public int getDerrotas() {
        return derrotas;
    }
    
    public void incrementarDerrotas(int valorIncremento) {
        derrotas += valorIncremento;
    }

//    public void setDerrotas(int derrotas) {
//        this.derrotas = derrotas;
//    }

    public int getEmpates() {
        return empates;
    }
    
    public void incrementarEmpates(int valorIncremento) {
        empates += valorIncremento;
    }
    
//    public void setEmpates(int empates) {
//        this.empates = empates;
//    }

    public int getQtdTirosCerteiros() {
        return qtdTirosCerteiros;
    }
    
    public void incrementarQtdTirosCerteiros(int valorIncremento) {
        qtdTirosCerteiros += valorIncremento;
    }

//    public void setQtdTirosCerteiros(int qtdTirosCerteiros) {
//        this.qtdTirosCerteiros = qtdTirosCerteiros;
//    }

    public int getQtdTirosRuins() {
        return qtdTirosRuins;
    }

    public void incrementarQtdTirosRuins(int valorIncremento) {
        qtdTirosRuins += valorIncremento;
    }
    
//    public void setQtdTirosRuins(int qtdTirosRuins) {
//        this.qtdTirosRuins = qtdTirosRuins;
//    }
    
    public int getQtdTirosRecebidos() {
        return qtdTirosRecebidos;
    }

    public void incrementarQtdTirosRecebidos(int valorIncremento) {
        qtdTirosRecebidos += valorIncremento;
    }
    
//    public void setQtdTirosRecebidos(int qtdTirosRecebidos) {
//        this.qtdTirosRecebidos = qtdTirosRecebidos;
//    }
    
    public int getQtdMovimentos() {
        return qtdMovimentos;
    }

    public void incrementarQtdMovimentos(int valorIncremento) {
        qtdMovimentos += valorIncremento;
    }
    
//    public void setQtdMovimentos(int qtdMovimentos) {
//        this.qtdMovimentos = qtdMovimentos;
//    }
    
    public Capivara getCapivara(){
        return super.getChild(Capivara.class, INDICE_CHILD_CAPIVARA);
    }
    
    public void setCapivara(Capivara novaCapivara){
        super.updateChild(INDICE_CHILD_CAPIVARA, novaCapivara);
    }
    
    public Rio getRio(){
        return super.getChild(Rio.class, INDICE_CHILD_RIO);
    }
    
    public void setRio(Rio novoRio){
        super.updateChild(INDICE_CHILD_RIO, novoRio);
    }
    
    public Canoa getCanoa(){
        return super.getChild(Canoa.class, INDICE_CHILD_CANOA);
    }
    
    public void setCanoa(Canoa novaCanoa){
        super.updateChild(INDICE_CHILD_CANOA, novaCanoa);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
//    @Override
//    public boolean equals(Object outroJogador) {
//        return outroJogador instanceof Jogador
//                && ((Jogador) outroJogador).nick.equals(nick)
//                && ((Jogador) outroJogador).getUsuario().equals(getUsuario())
//                && ((Jogador) outroJogador).getSenha().equals(getSenha());
//    }
    
    @Override
    public String toString() {
        StringBuilder finalText = new StringBuilder();
        
        finalText
                .append(Rio.class.getSimpleName())
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
                .append('\n')
                .append(tabSpace)
                .append("Pedacos(")
//                .append(lengthOfPedacos())
                .append("): ");
        
//        for (int count = 0; count < lengthOfPedacos(); count++) {
//            if (getPedaco(count).isMarcado()) {
//                finalText.append("[O]");
//            }
//            else{
//                finalText.append("[~]");
//            }
//        }
        
        finalText
                .append('\n')
                .append(tabSpace)
                .append("isCanoaDestruida: ");
//                .append(isCanoaDestruida());
        
        return finalText.toString();
    }
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private boolean receberTiro(int posicaoTiro){
        boolean recebeuTiro = getRio().receberTiro(posicaoTiro);
        
        if (recebeuTiro) {
            incrementarQtdTirosRecebidos(1);            
        }
        
        return recebeuTiro;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public boolean atirar(Jogador inimigo, int posicaoTiro){
        boolean acertouTiro = inimigo.receberTiro(posicaoTiro);
        
        if (acertouTiro) {
            incrementarQtdTirosCerteiros(1);
        }
        else{
            incrementarQtdTirosRuins(1);
        }
        
        return acertouTiro;
    }
    
    public void moverCanoa(int posicaoCanoa){
        getRio().moverCanoa(posicaoCanoa);
        incrementarQtdMovimentos(1);
    }
    
    public boolean perdeuCanoa(){
        return getRio().isCanoaDestruida();
    }
    
    public void reiniciarCanoa(){
        getRio().reconstruirCanoa();
    }
    //</editor-fold>
    
    //</editor-fold>    

}//class
