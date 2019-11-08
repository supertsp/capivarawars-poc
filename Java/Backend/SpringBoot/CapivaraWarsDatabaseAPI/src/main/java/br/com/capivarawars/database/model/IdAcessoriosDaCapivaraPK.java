package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import java.io.Serializable;
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
@Embeddable
public class IdAcessoriosDaCapivaraPK implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">   
    /**
     * RELATIONSHIPS
     */
    @ManyToOne
    @JoinColumn(name = "ID_CAPIVARA")
    private Capivara capivaraFK;

    @ManyToOne
    @JoinColumn(name = "ID_ACESSORIO")
    private Acessorio acessorioFK;

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
    /**
     * RELATIONSHIPS
     */
    public Capivara getCapivaraFK() {
        return capivaraFK;
    }

    public IdAcessoriosDaCapivaraPK setCapivaraFK(Capivara capivaraFK) {
        this.capivaraFK = capivaraFK;
        return this;
    }

    public Acessorio getAcessorioFK() {
        return acessorioFK;
    }

    public IdAcessoriosDaCapivaraPK setAcessorioFK(Acessorio acessorioFK) {
        this.acessorioFK = acessorioFK;
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
        return capivaraFK != null
                && acessorioFK != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
