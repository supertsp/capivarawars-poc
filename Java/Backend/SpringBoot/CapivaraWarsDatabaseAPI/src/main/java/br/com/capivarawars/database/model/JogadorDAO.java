package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
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
    
    @OneToOne(mappedBy = "jogador1")
    private PartidaDAO partidaDAO1;
    
    @OneToOne(mappedBy = "jogador2")
    private PartidaDAO partidaDAO2;
    
    @OneToOne(mappedBy = "jogadorVencedor")
    private PartidaDAO partidaDAOVencedor;
    
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
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public Long getIdJogador() {
        return idJogador;
    }

    public JogadorDAO setIdJogador(Long idJogador) {
        this.idJogador = idJogador;
        return this;
    }

    public Credenciais getCredenciais() {
        return credenciais;
    }

    public JogadorDAO setCredenciais(Credenciais credenciais) {
        this.credenciais = credenciais;
        return this;
    }

    public LocalDateTime getDataHoraCriacaoConta() {
        return dataHoraCriacaoConta;
    }

    public JogadorDAO setDataHoraCriacaoConta(LocalDateTime dataHoraCriacaoConta) {
        if (dataHoraCriacaoConta == null) {
            this.dataHoraCriacaoConta = LocalDateTime.now();
        }
        else{
            this.dataHoraCriacaoConta = dataHoraCriacaoConta;
        }
        
        return this;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public JogadorDAO setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public JogadorDAO setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public JogadorDAO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Character getGenero() {
        return genero;
    }

    public JogadorDAO setGenero(Character genero) {
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

    public JogadorDAO setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Boolean isOnline() {
        return online;
    }

    public JogadorDAO setOnline(Boolean online) {
        this.online = online;
        return this;
    }

    public String getUltimoCodigoAtivacao() {
        return ultimoCodigoAtivacao;
    }

    public JogadorDAO setUltimoCodigoAtivacao(String ultimoCodigoAtivacao) {
        this.ultimoCodigoAtivacao = ultimoCodigoAtivacao;
        return this;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public JogadorDAO setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
        return this;
    }

    public Integer getEmpates() {
        return empates;
    }

    public JogadorDAO setEmpates(Integer empates) {
        this.empates = empates;
        return this;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public JogadorDAO setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
        return this;
    }

    public Integer getMoedas() {
        return moedas;
    }

    public JogadorDAO setMoedas(Integer moedas) {
        this.moedas = moedas;
        return this;
    }

    public Integer getQtdTirosCerteiros() {
        return qtdTirosCerteiros;
    }

    public JogadorDAO setQtdTirosCerteiros(Integer qtdTirosCerteiros) {
        this.qtdTirosCerteiros = qtdTirosCerteiros;
        return this;
    }

    public Integer getQtdTirosRuins() {
        return qtdTirosRuins;
    }

    public JogadorDAO setQtdTirosRuins(Integer qtdTirosRuins) {
        this.qtdTirosRuins = qtdTirosRuins;
        return this;
    }

    public Integer getQtdTirosRecebidos() {
        return qtdTirosRecebidos;
    }

    public JogadorDAO setQtdTirosRecebidos(Integer qtdTirosRecebidos) {
        this.qtdTirosRecebidos = qtdTirosRecebidos;
        return this;
    }

    public Integer getQtdMovimentos() {
        return qtdMovimentos;
    }

    public JogadorDAO setQtdMovimentos(Integer qtdMovimentos) {
        this.qtdMovimentos = qtdMovimentos;
        return this;
    }

    public List<CapivaraDAO> getListaCapivaraDAO() {
        return listaCapivaraDAO;
    }

    public JogadorDAO setListaCapivaraDAO(List<CapivaraDAO> listaCapivaraDAO) {
        this.listaCapivaraDAO = listaCapivaraDAO;
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
    public boolean preencheuCamposObrigatorios(){
        if (dataHoraCriacaoConta == null) {
            this.dataHoraCriacaoConta = LocalDateTime.now();
        }
        
        return 
                credenciais != null &&
                urlFoto != null &&
                nomeCompleto != null &&
                email != null &&
                genero != null &&
                dataNascimento != null;
    }
    //</editor-fold>
    
    //</editor-fold>
    
}//class
