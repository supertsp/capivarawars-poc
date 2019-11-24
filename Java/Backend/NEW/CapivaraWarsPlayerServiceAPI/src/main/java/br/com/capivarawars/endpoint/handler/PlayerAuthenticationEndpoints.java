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
public class PlayerAuthenticationEndpoints {
		
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MatchPlayedRepository matchPlayedRepository;
	
	@Autowired
	private ChampionshipPlayedRepository championshipPlayedRepository;
	
	@Autowired
	private PlayerSearchEndpoints playerSearchEndpoint;
	
	@Autowired
	private PlayerCheckEndpoints playerCheckEndpoints;
	
	@Autowired
	private PlayerUpdateEndpoints playerUpdateEndpoints;
	
//	@Autowired
//	private DataBaseAPIClient dataBaseAPIClient;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>
	
	// <editor-fold desc="AUTHENTICATION methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_LOGIN)
	public ResponseEntity<String> login(@RequestBody Credentials credentials) {
		Boolean playerExists = playerCheckEndpoints.checkOnePlayerCredentials(credentials).getBody();
		
		if (playerExists) {
			Player searchedPlayer = playerSearchEndpoint.searchOnePlayerByNick(credentials.getNick()).getBody();
			
			if (!searchedPlayer.isOnline()) {
				playerUpdateEndpoints.updateOnePlayerOnline(searchedPlayer.getIdPlayer(), true);
				return ResponseEntity.ok("Successfully logged in :)");
			}
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This user is already logged in :0");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The credentials are wrong :(");
	}
	
	@PostMapping(API_PLAYER_SERVICE_LOGOUT)
	public ResponseEntity<String> logout(@PathVariable("idPlayer") Long idPlayer) {
		Boolean playerOnline = playerCheckEndpoints.checkOnePlayerOnline(idPlayer).getBody();
		
		if (playerOnline != null) {
			if (playerOnline) {
				Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(idPlayer).getBody();
				playerUpdateEndpoints.updateOnePlayerOnline(searchedPlayer.getIdPlayer(), false);
				return ResponseEntity.ok("Successfully logged out :)");
			}
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This user is not logged in yet :0");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid user :(");
	}
	// </editor-fold>	
	
}//class
