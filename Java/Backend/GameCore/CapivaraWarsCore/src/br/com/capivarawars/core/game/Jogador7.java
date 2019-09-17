package br.com.capivarawars.core.game;

//import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.capivarawars.core.Coroa7;
import br.com.capivarawars.core.Credencial7;
import java.util.List;

//import br.com.CapivaraWars.controller.Credencial7;


public class Jogador7 {

//	@JsonProperty
    private String nome;

//	@JsonProperty
    private String nick;

//	@JsonProperty
    private Credencial7 credencial;

//	@JsonProperty
    private boolean online;

    protected List<Coroa7> coroas;
    protected int vitorias;
    protected int derrotas;
    protected int empates;

    public Jogador7() {

    }

    public Jogador7(String nome, String nick, String usuario, String senha) {
        this.nome = nome;
        this.nick = nick;
        credencial = new Credencial7(usuario, senha);
    }

    public Jogador7(String nome, String nick, Credencial7 credencial) {
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

    public Credencial7 getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial7 credencial) {
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
        return outroJogador instanceof Jogador7
                && ((Jogador7) outroJogador).nick.equals(nick)
                && ((Jogador7) outroJogador).getUsuario().equals(getUsuario())
                && ((Jogador7) outroJogador).getSenha().equals(getSenha());
    }

}
