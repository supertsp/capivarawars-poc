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
@Table(name = "JOGADORES_EM_CAMPEONATO")
public class JogadoresEmCampeonato {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @EmbeddedId
    private IdJogadoresEmCampeonatoPK idJogadoresEmCampeonatoPK;

    @Column(name = "DATAHORA_INICIO_PARTICIPACAO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraInicioParticipacao;

    @Column(name = "DATAHORA_FIM_PARTICIPACAO", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraFimParticipacao;

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
    public IdJogadoresEmCampeonatoPK getIdJogadoresEmCampeonatoPK() {
        return idJogadoresEmCampeonatoPK;
    }

    public JogadoresEmCampeonato setIdJogadoresEmCampeonatoPK(IdJogadoresEmCampeonatoPK idJogadoresEmCampeonatoPK) {
        this.idJogadoresEmCampeonatoPK = idJogadoresEmCampeonatoPK;
        return this;
    }

    public LocalDateTime getDataHoraInicioParticipacao() {
        return dataHoraInicioParticipacao;
    }

    public JogadoresEmCampeonato setDataHoraInicioParticipacao(LocalDateTime dataHoraInicioParticipacao) {
        if (dataHoraInicioParticipacao == null) {
            this.dataHoraInicioParticipacao = LocalDateTime.now();
        } else {
            this.dataHoraInicioParticipacao = dataHoraInicioParticipacao;
        }

        return this;
    }

    public LocalDateTime getDataHoraFimParticipacao() {
        return dataHoraFimParticipacao;
    }

    public JogadoresEmCampeonato setDataHoraFimParticipacao(LocalDateTime dataHoraFimParticipacao) {
        if (dataHoraFimParticipacao == null) {
            this.dataHoraFimParticipacao = LocalDateTime.now();
        } else {
            this.dataHoraFimParticipacao = dataHoraFimParticipacao;
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
        if (dataHoraInicioParticipacao == null) {
            this.dataHoraInicioParticipacao = LocalDateTime.now();
        }

        return idJogadoresEmCampeonatoPK != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class
