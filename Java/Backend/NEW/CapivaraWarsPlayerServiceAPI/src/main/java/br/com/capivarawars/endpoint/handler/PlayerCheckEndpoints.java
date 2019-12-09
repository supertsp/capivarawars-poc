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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
public class PlayerCheckEndpoints {
		
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private PlayerService playerService;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>
		
	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	@GetMapping(API_PLAYER_SERVICE_CHECK_ONE_PLAYER_ONLINE)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Boolean> checkOnePlayerOnline(@PathVariable("idPlayer") Long idPlayer){
		return playerService.checkOnePlayerOnline(idPlayer);
	}
	
	@PostMapping(API_PLAYER_SERVICE_CHECK_ONE_PLAYER_CREDENTIALS)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Boolean> checkOnePlayerCredentials(@RequestBody Credentials credentials){
		return playerService.checkOnePlayerCredentials(credentials);
	}	
	// </editor-fold>
	
}//class
