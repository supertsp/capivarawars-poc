package br.com.capivarawars.core.game.gameobject;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.*;
import br.com.capivarawars.core.game.component.*;
import br.com.capivarawars.core.primitive.*;
import br.com.capivarawars.core.primitive.patterns.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String nick;
    private LocalDateTime dataHoraCriacaoConta;
    private String urlFoto;
    private String nomeCompleto;
    private String email;
    private Character genero;
    private LocalDate dataNascimento;
    private Boolean online;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;
    private Integer moedas;
    private Integer qtdTirosCerteiros;
    private Integer qtdTirosRuins;
    private Integer qtdTirosRecebidos;
    private Integer qtdMovimentos;
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
    public Jogador(String nomeCompleto, String nick, Capivara novaCapivara, int tamanhoRio, Canoa novaCanoa) {
        super(Jogador.class);
        this.nomeCompleto = nomeCompleto;
        this.nick = nick;
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
    public String getNick() {
        return nick;
    }

    public Jogador setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public LocalDateTime getDataHoraCriacaoConta() {
        return dataHoraCriacaoConta;
    }

    public Jogador setDataHoraCriacaoConta(LocalDateTime dataHoraCriacaoConta) {
        this.dataHoraCriacaoConta = dataHoraCriacaoConta;
        return this;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public Jogador setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
        return this;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Jogador setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Jogador setEmail(String email) {
        this.email = email;
        return this;
    }

    public Character getGenero() {
        return genero;
    }

    public Jogador setGenero(Character genero) {
        this.genero = genero;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Jogador setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
    
    public Boolean isOnline() {
        return online;
    }

    public Jogador setOnline(boolean estaOnline) {
        online = estaOnline;
        return this;
    }
    
    public Integer getVitorias() {
        return vitorias;
    }
    
    public Jogador incrementarVitorias(int valorIncremento) {
        vitorias += valorIncremento;
        return this;
    }

    public Jogador setVitorias(int vitorias) {
        this.vitorias = vitorias;
        return this;
    }
        
    public Integer getEmpates() {
        return empates;
    }
    
    public Jogador incrementarEmpates(int valorIncremento) {
        empates += valorIncremento;
        return this;
    }
    
    public Jogador setEmpates(int empates) {
        this.empates = empates;
        return this;
    }
    
    public int getDerrotas() {
        return derrotas;
    }
    
     public Jogador incrementarDerrotas(int valorIncremento) {
        derrotas += valorIncremento;
        return this;
    }

    public Jogador setDerrotas(int derrotas) {
        this.derrotas = derrotas;
        return this;
    }
    
    public Integer getMoedas() {
        return moedas;
    }
    
    public Jogador incrementarMoedas(int valorIncremento) {
        moedas += valorIncremento;
        return this;
    }
    
    public Jogador setMoedas(Integer moedas) {
        this.moedas = moedas;
        return this;
    }

    public int getQtdTirosCerteiros() {
        return qtdTirosCerteiros;
    }
    
    public Jogador incrementarQtdTirosCerteiros(int valorIncremento) {
        qtdTirosCerteiros += valorIncremento;
        return this;
    }

    public Jogador setQtdTirosCerteiros(int qtdTirosCerteiros) {
        this.qtdTirosCerteiros = qtdTirosCerteiros;
        return this;
    }

    public int getQtdTirosRuins() {
        return qtdTirosRuins;
    }

    public Jogador incrementarQtdTirosRuins(int valorIncremento) {
        qtdTirosRuins += valorIncremento;
        return this;
    }
    
    public Jogador setQtdTirosRuins(int qtdTirosRuins) {
        this.qtdTirosRuins = qtdTirosRuins;
        return this;
    }
    
    public int getQtdTirosRecebidos() {
        return qtdTirosRecebidos;
    }

    public Jogador incrementarQtdTirosRecebidos(int valorIncremento) {
        qtdTirosRecebidos += valorIncremento;
        return this;
    }
    
    public Jogador setQtdTirosRecebidos(int qtdTirosRecebidos) {
        this.qtdTirosRecebidos = qtdTirosRecebidos;
        return this;
    }
    
    public int getQtdMovimentos() {
        return qtdMovimentos;
    }

    public Jogador incrementarQtdMovimentos(int valorIncremento) {
        qtdMovimentos += valorIncremento;
        return this;
    }
    
    public Jogador setQtdMovimentos(int qtdMovimentos) {
        this.qtdMovimentos = qtdMovimentos;
        return this;
    }
    
    public Capivara getCapivara(){
        return super.getChild(Capivara.class, INDICE_CHILD_CAPIVARA);
    }
    
    public Jogador setCapivara(Capivara novaCapivara){
        super.updateChild(INDICE_CHILD_CAPIVARA, novaCapivara);
        return this;
    }
    
    public Rio getRio(){
        return super.getChild(Rio.class, INDICE_CHILD_RIO);
    }
    
    public Jogador setRio(Rio novoRio){
        super.updateChild(INDICE_CHILD_RIO, novoRio);
        return this;
    }
    
    public Canoa getCanoa(){
        return super.getChild(Canoa.class, INDICE_CHILD_CANOA);
    }
    
    public Jogador setCanoa(Canoa novaCanoa){
        super.updateChild(INDICE_CHILD_CANOA, novaCanoa);
        return this;
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
