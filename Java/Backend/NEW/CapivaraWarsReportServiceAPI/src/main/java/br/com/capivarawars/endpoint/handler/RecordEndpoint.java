package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.Player;
import br.com.capivarawars.database.repository.PlayerRepository;
import br.com.capivarawars.endpoint.client.PlayerServiceAPIClient;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.API_REPORT_SERVICE_SEARCH_ALL_PLAYERS;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author WINDOWS 8.1 JOSHUA, 03/12/2019, 18:21:19
 * Last update: -
 */// </editor-fold>
public class RecordEndpoint {
	
	@Autowired
	private PlayerServiceAPIClient playerServiceClient;
	
	@Autowired
	private PlayerRepository repository;

	@GetMapping(API_REPORT_SERVICE_SEARCH_ALL_PLAYERS)
	public ResponseEntity<List<Player>> searchAllPlayersFromServiceAPICLient() {
		List<Player> searchedPlayers = playerServiceClient.searchAllPlayers();
		repository.saveAll(searchedPlayers);

		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}//class
