package br.com.capivarawars.database.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.capivarawars.security.Criptografia;

@Document(collection = "Player")
public class Player {
   
    @Id
    private ObjectId _id;
    
//    @Indexed(name = "NICK");
    private String nick;
    
//    @Indexed(name = "PASSWORD")
    private String password;
    
//  @Indexed(name = "ACCOUNT_BIRTHDAY_DATETIME")
    private LocalDateTime accountBirthdayDateTime;
    
//   @Indexed(name = "URL_PHOTO")
    private String urlPhoto;
    
//  @Indexed(name = "FULLNAME")
    private String fullName;
    
//    @Indexed(name = "EMAIL")
    private String email;
    
//    @Indexed(name = "GENDER")
    private Character gender;

//    @Indexed(name = "BIRTHDAY")
    private LocalDate birthday;

//    @Indexed(name = "ONLINE")
    private Boolean online;

//   @Indexed(name = "LAST_ACTIVATION_CODE")
    private String lastActivationCode;
	
//   @Indexed(name = "COINS")
    private Integer coins;
	
//   @Indexed(name = "SCORE")
    private Integer score;	
	
//   @Indexed(name = "WINS")
    private Integer wins;

//   @Indexed(name = "DRAWS")
    private Integer draws;

//   @Indexed(name = "LOSES")
    private Integer loses;

//   @Indexed(name = "ACCURATE_SHOTS")
    private Integer accurateShots;

//   @Indexed(name = "BAD_SHOTS")
    private Integer badShots;

//   @Indexed(name = "SHOTS_RECEIVED")
    private Integer shotsReceived;

//   @Indexed(name = "MOVEMENTS")
    private Integer movements;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int VARCHAR_LENGTH_NICK = 45,
            VARCHAR_LENGTH_PASSWORD = 45,
            VARCHAR_LENGTH_URL_PHOTO = 255,
            VARCHAR_LENGTH_FULL_NAME = 100,
            VARCHAR_LENGTH_EMAIL = 255,
            CHAR_LENGTH_GENDER = 1,
            VARCHAR_LENGTH_LAST_ACTIVATION_CODE = 255,
			
			PONTUACAO_PESO_WINS = 4,
			PONTUACAO_PESO_LOSES = 2,
			PONTUACAO_PESO_DRAWS = 1,
			PONTUACAO_PESO_ACCURATE_SHOTS = 3,
			PONTUACAO_PESO_BAD_SHOTS = 3,
			PONTUACAO_PESO_SHOTS_RECEIVED = 2,
			PONTUACAO_PESO_MOVEMENTS = 2
			;


    public String get_id() {
        return _id.toHexString();
    }
	@JsonIgnore
	public ObjectId getObjectId() {
        return _id;
    }
    public Player set_id(ObjectId _idPlayer){
        this._id = _idPlayer;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password.trim();
        this.password = Criptografia.getSHA256(password);
    }
    
    public void setPasswordSemSHA256(String password) {
        this.password = password;
    }
    
    public LocalDateTime getAccountBirthdayDatetime() {
        return accountBirthdayDateTime;
    }

    public Player setAccountBirthdayDateTime(LocalDateTime accountBirthdayDateTime) {
        if (accountBirthdayDateTime == null) {
            this.accountBirthdayDateTime = LocalDateTime.now();
        } else {
            this.accountBirthdayDateTime = accountBirthdayDateTime;
        }

        return this;
    }

    public String getUrlFoto() {
        return urlPhoto;
    }

