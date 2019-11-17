package br.com.capivarawarsmongo.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Campeonato {
	 //<editor-fold defaultstate="collapsed" desc="attributes...">
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @Indexed(name = "ID_CAMPEONATO")
    private Long idPartida;

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
    private Premio premioPrimeiroColocado;

    @DBRef
    @Indexed(name = "ID_PREMIO_SEGUNDO_COLOCADO")
    private Premio premioSegundoColocado;
	
    @DBRef
    @Indexed(name = "ID_PREMIO_TERCEIRO_COLOCADO")
    private Premio premioTerceiroColocado;
	

    @DBRef
    private Jogador jogadorVencedorPrimeiro;
	
	
    @DBRef
    private Jogador jogadorVencedorSegundo;
	
	
    @DBRef
    private Jogador jogadorVencedorTerceiro;
	
	
    @DBRef
    private List<JogadoresEmCampeonato> listaDeJogadoresParticipantes;
	
	@DBRef
    private List<Partida> listaDePartidasOcorridas;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int VARCHAR_LENGTH_NOME = 120;

    public Long getIdPartida() {
        return idPartida;
    }

    public Campeonato setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Campeonato setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Campeonato setDataHoraInicio(LocalDateTime dataHoraInicio) {
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

    public Campeonato setDataHoraFim(LocalDateTime dataHoraFim) {
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

    public Campeonato setLimiteParticipantes(Integer limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
        return this;
    }

    public Integer getQtdAtualParticipantes() {
        return qtdAtualParticipantes;
    }

    public Campeonato setQtdAtualParticipantes(Integer qtdAtualParticipantes) {
        this.qtdAtualParticipantes = qtdAtualParticipantes;
        return this;
    }

    /**
     * RELATIONSHIPS
     */
    public Premio getPremioPrimeiroColocado() {
        return premioPrimeiroColocado;
    }

    public Campeonato setPremioPrimeiroColocado(Premio premioPrimeiroColocado) {
        this.premioPrimeiroColocado = premioPrimeiroColocado;
        return this;
    }

    public Premio getPremioSegundoColocado() {
        return premioSegundoColocado;
    }

    public Campeonato setPremioSegundoColocado(Premio premioSegundoColocado) {
        this.premioSegundoColocado = premioSegundoColocado;
        return this;
    }

    public Premio getPremioTerceiroColocado() {
        return premioTerceiroColocado;
    }

    public Campeonato setPremioTerceiroColocado(Premio premioTerceiroColocado) {
        this.premioTerceiroColocado = premioTerceiroColocado;
        return this;
    }

    public Jogador getJogadorVencedorPrimeiro() {
        return jogadorVencedorPrimeiro;
    }

    public Campeonato setJogadorVencedorPrimeiro(Jogador jogadorVencedorPrimeiro) {
        this.jogadorVencedorPrimeiro = jogadorVencedorPrimeiro;
        return this;
    }

    public Jogador getJogadorVencedorSegundo() {
        return jogadorVencedorSegundo;
    }

    public Campeonato setJogadorVencedorSegundo(Jogador jogadorVencedorSegundo) {
        this.jogadorVencedorSegundo = jogadorVencedorSegundo;
        return this;
    }

    public Jogador getJogadorVencedorTerceiro() {
        return jogadorVencedorTerceiro;
    }

    public Campeonato setJogadorVencedorTerceiro(Jogador jogadorVencedorTerceiro) {
        this.jogadorVencedorTerceiro = jogadorVencedorTerceiro;
        return this;
    }

    public List<JogadoresEmCampeonato> getListaDeJogadoresParticipantes() {
        return listaDeJogadoresParticipantes;
    }

    public Campeonato setListaDeJogadoresParticipantes(List<JogadoresEmCampeonato> listaDeJogadoresParticipantes) {
        this.listaDeJogadoresParticipantes = listaDeJogadoresParticipantes;
        return this;
    }

    public List<Partida> getListaDePartidasOcorridas() {
        return listaDePartidasOcorridas;
    }

    public Campeonato setListaDePartidasOcorridas(List<Partida> listaDePartidasOcorridas) {
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
    public Campeonato incrementQtdAtualParticipantes(int incrementValue) {
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
