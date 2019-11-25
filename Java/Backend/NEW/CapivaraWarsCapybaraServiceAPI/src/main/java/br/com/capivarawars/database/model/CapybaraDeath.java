package br.com.capivarawars.database.model;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.tool.JsonHandler;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 24/11/2019, 16:55:09
 * Last update: -
 */// </editor-fold>
@Entity
@Table(name = "CAPYBARA_DEATH")
public class CapybaraDeath {
	
	// <editor-fold defaultstate="collapsed" desc="Database fields...">
	@Id
	@GeneratedValue
	@Column(name = "ID_CAPYBARA_DEATH")
	private Long idCapybaraDeath;
	
	@Column(name = "DATE_OF_DEATH", columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime dateOfDeath;
	
	@Column(name = "DATE_FOR_RISE", columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime dateForRise;
	
	@Column(name = "DATE_OF_RISE", columnDefinition = "DATETIME")
	private LocalDateTime dateOfRise;	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Relationships fields...">	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "ID_CAPYBARA")
	private Capybara capybaraFK;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constants fields...">
	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="methods...">

	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public Long getIdCapybaraDeath() {
		return idCapybaraDeath;
	}

	public void setIdCapybaraDeath(Long idCapybaraDeath) {
		this.idCapybaraDeath = idCapybaraDeath;
	}

	public LocalDateTime getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(LocalDateTime dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public LocalDateTime getDateForRise() {
		return dateForRise;
	}

	public void setDateForRise(LocalDateTime dateForRise) {
		this.dateForRise = dateForRise;
	}

	public LocalDateTime getDateOfRise() {
		return dateOfRise;
	}

	public void setDateOfRise(LocalDateTime dateOfRise) {
		this.dateOfRise = dateOfRise;
	}
	
	@JsonIgnore
	public Capybara getCapybaraFK() {
		return capybaraFK;
	}

	public void setCapybaraFK(Capybara capybaraFK) {
		this.capybaraFK = capybaraFK;
	}
	
	public Long getIdCapybara(){
		return capybaraFK.getIdCapybara();
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="override methods...">
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + JsonHandler.toString(this);
	}
	// </editor-fold>    

	// <editor-fold defaultstate="collapsed" desc="main methods...">
	@JsonIgnore
	public boolean isValidObject(){
		if (dateOfDeath == null) {
            dateOfDeath = LocalDateTime.now();
        }
		
		if (dateForRise == null) {
            dateForRise = LocalDateTime.now().plusMinutes(30);
        }
				
        return capybaraFK != null;
    }
	// </editor-fold>

	// </editor-fold>

}//class
