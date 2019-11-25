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
	
	@Autowired
	private CapybaraDeathRepository capybaraDeathRepository;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	//"/capybara"
	public ResponseEntity<Capybara> createOneCapybara(@RequestBody Capybara newCapybara) {	
		
	}
	
	//"/capybara/{idCapybara}/death"
	public ResponseEntity<CapybaraDeath> createOneCapybaraDeath(Long idCapybara, CapybaraDeath newCapybaraDeath) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	//"/capybara/{idCapybara}"
	public ResponseEntity<Capybara> updateOneCapybara(Long idCapybara, Capybara capybaraToBeUpdated) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	//"/capybara/{idCapybara}/hp/{hp}"
	public ResponseEntity<Capybara> updateOneCapybaraHp(Long idCapybara, Integer hp) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	//"/capybara/{idCapybara}/death/{idDeath}"
	public ResponseEntity<CapybaraDeath> updateOneCapybaraDeath(
			Long idCapybara,
			Long idDeath,
			CapybaraDeath capybaraDeathToBeUpdated) {
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	//"/capybara/{idCapybara}"
	public ResponseEntity<Capybara> deleteOneCapybara(Long idCapybara) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	//"/capybara/{idCapybara}/death/{idDeath}"
	public ResponseEntity<CapybaraDeath> deleteOneCapybaraDeath(Long idCapybara, Long idDeath) {		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	//"/capybara/{idCapybara}"
	public ResponseEntity<Capybara> searchOneCapybaraById(@PathVariable("idCapybara") Long idCapybara){
		Capybara searchedCapybara = null;
		
		try {
			searchedCapybara = capybaraRepository.findById(idCapybara).get();
			return ResponseEntity.ok(searchedCapybara);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	//"/capybara/{idCapybara}/death/{idDeath}"
	public ResponseEntity<CapybaraDeath> searchOneCapybaraDeathById(Long idCapybara, Long idDeath) {		
		Capybara searchedCapybara = null;
		CapybaraDeath searchedCapybaraDeath = null;
		
		try {
			searchedCapybara = capybaraRepository.findById(idCapybara).get();			
			searchedCapybaraDeath = capybaraDeathRepository.findByCapybaraFKAndIdCapybaraDeath(searchedCapybara, idDeath);
			
			if (searchedCapybaraDeath != null) {
				return ResponseEntity.ok(searchedCapybaraDeath);
			}
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//"/capybaras"
	public ResponseEntity<List<Capybara>> searchAllCapybaras(){
		List<Capybara> searchedCapybaras = capybaraRepository.findAll();
		
		if (searchedCapybaras != null) {
			return ResponseEntity.ok(searchedCapybaras);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//"/capybara/{idCapybara}/deaths"
	public ResponseEntity<List<CapybaraDeath>> searchAllCapybaraDeaths(Long idCapybara){
		Capybara searchedCapybara = null;
		List<CapybaraDeath> searchedCapybaraDeaths = null;
		
		try {
			searchedCapybara = capybaraRepository.findById(idCapybara).get();			
			searchedCapybaraDeaths = capybaraDeathRepository.findAllByCapybaraFK(searchedCapybara);
			
			if (searchedCapybaraDeaths != null && searchedCapybaraDeaths.size() > 0) {
				return ResponseEntity.ok(searchedCapybaraDeaths);
			}
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//"/capybaras/live"
	public ResponseEntity<List<Capybara>> searchAllLiveCapybaras(){
		List<CapybaraDeath> searchedCapybaraDeaths = null;
		
		try {
			searchedCapybaraDeaths = capybaraDeathRepository.findByDateForRiseLessThanEqualOrderByDateForRiseDesc(LocalDateTime.now());
			
			if (searchedCapybaraDeaths != null && searchedCapybaraDeaths.size() > 0) {
				List<Capybara> capybaras = new ArrayList<>();
				
				for (CapybaraDeath capybaraDeath : searchedCapybaraDeaths) {
					capybaras.add(capybaraDeath.getCapybaraFK());
				}
				
				return ResponseEntity.ok(capybaras);
			}
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}	
	
	//"/capybaras/player/{idPlayer}"
	public ResponseEntity<List<Capybara>> searchAllCapybarasByIdPlayer(Long idPlayer){
		List<Capybara> searchedCapybaras = null;
		
		try {
			searchedCapybaras = capybaraRepository.findByIdPlayer(idPlayer);
			
			if (searchedCapybaras != null && searchedCapybaras.size() > 0) {
				return ResponseEntity.ok(searchedCapybaras);
			}
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">
	//"/capybara/{idCapybara}/check/died"
	public ResponseEntity<Boolean> checkOneCapybaraDied(Long idCapybara){
		Capybara searchedCapybara = null;
		List<CapybaraDeath> searchedCapybaraDeaths = null;
		
		try {
			searchedCapybara = capybaraRepository.findById(idCapybara).get();			
			searchedCapybaraDeaths = capybaraDeathRepository.findByCapybaraFKAndDateForRiseLessThanEqualOrderByDateForRiseDesc(searchedCapybara, LocalDateTime.now());
			
			if (searchedCapybaraDeaths != null 
					&& searchedCapybaraDeaths.size() > 0
					&& searchedCapybara.getHp() > 0) {				
				
				return ResponseEntity.ok(false);
			}
			
			return ResponseEntity.ok(true);
		} catch (Exception e) {			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

}//class
