package br.com.capivarawars.core.game;


//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.Credencial;
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
public class Jogador {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    private String nome;
    private String nick;
    private Credencial credencial;
    private boolean online;
    private List<Coroa> coroas;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int qtdTirosCerteiros;
    private int qtdTirosRuins;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    
    //</editor-fold>
    
    //</editor-fold>
        
    
    
    

    public Jogador() {

    }

    public Jogador(String nome, String nick, String usuario, String senha) {
        this.nome = nome;
        this.nick = nick;
        credencial = new Credencial(usuario, senha);
    }

    public Jogador(String nome, String nick, Credencial credencial) {
        this.nome = nome;
        this.nick = nick;
        this.credencial = credencial;
    }

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

    public String getUsuario() {
        return credencial.getUsuario();
    }

    public String getSenha() {
        return credencial.getSenha();
    }

    public void setOnline(boolean estaOnline) {
        online = estaOnline;
    }

    public boolean isOnline() {
        return online;
    }

    public boolean equals(Object outroJogador) {
        return outroJogador instanceof Jogador
                && ((Jogador) outroJogador).nick.equals(nick)
                && ((Jogador) outroJogador).getUsuario().equals(getUsuario())
                && ((Jogador) outroJogador).getSenha().equals(getSenha());
    }

}
