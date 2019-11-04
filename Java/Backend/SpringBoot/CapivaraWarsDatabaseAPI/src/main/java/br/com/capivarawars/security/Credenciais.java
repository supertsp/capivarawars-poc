package br.com.capivarawars.security;

//<editor-fold defaultstate="collapsed" desc="imports...">
import com.fasterxml.jackson.annotation.JsonProperty;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import java.util.ArrayList;
import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Embeddable;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 23/10/2019, 17:47:32
 * Last update: -
 *///</editor-fold>
@Embeddable
public class Credenciais {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @JsonProperty
    @Column(name = "NICK", length = VARCHAR_LENGTH_NICK)
    private String nick;
    
    @Column(name = "PASSWORD", length = VARCHAR_LENGTH_PASSWORD)
    private String password;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int
            VARCHAR_LENGTH_NICK = 45,
            VARCHAR_LENGTH_PASSWORD = 45;
    
    public static final String STRING_CONVERSION_ERROR = "~~E4404~~";
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public Credenciais() {
        super();
    }
    
    public Credenciais(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        nick = nick.trim();
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password.trim();
        this.password = criptografar(password);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    public String criptografar(String texto){
         try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            return STRING_CONVERSION_ERROR;
        }
    }
    //</editor-fold>
    
    //</editor-fold>
        
}//class
