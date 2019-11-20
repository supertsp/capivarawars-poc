package br.com.capivarawars.database.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.capivarawars.security.Criptografia;

@Document(collection = "Player")
public class Player {
   
    @Id
    private ObjectId _id;
    
    @Indexed(name = "nick")
    private String nick;
    
    @Indexed(name = "password")
    private String senha;
    
  @Indexed(name = "DATAHORA_CRIACAO_CONTA")
    private LocalDateTime dataHoraCriacaoConta;
    
   @Indexed(name = "URL_FOTO")
    private String urlFoto;
    
  @Indexed(name = "NOME_COMPLETO")
    private String nomeCompleto;
    
    @Indexed(name = "EMAIL")
    private String email;
    
    @Indexed(name = "GENERO")
    private Character genero;

    @Indexed(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Indexed(name = "ONLINE")
    private Boolean online;

   @Indexed(name = "ULTIMO_CODIGO_ATIVACAO")
    private String ultimoCodigoAtivacao;
	
   @Indexed(name = "MOEDAS")
    private Integer moedas;
	
   @Indexed(name = "PONTUACAO")
    private Integer pontuacao;	
	
   @Indexed(name = "VITORIAS")
    private Integer vitorias;

   @Indexed(name = "EMPATES")
    private Integer empates;

   @Indexed(name = "DERROTAS")
    private Integer derrotas;

   @Indexed(name = "QTD_TIROS_CERTEIROS")
    private Integer qtdTirosCerteiros;

   @Indexed(name = "QTD_TIROS_RUINS")
    private Integer qtdTirosRuins;

   @Indexed(name = "QTD_TIROS_RECEBIDOS")
    private Integer qtdTirosRecebidos;

   @Indexed(name = "QTD_MOVIMENTOS")
    private Integer qtdMovimentos;

   
    @DBRef
    private java.util.List<Capybara> listaDeCapivaras;
	
	@DBRef
    private java.util.List<Match> listaDePartidasComoJogador1;
	
	
    @DBRef
    private java.util.List<Match> listaDePartidasComoJogador2;
	
    @DBRef
    private java.util.List<Match> listaDePartidasComoVencedor;
	
	
    @DBRef
    private java.util.List<Championships> listaDeCampeonatosGanhosEmPrimeiro;

	
    @DBRef
    private java.util.List<Championships> listaDeCampeonatosGanhosEmSegundo;

	@JsonIgnore
    @DBRef
    private java.util.List<Championships> listaDeCampeonatosGanhosEmTerceiro;
	
	@JsonIgnore
    @DBRef
    private java.util.List<Championships_Played> listaDeCampeonatosParticipados;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int VARCHAR_LENGTH_NICK = 45,
            VARCHAR_LENGTH_SENHA = 45,
            VARCHAR_LENGTH_URL_FOTO = 255,
            VARCHAR_LENGTH_NOME_COMPLETO = 100,
            VARCHAR_LENGTH_EMAIL = 255,
            CHAR_LENGTH_GENERO = 1,
            VARCHAR_LENGTH_ULTIMO_CODIGO_ATIVACAO = 255,
			
			PONTUACAO_PESO_VITORIAS = 4,
			PONTUACAO_PESO_DERROTAS = 2,
			PONTUACAO_PESO_EMPATES = 1,
			PONTUACAO_PESO_TIROS_CERTEIROS = 3,
			PONTUACAO_PESO_TIROS_RUINS = 3,
			PONTUACAO_PESO_TIROS_RECEBIDOS = 2,
			PONTUACAO_PESO_MOVIMENTOS = 2
			;


    public String get_id() {
        return _id.toHexString();
    }

    public Player set_id(ObjectId _idPlayer){
        this._id = _idPlayer;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        senha = senha.trim();
        this.senha = Criptografia.getSHA256(senha);
    }
    
    public void setSenhaSemSHA256(String senha) {
        this.senha = senha;
    }
    
    public LocalDateTime getDataHoraCriacaoConta() {
        return dataHoraCriacaoConta;
    }

    public Player setDataHoraCriacaoConta(LocalDateTime dataHoraCriacaoConta) {
        if (dataHoraCriacaoConta == null) {
            this.dataHoraCriacaoConta = LocalDateTime.now();
        } else {
            this.dataHoraCriacaoConta = dataHoraCriacaoConta;
        }

        return this;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public Player setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Player setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Player setEmail(String email) {
        this.email = email;
        return this;
    }

    public Character getGenero() {
        return genero;
    }

    public Player setGenero(Character genero) {
        switch (genero) {
            case 'M':
            case 'm':
                genero = 'M';
                break;

            case 'F':
            case 'f':
                genero = 'F';
                break;

            default:
                genero = 'M';
        }
        this.genero = genero;

        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Player setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Boolean isOnline() {
        return online;
    }

    public Player setOnline(Boolean online) {
        this.online = online;
        return this;
    }

    public String getUltimoCodigoAtivacao() {
        return ultimoCodigoAtivacao;
    }

    public Player setUltimoCodigoAtivacao(String ultimoCodigoAtivacao) {
        this.ultimoCodigoAtivacao = ultimoCodigoAtivacao;
        return this;
    }
	
	public Integer getMoedas() {
        return moedas;
    }

    public Player setMoedas(Integer moedas) {
        this.moedas = moedas;
        return this;
    }

	public Integer getPontuacao() {
		return pontuacao;
	}

	public Player setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
		return this;
	}

    public Integer getVitorias() {
        return vitorias;
    }

    public Player setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
        return this;
    }

    public Integer getEmpates() {
        return empates;
    }

    public Player setEmpates(Integer empates) {
        this.empates = empates;
        return this;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public Player setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
        return this;
    }    

    public Integer getQtdTirosCerteiros() {
        return qtdTirosCerteiros;
    }

    public Player setQtdTirosCerteiros(Integer qtdTirosCerteiros) {
        this.qtdTirosCerteiros = qtdTirosCerteiros;
        return this;
    }

    public Integer getQtdTirosRuins() {
        return qtdTirosRuins;
    }

    public Player setQtdTirosRuins(Integer qtdTirosRuins) {
        this.qtdTirosRuins = qtdTirosRuins;
        return this;
    }

    public Integer getQtdTirosRecebidos() {
        return qtdTirosRecebidos;
    }

    public Player setQtdTirosRecebidos(Integer qtdTirosRecebidos) {
        this.qtdTirosRecebidos = qtdTirosRecebidos;
        return this;
    }

    public Integer getQtdMovimentos() {
        return qtdMovimentos;
    }

    public Player setQtdMovimentos(Integer qtdMovimentos) {
        this.qtdMovimentos = qtdMovimentos;
        return this;
    }

    public java.util.List<Capybara> getListaDeCapivaras() {
        return listaDeCapivaras;
    }

    public Player setListaDeCapivaras(java.util.List<Capybara> listaDeCapivaras) {
        this.listaDeCapivaras = listaDeCapivaras;
        return this;
    }

    public java.util.List<Match> getListaDePartidasComoJogador1() {
        return listaDePartidasComoJogador1;
    }

    public Player setListaDePartidasComoJogador1(java.util.List<Match> listaDePartidasComoJogador1) {
        this.listaDePartidasComoJogador1 = listaDePartidasComoJogador1;
        return this;
    }

    public java.util.List<Match> getListaDePartidasComoJogador2() {
        return listaDePartidasComoJogador2;
    }

    public Player setListaDePartidasComoJogador2(java.util.List<Match> listaDePartidasComoJogador2) {
        this.listaDePartidasComoJogador2 = listaDePartidasComoJogador2;
        return this;
    }

    public java.util.List<Match> getListaDePartidasComoVencedor() {
        return listaDePartidasComoVencedor;
    }

    public Player setListaDePartidasComoVencedor(java.util.List<Match> listaDePartidasComoVencedor) {
        this.listaDePartidasComoVencedor = listaDePartidasComoVencedor;
        return this;
    }

    public java.util.List<Championships> getListaDeCampeonatosGanhosEmPrimeiro() {
        return listaDeCampeonatosGanhosEmPrimeiro;
    }

    public Player setListaDeCampeonatosGanhosEmPrimeiro(java.util.List<Championships> listaDeCampeonatosGanhosEmPrimeiro) {
        this.listaDeCampeonatosGanhosEmPrimeiro = listaDeCampeonatosGanhosEmPrimeiro;
        return this;
    }

    public java.util.List<Championships> getListaDeCampeonatosGanhosEmSegundo() {
        return listaDeCampeonatosGanhosEmSegundo;
    }

    public Player setListaDeCampeonatosGanhosEmSegundo(java.util.List<Championships> listaDeCampeonatosGanhosEmSegundo) {
        this.listaDeCampeonatosGanhosEmSegundo = listaDeCampeonatosGanhosEmSegundo;
        return this;
    }

    public java.util.List<Championships> getListaDeCampeonatosGanhosEmTerceiro() {
        return listaDeCampeonatosGanhosEmTerceiro;
    }

    public Player setListaDeCampeonatosGanhosEmTerceiro(java.util.List<Championships> listaDeCampeonatosGanhosEmTerceiro) {
        this.listaDeCampeonatosGanhosEmTerceiro = listaDeCampeonatosGanhosEmTerceiro;
        return this;
    }

    public java.util.List<Championships_Played> getListaDeCampeonatosParticipados() {
        return listaDeCampeonatosParticipados;
    }

    public Player setListaDeCampeonatosParticipados(java.util.List<Championships_Played> listaDeCampeonatosParticipados) {
        this.listaDeCampeonatosParticipados = listaDeCampeonatosParticipados;
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
	public Integer calcularPontucao(){
		int tempVitorias = getVitorias() * PONTUACAO_PESO_VITORIAS;
		int tempEmpates = getEmpates() * PONTUACAO_PESO_EMPATES;
		int tempDerrotas = getDerrotas() * PONTUACAO_PESO_DERROTAS;
		int tempTirosCerteiros = getQtdTirosCerteiros() * PONTUACAO_PESO_TIROS_CERTEIROS;
		int tempTirosRuins = getQtdTirosRuins()* PONTUACAO_PESO_TIROS_RUINS;
		int tempTirosRecebidos = getQtdTirosRecebidos()* PONTUACAO_PESO_TIROS_RECEBIDOS;
		int tempMovimentos = getQtdMovimentos() / PONTUACAO_PESO_MOVIMENTOS;
		
		int tempPartidas = ((tempVitorias + tempEmpates) - tempDerrotas) * 3;		
		System.out.println("\nPONTUAÇÃO (tempPartidas): " + tempPartidas + "\n");
		
		int tempTiros = 0;
		
		try {
			tempTiros = (tempTirosCerteiros / Math.abs(tempTirosRuins - tempTirosRecebidos)) / 2;
		} catch (Exception e) {}				
		System.out.println("\nPONTUAÇÃO (tempTiros): " + tempTiros + "\n");
		
		try {
			pontuacao = (tempPartidas + tempTiros) / tempMovimentos;
		} catch (Exception e) {
			pontuacao = 0;
		}		
		System.out.println("\nPONTUAÇÃO (tempMovimentos): " + tempMovimentos + "\n");
		System.out.println("\nPONTUAÇÃO (tempPartidas + tempTiros): " + (tempTiros + tempPartidas) + "\n");		
		System.out.println("\nPONTUAÇÃO (final): " + pontuacao + "\n");
		
		return pontuacao;
	}
	
	public Player incrementMoedas(int incrementValue) {
        moedas += incrementValue;
        return this;
    }
	
	public Player incrementPontuacao(int incrementValue) {
        pontuacao += incrementValue;
        return this;
    }
	
	public Player incrementVitorias(int incrementValue) {
		vitorias += incrementValue;
		return this;
	}

    public Player incrementEmpates(int incrementValue) {
        empates += incrementValue;
        return this;
    }

    public Player incrementDerrotas(int incrementValue) {
        derrotas += incrementValue;
        return this;
    }
	
    public Player incrementQtdTirosCerteiros(int incrementValue) {
        qtdTirosCerteiros += incrementValue;
        return this;
    }

    public Player incrementQtdTirosRuins(int incrementValue) {
        qtdTirosRuins += incrementValue;
        return this;
    }

    public Player incrementQtdTirosRecebidos(int incrementValue) {
        qtdTirosRecebidos += incrementValue;
        return this;
    }

    public Player incrementQtdMovimentos(int incrementValue) {
        qtdMovimentos += incrementValue;
        return this;
    }
    
    public boolean preencheuCamposObrigatorios() {
        if (dataHoraCriacaoConta == null) {
            this.dataHoraCriacaoConta = LocalDateTime.now();
        }
		
		online = online == null ? false : online;
		
		moedas = moedas == null ? 0 : moedas;
		pontuacao = pontuacao == null ? 0 : pontuacao;
		vitorias = vitorias == null ? 0 : vitorias;
		empates = empates == null ? 0 : empates;
		derrotas = derrotas == null ? 0 : derrotas;		
		qtdTirosCerteiros = qtdTirosCerteiros == null ? 0 : qtdTirosCerteiros;
		qtdTirosRuins = qtdTirosRuins == null ? 0 : qtdTirosRuins;
		qtdTirosRecebidos = qtdTirosRecebidos == null ? 0 : qtdTirosRecebidos;
		qtdMovimentos = qtdMovimentos == null ? 0 : qtdMovimentos;
		
		calcularPontucao();
		
        return nick != null
                && senha != null
                && urlFoto != null
                && nomeCompleto != null
                && email != null
                && genero != null
                && dataNascimento != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class