    public Player setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Player setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Player setEmail(String email) {
        this.email = email;
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

    public LocalDate getBithday() {
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
        this.online = online;
        return this;
    }

    public String getLastActivationCode() {
        return lastActivationCode;
    }

    public Player setLastActiovationCode(String lastActivationCode) {
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

    public Integer getDraws() {
        return draws;
    }

    public Player setDraws(Integer draws) {
        this.draws = draws;
        return this;
    }

    public Integer getLosts() {
        return loses;
    }

    public Player setLosts(Integer losts) {
        this.loses = losts;
        return this;
    }    

    public Integer getAcurrateShots() {
        return accurateShots;
    }

    public Player setAcurrateShots(Integer accurateShots) {
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

	public Integer calcularPontucao(){
		int tempWins = getWins()* PONTUACAO_PESO_WINS;
		int tempDraws = getDraws()* PONTUACAO_PESO_DRAWS;
		int tempLoses = getDraws()* PONTUACAO_PESO_DRAWS;
		int tempAcurrateShots = getAcurrateShots()* PONTUACAO_PESO_ACCURATE_SHOTS;
		int tempBadShots = getBadShots()* PONTUACAO_PESO_BAD_SHOTS;
		int tempShotsReceived = getShotsReceived()*PONTUACAO_PESO_SHOTS_RECEIVED;
		int tempMovements = getMovements()/ PONTUACAO_PESO_MOVEMENTS;
		
		int tempGames = ((tempWins + tempDraws) - tempLoses) * 3;		
		System.out.println("\nPONTUAÇÃO (tempPartidas): " + tempGames + "\n");
		
		int tempShots = 0;
		
		try {
			tempShots = (tempAcurrateShots / Math.abs(tempBadShots - tempShotsReceived)) / 2;
		} catch (Exception e) {}				
		System.out.println("\nPONTUAÇÃO (tempTiros): " + tempShots + "\n");
		
		try {
			score = (tempGames + tempShots) / tempMovements;
		} catch (Exception e) {
			score = 0;
		}		
		System.out.println("\nPOINTS (tempMovements): " + tempMovements + "\n");
		System.out.println("\nPOINTS (tempGames + tempTiros): " + (tempShots + tempGames) + "\n");		
		System.out.println("\nPOINTS (final): " + score + "\n");
		
		return score;
	}
	
	public Player incrementMoedas(int incrementValue) {
        coins += incrementValue;
        return this;
    }
	
	public Player incrementPontuacao(int incrementValue) {
        score += incrementValue;
        return this;
    }
	
	public Player incrementVitorias(int incrementValue) {
		wins += incrementValue;
		return this;
	}

    public Player incrementEmpates(int incrementValue) {
        draws += incrementValue;
        return this;
    }

    public Player incrementDerrotas(int incrementValue) {
        loses += incrementValue;
        return this;
    }
	
    public Player incrementQtdTirosCerteiros(int incrementValue) {
        accurateShots += incrementValue;
        return this;
    }

    public Player incrementQtdTirosRuins(int incrementValue) {
        badShots += incrementValue;
        return this;
    }

    public Player incrementQtdTirosRecebidos(int incrementValue) {
        shotsReceived += incrementValue;
        return this;
    }

    public Player incrementQtdMovimentos(int incrementValue) {
        movements += incrementValue;
        return this;
    }
    
    public boolean preencheuCamposObrigatorios() {
        if (accountBirthdayDateTime == null) {
            this.accountBirthdayDateTime = LocalDateTime.now();
        }
		
		online = online == null ? false : online;
		
		coins = coins == null ? 0 : coins;
		score = score == null ? 0 : score;
		wins = wins == null ? 0 : wins;
		draws = draws == null ? 0 : draws;
		loses = loses == null ? 0 : loses;		
		accurateShots = accurateShots == null ? 0 : accurateShots;
		badShots = badShots == null ? 0 : badShots;
		shotsReceived = shotsReceived == null ? 0 : shotsReceived;
		movements = movements == null ? 0 : movements;
		
		calcularPontucao();
		
        return nick != null
                && password != null
                && urlPhoto != null
                && fullName != null
                && email != null
                && gender != null
                && birthday != null;
    }
	
		public boolean isValidObject() {
        if (accountBirthdayDateTime == null) {
            accountBirthdayDateTime = LocalDateTime.now();
        }
		
		online = online == null ? false : online;
		
		coins = coins == null ? 0 : coins;
		score = score == null ? 0 : score;
		wins = wins == null ? 0 : wins;
		loses = loses == null ? 0 : loses;
		draws = draws == null ? 0 : draws;
		accurateShots = accurateShots == null ? 0 : accurateShots;
		badShots = badShots == null ? 0 : badShots;
		shotsReceived = shotsReceived == null ? 0 : shotsReceived;
		movements = movements == null ? 0 : movements;
		
        return nick != null
                && password != null
                && email != null
                && fullName != null
                && gender != null
                && birthday != null;
    }
    //</editor-fold>
    //</editor-fold>

}//class