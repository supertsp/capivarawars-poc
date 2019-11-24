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
	public ResponseEntity<Capybara> createOneCapybara(@RequestBody Capybara newCapybara) {		
		return capybaraService.createOneCapybara(newCapybara);
	}
	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">

	// </editor-fold>

}//class
