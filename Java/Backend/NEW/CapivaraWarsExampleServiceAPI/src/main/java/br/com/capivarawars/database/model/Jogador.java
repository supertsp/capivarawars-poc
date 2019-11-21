package br.com.capivarawars.database.model;

// <editor-fold defaultstate="collapsed" desc="imports...">
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.database.repository.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import br.com.capivarawars.security.Criptografia;
import com.fasterxml.jackson.annotation.*;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 */// </editor-fold>
@Entity
@Table(name = "JOGADOR")
public class Jogador {

	// <editor-fold defaultstate="collapsed" desc="attributes...">
	// <editor-fold desc="DATABASE FIELDS..." defaultstate="collapsed">
	@Id
	@GeneratedValue
	@Column(name = "ID_JOGADOR")
	private Long idJogador;

	@Column(name = "NICK", length = 255, unique = true, nullable = false)
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
	// </editor-fold>
	// <editor-fold desc="RELATIONSHIPS..." defaultstate="collapsed">
//	@JsonIgnore
//	@OneToMany(mappedBy = "playerFK")
//	private List<String> listOfMatchesPlayed;
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constants attributes...">
	public static final int //
			VARCHAR_LENGTH_NICK = 45,
			PONTUACAO_PESO_MOVIMENTOS = 2 //
			;
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static attributes...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
	// </editor-fold>
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constructors...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="methods...">
	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public Long getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
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

	public LocalDateTime getDataHoraCriacaoConta() {
		return dataHoraCriacaoConta;
	}

	public void setDataHoraCriacaoConta(LocalDateTime dataHoraCriacaoConta) {
		this.dataHoraCriacaoConta = dataHoraCriacaoConta;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public String getUltimoCodigoAtivacao() {
		return ultimoCodigoAtivacao;
	}

	public void setUltimoCodigoAtivacao(String ultimoCodigoAtivacao) {
		this.ultimoCodigoAtivacao = ultimoCodigoAtivacao;
	}

	public Integer getMoedas() {
		return moedas;
	}

	public void setMoedas(Integer moedas) {
		this.moedas = moedas;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}

	public Integer getEmpates() {
		return empates;
	}

	public void setEmpates(Integer empates) {
		this.empates = empates;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}

	public Integer getQtdTirosCerteiros() {
		return qtdTirosCerteiros;
	}

	public void setQtdTirosCerteiros(Integer qtdTirosCerteiros) {
		this.qtdTirosCerteiros = qtdTirosCerteiros;
	}

	public Integer getQtdTirosRuins() {
		return qtdTirosRuins;
	}

	public void setQtdTirosRuins(Integer qtdTirosRuins) {
		this.qtdTirosRuins = qtdTirosRuins;
	}

	public Integer getQtdTirosRecebidos() {
		return qtdTirosRecebidos;
	}

	public void setQtdTirosRecebidos(Integer qtdTirosRecebidos) {
		this.qtdTirosRecebidos = qtdTirosRecebidos;
	}

	public Integer getQtdMovimentos() {
		return qtdMovimentos;
	}

	public void setQtdMovimentos(Integer qtdMovimentos) {
		this.qtdMovimentos = qtdMovimentos;
	}
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="override methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="main methods...">
	// </editor-fold>
	// </editor-fold>

}// class
