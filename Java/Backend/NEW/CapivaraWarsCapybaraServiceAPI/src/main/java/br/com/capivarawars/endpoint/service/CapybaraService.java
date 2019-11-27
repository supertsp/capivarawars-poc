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
	
	//Response codes: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
	
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
	public ResponseEntity<Capybara> createOneCapybara(Capybara newCapybara) {	
		Capybara searchedPlayer = searchOneCapybaraById(newCapybara.getIdCapybara()).getBody();
		
		if (searchedPlayer == null) {
			if (newCapybara.isValidObject()) {
				try {
					newCapybara = capybaraRepository.save(newCapybara);
					return ResponseEntity.ok(newCapybara);
				} catch (Exception e) {		
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new Capybara());
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	//"/capybara/{idCapybara}/death"
	public ResponseEntity<CapybaraDeath> createOneCapybaraDeath(Long idCapybara, CapybaraDeath newCapybaraDeath) {		
		Capybara searchedCapybara = searchOneCapybaraById(idCapybara).getBody();		
		
		if (searchedCapybara != null) {			
			newCapybaraDeath.setCapybaraFK(searchedCapybara);
			
			CapybaraDeath searchedCapybaraDeath = searchOneCapybaraDeathById(idCapybara, newCapybaraDeath.getIdCapybaraDeath()).getBody();
			
			if (searchedCapybaraDeath == null) {
				if (newCapybaraDeath.isValidObject()) {					
					newCapybaraDeath = capybaraDeathRepository.save(newCapybaraDeath);
					return ResponseEntity.ok(newCapybaraDeath);
				}
				else{
					return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new CapybaraDeath());
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new CapybaraDeath());
			}			
		}
		else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	//"/capybara/{idCapybara}"
	public ResponseEntity<Capybara> updateOneCapybara(Long idCapybara, Capybara capybaraToBeUpdated) {		
		if (capybaraToBeUpdated.isValidObject()) {			
			Capybara searchedCapybara = searchOneCapybaraById(idCapybara).getBody();
			
			if (searchedCapybara != null) {
				try {
					capybaraToBeUpdated.setIdCapybara(idCapybara);
					capybaraToBeUpdated = capybaraRepository.save(capybaraToBeUpdated);
					return ResponseEntity.ok(capybaraToBeUpdated);
				} catch (Exception e) {	
				}
			}			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//"/capybara/{idCapybara}/hp/{hp}"
	public ResponseEntity<Capybara> updateOneCapybaraHp(Long idCapybara, Integer hp) {		
		Capybara searchedCapybara = searchOneCapybaraById(idCapybara).getBody();
			
		if (searchedCapybara != null) {
			try {
				searchedCapybara.setHp(hp);
				searchedCapybara = capybaraRepository.save(searchedCapybara);
				return ResponseEntity.ok(searchedCapybara);
			} catch (Exception e) {	
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//"/capybara/{idCapybara}/death/{idDeath}"
	public ResponseEntity<CapybaraDeath> updateOneCapybaraDeath(
			Long idCapybara,
			Long idDeath,
			CapybaraDeath capybaraDeathToBeUpdated) {
		
		CapybaraDeath searchedCapybaraDeath = searchOneCapybaraDeathById(idCapybara, idDeath).getBody();
		
		if (searchedCapybaraDeath != null) {
			capybaraDeathToBeUpdated.setIdCapybaraDeath(searchedCapybaraDeath.getIdCapybaraDeath());
			capybaraDeathToBeUpdated.setCapybaraFK(searchedCapybaraDeath.getCapybaraFK());			
		
			if (capybaraDeathToBeUpdated.isValidObject()) {
				try {
					capybaraDeathToBeUpdated = capybaraDeathRepository.save(capybaraDeathToBeUpdated);					
					return ResponseEntity.ok(capybaraDeathToBeUpdated);
				} catch (Exception e) {					
				}
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	//"/capybara/{idCapybara}"
	public ResponseEntity<Capybara> deleteOneCapybara(Long idCapybara) {
		Capybara searchedCapybara = searchOneCapybaraById(idCapybara).getBody();

		if (searchedCapybara != null) {
			try {
				capybaraRepository.deleteById(idCapybara);
				return ResponseEntity.ok(searchedCapybara);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//"/capybara/{idCapybara}/death/{idDeath}"
	public ResponseEntity<CapybaraDeath> deleteOneCapybaraDeath(Long idCapybara, Long idDeath) {		
		CapybaraDeath searchedCapybaraDeath = searchOneCapybaraDeathById(idCapybara, idDeath).getBody();

		if (searchedCapybaraDeath != null) {
			try {
				capybaraDeathRepository.deleteById(idDeath);
				return ResponseEntity.ok(searchedCapybaraDeath);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
