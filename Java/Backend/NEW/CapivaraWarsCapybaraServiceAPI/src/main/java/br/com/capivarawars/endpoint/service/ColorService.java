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
	//"/color"
	public ResponseEntity<Color> createOneColor(Color newColor) {		
		Color searchedColor = searchOneColorById(newColor.getIdColor()).getBody();
		
		if (searchedColor == null) {			
			if (newColor.isValidObject()) {	
				try {
					newColor = colorRepository.save(newColor);
					return ResponseEntity.ok(newColor);
				} catch (Exception e) {		
				}
			}
			else{
				return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(new Color());
			}			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	//"/color/{idColor}"
	public ResponseEntity<Color> updateOneColor(Long idColor, Color colorToBeUpdated) {		
		if (colorToBeUpdated.isValidObject()) {			
			Color searchedColor = searchOneColorById(idColor).getBody();
			
			if (searchedColor != null) {
				try {
					colorToBeUpdated.setIdColor(idColor);
					colorToBeUpdated = colorRepository.save(colorToBeUpdated);
					return ResponseEntity.ok(colorToBeUpdated);
				} catch (Exception e) {	
				}
			}			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DELETE methods...">
	//"/color/{idColor}"
	public ResponseEntity<Color> deleteOneColor(Long idColor) {
		Color searchedColor = searchOneColorById(idColor).getBody();

		if (searchedColor != null) {
			try {
				colorRepository.deleteById(idColor);
				return ResponseEntity.ok(searchedColor);
			} catch (Exception e) {
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	//"/color/{idColor}"
	public ResponseEntity<Color> searchOneColorById(Long idColor){
		Color searchedColor = null;
		
		try {
			searchedColor = colorRepository.findById(idColor).get();
			return ResponseEntity.ok(searchedColor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	//"/colors"
	public ResponseEntity<List<Color>> searchAllColors(){
		List<Color> searchedColor = colorRepository.findAll();
		
		if (searchedColor != null) {
			return ResponseEntity.ok(searchedColor);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="CHECK methods...">

	// </editor-fold>

}//class
