package br.com.capivarawars.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.security.Cripotografia;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author TPEDROSO, 23/10/2019, 13:11:44 Last update: -
 *///</editor-fold>
public class Jogador {

	//<editor-fold defaultstate="collapsed" desc="attributes...">
	//<editor-fold defaultstate="collapsed" desc="main attributes...">
	private Long idJogador;
	private String nick;
	private String senha;
	private LocalDateTime dataHoraCriacaoConta;
	private String urlFoto;
	private String nomeCompleto;
	private String email;
	private Character genero;
	private LocalDate dataNascimento;
	private Boolean online;
	private String ultimoCodigoAtivacao;
	private Integer moedas;
	private Integer pontuacao;
	private Integer vitorias;
	private Integer empates;
	private Integer derrotas;
	private Integer qtdTirosCerteiros;
	private Integer qtdTirosRuins;
	private Integer qtdTirosRecebidos;
	private Integer qtdMovimentos;
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

	public Long getIdJogador() {
		return idJogador;
	}

	public Jogador setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
		return this;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSenhaSemSHA256(String senha) {
		this.senha = senha;
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

	public Jogador setOnline(Boolean online) {
		this.online = online;
		return this;
	}

	public String getUltimoCodigoAtivacao() {
		return ultimoCodigoAtivacao;
	}

	public Jogador setUltimoCodigoAtivacao(String ultimoCodigoAtivacao) {
		this.ultimoCodigoAtivacao = ultimoCodigoAtivacao;
		return this;
	}

	public Integer getMoedas() {
		return moedas;
	}

	public Jogador setMoedas(Integer moedas) {
		this.moedas = moedas;
		return this;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public Jogador setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
		return this;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public Jogador setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
		return this;
	}

	public Integer getEmpates() {
		return empates;
	}

	public Jogador setEmpates(Integer empates) {
		this.empates = empates;
		return this;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public Jogador setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
		return this;
	}

	public Integer getQtdTirosCerteiros() {
		return qtdTirosCerteiros;
	}

	public Jogador setQtdTirosCerteiros(Integer qtdTirosCerteiros) {
		this.qtdTirosCerteiros = qtdTirosCerteiros;
		return this;
	}

	public Integer getQtdTirosRuins() {
		return qtdTirosRuins;
	}

	public Jogador setQtdTirosRuins(Integer qtdTirosRuins) {
		this.qtdTirosRuins = qtdTirosRuins;
		return this;
	}

	public Integer getQtdTirosRecebidos() {
		return qtdTirosRecebidos;
	}

	public Jogador setQtdTirosRecebidos(Integer qtdTirosRecebidos) {
		this.qtdTirosRecebidos = qtdTirosRecebidos;
		return this;
	}

	public Integer getQtdMovimentos() {
		return qtdMovimentos;
	}

	public Jogador setQtdMovimentos(Integer qtdMovimentos) {
		this.qtdMovimentos = qtdMovimentos;
		return this;
	}
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

}//class
