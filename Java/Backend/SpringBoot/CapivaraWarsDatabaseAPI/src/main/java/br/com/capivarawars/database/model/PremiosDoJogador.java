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
@Table(name = "PREMIOS_DO_JOGADOR")
public class PremiosDoJogador {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @EmbeddedId
    private IdPremiosDoJogadorPK idPremiosDoJogadorPK;

    @Column(name = "DATAHORA_AQUISICAO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraAquisicao;

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
    public IdPremiosDoJogadorPK getIdPremiosDoJogadorPK() {
        return idPremiosDoJogadorPK;
    }

    public PremiosDoJogador setIdPremiosDoJogadorPK(IdPremiosDoJogadorPK idPremiosDoJogadorPK) {
        this.idPremiosDoJogadorPK = idPremiosDoJogadorPK;
        return this;
    }

    public LocalDateTime getDataHoraAquisicao() {
        return dataHoraAquisicao;
    }

    public PremiosDoJogador setDataHoraInicio(LocalDateTime dataHoraInicio) {
        if (dataHoraInicio == null) {
            this.dataHoraAquisicao = LocalDateTime.now();
        } else {
            this.dataHoraAquisicao = dataHoraInicio;
        }

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
        if (dataHoraAquisicao == null) {
            this.dataHoraAquisicao = LocalDateTime.now();
        }

        return idPremiosDoJogadorPK != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
