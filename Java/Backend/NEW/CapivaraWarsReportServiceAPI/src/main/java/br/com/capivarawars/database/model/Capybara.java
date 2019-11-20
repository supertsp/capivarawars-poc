package br.com.capivarawars.database.model;

import java.time.LocalDateTime;
import java.util.List;


public class Capybara {


	    private Long idCapivara;

	    
	    private String nome;

	  
	    private LocalDateTime dataHoraCriacao;


	    private Integer barraVida;


	    private Player jogadorFK;

	
//	    private List<AcessoriosDaCapivara> listaDeAcessoriosDaCapivara;

	    public static final int VARCHAR_LENGTH_NOME = 45;

	    public Long getIdCapivara() {
	        return idCapivara;
	    }

	    public Capybara setIdCapivara(Long idCapivara) {
	        this.idCapivara = idCapivara;
	        return this;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public Capybara setNome(String nome) {
	        this.nome = nome;
	        return this;
	    }

	    public LocalDateTime getDataHoraCriacao() {
	        return dataHoraCriacao;
	    }

	    public Capybara setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
	        if (dataHoraCriacao == null) {
	            this.dataHoraCriacao = LocalDateTime.now();
	        } else {
	            this.dataHoraCriacao = dataHoraCriacao;
	        }

	        return this;
	    }

	    public Integer getBarraVida() {
	        return barraVida;
	    }

	    public Capybara setBarraVida(Integer barraVida) {
	        this.barraVida = barraVida;
	        return this;
	    }

	    public Player getJogadorFK() {
	        return jogadorFK;
	    }

	    public Capybara setJogadorFK(Player jogadorFK) {
	        this.jogadorFK = jogadorFK;
	        return this;
	    }

//	    public List<AcessoriosDaCapivara> getListaDeAcessoriosDaCapivara() {
//	        return listaDeAcessoriosDaCapivara;
//	    }

//	    public Capivara setListaDeAcessoriosDaCapivara(List<AcessoriosDaCapivara> listaDeAcessoriosDaCapivara) {
//	        this.listaDeAcessoriosDaCapivara = listaDeAcessoriosDaCapivara;
//	        return this;
//	    }
	    
	    public boolean preencheuCamposObrigatorios() {
	        if (dataHoraCriacao == null) {
	            this.dataHoraCriacao = LocalDateTime.now();
	        }

	        return nome != null;
	    }
	
}
