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
public class PlayerUpdateEndpoints {
		
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

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	@PutMapping(API_PLAYER_SERVICE_UPDATE_ONE_PLAYER)
	public ResponseEntity<Player> updateOnePlayer(
			@PathVariable("idPlayer") Long idPlayer,
			@RequestBody Player playerToBeUpdated) {
		
		if (playerToBeUpdated.isValidObject()) {
			
			Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(idPlayer).getBody();
			
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
			
		Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(idPlayer).getBody();

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
		
		MatchPlayed searchedMatchPlayed = playerSearchEndpoint.searchOnePlayerMatchById(idPlayer, idMatch).getBody();
		
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
		
		ChampionshipPlayed searchedChampionshipPlayed = playerSearchEndpoint.searchOnePlayerChampionshipById(idPlayer, idChampionship).getBody();
		
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
	
}//class
