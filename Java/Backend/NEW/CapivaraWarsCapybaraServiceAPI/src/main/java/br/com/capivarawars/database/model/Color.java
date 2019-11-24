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
@Table(name = "COLOR")
public class Color {
	
	// <editor-fold defaultstate="collapsed" desc="Database fields...">
	@Id
	@GeneratedValue
	@Column(name = "ID_COLOR")
	private Long idColor;
	
	@Column(name = "NAME", length = VARCHAR_LENGTH_NAME, nullable = false)
	private String name;
	
	@Column(name = "RGBA", length = CHAR_LENGTH_RGBA, columnDefinition = "CHAR")
	private String rgba;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Relationships fields...">
	@JsonIgnore
	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
	private List<Capybara> listOfCapybaras;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constants fields...">
	public static final int //
			VARCHAR_LENGTH_NAME = 120,
			CHAR_LENGTH_RGBA = 9 //
			;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="methods...">

	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public Long getIdColor() {
		return idColor;
	}

	public Color setIdColor(Long idColor) {
		this.idColor = idColor;
		return this;
	}

	public String getName() {
		return name;
	}

	public Color setName(String name) {
		this.name = name;
		return this;
	}

	public String getRgba() {
		return rgba;
	}

	public Color setRgba(String rgba) {
		this.rgba = rgba;
		return this;
	}
	
	@JsonIgnore
//	@JsonProperty
	public List<Capybara> getListOfCapybaras() {
		return listOfCapybaras;
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="override methods...">
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + JsonHandler.toString(this);
	}
	// </editor-fold>    

	// <editor-fold defaultstate="collapsed" desc="main methods...">
	public Color addCapybara(Capybara newCapybara){
		listOfCapybaras.add(newCapybara);
		newCapybara.setColor(this);
		return this;
	}
	
	public boolean updateCapybara(Capybara originalCapybara, Capybara capybaraToBeUpdated){
		int indexOfOriginal = listOfCapybaras.indexOf(originalCapybara);
		
		if (indexOfOriginal != -1) {
			listOfCapybaras.set(indexOfOriginal, capybaraToBeUpdated);
			capybaraToBeUpdated.setColor(this);
			return true;
		}
		
		return false;
	}	
	
	public Color removeCapybara(Capybara capybaraBeRemoved){
		listOfCapybaras.remove(capybaraBeRemoved);
		return this;
	}
	
	@JsonIgnore
	public boolean isValidObject(){
        return name != null
                && rgba != null;
    }
	// </editor-fold>

	// </editor-fold>

}//class
