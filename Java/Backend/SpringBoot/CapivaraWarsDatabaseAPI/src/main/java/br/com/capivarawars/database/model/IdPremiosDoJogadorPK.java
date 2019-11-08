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
public class IdPremiosDoJogadorPK implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">   
    /**
     * RELATIONSHIPS
     */
    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR")
    private Jogador jogadorFK;

    @ManyToOne
    @JoinColumn(name = "ID_PREMIO")
    private Premio premioFK;
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
    public Jogador getJogadorFK() {
        return jogadorFK;
    }

    public IdPremiosDoJogadorPK setJogadorFK(Jogador jogadorFK) {
        this.jogadorFK = jogadorFK;
        return this;
    }

    public Premio getPremioFK() {
        return premioFK;
    }
    
    public IdPremiosDoJogadorPK setPremioFK(Premio premioFK) {    
        this.premioFK = premioFK;
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
        return jogadorFK != null
                && premioFK != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
