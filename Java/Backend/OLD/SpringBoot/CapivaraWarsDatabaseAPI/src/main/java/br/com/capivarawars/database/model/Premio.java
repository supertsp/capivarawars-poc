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
@Table(name = "PREMIO")
public class Premio {

	//<editor-fold defaultstate="collapsed" desc="attributes...">
	//<editor-fold defaultstate="collapsed" desc="main attributes...">
	@Id
	@GeneratedValue
	@Column(name = "ID_PREMIO")
	private Long idPremio;

	@Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
	private String nome;

	@Column(name = "VALOR_EM_MOEDAS")
	private Integer valorEmMoedas;

	@Column(name = "URL_IMAGEM", length = VARCHAR_LENGTH_URL_IMAGEM)
	private String urlImagem;

	@Column(name = "DATAHORA_CRIACAO", columnDefinition = "DATETIME")
	private LocalDateTime dataHoraCriacao;

	/**
	 * RELATIONSHIPS
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "premioPrimeiroColocado")
	private List<Campeonato> listaDeCampeonatosComPrimeiroColocado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "premioSegundoColocado")
	private List<Campeonato> listaDeCampeonatosComSegundoColocado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "premioTerceiroColocado")
	private List<Campeonato> listaDeCampeonatosComTerceiroColocado;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idPremiosDoJogadorPK.premioFK")
	private List<PremiosDoJogador> listaDePremiosDoJogador;
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
	public Long getIdPremio() {
		return idPremio;
	}

	public Premio setIdPremio(Long idPremio) {
		this.idPremio = idPremio;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Premio setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Integer getValorEmMoedas() {
		return valorEmMoedas;
	}

	public Premio setValorEmMoedas(Integer valorEmMoedas) {
		this.valorEmMoedas = valorEmMoedas;
		return this;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public Premio setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
		return this;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public Premio setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
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
	public List<Campeonato> getListaDeCampeonatosComPrimeiroColocado() {
		return listaDeCampeonatosComPrimeiroColocado;
	}

	public Premio setListaDeCampeonatosComPrimeiroColocado(List<Campeonato> listaDeCampeonatosComPrimeiroColocado) {
		this.listaDeCampeonatosComPrimeiroColocado = listaDeCampeonatosComPrimeiroColocado;
		return this;
	}

	public List<Campeonato> getListaDeCampeonatosComSegundoColocado() {
		return listaDeCampeonatosComSegundoColocado;
	}

	public Premio setListaDeCampeonatosComSegundoColocado(List<Campeonato> listaDeCampeonatosComSegundoColocado) {
		this.listaDeCampeonatosComSegundoColocado = listaDeCampeonatosComSegundoColocado;
		return this;
	}

	public List<Campeonato> getListaDeCampeonatosComTerceiroColocado() {
		return listaDeCampeonatosComTerceiroColocado;
	}

	public Premio setListaDeCampeonatosComTerceiroColocado(List<Campeonato> listaDeCampeonatosComTerceiroColocado) {
		this.listaDeCampeonatosComTerceiroColocado = listaDeCampeonatosComTerceiroColocado;
		return this;
	}

	public List<PremiosDoJogador> getListaDePremiosDoJogador() {
		return listaDePremiosDoJogador;
	}

	public Premio setListaDePremiosDoJogador(List<PremiosDoJogador> listaDePremiosDoJogador) {
		this.listaDePremiosDoJogador = listaDePremiosDoJogador;
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
				&& valorEmMoedas != null
				&& urlImagem != null;
	}
	//</editor-fold>
	//</editor-fold>

}//class
