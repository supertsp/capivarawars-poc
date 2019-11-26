package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.endpoint.service.PlayerService;
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
public class PlayerDeleteEndpoints {
		
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private PlayerService playerService;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	@DeleteMapping(API_PLAYER_SERVICE_DELETE_ONE_PLAYER)
	public ResponseEntity<Player> deleteOnePlayer(@PathVariable("idPlayer") Long idPlayer) {
		return playerService.deleteOnePlayer(idPlayer);
	}
	
	@DeleteMapping(API_PLAYER_SERVICE_DELETE_ONE_PLAYER_MATCH)
	public ResponseEntity<MatchPlayed> deleteOnePlayerMatch(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idMatch") Long idMatch){
	
		return playerService.deleteOnePlayerMatch(idPlayer, idMatch);
	}
	
	@DeleteMapping(API_PLAYER_SERVICE_DELETE_ONE_PLAYER_CHAMPIONSHIP)
	public ResponseEntity<ChampionshipPlayed> deleteOnePlayerChampionship(
			@PathVariable("idPlayer") Long idPlayer,
			@PathVariable("idChampionship") Long idChampionship){
	
		return playerService.deleteOnePlayerChampionship(idPlayer, idChampionship);
	}
	// </editor-fold>	
	
}//class
