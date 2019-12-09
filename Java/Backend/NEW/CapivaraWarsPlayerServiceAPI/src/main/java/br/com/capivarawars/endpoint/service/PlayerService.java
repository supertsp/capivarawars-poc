package br.com.capivarawars.endpoint.service;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;
import br.com.capivarawars.tool.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 24/11/2019, 13:02:40
 * Last update: -
 */// </editor-fold>
@Service
public class PlayerService {
	
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
	public ResponseEntity<Player> createOnePlayer(Player newPlayer) {
		Player searchedPlayer = searchOnePlayerById(newPlayer.getIdPlayer()).getBody();
		
		if (searchedPlayer == null) {
			if (newPlayer.isValidObject()) {
				try {
					newPlayer = playerRepository.save(newPlayer);
					return ResponseEntity.ok(newPlayer);
				} catch (Exception e) {
					//Caso o email ou nick sejam duplicados é gerado esse erro							
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new Player());
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	public ResponseEntity<MatchPlayed> createOnePlayerMatch(Long idPlayer, MatchPlayed matchPlayed) {		
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
	
	public ResponseEntity<ChampionshipPlayed> createOnePlayerChampionship(Long idPlayer, ChampionshipPlayed championshipPlayed) {
		
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
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	public ResponseEntity<Player> updateOnePlayer(Long idPlayer, Player playerToBeUpdated) {		
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
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	public ResponseEntity<Player> patchOnePlayer(Long idPlayer, Player playerToBeCopiedFields) {
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();

		if (searchedPlayer != null) {
			try {
				searchedPlayer.patchFields(playerToBeCopiedFields);
				
				if (searchedPlayer.isValidObject()) {
					searchedPlayer = playerRepository.save(searchedPlayer);
					return ResponseEntity.ok(searchedPlayer);
				}
				
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
			} catch (Exception e) {
				//Caso o email ou nick sejam duplicados é gerado esse erro				
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<Player> updateOnePlayerOnline(Long idPlayer, Boolean online) {			
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
	
	public ResponseEntity<MatchPlayed> updateOnePlayerMatch(Long idPlayer, Long idMatch, MatchPlayed matchToBeUpdated) {		
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
	
	public ResponseEntity<ChampionshipPlayed> updateOnePlayerChampionship(Long idPlayer, Long idChampionship, ChampionshipPlayed championshipToBeUpdated) {		
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
	public ResponseEntity<Player> deleteOnePlayer(Long idPlayer) {
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
	
	public ResponseEntity<MatchPlayed> deleteOnePlayerMatch(Long idPlayer, Long idMatch){	
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
	
	public ResponseEntity<ChampionshipPlayed> deleteOnePlayerChampionship(Long idPlayer, Long idChampionship){	
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
	public ResponseEntity<Player> searchOnePlayerById(Long idPlayer){
		Player searchedPlayer = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();
			return ResponseEntity.ok(searchedPlayer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	public ResponseEntity<Player> searchOnePlayerByNick(String nick){
		Player searchedPlayer = playerRepository.findByNick(nick);
			
		if (searchedPlayer != null) {
			return ResponseEntity.ok(searchedPlayer);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<Player> searchOnePlayerByEmail(String email){
		Player searchedPlayer = playerRepository.findByEmail(email);
		
		if (searchedPlayer != null) {
			return ResponseEntity.ok(searchedPlayer);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
		
	public ResponseEntity<List<Player>> searchAllPlayers(){
		List<Player> searchedPlayers = playerRepository.findAll();
		
		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<List<Player>> searchAllPlayersByScore(){
		List<Player> searchedPlayers = playerRepository.findAllOrderByScoreDesc();
		
		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<List<Player>> searchAllPlayersByOnline(Boolean online){
		List<Player> searchedPlayers = playerRepository.findAllByOnlineOrderByScoreDesc(online);
		
		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<MatchPlayed> searchOnePlayerMatchById(Long idPlayer, Long idMatch){		
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
	
	public ResponseEntity<List<MatchPlayed>> searchAllPlayerMatches(Long idPlayer){		
		Player searchedPlayer = null;
		List<MatchPlayed> searchedMatchesPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedMatchesPlayed = matchPlayedRepository.findAllByPlayerFK(searchedPlayer);
			
			if (searchedMatchesPlayed != null && searchedMatchesPlayed.size() > 0) {
				return ResponseEntity.ok(searchedMatchesPlayed);
			}			
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<ChampionshipPlayed> searchOnePlayerChampionshipById(Long idPlayer, Long idChampionship){		
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
	
	public ResponseEntity<List<ChampionshipPlayed>> searchAllPlayerChampionships(Long idPlayer){		
		Player searchedPlayer = null;
		List<ChampionshipPlayed> searchedChampionshipsPlayed = null;
		
		try {
			searchedPlayer = playerRepository.findById(idPlayer).get();			
			searchedChampionshipsPlayed = championshipPlayedRepository.findAllByPlayerFK(searchedPlayer);
			
			if (searchedChampionshipsPlayed != null && searchedChampionshipsPlayed.size() > 0) {
				return ResponseEntity.ok(searchedChampionshipsPlayed);
			}			
		} catch (Exception e) {
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	public ResponseEntity<Boolean> checkOnePlayerOnline(Long idPlayer){
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();
		
		if (searchedPlayer != null) {
			if (searchedPlayer.isOnline()) {
				return ResponseEntity.ok(true);
			}
			
			return ResponseEntity.ok(false);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<Boolean> checkOnePlayerCredentials(Credentials credentials){
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
	public ResponseEntity<String> login(Credentials credentials) {
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
	
	public ResponseEntity<String> logout(Long idPlayer) {
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
