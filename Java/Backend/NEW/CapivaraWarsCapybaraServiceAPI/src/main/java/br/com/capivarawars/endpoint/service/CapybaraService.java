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
public class CapybaraService {
	
	// <editor-fold defaultstate="collapsed" desc="fields...">
	@Autowired
	private CapybaraRepository capybaraRepository;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	public ResponseEntity<Capybara> createOneCapybara(@RequestBody Capybara newCapybara) {	
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<CapybaraDeath> createOneCapybaraDeath(Long idCapybara, CapybaraDeath newCapybaraDeath) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	public ResponseEntity<Capybara> updateOneCapybara(Long idCapybara, Capybara capybaraToBeUpdated) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<Capybara> updateOneCapybaraHp(Long idCapybara, Integer hp) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<CapybaraDeath> updateOneCapybaraDeath(
			Long idCapybara,
			Long idDeath,
			CapybaraDeath capybaraDeathToBeUpdated) {
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	public ResponseEntity<Capybara> deleteOneCapybara(Long idCapybara) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<CapybaraDeath> deleteOneCapybaraDeath(Long idCapybara, Long idDeath) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	public ResponseEntity<Capybara> searchOneCapybaraById(@PathVariable("idCapybara") Long idCapybara){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<CapybaraDeath> searchOneCapybaraDeathById(Long idCapybara, Long idDeath) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<List<Capybara>> searchAllCapybaras(){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<List<CapybaraDeath>> searchAllCapybaraDeaths(){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	public ResponseEntity<List<Capybara>> searchAllLiveCapybaras(){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}	
	
	public ResponseEntity<List<Capybara>> searchAllCapybarasByIdPlayer(Long idPlayer){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	public ResponseEntity<Boolean> checkOneCapybaraDied(Long idCapybara){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	// </editor-fold>

}//class
