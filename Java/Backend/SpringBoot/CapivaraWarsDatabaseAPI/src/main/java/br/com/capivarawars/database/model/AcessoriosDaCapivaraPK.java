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
public class AcessoriosDaCapivaraPK  implements Serializable{

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">   
    @ManyToOne
    @JoinColumn(name = "ID_CAPIVARA")
    private CapivaraDAO capivaraDAO;

    @ManyToOne
    @JoinColumn(name = "ID_ACESSORIO")
    private AcessorioDAO acessorioDAO;

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
    public CapivaraDAO getCapivaraDAO() {
        return capivaraDAO;
    }

    public AcessoriosDaCapivaraPK setCapivaraDAO(CapivaraDAO capivaraDAO) {
        this.capivaraDAO = capivaraDAO;
        return this;
    }

    public AcessorioDAO getAcessorioDAO() {
        return acessorioDAO;
    }

    public AcessoriosDaCapivaraPK setAcessorioDAO(AcessorioDAO acessorioDAO) {
        this.acessorioDAO = acessorioDAO;
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
        return 
                capivaraDAO != null &&
                acessorioDAO != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
