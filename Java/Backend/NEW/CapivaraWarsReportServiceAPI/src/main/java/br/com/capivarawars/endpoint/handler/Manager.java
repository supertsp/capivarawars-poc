package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.Player;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author WINDOWS 8.1 JOSHUA, 03/12/2019, 21:21:21 Last update: -
 */// </editor-fold>
public class Manager {

	//gerando dados no mongo
	public void gerandoDadosNoMongo() {
		RecordEndpoint recordEndpoint = new RecordEndpoint();
		recordEndpoint.searchAllPlayersFromServiceAPICLient();
	}

	//pegando dados brutos do mongo
	public List voltaDadosDoMongo() {
		JogadorEndpoint jogadorEndpoint = new JogadorEndpoint();
		ResponseEntity<List<Player>> listaDeJogadores = jogadorEndpoint.searchAllPlayers();

		return (List) listaDeJogadores;

	}
	
	//guarda dados que vem do mongo em variaveis
	

}//class
