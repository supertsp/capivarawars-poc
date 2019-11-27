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
 * @author tiago, 24/11/2019, 18:00:53
 * Last update: -
 */// </editor-fold>
@RestController
@RequestMapping(API_CAPYBARA_SERVICE)
public class ColorEndpoints {
	
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private ColorService colorService;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	@PostMapping(API_CAPYBARA_SERVICE_CREATE_ONE_COLOR)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Created"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 206, message = "Partial Content"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "-"),
      @ApiResponse(code = 406, message = "Not Acceptable") })
	public ResponseEntity<Color> createOneColor(@RequestBody Color newColor) {		
		return colorService.createOneColor(newColor);
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	@PutMapping(API_CAPYBARA_SERVICE_UPDATE_ONE_COLOR)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Updated"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Color> updateOneColor(
			@PathVariable("idColor") Long idColor,
			@RequestBody Color colorToBeUpdated) {
		
		return colorService.updateOneColor(idColor, colorToBeUpdated);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	@DeleteMapping(API_CAPYBARA_SERVICE_DELETE_ONE_COLOR)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Deleted"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Color> deleteOneColor(@PathVariable("idColor") Long idColor) {
		return colorService.deleteOneColor(idColor);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ONE_COLOR_BY_ID)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Deleted"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<Color> searchOneColorById(@PathVariable("idColor") Long idColor){
		return colorService.searchOneColorById(idColor);
	}
	
	@GetMapping(API_CAPYBARA_SERVICE_SEARCH_ALL_COLORS)
	@ApiResponses(value = { 
      @ApiResponse(code = 200, message = "Element Found"),
      @ApiResponse(code = 201, message = "-"),
      @ApiResponse(code = 401, message = "-"),
      @ApiResponse(code = 403, message = "-"),
      @ApiResponse(code = 404, message = "Not Found")})
	public ResponseEntity<List<Color>> searchAllColors(){
		return colorService.searchAllColors();
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">

	// </editor-fold>

}//class
