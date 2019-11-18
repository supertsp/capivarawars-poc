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
public class IdJogadoresEmCampeonatoPK implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">   
    /**
     * RELATIONSHIPS
     */
    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR")
    private Jogador jogadorFK;

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
    /**
     * RELATIONSHIPS
     */
    public Jogador getJogadorFK() {
        return jogadorFK;
    }

    public IdJogadoresEmCampeonatoPK setJogadorFK(Jogador jogadorFK) {
        this.jogadorFK = jogadorFK;
        return this;
    }

    public Campeonato getCampeonatoFK() {
        return campeonatoFK;
    }

    public IdJogadoresEmCampeonatoPK setCampeonatoFK(Campeonato campeonatoFK) {
        this.campeonatoFK = campeonatoFK;
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
                && campeonatoFK != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
