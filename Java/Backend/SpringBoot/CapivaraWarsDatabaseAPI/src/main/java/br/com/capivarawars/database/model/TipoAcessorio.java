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
@Table(name = "TIPO_ACESSORIO")
public class TipoAcessorio {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_TIPO_ACESSORIO")
    private Long idTipoAcessorio;

    @Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
    private String nome;

    /**
     * RELATIONSHIPS
     */
    @OneToMany(mappedBy = "tipoAcessorioFK")
    private List<Acessorio> listaDeAcessorios;
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
    public Long getIdTipoAcessorio() {
        return idTipoAcessorio;
    }

    public TipoAcessorio setIdTipoAcessorio(Long idTipoAcessorio) {
        this.idTipoAcessorio = idTipoAcessorio;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoAcessorio setNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * RELATIONSHIPS
     */
    public List<Acessorio> getListaDeAcessorios() {
        return listaDeAcessorios;
    }

    public TipoAcessorio setListaDeAcessorios(List<Acessorio> listaDeAcessorios) {
        this.listaDeAcessorios = listaDeAcessorios;
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
        return nome != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
