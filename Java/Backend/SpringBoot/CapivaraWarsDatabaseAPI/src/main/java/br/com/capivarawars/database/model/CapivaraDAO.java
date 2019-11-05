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
@Table(name="CAPIVARA")
public class CapivaraDAO {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_CAPIVARA")
    private Long idCapivara;
    
    @Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
    private String nome;
        
    @Column(name = "DATA_HORA_CRIACAO_CONTA", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraCriacao;
    
    @Column(name = "BARRA_VIDA")
    private Integer barraVida;
    
    
    /**
     * FOREIGN KEYS
     */
    @ManyToOne
    @JoinColumn(name = "ID_COR")
    private CorDAO corDAO;
    
    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR")
    private JogadorDAO jogadorDAO;
    
    @OneToMany(mappedBy = "idAcessoriosDaCapivaraPK.capivaraDAO")
    private List<AcessoriosDaCapivaraDAO> listaAcessoriosDaCapivaraDAO;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int
            VARCHAR_LENGTH_NOME = 45;
            
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
     public Long getIdCapivara() {
        return idCapivara;
    }

    public CapivaraDAO setIdCapivara(Long idCapivara) {
        this.idCapivara = idCapivara;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CapivaraDAO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDateTime getDataHoraCriacao() {        
        return dataHoraCriacao;
    }

    public CapivaraDAO setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        if (dataHoraCriacao == null) {
            this.dataHoraCriacao = LocalDateTime.now();
        }
        else{
            this.dataHoraCriacao = dataHoraCriacao;
        }
        
        return this;
    }

    public Integer getBarraVida() {
        return barraVida;
    }

    public CapivaraDAO setBarraVida(Integer barraVida) {
        this.barraVida = barraVida;
        return this;
    }

    public CorDAO getCorDAO() {
        return corDAO;
    }

    public CapivaraDAO setCorDAO(CorDAO corDAO) {
        this.corDAO = corDAO;
        return this;
    }

    public JogadorDAO getJogadorDAO() {
        return jogadorDAO;
    }

    public CapivaraDAO setJogadorDAO(JogadorDAO jogadorDAO) {
        this.jogadorDAO = jogadorDAO;
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
    public boolean preencheuCamposObrigatorios(){
        if (dataHoraCriacao == null) {
            this.dataHoraCriacao = LocalDateTime.now();
        }
        
        return 
                nome != null;
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
