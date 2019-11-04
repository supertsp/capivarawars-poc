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
@Table(name = "CAMPEONATO")
public class CampeonatoDAO {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_CAMPEONATO")
    private Long idPartida;
    
    @Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
    private String nome;
    
    @Column(name = "DATAHORA_INICIO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraInicio;
    
    @Column(name = "DATAHORA_FIM", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraFim;

    @Column(name = "LIMITE_PARTICIPANTES")
    private Integer limiteParticipantes;
    
    @Column(name = "QTD_PARTICIPANTES")
    private Integer qtdParticipantes;
    
    
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_JOGADOR_1", referencedColumnName = "ID_JOGADOR")
    private JogadorDAO jogador1;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_JOGADOR_2", referencedColumnName = "ID_JOGADOR")
    private JogadorDAO jogador2;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_JOGADOR_VENCEDOR", referencedColumnName = "ID_JOGADOR")
    private JogadorDAO jogadorVencedor;
    
    @Column(name = "EMPATOU")
    private Boolean empatou;
    
    
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int
            VARCHAR_LENGTH_NOME = 120
            ;
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
   

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public CampeonatoDAO setDataHoraInicio(LocalDateTime dataHoraInicio) {
        if (dataHoraInicio == null) {
            this.dataHoraInicio = LocalDateTime.now();
        }
        else{
            this.dataHoraInicio = dataHoraInicio;
        }
        
        return this;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public CampeonatoDAO setDataHoraFim(LocalDateTime dataHoraFim) {
        if (dataHoraFim == null) {
            this.dataHoraFim = LocalDateTime.now();
        }
        else{
            this.dataHoraFim = dataHoraFim;
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
        if (dataHoraInicio == null) {
            this.dataHoraInicio = LocalDateTime.now();
        }
        
        return 
                jogador1 != null &&
                jogador2 != null;
    }
    //</editor-fold>
    //</editor-fold>

    

}//class
