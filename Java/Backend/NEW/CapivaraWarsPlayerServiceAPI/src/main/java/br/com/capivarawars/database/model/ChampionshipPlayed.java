package br.com.capivarawars.database.model;

// <editor-fold defaultstate="collapsed" desc="imports...">
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.database.repository.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import br.com.capivarawars.security.Cryptography;
import br.com.capivarawars.tool.JsonHandler;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalTime;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00
 * Last update: -
 */// </editor-fold>
@Entity
@Table(name = "CHAMPIONSHIP_PLAYED",
		indexes = {
			@Index(name = "INDEX_CHAMPIONSHIP_PLAYED_ID_CHAMPIONSHIP", columnList = "ID_CHAMPIONSHIP"),
			@Index(name = "INDEX_CHAMPIONSHIP_PLAYED_ID_GAME_STATUS", columnList = "ID_GAME_STATUS"),
			@Index(name = "INDEX_CHAMPIONSHIP_PLAYED_ID_PRIZE_EARNED", columnList = "ID_PRIZE_EARNED")
})
public class ChampionshipPlayed {
	
	// <editor-fold defaultstate="collapsed" desc="Database fields...">
	@Id
	@GeneratedValue
	@Column(name = "ID_CHAMPIONSHIP_PLAYED")
	private Long idChampionshipPlayed;
	
	@Column(name = "ID_CHAMPIONSHIP")
	private Long idChampionship;
	
	@Column(name = "START", columnDefinition = "DATETIME")
	private LocalDateTime start;
	
	@Column(name = "END", columnDefinition = "DATETIME")
	private LocalDateTime end;
	
	@Column(name = "ID_GAME_STATUS")
	private Long idGameStatus;
	
	@Column(name = "ID_PRIZE_EARNED")
	private Long idPrizeEarned;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Relationships fields...">
	@ManyToOne
    @JoinColumn(name = "ID_PLAYER")
	private Player playerFK;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constants fields...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="methods...">

	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public Long getIdChampionshipPlayed() {
		return idChampionshipPlayed;
	}

	public ChampionshipPlayed setIdChampionshipPlayed(Long idChampionshipPlayed) {
		this.idChampionshipPlayed = idChampionshipPlayed;
		return this;
	}

	public Long getIdChampionship() {
		return idChampionship;
	}

	public ChampionshipPlayed setIdChampionship(Long idChampionship) {
		this.idChampionship = idChampionship;
		return this;
	}
	
	public LocalDateTime getStart() {
		return start;
	}
		
	public ChampionshipPlayed setStart(LocalDateTime start) {
		this.start = start;
		return this;
	}
	
	public LocalDateTime getEnd() {
		return end;
	}

	public ChampionshipPlayed setEnd(LocalDateTime end) {
		this.end = end;
		return this;
	}

	public Long getIdGameStatus() {
		return idGameStatus;
	}

	public ChampionshipPlayed setIdGameStatus(Long idGameStatus) {
		this.idGameStatus = idGameStatus;
		return this;
	}
	
	public Long getIdPrizeEarned() {
		return idPrizeEarned;
	}

	public ChampionshipPlayed setIdPrizeEarned(Long idPrizeEarned) {
		this.idPrizeEarned = idPrizeEarned;
		return this;
	}
	
	@JsonIgnore
	public Player getPlayerFK() {
		return playerFK;
	}
	
	@JsonIgnore
	public ChampionshipPlayed setPlayerFK(Player playerFK) {
		this.playerFK = playerFK;
		return this;
	}
	
	public Long getIdPlayer(){
		if (playerFK != null) {
			return playerFK.getIdPlayer();
		}
		
		return null;
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
	public boolean isValidObject() {
        return playerFK != null
                && idChampionship != null
                && idGameStatus != null;
    }
	// </editor-fold>

	// </editor-fold>
	
}//class
