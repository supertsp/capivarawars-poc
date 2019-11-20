package br.com.capivarawars.database.model;

import java.time.LocalDateTime;

public class Match {
	private Long _idPartida;
	 private LocalDateTime dataHoraInicio;
	 private LocalDateTime dataHoraFim;
	 private Boolean empatou;
	 private Player jogador1;
	 private Player jogador2;
	  private Player jogadorVencedor;
	   
	   public Long getIdPartida() {
	        return _idPartida;
	    }

	    public Match setIdPartida(Long idPartida) {
	        this._idPartida = idPartida;
	        return this;
	    }

	    public LocalDateTime getDataHoraInicio() {
	        return dataHoraInicio;
	    }

	    public Match setDataHoraInicio(LocalDateTime dataHoraInicio) {
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

	    public Match setDataHoraFim(LocalDateTime dataHoraFim) {
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

	    public Match setEmpatou(Boolean empatou) {
	        this.empatou = empatou;
	        return this;
	    }

	    /**
	     * RELATIONSHIPS
	     */
	    public Player getJogador1() {
	        return jogador1;
	    }

	    public Match setJogador1(Player jogador1) {
	        this.jogador1 = jogador1;
	        return this;
	    }

	    public Player getJogador2() {
	        return jogador2;
	    }

	    public Match setJogador2(Player jogador2) {
	        this.jogador2 = jogador2;
	        return this;
	    }

	    public Player getJogadorVencedor() {
	        return jogadorVencedor;
	    }

	    public Match setJogadorVencedor(Player jogadorVencedor) {
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
