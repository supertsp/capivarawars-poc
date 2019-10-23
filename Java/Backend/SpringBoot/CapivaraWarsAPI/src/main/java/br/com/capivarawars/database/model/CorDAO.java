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
 * @author TPEDROSO, 23/10/2019, 13:11:44
 * Last update: -
 *///</editor-fold>
@Entity
@Table(name="COR")
public class CorDAO {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_COR")
    private Long idCor;
    
    @Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
    private String nome;
        
    @Column(name = "RGBA", length = CHAR_LENGTH_RGBA, columnDefinition = "CHAR")
    private String rgba;
          
    @OneToMany(mappedBy = "corDAO")
    private List<CapivaraDAO> listaCapivaraDAO;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int
            VARCHAR_LENGTH_NOME = 120,
            CHAR_LENGTH_RGBA = 9;
            
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public CorDAO() {
        super();
    }
    
    public CorDAO(String nome, String rgba) {
        this.nome = nome;
        this.rgba = rgba;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public Long getIdCor() {
        return idCor;
    }

    public void setIdCor(Long idCor) {
        this.idCor = idCor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRgba() {
        return rgba;
    }

    public void setRgba(String rgba) {
        this.rgba = rgba;
    }

    public List<CapivaraDAO> getListaCapivaraDAO() {
        return listaCapivaraDAO;
    }

    public void setListaCapivaraDAO(List<CapivaraDAO> listaCapivaraDAO) {
        this.listaCapivaraDAO = listaCapivaraDAO;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    
    //</editor-fold>
    
    //</editor-fold>
        
}//class
