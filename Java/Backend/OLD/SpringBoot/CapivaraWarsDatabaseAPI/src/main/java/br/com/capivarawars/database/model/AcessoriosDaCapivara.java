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
@Table(name = "ACESSORIOS_DA_CAPIVARA")
public class AcessoriosDaCapivara {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @EmbeddedId
    private IdAcessoriosDaCapivaraPK idAcessoriosDaCapivaraPK;

    @Column(name = "DATAHORA_AQUISICAO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraAquisicao;

    @Column(name = "PRECO_PAGO")
    private Integer precoPago;
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
    public IdAcessoriosDaCapivaraPK getIdAcessoriosDaCapivaraPK() {
        return idAcessoriosDaCapivaraPK;
    }

    public AcessoriosDaCapivara setIdAcessoriosDaCapivaraPK(IdAcessoriosDaCapivaraPK idAcessoriosDaCapivaraPK) {
        this.idAcessoriosDaCapivaraPK = idAcessoriosDaCapivaraPK;
        return this;
    }

    public LocalDateTime getDataHoraAquisicao() {
        return dataHoraAquisicao;
    }

    public AcessoriosDaCapivara setDataHoraAquisicao(LocalDateTime dataHoraAquisicao) {
        if (dataHoraAquisicao == null) {
            this.dataHoraAquisicao = LocalDateTime.now();
        } else {
            this.dataHoraAquisicao = dataHoraAquisicao;
        }

        return this;
    }

    public Integer getPrecoPago() {
        return precoPago;
    }

    public AcessoriosDaCapivara setPrecoPago(Integer precoPago) {
        this.precoPago = precoPago;
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

        return idAcessoriosDaCapivaraPK != null
                && precoPago != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
