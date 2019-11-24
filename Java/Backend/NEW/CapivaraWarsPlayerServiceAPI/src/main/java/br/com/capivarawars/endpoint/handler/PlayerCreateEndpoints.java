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
public class PlayerCreateEndpoints {
		
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

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER)
	public ResponseEntity<Player> createOnePlayer(@RequestBody Player newPlayer) {
		if (newPlayer.isValidObject()) {
			
			Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(newPlayer.getIdPlayer()).getBody();
			
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
		
		Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(idPlayer).getBody();		
		
		if (searchedPlayer != null) {			
			matchPlayed.setPlayerFK(searchedPlayer);
			
			MatchPlayed searchedMatchPlayed = playerSearchEndpoint.searchOnePlayerMatchById(idPlayer, matchPlayed.getIdMatch()).getBody();
			
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
		
		Player searchedPlayer = playerSearchEndpoint.searchOnePlayerById(idPlayer).getBody();
		
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
	
}//class
