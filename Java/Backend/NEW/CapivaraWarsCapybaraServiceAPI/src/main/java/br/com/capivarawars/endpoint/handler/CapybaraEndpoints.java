package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.endpoint.service.*;
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
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
 * @author tiago, 24/11/2019, 17:59:53
 * Last update: -
 */// </editor-fold>
@RestController
@RequestMapping(API_CAPYBARA_SERVICE)
public class CapybaraEndpoints {
	
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private CapybaraService capybaraService;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	@PostMapping(API_CAPYBARA_SERVICE_CREATE_ONE_CAPYBARA)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Created"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 206, message = "Partial Content"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "-"),
      @ApiResponse(code = 406, message = "Not Acceptable") })
	public ResponseEntity<Capybara> createOneCapybara(@RequestBody Capybara newCapybara) {		
		return capybaraService.createOneCapybara(newCapybara);
	}
	
	@PostMapping(API_CAPYBARA_SERVICE_CREATE_ONE_CAPYBARA_DEATH)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Created"),
      @ApiResponse(code = 201, message = "-"),
	  @ApiResponse(code = 206, message = "Partial Content"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 406, message = "Not Acceptable") })
	public ResponseEntity<CapybaraDeath> createOneCapybaraDeath(
			@PathVariable("idCapybara") Long idCapybara,
			@RequestBody CapybaraDeath newCapybaraDeath) {		
		return capybaraService.createOneCapybaraDeath(idCapybara, newCapybaraDeath);
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	@PutMapping(API_CAPYBARA_SERVICE_UPDATE_ONE_CAPYBARA)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Updated"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Capybara> updateOneCapybara(
			@PathVariable("idCapybara") Long idCapybara,
			@RequestBody Capybara capybaraToBeUpdated) {
		
		return capybaraService.updateOneCapybara(idCapybara, capybaraToBeUpdated);
	}
	
	@PutMapping(API_CAPYBARA_SERVICE_UPDATE_ONE_CAPYBARA_HP)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Updated"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Capybara> updateOneCapybaraHp(
			@PathVariable("idCapybara") Long idCapybara,
			@PathVariable("hp") Integer hp) {
		
		return capybaraService.updateOneCapybaraHp(idCapybara, hp);
	}
	
	@PutMapping(API_CAPYBARA_SERVICE_UPDATE_ONE_CAPYBARA_DEATH)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Updated"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<CapybaraDeath> updateOneCapybaraDeath(
			@PathVariable("idCapybara") Long idCapybara,
			@PathVariable("idDeath") Long idDeath,
			@RequestBody CapybaraDeath capybaraDeathToBeUpdated) {
		
		return capybaraService.updateOneCapybaraDeath(idCapybara, idDeath, capybaraDeathToBeUpdated);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	@DeleteMapping(API_CAPYBARA_SERVICE_DELETE_ONE_CAPYBARA)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Deleted"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Capybara> deleteOneCapybara(@PathVariable("idCapybara") Long idCapybara) {
		return capybaraService.deleteOneCapybara(idCapybara);
	}
	
	@DeleteMapping(API_CAPYBARA_SERVICE_DELETE_ONE_CAPYBARA_DEATH)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Deleted"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<CapybaraDeath> deleteOneCapybaraDeath(
			@PathVariable("idCapybara") Long idCapybara,
			@PathVariable("idDeath") Long idDeath) {
		
		return capybaraService.deleteOneCapybaraDeath(idCapybara, idDeath);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ONE_CAPYBARA_BY_ID)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Capybara> searchOneCapybaraById(@PathVariable("idCapybara") Long idCapybara){
		return capybaraService.searchOneCapybaraById(idCapybara);
	}
	
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ONE_CAPYBARA_DEATH_BY_ID)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<CapybaraDeath> searchOneCapybaraDeathById(
			@PathVariable("idCapybara") Long idCapybara,
			@PathVariable("idDeath") Long idDeath) {
		
		return capybaraService.searchOneCapybaraDeathById(idCapybara, idDeath);
	}
	
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ALL_CAPYBARAS)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<List<Capybara>> searchAllCapybaras(){
		return capybaraService.searchAllCapybaras();
	}
	
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ALL_CAPYBARA_DEATHS)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<List<CapybaraDeath>> searchAllCapybaraDeaths(@PathVariable("idCapybara") Long idCapybara){
		return capybaraService.searchAllCapybaraDeaths(idCapybara);
	}
	
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ALL_LIVE_CAPYBARAS)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<List<Capybara>> searchAllLiveCapybaras(){
		return capybaraService.searchAllLiveCapybaras();
	}
	
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ALL_CAPYBARAS_BY_ID_PLAYER)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<List<Capybara>> searchAllCapybarasByIdPlayer(@PathVariable("idPlayer") Long idPlayer){
		return capybaraService.searchAllCapybarasByIdPlayer(idPlayer);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	@GetMapping(API_CAPYBARA_SERVICE_CHECK_ONE_CAPYBARA_DIED)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Boolean> checkOneCapybaraDied(@PathVariable("idCapybara") Long idCapybara){
		return capybaraService.checkOneCapybaraDied(idCapybara);
	}
	// </editor-fold>

}//class
