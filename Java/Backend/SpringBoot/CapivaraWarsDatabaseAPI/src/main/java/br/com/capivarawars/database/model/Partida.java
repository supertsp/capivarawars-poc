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
@Table(name = "PARTIDA")
public class Partida {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_PARTIDA")
    private Long idPartida;

    @Column(name = "DATAHORA_INICIO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraInicio;

    @Column(name = "DATAHORA_FIM", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraFim;

    @Column(name = "EMPATOU")
    private Boolean empatou;

    /**
     * RELATIONSHIPS
     */
    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR_1")
    private Jogador jogador1;

    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR_2")
    private Jogador jogador2;

    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR_VENCEDOR")
    private Jogador jogadorVencedor;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPEONATO")
    private Campeonato campeonatoFK;

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
    public Long getIdPartida() {
        return idPartida;
    }

    public Partida setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
        return this;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Partida setDataHoraInicio(LocalDateTime dataHoraInicio) {
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

    public Partida setDataHoraFim(LocalDateTime dataHoraFim) {
        if (dataHoraFim == null) {
            this.dataHoraFim = LocalDateTime.now();
        } else {
            this.dataHoraFim = dataHoraFim;
        }

        return this;
    }

    public Boolean isEmpatou() {
        return empatou;
    }

    public Partida setEmpatou(Boolean empatou) {
        this.empatou = empatou;
        return this;
    }

    /**
     * RELATIONSHIPS
     */
    public Jogador getJogador1() {
        return jogador1;
    }

    public Partida setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
        return this;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Partida setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
        return this;
    }

    public Jogador getJogadorVencedor() {
        return jogadorVencedor;
    }

    public Partida setJogadorVencedor(Jogador jogadorVencedor) {
        this.jogadorVencedor = jogadorVencedor;
        return this;
    }

    public Campeonato getCampeonatoFK() {
        return campeonatoFK;
    }

    public void setCampeonatoFK(Campeonato campeonatoFK) {
        this.campeonatoFK = campeonatoFK;
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

        return jogador1 != null
                && jogador2 != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
