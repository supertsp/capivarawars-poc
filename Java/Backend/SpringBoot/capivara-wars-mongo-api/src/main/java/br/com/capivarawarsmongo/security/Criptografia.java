package br.com.capivarawarsmongo.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class Criptografia {

	 public static final String STRING_CONVERSION_ERROR = "~~E4404~~";
	
	 public static String getSHA256(String texto){
         try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            return STRING_CONVERSION_ERROR;
        }
    }
}
