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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
	
	// <editor-fold defaultstate="collapsed" desc="Database fields...">
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
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd hh:mm:ss")
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
	
	//REMOVE IN FUTURE
	@Column(name = "CAPYBARA_NAME", length = 45)
	private String capybaraName;
	
	@Column(name = "CAPYBARA_COLOR", length = 9)
	private String capybaraColor;
	
	@Column(name = "CAPYBARA_LIFE")
	private Integer capybaraLife;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Relationships fields...">
	@JsonIgnore
	@OneToMany(mappedBy = "playerFK", cascade = CascadeType.ALL)
	private List<MatchPlayed> listOfMatchesPlayed;

	@JsonIgnore
	@OneToMany(mappedBy = "playerFK", cascade = CascadeType.ALL)
	private List<ChampionshipPlayed> listOfChampionshipsPlayed;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constants fields...">
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

	// <editor-fold defaultstate="collapsed" desc="auxiliary fields...">
	private static Player playerError = new Player();
	
	@JsonIgnore
	private String passwordNoCrypt;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="methods...">

	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	public Long getIdPlayer() {
		return idPlayer;
	}

	public Player setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
		return this;
	}

	public String getNick() {
		return nick;
	}

	public Player setNick(String nick) {
		this.nick = nick;
		return this;
	}
		
	public String getPassword() {
		return password;
	}

	public Player setPassword(String password) {
		if (password != null) {
			password = password.trim();
			this.passwordNoCrypt = password;
			this.password = Cryptography.getSHA256(password);
		} else {
			this.password = "";
		}

		return this;
	}

	public String getEmail() {
		return email;
	}

	public Player setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public LocalDateTime getAccountBirthday() {
		return accountBirthday;
	}
		
	public Player setAccountBirthday(LocalDateTime accountBirthday) {
		this.accountBirthday = accountBirthday;
		return this;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public Player setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public Player setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
		
	public Character getGender() {
        return gender;
    }

    public Player setGender(Character gender) {
        gender = gender == null ? ' ' : gender;
		
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public Player setBirthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}
	
	public Boolean isOnline() {
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

	public String getLastActivationCode() {
		return lastActivationCode;
	}

	public Player setLastActivationCode(String lastActivationCode) {
		this.lastActivationCode = lastActivationCode;
		return this;
	}

	public Integer getCoins() {
		return coins;
	}

	public Player setCoins(Integer coins) {
		this.coins = coins;
		return this;
	}

	public Integer getScore() {
		return score;
	}

	public Player setScore(Integer score) {
		this.score = score;
		return this;
	}

	public Integer getWins() {
		return wins;
	}

	public Player setWins(Integer wins) {
		this.wins = wins;
		return this;
	}

	public Integer getLosses() {
		return losses;
	}

	public Player setLosses(Integer losses) {
		this.losses = losses;
		return this;
	}

	public Integer getDraws() {
		return draws;
	}

	public Player setDraws(Integer draws) {
		this.draws = draws;
		return this;
	}

	public Integer getAccurateShots() {
		return accurateShots;
	}

	public Player setAccurateShots(Integer accurateShots) {
		this.accurateShots = accurateShots;
		return this;
	}

	public Integer getBadShots() {
		return badShots;
	}

	public Player setBadShots(Integer badShots) {
		this.badShots = badShots;
		return this;
	}

	public Integer getShotsReceived() {
		return shotsReceived;
	}

	public Player setShotsReceived(Integer shotsReceived) {
		this.shotsReceived = shotsReceived;
		return this;
	}

	public Integer getMovements() {
		return movements;
	}

	public Player setMovements(Integer movements) {
		this.movements = movements;
		return this;
	}

	public Integer getMatchesPlayed() {
		if (listOfMatchesPlayed != null) {
			matchesPlayed = listOfMatchesPlayed.size();
		}
		
		return matchesPlayed;
	}

	public Player setMatchesPlayed(Integer matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
		return this;
	}

	public Integer getChampionshipsPlayed() {
		if (listOfChampionshipsPlayed != null) {
			championshipsPlayed = listOfChampionshipsPlayed.size();
		}
		
		return championshipsPlayed;
	}

	public Player setChampionshipsPlayed(Integer championshipsPlayed) {
		this.championshipsPlayed = championshipsPlayed;
		return this;
	}

	public Integer getPrizesEarned() {
		int contPrizes = 0;
		
		if (listOfMatchesPlayed != null) {
			for (MatchPlayed matchPlayed : listOfMatchesPlayed) {
				if (matchPlayed.getIdPrizeEarned() != null) {
					contPrizes++;
				}
			}
		}
		
		if (listOfChampionshipsPlayed != null) {
			for (ChampionshipPlayed championshipPlayed : listOfChampionshipsPlayed) {
				if (championshipPlayed.getIdPrizeEarned() != null) {
					contPrizes++;
				}
			}
		}
		
		this.prizesEarned = contPrizes;
		
		return prizesEarned;
	}

	public Player setPrizesEarned(Integer prizesEarned) {
		this.prizesEarned = prizesEarned;
		return this;
	}
	
	@JsonIgnore
//	@JsonProperty
	public List<MatchPlayed> getListOfMatchesPlayed(){
		return listOfMatchesPlayed;
	}
		
	@JsonIgnore
//	@JsonProperty
	public List<ChampionshipPlayed> getListOfChampionshipsPlayed(){
		return listOfChampionshipsPlayed;
	}
	
	
	//REMOVE IN FUTURE
	public String getCapybaraName() {
		return capybaraName;
	}

	public Player setCapybaraName(String capybaraName) {
		this.capybaraName = capybaraName;
		return this;
	}

	public String getCapybaraColor() {
		if (capybaraColor == null) {
			capybaraColor = "brown";
		}
		return capybaraColor;
	}

	public Player setCapybaraColor(String capybaraColor) {
		this.capybaraColor = capybaraColor;
		return this;
	}

	public Integer getCapybaraLife() {
		if (capybaraLife == null) {
			capybaraLife = 7;
		}
		return capybaraLife;
	}

	public void setCapybaraLife(Integer capybaraLife) {
		if (capybaraLife >= 0 && capybaraLife <= 7) {
			this.capybaraLife = capybaraLife;
		}
	}
	
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="override methods...">
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + JsonHandler.toString(this);
	}
	// </editor-fold>    
	
	// <editor-fold defaultstate="collapsed" desc="static methods...">
	public static Player getInstanceForError(){
		//reseting the Player
		playerError.idPlayer = null;
		playerError.nick = null;
		playerError.password = null;
		playerError.email = null;
		playerError.accountBirthday = null;
		playerError.avatarUrl = null;
		playerError.fullName = null;
		playerError.gender = null;
		playerError.birthday = null;
		playerError.online = null;
		playerError.lastActivationCode = null;
		playerError.coins = null;
		playerError.score = null;
		playerError.wins = null;
		playerError.losses = null;
		playerError.draws = null;
		playerError.accurateShots = null;
		playerError.badShots = null;
		playerError.shotsReceived = null;
		playerError.movements = null;
		playerError.matchesPlayed = null;
		playerError.championshipsPlayed = null;
		playerError.prizesEarned = null;
		return playerError;
	}
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="main methods...">
	public Player addMatchPlayed(MatchPlayed newMatchPlayed){
		listOfMatchesPlayed.add(newMatchPlayed);
		newMatchPlayed.setPlayerFK(this);
		matchesPlayed = listOfMatchesPlayed.size();
		return this;
	}
	
	public Player addChampionshipPlayed(ChampionshipPlayed newChampionshipPlayed){
		listOfChampionshipsPlayed.add(newChampionshipPlayed);
		newChampionshipPlayed.setPlayerFK(this);
		championshipsPlayed = listOfChampionshipsPlayed.size();
		return this;
	}
		
	public boolean updateMatchPlayed(MatchPlayed originalMatch, MatchPlayed matchToBeUpdated){
		int indexOfOriginal = listOfMatchesPlayed.indexOf(originalMatch);
		
		if (indexOfOriginal != -1) {
			listOfMatchesPlayed.set(indexOfOriginal, matchToBeUpdated);
			matchToBeUpdated.setPlayerFK(this);
			return true;
		}
		
		return false;
	}	
	
	public boolean updateChampionshipPlayed(ChampionshipPlayed originalChampionshipPlayed, ChampionshipPlayed championshipToBeUpdated){
		int indexOfOriginal = listOfChampionshipsPlayed.indexOf(originalChampionshipPlayed);
		
		if (indexOfOriginal != -1) {
			listOfChampionshipsPlayed.set(indexOfOriginal, championshipToBeUpdated);
			championshipToBeUpdated.setPlayerFK(this);
			return true;
		}
		
		return false;
	}	
		
	public Player removeMatchPlayed(MatchPlayed matchToBeRemoved){
		listOfMatchesPlayed.remove(matchToBeRemoved);
		matchesPlayed = listOfMatchesPlayed.size();
		return this;
	}
	
	public Player removeChampionshipPlayed(ChampionshipPlayed championshipToBeRemoved){
		listOfChampionshipsPlayed.remove(championshipToBeRemoved);
		championshipsPlayed = listOfChampionshipsPlayed.size();
		return this;
	}
	
	@JsonIgnore
	public boolean isValidObject() {
        if (accountBirthday == null) {
            accountBirthday = LocalDateTime.now();
        }
		
		online = online == null ? false : online;
		
		coins = coins == null ? 0 : coins;
		score = score == null ? 0 : score;
		wins = wins == null ? 0 : wins;
		losses = losses == null ? 0 : losses;
		draws = draws == null ? 0 : draws;
		accurateShots = accurateShots == null ? 0 : accurateShots;
		badShots = badShots == null ? 0 : badShots;
		shotsReceived = shotsReceived == null ? 0 : shotsReceived;
		movements = movements == null ? 0 : movements;
		matchesPlayed = matchesPlayed == null ? 0 : matchesPlayed;
		championshipsPlayed = championshipsPlayed == null ? 0 : championshipsPlayed;
		prizesEarned = prizesEarned == null ? 0 : prizesEarned;
		
        return nick != null
                && password != null
                && email != null
                && fullName != null
                && gender != null
                && birthday != null;
    }
	
	public void patchFields(Player playerToBeCopiedFields){
//		setIdPlayer(playerToBeCopiedFields.getIdPlayer()!= null ? playerToBeCopiedFields.getIdPlayer(): this.idPlayer);
		setNick(playerToBeCopiedFields.getNick() != null ? playerToBeCopiedFields.getNick() : this.nick);
		
		if(playerToBeCopiedFields.getPassword() != null){
			setPassword(playerToBeCopiedFields.passwordNoCrypt);
		}
		
		setEmail(playerToBeCopiedFields.getEmail() != null ? playerToBeCopiedFields.getEmail() : this.email);
		setAccountBirthday(playerToBeCopiedFields.getAccountBirthday() != null ? playerToBeCopiedFields.getAccountBirthday() : this.accountBirthday);
		setAvatarUrl(playerToBeCopiedFields.getAvatarUrl() != null ? playerToBeCopiedFields.getAvatarUrl() : this.avatarUrl);
		setFullName(playerToBeCopiedFields.getFullName() != null ? playerToBeCopiedFields.getFullName() : this.fullName);
		setGender(playerToBeCopiedFields.getGender() != null ? playerToBeCopiedFields.getGender() : this.gender);
		setBirthday(playerToBeCopiedFields.getBirthday() != null ? playerToBeCopiedFields.getBirthday() : this.birthday);
		setOnline(playerToBeCopiedFields.isOnline() != null ? playerToBeCopiedFields.isOnline() : this.online);
		setLastActivationCode(playerToBeCopiedFields.getLastActivationCode() != null ? playerToBeCopiedFields.getLastActivationCode() : this.lastActivationCode);
		setCoins(playerToBeCopiedFields.getCoins() != null ? playerToBeCopiedFields.getCoins() : this.coins);
		setScore(playerToBeCopiedFields.getScore() != null ? playerToBeCopiedFields.getScore() : this.score);
		setWins(playerToBeCopiedFields.getWins() != null ? playerToBeCopiedFields.getWins() : this.wins);
		setLosses(playerToBeCopiedFields.getLosses() != null ? playerToBeCopiedFields.getLosses() : this.losses);
		setDraws(playerToBeCopiedFields.getDraws() != null ? playerToBeCopiedFields.getDraws() : this.draws);
		setAccurateShots(playerToBeCopiedFields.getAccurateShots() != null ? playerToBeCopiedFields.getAccurateShots() : this.accurateShots);
		setBadShots(playerToBeCopiedFields.getBadShots() != null ? playerToBeCopiedFields.getBadShots() : this.badShots);
		setShotsReceived(playerToBeCopiedFields.getShotsReceived() != null ? playerToBeCopiedFields.getShotsReceived() : this.shotsReceived);
		setMovements(playerToBeCopiedFields.getMovements() != null ? playerToBeCopiedFields.getMovements() : this.movements);
	}

	// </editor-fold>

	// </editor-fold>	

}//class
