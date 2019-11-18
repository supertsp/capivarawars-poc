package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

import javax.persistence.*;
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
@Entity
@Table(name = "ACESSORIO")
public class Acessorio {

	//<editor-fold defaultstate="collapsed" desc="attributes...">
	//<editor-fold defaultstate="collapsed" desc="main attributes...">
	@Id
	@GeneratedValue
	@Column(name = "ID_ACESSORIO")
	private Long idTipoAcessorio;

	@Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
	private String nome;

	@Column(name = "PRECO")
	private Integer preco;

	@Column(name = "URL_IMAGEM", length = VARCHAR_LENGTH_URL_IMAGEM)
	private String urlImagem;

	@Column(name = "DATAHORA_CRIACAO", columnDefinition = "DATETIME")
	private LocalDateTime dataHoraCriacao;

	/**
	 * RELATIONSHIPS
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_ACESSORIO")
	private TipoAcessorio tipoAcessorioFK;

	@JsonIgnore
	@OneToMany(mappedBy = "idAcessoriosDaCapivaraPK.acessorioFK")
	private List<AcessoriosDaCapivara> listaDeAcessoriosDaCapivara;
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="constants attributes...">
	public static final int VARCHAR_LENGTH_NOME = 120,
			VARCHAR_LENGTH_URL_IMAGEM = 255;

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
	public Long getIdTipoAcessorio() {
		return idTipoAcessorio;
	}

	public Acessorio setIdTipoAcessorio(Long idTipoAcessorio) {
		this.idTipoAcessorio = idTipoAcessorio;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Acessorio setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Integer getPreco() {
		return preco;
	}

	public Acessorio setPreco(Integer preco) {
		this.preco = preco;
		return this;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public Acessorio setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
		return this;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public Acessorio setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		if (dataHoraCriacao == null) {
			this.dataHoraCriacao = LocalDateTime.now();
		} else {
			this.dataHoraCriacao = dataHoraCriacao;
		}

		return this;
	}

	/**
	 * RELATIONSHIPS
	 */
	public TipoAcessorio getTipoAcessorioFK() {
		return tipoAcessorioFK;
	}

	public Acessorio setTipoAcessorioFK(TipoAcessorio tipoAcessorioFK) {
		this.tipoAcessorioFK = tipoAcessorioFK;
		return this;
	}

	public List<AcessoriosDaCapivara> getListaDeAcessoriosDaCapivara() {
		return listaDeAcessoriosDaCapivara;
	}

	public Acessorio setListaDeAcessoriosDaCapivara(List<AcessoriosDaCapivara> listaDeAcessoriosDaCapivara) {
		this.listaDeAcessoriosDaCapivara = listaDeAcessoriosDaCapivara;
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
	public boolean preencheuCamposObrigatorios() {
		if (dataHoraCriacao == null) {
			this.dataHoraCriacao = LocalDateTime.now();
		}

		return nome != null
				&& preco != null
				&& urlImagem != null
				&& tipoAcessorioFK != null;
	}
	//</editor-fold>
	//</editor-fold>

}//class
