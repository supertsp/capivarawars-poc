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
import com.fasterxml.jackson.annotation.*;
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
@Table(name = "PLAYER")
public class Player {

	// <editor-fold defaultstate="collapsed" desc="attributes...">
	// <editor-fold desc="DATABASE FIELDS..." defaultstate="collapsed">
	@Id
	@GeneratedValue
	@Column(name = "ID_PLAYER")
	private Long idPlayer;

	@Column(name = "NICK", length = VARCHAR_LENGTH_NICK, unique = true, nullable = false)
	private String nick;

	@Column(name = "PASSWORD", length = VARCHAR_LENGTH_PASSWORD)
	private String password;

	@Column(name = "EMAIL", length = VARCHAR_LENGTH_EMAIL, unique = true)
	private String email;

	@Column(name = "ACCOUNT_BIRTHDAY", columnDefinition = "DATETIME")
	private LocalDateTime accountBirthday;

	@Column(name = "AVATAR_URL", length = VARCHAR_LENGTH_AVATAR_URL)
	private String avatarUrl;

	@Column(name = "FULL_NAME", length = VARCHAR_LENGTH_FULL_NAME)
	private String fullName;

	@Column(name = "GENDER", length = CHAR_LENGTH_GENDER, columnDefinition = "CHAR")
	private Character gender;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE")
	private LocalDate birthday;

	@Column(name = "ONLINE")
	private Boolean online;

	@Column(name = "LAST_ACTIVATION_CODE", length = VARCHAR_LENGTH_LAST_ACTIVATION_CODE)
	private String lastActivationCode;

	@Column(name = "COINS")
	private Integer coins;

	@Column(name = "SCORE")
	private Integer score;

	@Column(name = "WINS")
	private Integer wins;

	@Column(name = "LOSSES")
	private Integer losses;

	@Column(name = "DRAWS")
	private Integer draws;

	@Column(name = "ACCURATE_SHOTS")
	private Integer accurateShots;

	@Column(name = "BAD_SHOTS")
	private Integer badShots;

	@Column(name = "SHOTS_RECEIVED")
	private Integer shotsReceived;

	@Column(name = "MOVEMENTS")
	private Integer movements;

	@Column(name = "MATCHES_PLAYED")
	private Integer matchesPlayed;

	@Column(name = "CHAMPIONSHIPS_PLAYED")
	private Integer championshipsPlayed;

	@Column(name = "PRIZES_EARNED")
	private Integer prizesEarned;
	// </editor-fold>	
	// <editor-fold desc="RELATIONSHIPS..." defaultstate="collapsed"> 
	@JsonIgnore
	@OneToMany(mappedBy = "playerFK")
	private List<MatchesPlayed> listOfMatchesPlayed;

	@JsonIgnore
	@OneToMany(mappedBy = "playerFK")
	private List<ChampionshipsPlayed> listOfChampionshipsPlayed;

	@JsonIgnore
	@OneToMany(mappedBy = "playerFK")
	private List<PrizesEarned> listOfPrizesEarned;
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constants attributes..."> 
	public static final int //
			VARCHAR_LENGTH_NICK = 45,
			VARCHAR_LENGTH_PASSWORD = 45,
			VARCHAR_LENGTH_EMAIL = 255,
			VARCHAR_LENGTH_AVATAR_URL = 255,
			VARCHAR_LENGTH_FULL_NAME = 100,
			CHAR_LENGTH_GENDER = 1,
			VARCHAR_LENGTH_LAST_ACTIVATION_CODE = 255 //
			;

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static attributes...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
	// </editor-fold>
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constructors...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="methods...">
	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public String getPassword() {
		return password;
	}

	public Player setPassword(String password) {
		if (password != null) {
			password = password.trim();
			this.password = Cryptography.getSHA256(password);
		} else {
			this.password = "";
		}

		return this;
	}
	
	public Character getGender() {
        return gender;
    }

    public Player setGender(Character gender) {
        switch (gender) {
            case 'M':
            case 'm':
                gender = 'M';
                break;

            case 'F':
            case 'f':
                gender = 'F';
                break;

            default:
                gender = 'M';
        }
        this.gender = gender;

        return this;
    }
	
	public Boolean getOnline() {
		return online;
	}

	public Player setOnline(Boolean online) {
		if (online == null) {
			this.online = false;
		} else {
			this.online = online;
		}

		return this;
	}
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="override methods...">	
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="main methods...">	
	// </editor-fold>
	// </editor-fold>

}//class
