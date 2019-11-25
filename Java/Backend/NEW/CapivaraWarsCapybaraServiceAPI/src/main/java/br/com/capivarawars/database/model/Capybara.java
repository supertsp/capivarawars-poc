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
@Table(name = "CAPYBARA",
		indexes = {
			@Index(name = "INDEX_CAPYBARA_ID_PLAYER", columnList = "ID_PLAYER")
})
public class Capybara {
	
	// <editor-fold defaultstate="collapsed" desc="Database fields...">
	@Id
	@GeneratedValue
	@Column(name = "ID_CAPYBARA")
	private Long idCapybara;
	
	@Column(name = "NAME", length = VARCHAR_LENGTH_NAME, nullable = false)
	private String name;
	
	@Column(name = "BIRTHDAY", columnDefinition = "DATETIME")
	private LocalDateTime birthday;
	
	@Column(name = "HP")
	private Integer hp;
	
	@Column(name = "DEATHS")
	private Integer deaths;
	
	@Column(name = "ID_PLAYER")
	private Integer idPlayer;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Relationships fields...">	
	@ManyToOne
    @JoinColumn(name = "ID_COLOR")
	private Color color;
	
	@JsonIgnore
	@OneToMany(mappedBy = "capybaraFK", cascade = CascadeType.ALL)
	private List<CapybaraDeath> listOfCapybaraDeaths;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constants fields...">
	public static final int //
			VARCHAR_LENGTH_NAME = 45 //
			;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="methods...">

	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public Long getIdCapybara() {
		return idCapybara;
	}

	public Capybara setIdCapybara(Long idCapybara) {
		this.idCapybara = idCapybara;
		return this;
	}

	public String getName() {
		return name;
	}

	public Capybara setName(String name) {
		this.name = name;
		return this;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public Capybara setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
		return this;
	}

	public Integer getHp() {
		return hp;
	}

	public Capybara setHp(Integer hp) {
		this.hp = hp;
		return this;
	}

	public Integer getDeaths() {
		deaths = listOfCapybaraDeaths.size();
		return deaths;
	}

	public Capybara setDeaths(Integer deaths) {
		this.deaths = deaths;
		return this;
	}
		
	public Integer getIdPlayer() {
		return idPlayer;
	}

	public Capybara setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
		return this;
	}

	public Color getColor() {
		return color;
	}

	public Capybara setColor(Color color) {
		this.color = color;
		return this;
	}
	
	@JsonIgnore
	public List<CapybaraDeath> getListOfCapybaraDeaths() {
		return listOfCapybaraDeaths;
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="override methods...">
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + JsonHandler.toString(this);
	}
	// </editor-fold>    

	// <editor-fold defaultstate="collapsed" desc="main methods...">
	public Capybara addCapybaraDeath(CapybaraDeath newCapybaraDeath){
		listOfCapybaraDeaths.add(newCapybaraDeath);
		newCapybaraDeath.setCapybaraFK(this);
		return this;
	}
	
	public boolean updateCapybaraDeath(CapybaraDeath originalCapybaraDeath, CapybaraDeath capybaraToBeUpdatedDeath){
		int indexOfOriginal = listOfCapybaraDeaths.indexOf(originalCapybaraDeath);
		
		if (indexOfOriginal != -1) {
			listOfCapybaraDeaths.set(indexOfOriginal, capybaraToBeUpdatedDeath);
			capybaraToBeUpdatedDeath.setCapybaraFK(this);
			return true;
		}
		
		return false;
	}	
	
	public Capybara removeCapybaraDeath(CapybaraDeath capybaraBeRemoved){
		listOfCapybaraDeaths.remove(capybaraBeRemoved);
		return this;
	}
	
	@JsonIgnore
	public boolean isValidObject(){
		if (birthday == null) {
            birthday = LocalDateTime.now();
        }
		
		hp = hp == null ? 0 : hp;
		
        return color != null
                && name != null;
    }
	// </editor-fold>

	// </editor-fold>

}//class
