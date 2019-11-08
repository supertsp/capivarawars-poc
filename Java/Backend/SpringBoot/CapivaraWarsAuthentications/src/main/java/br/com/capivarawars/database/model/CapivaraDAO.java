package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.core.CorPadrao;
import br.com.capivarawars.core.game.gameobject.Capivara;
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
    
    @ManyToOne
    @JoinColumn(name = "ID_COR")
    private CorDAO corDAO;
    
    @ManyToOne
    @JoinColumn(name = "ID_JOGADOR")
    private JogadorDAO jogadorDAO;
      
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
    public CapivaraDAO() {
        super();
    }
    
    public CapivaraDAO(String nome, LocalDateTime dataHoraCriacao, Integer barraVida, CorDAO corDAO) {
        this.nome = nome;
        this.dataHoraCriacao = dataHoraCriacao;
        this.barraVida = barraVida;
        this.corDAO = corDAO;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
     public Long getIdCapivara() {
        return idCapivara;
    }

    public void setIdCapivara(Long idCapivara) {
        this.idCapivara = idCapivara;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Integer getBarraVida() {
        return barraVida;
    }

    public void setBarraVida(Integer barraVida) {
        this.barraVida = barraVida;
    }

    public CorDAO getCorDAO() {
        return corDAO;
    }

    public void setCorDAO(CorDAO corDAO) {
        this.corDAO = corDAO;
    }

    public JogadorDAO getJogadorDAO() {
        return jogadorDAO;
    }

    public void setJogadorDAO(JogadorDAO jogadorDAO) {
        this.jogadorDAO = jogadorDAO;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public Capivara fillJogador(Capivara capivara){
        capivara
            .setNome(getNome())
            .setCor(CorPadrao.NENHUMA)
            .setDataHoraCriacao(getDataHoraCriacao())
            .getBarraDeEnergia().setValorAtual(getBarraVida());
            ;
        
        return capivara;
    }
    //</editor-fold>
    
    //</editor-fold>

   
        
}//class
