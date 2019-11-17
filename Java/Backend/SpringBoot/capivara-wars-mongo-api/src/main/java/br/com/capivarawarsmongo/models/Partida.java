package br.com.capivarawarsmongo.models;

import java.time.LocalDateTime;

public class Partida {
	private Long idPartida;
	 private LocalDateTime dataHoraInicio;
	 private LocalDateTime dataHoraFim;
	 private Boolean empatou;
	 private Jogador jogador1;
	 private Jogador jogador2;
	  private Jogador jogadorVencedor;
	   
	   public Long getIdPartida() {
	        return idPartida;
	    }

	    public Partida setIdPartida(Long idPartida) {
	        this.idPartida = idPartida;
	        return this;
	    }

	    public LocalDateTime getDataHoraInicio() {
	        return dataHoraInicio;
	    }

	    public Partida setDataHoraInicio(LocalDateTime dataHoraInicio) {
	        if (dataHoraInicio == null) {
	            this.dataHoraInicio = LocalDateTime.now();
	        } else {
	            this.dataHoraInicio = dataHoraInicio;
	        }

	        return this;
	    }

	    public LocalDateTime getDataHoraFim() {
	        return dataHoraFim;
	    }

	    public Partida setDataHoraFim(LocalDateTime dataHoraFim) {
	        if (dataHoraFim == null) {
	            this.dataHoraFim = LocalDateTime.now();
	        } else {
	            this.dataHoraFim = dataHoraFim;
	        }

	        return this;
	    }

	    public Boolean isEmpatou() {
	        return empatou;
	    }

	    public Partida setEmpatou(Boolean empatou) {
	        this.empatou = empatou;
	        return this;
	    }

	    /**
	     * RELATIONSHIPS
	     */
	    public Jogador getJogador1() {
	        return jogador1;
	    }

	    public Partida setJogador1(Jogador jogador1) {
	        this.jogador1 = jogador1;
	        return this;
	    }

	    public Jogador getJogador2() {
	        return jogador2;
	    }

	    public Partida setJogador2(Jogador jogador2) {
	        this.jogador2 = jogador2;
	        return this;
	    }

	    public Jogador getJogadorVencedor() {
	        return jogadorVencedor;
	    }

	    public Partida setJogadorVencedor(Jogador jogadorVencedor) {
	        this.jogadorVencedor = jogadorVencedor;
	        return this;
	    }

	    public boolean preencheuCamposObrigatorios() {
	        if (dataHoraInicio == null) {
	            this.dataHoraInicio = LocalDateTime.now();
	        }

	        return jogador1 != null
	                && jogador2 != null;
	    }

}
