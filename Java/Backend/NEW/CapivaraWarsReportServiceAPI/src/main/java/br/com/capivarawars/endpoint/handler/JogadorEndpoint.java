package br.com.capivarawars.endpoint.handler;

//<editor-fold defaultstate="collapsed" desc="imports...">
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.capivarawars.database.model.Player;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import org.springframework.web.bind.annotation.*;
import br.com.capivarawars.database.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//<editor-fold defaultstate="collapsed" desc="documentation...">

/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 *///</editor-fold>
@RestController
@RequestMapping(API_REPORT_SERVICE)
public class JogadorEndpoint {

	
	@Autowired
	private PlayerRepository repository;
	
	@GetMapping(API_REPORT_SERVICE_SEARCH_ALL_PLAYERS)
	public ResponseEntity<List<Player>> searchAllPlayers() {
		List<Player> searchedPlayers = repository.findAll();

		if (searchedPlayers != null) {
			return ResponseEntity.ok(searchedPlayers);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@GetMapping(API_REPORT_SERVICE_SEARCH_ONE_PLAYER_BY_ID)
	public ResponseEntity<Player> searchOnePlayerById(ObjectId idPlayer) {
		Player searchedPlayer = null;

		try {
			searchedPlayer = repository.findById(idPlayer).get();
			return ResponseEntity.ok(searchedPlayer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping(API_REPORT_SERVICE_UPDATE_ONE_PLAYER)
	public ResponseEntity<Player> updateOnePlayer(ObjectId _idPlayer, Player playerToBeUpdated) {
		if (playerToBeUpdated.isValidObject()) {

			Player searchedPlayer = searchOnePlayerById(_idPlayer).getBody();

			if (searchedPlayer != null) {
				try {
					playerToBeUpdated.set_id(_idPlayer);
					playerToBeUpdated = repository.save(playerToBeUpdated);
					return ResponseEntity.ok(playerToBeUpdated);
				} catch (Exception e) {
					//Caso o email ou nick sejam duplicados é gerado esse erro				
				}
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@PostMapping(API_REPORT_SERVICE_CREATE_ONE_PLAYER)
	public ResponseEntity<Player> createOnePlayer(Player newPlayer) {
		Player searchedPlayer = searchOnePlayerById(newPlayer.getObjectId()).getBody();

		if (searchedPlayer == null) {
			if (newPlayer.isValidObject()) {
				try {
					newPlayer = repository.save(newPlayer);
					return ResponseEntity.ok(newPlayer);
				} catch (Exception e) {
					//Caso o email ou nick sejam duplicados é gerado esse erro							
				}
			} else {
				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new Player());
			}
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new Player());
	}

	@DeleteMapping(API_REPORT_SERVICE_DELETE_ONE_PLAYER)
	public ResponseEntity<Player> deleteOnePlayer(ObjectId idPlayer) {
		Player searchedPlayer = searchOnePlayerById(idPlayer).getBody();

		if (searchedPlayer != null) {
			try {
				repository.deleteById(idPlayer);
				return ResponseEntity.ok(searchedPlayer);
			} catch (Exception e) {
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
