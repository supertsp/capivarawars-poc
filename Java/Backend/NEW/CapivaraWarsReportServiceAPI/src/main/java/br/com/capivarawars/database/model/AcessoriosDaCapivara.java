package br.com.capivarawars.database.model;

import java.time.LocalDateTime;

public class AcessoriosDaCapivara {

		
	private LocalDateTime dataHoraAquisicao;


	private Integer precoPago;


	public LocalDateTime getDataHoraAquisicao() {
		return dataHoraAquisicao;
	}

	public AcessoriosDaCapivara setDataHoraAquisicao(LocalDateTime dataHoraAquisicao) {
		if (dataHoraAquisicao == null) {
			this.dataHoraAquisicao = LocalDateTime.now();
		} else {
			this.dataHoraAquisicao = dataHoraAquisicao;
		}

		return this;
	}

	public Integer getPrecoPago() {
		return precoPago;
	}

	public AcessoriosDaCapivara setPrecoPago(Integer precoPago) {
		this.precoPago = precoPago;
		return this;
	}


}
