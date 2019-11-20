package br.com.capivarawars.database.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Championships {
	 //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @Indexed(name = "ID_CAMPEONATO")
    private Long id_Partida;

    @Indexed(name = "NOME")
    private String nome;

    @Indexed(name = "DATAHORA_INICIO")
    private LocalDateTime dataHoraInicio;

    @Indexed(name = "DATAHORA_FIM")
    private LocalDateTime dataHoraFim;

    @Indexed(name = "LIMITE_PARTICIPANTES")
    private Integer limiteParticipantes;

    @Indexed(name = "QTD_ATUAL_PARTICIPANTES")
    private Integer qtdAtualParticipantes;

 
    @DBRef
    private Prize_Earned premioPrimeiroColocado;

    @DBRef
    @Indexed(name = "ID_PREMIO_SEGUNDO_COLOCADO")
    private Prize_Earned premioSegundoColocado;
	
    @DBRef
    @Indexed(name = "ID_PREMIO_TERCEIRO_COLOCADO")
    private Prize_Earned premioTerceiroColocado;
	

    @DBRef
    private Player jogadorVencedorPrimeiro;
	
	
    @DBRef
    private Player jogadorVencedorSegundo;
	
	
    @DBRef
    private Player jogadorVencedorTerceiro;
	
	
    @DBRef
    private List<Championships_Played> listaDeJogadoresParticipantes;
	
	@DBRef
    private List<Match> listaDePartidasOcorridas;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int VARCHAR_LENGTH_NOME = 120;

    public Long getIdPartida() {
        return id_Partida;
    }

    public Championships setIdPartida(Long idPartida) {
        this.id_Partida = idPartida;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Championships setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Championships setDataHoraInicio(LocalDateTime dataHoraInicio) {
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

    public Championships setDataHoraFim(LocalDateTime dataHoraFim) {
        if (dataHoraFim == null) {
            this.dataHoraFim = LocalDateTime.now();
        } else {
            this.dataHoraFim = dataHoraFim;
        }

        return this;
    }

    public Integer getLimiteParticipantes() {
        return limiteParticipantes;
    }

    public Championships setLimiteParticipantes(Integer limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
        return this;
    }

    public Integer getQtdAtualParticipantes() {
        return qtdAtualParticipantes;
    }

    public Championships setQtdAtualParticipantes(Integer qtdAtualParticipantes) {
        this.qtdAtualParticipantes = qtdAtualParticipantes;
        return this;
    }

    /**
     * RELATIONSHIPS
     */
    public Prize_Earned getPremioPrimeiroColocado() {
        return premioPrimeiroColocado;
    }

    public Championships setPremioPrimeiroColocado(Prize_Earned premioPrimeiroColocado) {
        this.premioPrimeiroColocado = premioPrimeiroColocado;
        return this;
    }

    public Prize_Earned getPremioSegundoColocado() {
        return premioSegundoColocado;
    }

    public Championships setPremioSegundoColocado(Prize_Earned premioSegundoColocado) {
        this.premioSegundoColocado = premioSegundoColocado;
        return this;
    }

    public Prize_Earned getPremioTerceiroColocado() {
        return premioTerceiroColocado;
    }

    public Championships setPremioTerceiroColocado(Prize_Earned premioTerceiroColocado) {
        this.premioTerceiroColocado = premioTerceiroColocado;
        return this;
    }

    public Player getJogadorVencedorPrimeiro() {
        return jogadorVencedorPrimeiro;
    }

    public Championships setJogadorVencedorPrimeiro(Player jogadorVencedorPrimeiro) {
        this.jogadorVencedorPrimeiro = jogadorVencedorPrimeiro;
        return this;
    }

    public Player getJogadorVencedorSegundo() {
        return jogadorVencedorSegundo;
    }

    public Championships setJogadorVencedorSegundo(Player jogadorVencedorSegundo) {
        this.jogadorVencedorSegundo = jogadorVencedorSegundo;
        return this;
    }

    public Player getJogadorVencedorTerceiro() {
        return jogadorVencedorTerceiro;
    }

    public Championships setJogadorVencedorTerceiro(Player jogadorVencedorTerceiro) {
        this.jogadorVencedorTerceiro = jogadorVencedorTerceiro;
        return this;
    }

    public List<Championships_Played> getListaDeJogadoresParticipantes() {
        return listaDeJogadoresParticipantes;
    }

    public Championships setListaDeJogadoresParticipantes(List<Championships_Played> listaDeJogadoresParticipantes) {
        this.listaDeJogadoresParticipantes = listaDeJogadoresParticipantes;
        return this;
    }

    public List<Match> getListaDePartidasOcorridas() {
        return listaDePartidasOcorridas;
    }

    public Championships setListaDePartidasOcorridas(List<Match> listaDePartidasOcorridas) {
        this.listaDePartidasOcorridas = listaDePartidasOcorridas;
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
    public Championships incrementQtdAtualParticipantes(int incrementValue) {
        qtdAtualParticipantes += incrementValue;
        return this;
    }

    public boolean preencheuCamposObrigatorios() {
        if (dataHoraInicio == null) {
            this.dataHoraInicio = LocalDateTime.now();
        }

        return nome != null
                && limiteParticipantes != null
                && premioPrimeiroColocado != null
                && premioSegundoColocado != null
                && premioTerceiroColocado != null;
    }
    //</editor-fold>
    //</editor-fold>

}
