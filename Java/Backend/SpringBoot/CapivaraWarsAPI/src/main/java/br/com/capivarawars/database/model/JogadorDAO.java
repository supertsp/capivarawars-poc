package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.game.gameobject.Jogador;
import br.com.capivarawars.security.Credenciais;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * @author TPEDROSO, 23/10/2019, 13:11:44
 * Last update: -
 *///</editor-fold>
@Entity
@Table(name="JOGADOR")
public class JogadorDAO {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_JOGADOR")
    private Long idJogador;
    
    @JsonProperty
    @Embedded
    private Credenciais credenciais;
    
    @Column(name = "DATAHORA_CRIACAO_CONTA", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraCriacaoConta;
    
    @Column(name = "URL_FOTO", length = VARCHAR_LENGTH_URL_FOTO)
    private String urlFoto;
    
    @Column(name = "NOME_COMPLETO", length = VARCHAR_LENGTH_NOME_COMPLETO)
    private String nomeCompleto;
    
    @Column(name = "EMAIL", length = VARCHAR_LENGTH_EMAIL)
    private String email;
        
    @Column(name = "GENERO", length = CHAR_LENGTH_GENERO, columnDefinition = "CHAR")
    private Character genero;
    
    @Column(name = "DATA_NASCIMENTO", columnDefinition = "DATE")
    private LocalDate dataNascimento;
    
    @Column(name = "ONLINE")
    private Boolean online;
    
    @Column(name = "ULTIMO_CODIGO_ATIVACAO", length = VARCHAR_LENGTH_ULTIMO_CODIGO_ATIVACAO)
    private String ultimoCodigoAtivacao;
    
    @Column(name = "VITORIAS")
    private Integer vitorias;
    
    @Column(name = "EMPATES")
    private Integer empates;
    
    @Column(name = "DERROTAS")
    private Integer derrotas;
    
    @Column(name = "MOEDAS")
    private Integer moedas;
    
    @Column(name = "QTD_TIROS_CERTEIROS")
    private Integer qtdTirosCerteiros;
    
    @Column(name = "QTD_TIROS_RUINS")
    private Integer qtdTirosRuins;
    
    @Column(name = "QTD_TIROS_RECEBIDOS")
    private Integer qtdTirosRecebidos;
    
    @Column(name = "QTD_MOVIMENTOS")
    private Integer qtdMovimentos;
    
    @OneToMany(mappedBy = "jogadorDAO")
    private List<CapivaraDAO> listaCapivaraDAO;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int            
            VARCHAR_LENGTH_URL_FOTO = 255,
            VARCHAR_LENGTH_NOME_COMPLETO = 100,
            VARCHAR_LENGTH_EMAIL = 255,
            CHAR_LENGTH_GENERO = 1,
            VARCHAR_LENGTH_ULTIMO_CODIGO_ATIVACAO = 255;
            
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public JogadorDAO() {
        super();
    }
    
    public JogadorDAO(Credenciais credenciais, LocalDateTime dataHoraCriacaoConta, String urlFoto, String nomeCompleto, String email, Character genero, LocalDate dataNascimento, Boolean online, Integer moedas) {
        this.credenciais = credenciais;
        this.dataHoraCriacaoConta = dataHoraCriacaoConta;
        this.urlFoto = urlFoto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.online = online;
        this.moedas = moedas;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public Long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Long idJogador) {
        this.idJogador = idJogador;
    }

    public Credenciais getCredenciais() {
        return credenciais;
    }

    public void setCredenciais(Credenciais credenciais) {
        this.credenciais = credenciais;
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

    public Boolean isOnline() {
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

    public Integer getMoedas() {
        return moedas;
    }

    public void setMoedas(Integer moedas) {
        this.moedas = moedas;
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

    public List<CapivaraDAO> getListaCapivaraDAO() {
        return listaCapivaraDAO;
    }

    public void setListaCapivaraDAO(List<CapivaraDAO> listaCapivaraDAO) {
        this.listaCapivaraDAO = listaCapivaraDAO;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public Jogador fillJogador(Jogador jogador){
        jogador
            .setNick(getCredenciais().getNick())
            .setDataHoraCriacaoConta(getDataHoraCriacaoConta())
            .setUrlFoto(getUrlFoto())
            .setNomeCompleto(getNomeCompleto())
            .setEmail(getEmail())
            .setGenero(getGenero())
            .setDataNascimento(getDataNascimento())
            .setOnline(isOnline())
            .setVitorias(getVitorias())
            .setEmpates(getEmpates())
            .setDerrotas(getDerrotas())
            .setMoedas(getMoedas())
            .setQtdTirosCerteiros(getQtdTirosCerteiros())
            .setQtdTirosRuins(getQtdTirosRuins())
            .setQtdTirosRecebidos(getQtdTirosRecebidos())
            .setQtdMovimentos(getQtdMovimentos())
            ;
        return jogador;
    }
    //</editor-fold>
    
    //</editor-fold>

    

    
           
}//class
