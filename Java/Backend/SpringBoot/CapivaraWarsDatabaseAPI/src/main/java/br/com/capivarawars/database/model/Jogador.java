package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.security.Cripotografia;
import com.fasterxml.jackson.annotation.*;
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
@Table(name = "JOGADOR")
public class Jogador {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_JOGADOR")
    private Long idJogador;

    @Column(name = "NICK", length = VARCHAR_LENGTH_NICK, unique=true, nullable=false)
    private String nick;

    @Column(name = "SENHA", length = VARCHAR_LENGTH_SENHA)
    private String senha;

    @Column(name = "DATAHORA_CRIACAO_CONTA", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraCriacaoConta;

    @Column(name = "URL_FOTO", length = VARCHAR_LENGTH_URL_FOTO)
    private String urlFoto;

    @Column(name = "NOME_COMPLETO", length = VARCHAR_LENGTH_NOME_COMPLETO)
    private String nomeCompleto;

    @Column(name = "EMAIL", length = VARCHAR_LENGTH_EMAIL, unique=true)
    private String email;

    @Column(name = "GENERO", length = CHAR_LENGTH_GENERO, columnDefinition = "CHAR")
    private Character genero;

    @Column(name = "DATA_NASCIMENTO", columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Column(name = "ONLINE")
    private Boolean online;

    @Column(name = "ULTIMO_CODIGO_ATIVACAO", length = VARCHAR_LENGTH_ULTIMO_CODIGO_ATIVACAO)
    private String ultimoCodigoAtivacao;
	
	@Column(name = "MOEDAS")
    private Integer moedas;
	
	@Column(name = "PONTUACAO")
    private Integer pontuacao;	
	
    @Column(name = "VITORIAS")
    private Integer vitorias;

    @Column(name = "EMPATES")
    private Integer empates;

    @Column(name = "DERROTAS")
    private Integer derrotas;

    @Column(name = "QTD_TIROS_CERTEIROS")
    private Integer qtdTirosCerteiros;

    @Column(name = "QTD_TIROS_RUINS")
    private Integer qtdTirosRuins;

    @Column(name = "QTD_TIROS_RECEBIDOS")
    private Integer qtdTirosRecebidos;

    @Column(name = "QTD_MOVIMENTOS")
    private Integer qtdMovimentos;

    /**
     * RELATIONSHIPS
     */
	@JsonIgnore
    @OneToMany(mappedBy = "jogadorFK")
    private List<Capivara> listaDeCapivaras;
	
	@JsonIgnore
    @OneToMany(mappedBy = "jogador1")
    private List<Partida> listaDePartidasComoJogador1;
	
	@JsonIgnore
    @OneToMany(mappedBy = "jogador2")
    private List<Partida> listaDePartidasComoJogador2;
	
	@JsonIgnore
    @OneToMany(mappedBy = "jogadorVencedor")
    private List<Partida> listaDePartidasComoVencedor;
	
	@JsonIgnore
    @OneToMany(mappedBy = "jogadorVencedorPrimeiro")
    private List<Campeonato> listaDeCampeonatosGanhosEmPrimeiro;

	@JsonIgnore
    @OneToMany(mappedBy = "jogadorVencedorSegundo")
    private List<Campeonato> listaDeCampeonatosGanhosEmSegundo;

	@JsonIgnore
    @OneToMany(mappedBy = "jogadorVencedorTerceiro")
    private List<Campeonato> listaDeCampeonatosGanhosEmTerceiro;
	
	@JsonIgnore
    @OneToMany(mappedBy = "idJogadoresEmCampeonatoPK.jogadorFK")
    private List<JogadoresEmCampeonato> listaDeCampeonatosParticipados;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int VARCHAR_LENGTH_NICK = 45,
            VARCHAR_LENGTH_SENHA = 45,
            VARCHAR_LENGTH_URL_FOTO = 255,
            VARCHAR_LENGTH_NOME_COMPLETO = 100,
            VARCHAR_LENGTH_EMAIL = 255,
            CHAR_LENGTH_GENERO = 1,
            VARCHAR_LENGTH_ULTIMO_CODIGO_ATIVACAO = 255,
			
			PONTUACAO_PESO_VITORIAS = 4,
			PONTUACAO_PESO_DERROTAS = 2,
			PONTUACAO_PESO_EMPATES = 1,
			PONTUACAO_PESO_TIROS_CERTEIROS = 3,
			PONTUACAO_PESO_TIROS_RUINS = 3,
			PONTUACAO_PESO_TIROS_RECEBIDOS = 2,
			PONTUACAO_PESO_MOVIMENTOS = 2
			;

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
        senha = senha.trim();
        this.senha = Cripotografia.getSHA256(senha);
    }
    
    public LocalDateTime getDataHoraCriacaoConta() {
        return dataHoraCriacaoConta;
    }

    public Jogador setDataHoraCriacaoConta(LocalDateTime dataHoraCriacaoConta) {
        if (dataHoraCriacaoConta == null) {
            this.dataHoraCriacaoConta = LocalDateTime.now();
        } else {
            this.dataHoraCriacaoConta = dataHoraCriacaoConta;
        }

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
        switch (genero) {
            case 'M':
            case 'm':
                genero = 'M';
                break;

            case 'F':
            case 'f':
                genero = 'F';
                break;

            default:
                genero = 'M';
        }
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

    /**
     * RELATIONSHIPS
     */
    public List<Capivara> getListaDeCapivaras() {
        return listaDeCapivaras;
    }

    public Jogador setListaDeCapivaras(List<Capivara> listaDeCapivaras) {
        this.listaDeCapivaras = listaDeCapivaras;
        return this;
    }

    public List<Partida> getListaDePartidasComoJogador1() {
        return listaDePartidasComoJogador1;
    }

    public Jogador setListaDePartidasComoJogador1(List<Partida> listaDePartidasComoJogador1) {
        this.listaDePartidasComoJogador1 = listaDePartidasComoJogador1;
        return this;
    }

    public List<Partida> getListaDePartidasComoJogador2() {
        return listaDePartidasComoJogador2;
    }

    public Jogador setListaDePartidasComoJogador2(List<Partida> listaDePartidasComoJogador2) {
        this.listaDePartidasComoJogador2 = listaDePartidasComoJogador2;
        return this;
    }

    public List<Partida> getListaDePartidasComoVencedor() {
        return listaDePartidasComoVencedor;
    }

    public Jogador setListaDePartidasComoVencedor(List<Partida> listaDePartidasComoVencedor) {
        this.listaDePartidasComoVencedor = listaDePartidasComoVencedor;
        return this;
    }

    public List<Campeonato> getListaDeCampeonatosGanhosEmPrimeiro() {
        return listaDeCampeonatosGanhosEmPrimeiro;
    }

    public Jogador setListaDeCampeonatosGanhosEmPrimeiro(List<Campeonato> listaDeCampeonatosGanhosEmPrimeiro) {
        this.listaDeCampeonatosGanhosEmPrimeiro = listaDeCampeonatosGanhosEmPrimeiro;
        return this;
    }

    public List<Campeonato> getListaDeCampeonatosGanhosEmSegundo() {
        return listaDeCampeonatosGanhosEmSegundo;
    }

    public Jogador setListaDeCampeonatosGanhosEmSegundo(List<Campeonato> listaDeCampeonatosGanhosEmSegundo) {
        this.listaDeCampeonatosGanhosEmSegundo = listaDeCampeonatosGanhosEmSegundo;
        return this;
    }

    public List<Campeonato> getListaDeCampeonatosGanhosEmTerceiro() {
        return listaDeCampeonatosGanhosEmTerceiro;
    }

    public Jogador setListaDeCampeonatosGanhosEmTerceiro(List<Campeonato> listaDeCampeonatosGanhosEmTerceiro) {
        this.listaDeCampeonatosGanhosEmTerceiro = listaDeCampeonatosGanhosEmTerceiro;
        return this;
    }

    public List<JogadoresEmCampeonato> getListaDeCampeonatosParticipados() {
        return listaDeCampeonatosParticipados;
    }

    public Jogador setListaDeCampeonatosParticipados(List<JogadoresEmCampeonato> listaDeCampeonatosParticipados) {
        this.listaDeCampeonatosParticipados = listaDeCampeonatosParticipados;
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
	public Integer calcularPontucao(){
		int tempVitorias = getVitorias() * PONTUACAO_PESO_VITORIAS;
		int tempEmpates = getEmpates() * PONTUACAO_PESO_EMPATES;
		int tempDerrotas = getDerrotas() * PONTUACAO_PESO_DERROTAS;
		int tempTirosCerteiros = getQtdTirosCerteiros() * PONTUACAO_PESO_TIROS_CERTEIROS;
		int tempTirosRuins = getQtdTirosRuins()* PONTUACAO_PESO_TIROS_RUINS;
		int tempTirosRecebidos = getQtdTirosRecebidos()* PONTUACAO_PESO_TIROS_RECEBIDOS;
		int tempMovimentos = getQtdMovimentos() / PONTUACAO_PESO_MOVIMENTOS;
		
		int tempPartidas = ((tempVitorias + tempEmpates) - tempDerrotas) * 3;		
		System.out.println("\nPONTUAÇÃO (tempPartidas): " + tempPartidas + "\n");
		
		int tempTiros = 0;
		
		try {
			tempTiros = (tempTirosCerteiros / Math.abs(tempTirosRuins - tempTirosRecebidos)) / 2;
		} catch (Exception e) {}				
		System.out.println("\nPONTUAÇÃO (tempTiros): " + tempTiros + "\n");
		
		try {
			pontuacao = (tempPartidas + tempTiros) / tempMovimentos;
		} catch (Exception e) {
			pontuacao = 0;
		}		
		System.out.println("\nPONTUAÇÃO (tempMovimentos): " + tempMovimentos + "\n");
		System.out.println("\nPONTUAÇÃO (tempPartidas + tempTiros): " + (tempTiros + tempPartidas) + "\n");		
		System.out.println("\nPONTUAÇÃO (final): " + pontuacao + "\n");
		
		return pontuacao;
	}
	
	public Jogador incrementMoedas(int incrementValue) {
        moedas += incrementValue;
        return this;
    }
	
	public Jogador incrementPontuacao(int incrementValue) {
        pontuacao += incrementValue;
        return this;
    }
	
	public Jogador incrementVitorias(int incrementValue) {
		vitorias += incrementValue;
		return this;
	}

    public Jogador incrementEmpates(int incrementValue) {
        empates += incrementValue;
        return this;
    }

    public Jogador incrementDerrotas(int incrementValue) {
        derrotas += incrementValue;
        return this;
    }
	
    public Jogador incrementQtdTirosCerteiros(int incrementValue) {
        qtdTirosCerteiros += incrementValue;
        return this;
    }

    public Jogador incrementQtdTirosRuins(int incrementValue) {
        qtdTirosRuins += incrementValue;
        return this;
    }

    public Jogador incrementQtdTirosRecebidos(int incrementValue) {
        qtdTirosRecebidos += incrementValue;
        return this;
    }

    public Jogador incrementQtdMovimentos(int incrementValue) {
        qtdMovimentos += incrementValue;
        return this;
    }
    
    public boolean preencheuCamposObrigatorios() {
        if (dataHoraCriacaoConta == null) {
            this.dataHoraCriacaoConta = LocalDateTime.now();
        }
		
		online = online == null ? false : online;
		
		moedas = moedas == null ? 0 : moedas;
		pontuacao = pontuacao == null ? 0 : pontuacao;
		vitorias = vitorias == null ? 0 : vitorias;
		empates = empates == null ? 0 : empates;
		derrotas = derrotas == null ? 0 : derrotas;		
		qtdTirosCerteiros = qtdTirosCerteiros == null ? 0 : qtdTirosCerteiros;
		qtdTirosRuins = qtdTirosRuins == null ? 0 : qtdTirosRuins;
		qtdTirosRecebidos = qtdTirosRecebidos == null ? 0 : qtdTirosRecebidos;
		qtdMovimentos = qtdMovimentos == null ? 0 : qtdMovimentos;
		
		calcularPontucao();
		
        return nick != null
                && senha != null
                && urlFoto != null
                && nomeCompleto != null
                && email != null
                && genero != null
                && dataNascimento != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
