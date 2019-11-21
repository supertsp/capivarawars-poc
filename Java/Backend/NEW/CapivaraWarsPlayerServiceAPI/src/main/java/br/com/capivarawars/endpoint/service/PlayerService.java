package br.com.capivarawars.endpoint.service;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 */// </editor-fold>
@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MatchPlayedRepository matchesPlayedRepository;
	
	@Autowired
	private ChampionshipPlayedRepository championshipsPlayedRepository;
	
	@Autowired
	private PrizeEarnedRepository prizesEarnedRepository;
	
	@Autowired
	private static PlayerService instance;
	
	private static PlayerService getInstance(){
		if (instance == null) {
			instance = new PlayerService();
		}
		
		return instance;
	}
	
	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER)
	public ResponseEntity<Player> createOnePlayer(@RequestBody Player newPlayer) {
		if (newPlayer.isValidObject()) {
			try {
				playerRepository.save(newPlayer);
				return ResponseEntity.ok(newPlayer);
			} catch (Exception e) {
				//Caso o email ou nick sejam duplicados é gerado esse erro
				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(
						Player.getInstanceForError()
								.setNick("THIS FIELD MUST BE UNIQUE")
								.setEmail("THIS FIELD MUST BE UNIQUE")
				);
			}
		}
		
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(Player.getInstanceForError());
	}
	
	@PostMapping(API_PLAYER_SERVICE_CREATE_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> createOnePlayerMatch(@RequestBody MatchPlayed matchPlayed) {
		if (matchPlayed.isValidObject()) {
//			try {
				matchesPlayedRepository.save(matchPlayed);
				return ResponseEntity.ok(matchPlayed);
//			} catch (Exception e) {
//				//Caso o email ou nick sejam duplicados é gerado esse erro
//				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new MatchesPlayed);
//			}
		}
		
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new MatchPlayed());
	}
	// </editor-fold>
	// <editor-fold desc="UPDATE methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="DELETE methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="SEARCH methods..." defaultstate="collapsed">
	public static Player searchById(Long playerId){
		return getInstance().playerRepository.getOne(playerId);
	}
	// </editor-fold>
	// <editor-fold desc="CHECK methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="AUTHENTICATION methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_LOGIN)
	public ResponseEntity<Player> login(@RequestHeader String nick, @RequestHeader String senha) {
		Player jogadorProcurado = null;
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	// </editor-fold>

}//class
