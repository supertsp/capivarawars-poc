package br.com.capivarawars.tool;

// <editor-fold defaultstate="collapsed" desc="imports...">
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
 * @author tiago, 20/11/2019, 14:48:01
 * Last update: -
 */// </editor-fold>
public class JsonHandler {
	
	private static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;
	
	public static String toString(Object objectForConversion){
		try {
			return objectMapper.writeValueAsString(objectForConversion);
		} catch (Exception ex) {
			return "";
		}
	}

}//class
