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
import org.springframework.beans.factory.annotation.Autowired;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 */// </editor-fold>
@Entity
@Table(name = "MATCH_PLAYED",
		indexes = {
			@Index(name = "INDEX_MATCH_PLAYED_ID_MATCH", columnList = "ID_MATCH"),
			@Index(name = "INDEX_MATCH_PLAYED_ID_GAME_STATUS", columnList = "ID_GAME_STATUS"),
			@Index(name = "INDEX_MATCH_PLAYED_ID_PRIZE_EARNED", columnList = "ID_PRIZE_EARNED")
})
public class MatchPlayed {

	// <editor-fold defaultstate="collapsed" desc="Database fields...">
	@Id
	@GeneratedValue
	@Column(name = "ID_MATCH_PLAYED")
	private Long idMatchPlayed;
	
	@Column(name = "ID_MATCH")
	private Long idMatch;

	@Column(name = "ID_GAME_STATUS")
	private Long idGameStatus;
	
	@Column(name = "ID_PRIZE_EARNED")
	private Long idPrizeEarned;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Relationships fields...">
	@JsonIgnore
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
	public Long getIdMatchPlayed() {
		return idMatchPlayed;
	}

	public MatchPlayed setIdMatchPlayed(Long idMatchPlayed) {
		this.idMatchPlayed = idMatchPlayed;
		return this;
	}
	
	public Long getIdMatch() {
		return idMatch;
	}

	public MatchPlayed setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
		return this;
	}

	public Long getIdGameStatus() {
		return idGameStatus;
	}

	public MatchPlayed setIdGameStatus(Long idGameStatus) {
		this.idGameStatus = idGameStatus;
		return this;
	}

	public Long getIdPrizeEarned() {
		return idPrizeEarned;
	}

	public MatchPlayed setIdPrizeEarned(Long idPrizeEarned) {
		this.idPrizeEarned = idPrizeEarned;
		return this;
	}
		
	@JsonIgnore
	public Player getPlayerFK() {
		return playerFK;
	}

	@JsonIgnore
	public MatchPlayed setPlayerFK(Player playerFK) {
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
	public boolean isValidObject(){
        return playerFK != null
                && idMatch != null;
    }
	// </editor-fold>

	// </editor-fold>
		
}//class
