package br.com.capivarawars.security;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.Player;
import br.com.capivarawars.tool.JsonHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 23/11/2019, 21:54:38
 * Last update: -
 */// </editor-fold>
public class Credentials {
	
	// <editor-fold defaultstate="collapsed" desc="fields...">

	// <editor-fold defaultstate="collapsed" desc="main fields...">
	@JsonProperty
	private String nick;
	
	@JsonProperty
	private String password;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constants fields...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="static fields...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="auxiliary fields...">

	// </editor-fold>

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="constructors...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="methods...">

	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">	
	public String getNick() {
		return nick;
	}

	public Credentials setNick(String nick) {
		this.nick = nick;
		return this;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public Credentials setPassword(String password) {
		this.password = Cryptography.getSHA256(password);
		return this;
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="override methods...">
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + JsonHandler.toString(this);
	}
	// </editor-fold>    

	// <editor-fold defaultstate="collapsed" desc="auxiliary methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="static methods...">

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="main methods...">
	public Boolean validate(Player playerToBeCompared){
		return nick.equals(playerToBeCompared.getNick())
				&& password.equals(playerToBeCompared.getPassword());
				
	}
	// </editor-fold>

	// </editor-fold>

}//class
