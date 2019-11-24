package br.com.capivarawars.endpoint.service;

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
 * @author tiago, 24/11/2019, 17:55:44
 * Last update: -
 */// </editor-fold>
@Service
public class ColorService {
	
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private ColorRepository colorRepository;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	public ResponseEntity<Color> createOneColor(@RequestBody Color newColor) {		
		return ResponseEntity.status(HttpStatus.OK).body(newColor);
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
