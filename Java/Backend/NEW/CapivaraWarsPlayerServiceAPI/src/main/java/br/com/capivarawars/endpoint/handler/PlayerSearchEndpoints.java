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
public class PlayerSearchEndpoints {
		
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MatchPlayedRepository matchPlayedRepository;
	
	@Autowired
	private ChampionshipPlayedRepository championshipPlayedRepository;
		
//	@Autowired
//	private DataBaseAPIClient dataBaseAPIClient;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_BY_ID)
	public ResponseEntity<Player> searchOnePlayerById(@PathVariable("idPlayer") Long idPlayer){
		Player searchedPlayer = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();
			return ResponseEntity.ok(searchedPlayer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_BY_NICK)
	public ResponseEntity<Player> searchOnePlayerByNick(@PathVariable("nick") String nick){
		Player searchedPlayer = playerRepository.findByNick(nick);
			
		if (searchedPlayer != null) {
			return ResponseEntity.ok(searchedPlayer);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_BY_EMAIL)
	public ResponseEntity<Player> searchOnePlayerByEmail(@PathVariable("email") String email){
		Player searchedPlayer = playerRepository.findByEmail(email);
		
		if (searchedPlayer != null) {
			return ResponseEntity.ok(searchedPlayer);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS)
	public ResponseEntity<List<Player>> searchAllPlayers(){
		List<Player> searchedPlayers = playerRepository.findAll();
		
		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS_BY_SCORE)
	public ResponseEntity<List<Player>> searchAllPlayersByScore(){
		List<Player> searchedPlayers = playerRepository.findAllOrderByScoreDesc();
		
		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS_BY_ONLINE)
	public ResponseEntity<List<Player>> searchAllPlayersByOnline(@PathVariable("online") Boolean online){
		List<Player> searchedPlayers = playerRepository.findAllByOnlineOrderByScoreDesc(online);
		
		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> searchOnePlayerMatchById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idMatch") Long idMatch){
		
		Player searchedPlayer = null;
		MatchPlayed searchedMatchPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedMatchPlayed = matchPlayedRepository.findByIdMatchAndPlayerFK(idMatch, searchedPlayer);
			
			if (searchedMatchPlayed != null) {
				return ResponseEntity.ok(searchedMatchPlayed);
			}
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_MATCHES)
	public ResponseEntity<List<MatchPlayed>> searchAllPlayerMatches(@PathVariable("idPlayer") Long idPlayer){		
		Player searchedPlayer = null;
		List<MatchPlayed> searchedMatchesPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedMatchesPlayed = matchPlayedRepository.findAllByPlayerFK(searchedPlayer);
			
			if (searchedMatchesPlayed != null && searchedMatchesPlayed.size() > 0) {
				return ResponseEntity.ok(searchedMatchesPlayed);
			}
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> searchOnePlayerChampionshipById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idChampionship") Long idChampionship){
		
		Player searchedPlayer = null;
		ChampionshipPlayed searchedChampionshipPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedChampionshipPlayed = championshipPlayedRepository.findByIdChampionshipAndPlayerFK(idChampionship, searchedPlayer);	
			
			if (searchedChampionshipPlayed != null) {
				return ResponseEntity.ok(searchedChampionshipPlayed);
			}
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_CHAMPIONSHIPS)
	public ResponseEntity<List<ChampionshipPlayed>> searchAllPlayerChampionships(@PathVariable("idPlayer") Long idPlayer){		
		Player searchedPlayer = null;
		List<ChampionshipPlayed> searchedChampionshipsPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedChampionshipsPlayed = championshipPlayedRepository.findAllByPlayerFK(searchedPlayer);
			
			if (searchedChampionshipsPlayed != null && searchedChampionshipsPlayed.size() > 0) {
				return ResponseEntity.ok(searchedChampionshipsPlayed);
			}
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}	
	// </editor-fold>
	
}//class
