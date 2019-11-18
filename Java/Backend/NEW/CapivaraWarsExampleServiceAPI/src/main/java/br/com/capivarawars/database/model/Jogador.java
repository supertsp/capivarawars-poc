package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
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
	@JsonIgnore
	@OneToMany(mappedBy = "playerFK")
	private List<String> listOfMatchesPlayed;
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
