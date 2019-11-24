package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 
 * Last update: -
 */// </editor-fold>
@RestController
@RequestMapping(API_PLAYER_SERVICE)
public class PlayerCheckEndpoints {
		
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MatchPlayedRepository matchPlayedRepository;
	
	@Autowired
	private ChampionshipPlayedRepository championshipPlayedRepository;
	
	@Autowired
	private PlayerSearchEndpoints playerSearchEndpoint;
	
//	@Autowired
//	private DataBaseAPIClient dataBaseAPIClient;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>
		
	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	@GetMapping(API_PLAYER_SERVICE_CHECK_ONE_PLAYER_ONLINE)
	public ResponseEntity<Boolean> checkOnePlayerOnline(@PathVariable("idPlayer") Long idPlayer){
		Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(idPlayer).getBody();
		
		if (searchedPlayer != null) {
			if (searchedPlayer.isOnline()) {
				return ResponseEntity.ok(true);
			}
			
			return ResponseEntity.ok(false);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_CHECK_ONE_PLAYER_CREDENTIALS)
	public ResponseEntity<Boolean> checkOnePlayerCredentials(@RequestBody Credentials credentials){
		Player searchedPlayer = playerSearchEndpoint.searchOnePlayerByNick(credentials.getNick()).getBody();
		
		if (searchedPlayer != null) {
			if (credentials.validate(searchedPlayer)) {
				return ResponseEntity.ok(true);
			}
			
			return ResponseEntity.ok(false);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}	
	// </editor-fold>
	
}//class
