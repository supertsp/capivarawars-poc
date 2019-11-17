package br.com.capivarawarsmongo.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.index.Indexed;

public class JogadoresEmCampeonato {
	   
//	 private IdJogadoresEmCampeonatoPK idJogadoresEmCampeonatoPK;

	    @Indexed(name = "DATAHORA_INICIO_PARTICIPACAO")
	    private LocalDateTime dataHoraInicioParticipacao;

	    @Indexed(name = "DATAHORA_FIM_PARTICIPACAO")
	    private LocalDateTime dataHoraFimParticipacao;

	
//	    public IdJogadoresEmCampeonatoPK getIdJogadoresEmCampeonatoPK() {
//	        return idJogadoresEmCampeonatoPK;
//	    }

//	    public JogadoresEmCampeonato setIdJogadoresEmCampeonatoPK(IdJogadoresEmCampeonatoPK idJogadoresEmCampeonatoPK) {
//	        this.idJogadoresEmCampeonatoPK = idJogadoresEmCampeonatoPK;
//	        return this;
//	    }

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

//	    public boolean preencheuCamposObrigatorios() {
//	        if (dataHoraInicioParticipacao == null) {
//	            this.dataHoraInicioParticipacao = LocalDateTime.now();
//	        }
//
//	        return idJogadoresEmCampeonatoPK != null;
//	    }
}
