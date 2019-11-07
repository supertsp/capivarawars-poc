package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
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
@Table(name = "CAMPEONATO")
public class CampeonatoDAO {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_CAMPEONATO")
    private Long idPartida;

    @Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
    private String nome;

    @Column(name = "DATAHORA_INICIO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraInicio;

    @Column(name = "DATAHORA_FIM", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraFim;

    @Column(name = "LIMITE_PARTICIPANTES")
    private Integer limiteParticipantes;

    @Column(name = "QTD_PARTICIPANTES")
    private Integer qtdParticipantes;
    
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PREMIO_PRIMEIRO_COLOCADO", referencedColumnName = "ID_PREMIO")
    private PremioDAO premioPrimeiroColocado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PREMIO_SEGUNDO_COLOCADO", referencedColumnName = "ID_PREMIO")
    private PremioDAO premioSegundoColocado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PREMIO_TERCEIRO_COLOCADO", referencedColumnName = "ID_PREMIO")
    private PremioDAO premioTerceiroColocado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_JOGADOR_VENCEDOR_PRIMEIRO", referencedColumnName = "ID_JOGADOR")
    private JogadorDAO jogadorVencedorPrimeiro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_JOGADOR_VENCEDOR_SEGUNDO", referencedColumnName = "ID_JOGADOR")
    private JogadorDAO jogadorVencedorSegundo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_JOGADOR_VENCEDOR_TERCEIRO", referencedColumnName = "ID_JOGADOR")
    private JogadorDAO jogadorVencedorTerceiro;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int VARCHAR_LENGTH_NOME = 120;

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
    public Long getIdPartida() {
        return idPartida;
    }

    public CampeonatoDAO setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CampeonatoDAO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public CampeonatoDAO setDataHoraInicio(LocalDateTime dataHoraInicio) {
        if (dataHoraInicio == null) {
            this.dataHoraInicio = LocalDateTime.now();
        } else {
            this.dataHoraInicio = dataHoraInicio;
        }

        return this;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public CampeonatoDAO setDataHoraFim(LocalDateTime dataHoraFim) {
        if (dataHoraFim == null) {
            this.dataHoraFim = LocalDateTime.now();
        } else {
            this.dataHoraFim = dataHoraFim;
        }

        return this;
    }

    public Integer getLimiteParticipantes() {
        return limiteParticipantes;
    }

    public CampeonatoDAO setLimiteParticipantes(Integer limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
        return this;
    }

    public Integer getQtdParticipantes() {
        return qtdParticipantes;
    }

    public CampeonatoDAO setQtdParticipantes(Integer qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
        return this;
    }

    public PremioDAO getPremioPrimeiroColocado() {
        return premioPrimeiroColocado;
    }

    public CampeonatoDAO setPremioPrimeiroColocado(PremioDAO premioPrimeiroColocado) {
        this.premioPrimeiroColocado = premioPrimeiroColocado;
        return this;
    }

    public PremioDAO getPremioSegundoColocado() {
        return premioSegundoColocado;
    }

    public CampeonatoDAO setPremioSegundoColocado(PremioDAO premioSegundoColocado) {
        this.premioSegundoColocado = premioSegundoColocado;
        return this;
    }

    public PremioDAO getPremioTerceiroColocado() {
        return premioTerceiroColocado;
    }

    public CampeonatoDAO setPremioTerceiroColocado(PremioDAO premioTerceiroColocado) {
        this.premioTerceiroColocado = premioTerceiroColocado;
        return this;
    }

    public JogadorDAO getJogadorVencedorPrimeiro() {
        return jogadorVencedorPrimeiro;
    }

    public CampeonatoDAO setJogadorVencedorPrimeiro(JogadorDAO jogadorVencedorPrimeiro) {
        this.jogadorVencedorPrimeiro = jogadorVencedorPrimeiro;
        return this;
    }

    public JogadorDAO getJogadorVencedorSegundo() {
        return jogadorVencedorSegundo;
    }

    public CampeonatoDAO setJogadorVencedorSegundo(JogadorDAO jogadorVencedorSegundo) {
        this.jogadorVencedorSegundo = jogadorVencedorSegundo;
        return this;
    }

    public JogadorDAO getJogadorVencedorTerceiro() {
        return jogadorVencedorTerceiro;
    }

    public CampeonatoDAO setJogadorVencedorTerceiro(JogadorDAO jogadorVencedorTerceiro) {
        this.jogadorVencedorTerceiro = jogadorVencedorTerceiro;
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
        if (dataHoraInicio == null) {
            this.dataHoraInicio = LocalDateTime.now();
        }

        return 
                nome != null &&
                limiteParticipantes != null &&
                qtdParticipantes != null &&
                premioPrimeiroColocado != null &&
                premioSegundoColocado != null &&
                premioTerceiroColocado != null;
        
    }
    //</editor-fold>
    //</editor-fold>

}//class
