package br.com.capivarawars.core.game;

//import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.capivarawars.core.Coroa;
import java.util.List;

//import br.com.CapivaraWars.controller.Credencial7;


public class Jogador {

//	@JsonProperty
    private String nome;

//	@JsonProperty
    private String nick;

//	@JsonProperty
    private Credencial credencial;

//	@JsonProperty
    private boolean online;

    protected List<Coroa> coroas;
    protected int vitorias;
    protected int derrotas;
    protected int empates;

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
