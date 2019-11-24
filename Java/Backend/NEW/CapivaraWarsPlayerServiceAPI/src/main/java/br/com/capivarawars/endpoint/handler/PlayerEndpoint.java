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
public class PlayerEndpoint {
		
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

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER)
	public ResponseEntity<Player> createOnePlayer(@RequestBody Player newPlayer) {
		if (newPlayer.isValidObject()) {
			
			Player searchedPlayer = searchOnePlayerById(newPlayer.getIdPlayer()).getBody();
			
			if (searchedPlayer == null) {
				try {
					newPlayer = playerRepository.save(newPlayer);
					return ResponseEntity.ok(newPlayer);
				} catch (Exception e) {
					//Caso o email ou nick sejam duplicados é gerado esse erro				
				}
			}			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> createOnePlayerMatch(
			@PathVariable("idPlayer") Long idPlayer,
			@RequestBody MatchPlayed matchPlayed) {
		
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();		
		
		if (searchedPlayer != null) {			
			matchPlayed.setPlayerFK(searchedPlayer);
			
			MatchPlayed searchedMatchPlayed = searchOnePlayerMatchById(idPlayer, matchPlayed.getIdMatch()).getBody();
			
			if (searchedMatchPlayed == null) {
				if (matchPlayed.isValidObject()) {					
					matchPlayed = matchPlayedRepository.save(matchPlayed);
//					searchedPlayer.addMatchPlayed(matchPlayed);
//					playerRepository.save(searchedPlayer);
					
					return ResponseEntity.ok(matchPlayed);
				}
				else{
					return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new MatchPlayed());
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new MatchPlayed());
			}			
		}
		else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> createOnePlayerChampionship(
			@PathVariable("idPlayer") Long idPlayer,
			@RequestBody ChampionshipPlayed championshipPlayed) {
		
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();
		
		if (searchedPlayer != null) {
			championshipPlayed.setPlayerFK(searchedPlayer);
			
			ChampionshipPlayed searchedChampionshipPlayed = 
					championshipPlayedRepository.findByIdChampionshipAndPlayerFK(championshipPlayed.getIdChampionship(), searchedPlayer);	
			
			if (searchedChampionshipPlayed == null) {
				if (championshipPlayed.isValidObject()) {
					championshipPlayed = championshipPlayedRepository.save(championshipPlayed);					
//					searchedPlayer.addChampionshipPlayed(championshipPlayed);
//					playerRepository.save(searchedPlayer);
					
					return ResponseEntity.ok(championshipPlayed);
				}
				else{
					return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new ChampionshipPlayed());
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ChampionshipPlayed());
			}
		}
		else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	@PutMapping(API_PLAYER_SERVICE_UPDATE_ONE_PLAYER)
	public ResponseEntity<Player> updateOnePlayer(
			@PathVariable("idPlayer") Long idPlayer,
			@RequestBody Player playerToBeUpdated) {
		
		if (playerToBeUpdated.isValidObject()) {
			
			Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();
			
			if (searchedPlayer != null) {
				try {
					playerToBeUpdated.setIdPlayer(idPlayer);
					playerToBeUpdated = playerRepository.save(playerToBeUpdated);
					return ResponseEntity.ok(playerToBeUpdated);
				} catch (Exception e) {
					//Caso o email ou nick sejam duplicados é gerado esse erro				
				}
			}			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PutMapping(API_PLAYER_SERVICE_UPDATE_ONE_PLAYER_ONLINE)
	public ResponseEntity<Player> updateOnePlayerOnline(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("online") Boolean online) {	
			
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();

		if (searchedPlayer != null) {
			try {
				searchedPlayer.setOnline(online);
				searchedPlayer = playerRepository.save(searchedPlayer);
				return ResponseEntity.ok(searchedPlayer);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PutMapping(API_PLAYER_SERVICE_UPDATE_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> updateOnePlayerMatch(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idMatch") Long idMatch,
			@RequestBody MatchPlayed matchToBeUpdated) {
		
		MatchPlayed searchedMatchPlayed = searchOnePlayerMatchById(idPlayer, idMatch).getBody();
		
		if (searchedMatchPlayed != null) {
			matchToBeUpdated.setIdMatchPlayed(searchedMatchPlayed.getIdMatchPlayed());
			matchToBeUpdated.setIdMatch(searchedMatchPlayed.getIdMatch());
			matchToBeUpdated.setPlayerFK(searchedMatchPlayed.getPlayerFK());			
		
			if (matchToBeUpdated.isValidObject()) {
				try {
					matchToBeUpdated = matchPlayedRepository.save(matchToBeUpdated);					
					return ResponseEntity.ok(matchToBeUpdated);
				} catch (Exception e) {					
				}
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PutMapping(API_PLAYER_SERVICE_UPDATE_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> updateOnePlayerChampionship(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idChampionship") Long idChampionship,
			@RequestBody ChampionshipPlayed championshipToBeUpdated) {
		
		ChampionshipPlayed searchedChampionshipPlayed = searchOnePlayerChampionshipById(idPlayer, idChampionship).getBody();
		
		if (searchedChampionshipPlayed != null) {
			championshipToBeUpdated.setIdChampionshipPlayed(searchedChampionshipPlayed.getIdChampionshipPlayed());
			championshipToBeUpdated.setIdChampionship(searchedChampionshipPlayed.getIdChampionship());
			championshipToBeUpdated.setPlayerFK(searchedChampionshipPlayed.getPlayerFK());			
		
			if (championshipToBeUpdated.isValidObject()) {
				try {
					championshipToBeUpdated = championshipPlayedRepository.save(championshipToBeUpdated);					
					return ResponseEntity.ok(championshipToBeUpdated);
				} catch (Exception e) {					
				}
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	@DeleteMapping(API_PLAYER_SERVICE_DELETE_ONE_PLAYER)
	public ResponseEntity<Player> deleteOnePlayer(@PathVariable("idPlayer") Long idPlayer) {
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();

		if (searchedPlayer != null) {
			try {
				playerRepository.deleteById(idPlayer);
				return ResponseEntity.ok(searchedPlayer);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@DeleteMapping(API_PLAYER_SERVICE_DELETE_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> deleteOnePlayerMatch(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idMatch") Long idMatch){
	
		MatchPlayed searchedMatchPlayed = searchOnePlayerMatchById(idPlayer, idMatch).getBody();

		if (searchedMatchPlayed != null) {
			try {
				matchPlayedRepository.deleteById(searchedMatchPlayed.getIdMatchPlayed());
				return ResponseEntity.ok(searchedMatchPlayed);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@DeleteMapping(API_PLAYER_SERVICE_DELETE_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> deleteOnePlayerChampionship(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idChampionship") Long idChampionship){
	
		ChampionshipPlayed searchedChampionshipPlayed = searchOnePlayerChampionshipById(idPlayer, idChampionship).getBody();

		if (searchedChampionshipPlayed != null) {
			try {
				championshipPlayedRepository.deleteById(searchedChampionshipPlayed.getIdChampionshipPlayed());
				return ResponseEntity.ok(searchedChampionshipPlayed);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
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

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	@GetMapping(API_PLAYER_SERVICE_CHECK_ONE_PLAYER_ONLINE)
	public ResponseEntity<Boolean> checkOnePlayerOnline(@PathVariable("idPlayer") Long idPlayer){
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();
		
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
		Player searchedPlayer = searchOnePlayerByNick(credentials.getNick()).getBody();
		
		if (searchedPlayer != null) {
			if (credentials.validate(searchedPlayer)) {
				return ResponseEntity.ok(true);
			}
			
			return ResponseEntity.ok(false);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}	
	// </editor-fold>

	// <editor-fold desc="AUTHENTICATION methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_LOGIN)
	public ResponseEntity<String> login(@RequestBody Credentials credentials) {
		Boolean playerExists = checkOnePlayerCredentials(credentials).getBody();
		
		if (playerExists) {
			Player searchedPlayer = searchOnePlayerByNick(credentials.getNick()).getBody();
			
			if (!searchedPlayer.isOnline()) {
				updateOnePlayerOnline(searchedPlayer.getIdPlayer(), true);
				return ResponseEntity.ok("Successfully logged in :)");
			}
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This user is already logged in :0");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The credentials are wrong :(");
	}
	
	@PostMapping(API_PLAYER_SERVICE_LOGOUT)
	public ResponseEntity<String> logout(@PathVariable("idPlayer") Long idPlayer) {
		Boolean playerOnline = checkOnePlayerOnline(idPlayer).getBody();
		
		if (playerOnline != null) {
			if (playerOnline) {
				Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();
				updateOnePlayerOnline(searchedPlayer.getIdPlayer(), false);
				return ResponseEntity.ok("Successfully logged out :)");
			}
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This user is not logged in yet :0");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid user :(");
	}
	// </editor-fold>	
	
}//class
