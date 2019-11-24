package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.endpoint.service.PlayerEnpointService;
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
public class PlayerSearchEndpoints {
		
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private PlayerEnpointService playerEnpointService;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_BY_ID)
	public ResponseEntity<Player> searchOnePlayerById(@PathVariable("idPlayer") Long idPlayer){
		return playerEnpointService.searchOnePlayerById(idPlayer);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_BY_NICK)
	public ResponseEntity<Player> searchOnePlayerByNick(@PathVariable("nick") String nick){
		return playerEnpointService.searchOnePlayerByNick(nick);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_BY_EMAIL)
	public ResponseEntity<Player> searchOnePlayerByEmail(@PathVariable("email") String email){
		return playerEnpointService.searchOnePlayerByEmail(email);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS)
	public ResponseEntity<List<Player>> searchAllPlayers(){
		return playerEnpointService.searchAllPlayers();
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS_BY_SCORE)
	public ResponseEntity<List<Player>> searchAllPlayersByScore(){
		return playerEnpointService.searchAllPlayersByScore();
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS_BY_ONLINE)
	public ResponseEntity<List<Player>> searchAllPlayersByOnline(@PathVariable("online") Boolean online){
		return playerEnpointService.searchAllPlayersByOnline(online);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> searchOnePlayerMatchById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idMatch") Long idMatch){
		
		return playerEnpointService.searchOnePlayerMatchById(idPlayer, idMatch);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_MATCHES)
	public ResponseEntity<List<MatchPlayed>> searchAllPlayerMatches(@PathVariable("idPlayer") Long idPlayer){		
		return playerEnpointService.searchAllPlayerMatches(idPlayer);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> searchOnePlayerChampionshipById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idChampionship") Long idChampionship){
		
		return playerEnpointService.searchOnePlayerChampionshipById(idPlayer, idChampionship);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_CHAMPIONSHIPS)
	public ResponseEntity<List<ChampionshipPlayed>> searchAllPlayerChampionships(@PathVariable("idPlayer") Long idPlayer){		
		return playerEnpointService.searchAllPlayerChampionships(idPlayer);
	}	
	// </editor-fold>
	
}//class
