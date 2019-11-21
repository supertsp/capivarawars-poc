package br.com.capivarawars.security;

// <editor-fold defaultstate="collapsed" desc="imports...">
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
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
public class Criptografia {

	// <editor-fold defaultstate="collapsed" desc="attributes...">
	// <editor-fold defaultstate="collapsed" desc="main attributes...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constants attributes...">
	public static final String STRING_CONVERSION_ERROR = "~~E4404~~";

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static attributes...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
	// </editor-fold>
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constructors...">
	// </editor-fold>
	// <editor-fold desc="methods...">
	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="override methods...">
	// </editor-fold>    
	// <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
	// </editor-fold>
	// <editor-fold desc="static methods...">
	public static String getSHA256(String texto) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(hash);
		} catch (Exception e) {
			return STRING_CONVERSION_ERROR;
		}
	}
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="main methods...">
	// </editor-fold>
	// </editor-fold>

}//class
