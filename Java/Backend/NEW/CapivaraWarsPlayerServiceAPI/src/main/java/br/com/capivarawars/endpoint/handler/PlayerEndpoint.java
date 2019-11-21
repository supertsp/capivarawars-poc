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
	
	@Autowired
	private PrizeEarnedRepository prizeEarnedRepository;
	
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
	
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER_PRIZE)
	public ResponseEntity<PrizesEarned> createOnePlayerPrize(
			@PathVariable("idPlayer") Long idPlayer,
			@RequestBody PrizesEarned prizeEarned) {
		
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();
		
		if (searchedPlayer != null) {
			prizeEarned.setPlayerFK(searchedPlayer);
			
			PrizesEarned searchedPrizeEarned = prizeEarnedRepository.findByIdPrizeAndPlayerFK(prizeEarned.getIdPrize(), searchedPlayer);
			
			if (searchedPrizeEarned == null) {
				if (prizeEarned.isValidObject()) {
					prizeEarned = prizeEarnedRepository.save(prizeEarned);
					return ResponseEntity.ok(prizeEarned);
				}
				else{
					return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new PrizesEarned());
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new PrizesEarned());
			}
		}
		else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER)
	public ResponseEntity<Player> searchOnePlayerById(@PathVariable("idPlayer") Long idPlayer){
		Player searchedPlayer = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();
			return ResponseEntity.ok(searchedPlayer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> searchOnePlayerMatchById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idMatch") Long idMatch){
		
		Player searchedPlayer = null;
		MatchPlayed searchedMatchesPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedMatchesPlayed = matchPlayedRepository.findByIdMatchAndPlayerFK(idMatch, searchedPlayer);
			
			if (searchedMatchesPlayed != null) {
				return ResponseEntity.ok(searchedMatchesPlayed);
			}
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> searchOnePlayerChampionshipById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idChampionship") Long idChampionship){
		
		Player searchedPlayer = null;
		ChampionshipPlayed searchedChampionshipsPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedChampionshipsPlayed = championshipPlayedRepository.findByIdChampionshipAndPlayerFK(idChampionship, searchedPlayer);	
			
			if (searchedChampionshipsPlayed != null) {
				return ResponseEntity.ok(searchedChampionshipsPlayed);
			}
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_PRIZE)
	public ResponseEntity<PrizesEarned> searchOnePlayerPrizeById(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idPrize") Long idPrize){
		
		Player searchedPlayer = null;
		PrizesEarned searchedPrizesEarned = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedPrizesEarned = prizeEarnedRepository.findByIdPrizeAndPlayerFK(idPrize, searchedPlayer);	
			
			if (searchedPrizesEarned != null) {
				return ResponseEntity.ok(searchedPrizesEarned);
			}
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">

	// </editor-fold>

	// <editor-fold desc="AUTHENTICATION methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_LOGIN)
	public ResponseEntity<Player> login(@RequestHeader String nick, @RequestHeader String senha) {
		Player jogadorProcurado = null;
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	// </editor-fold>	
	
}//class

//System.out.println("\n\n\nsearchedMatchesPlayed:\n" +
//					searchedMatchesPlayed
//			+"\n\n\n\n");