package br.com.capivarawars.endpoint.handler;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
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

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 *///</editor-fold>
@RestController
@RequestMapping(API_AUTHENTICATION)
public class AuthenticationEndpoint {

	@Autowired
	private DataBaseAPIClient dataBaseAPIClient;

	//<editor-fold defaultstate="collapsed" desc="CREATE methods...">
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="UPDATE methods...">
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="DELETE methods...">
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="SEARCH methods...">
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="CHECK methods...">
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="AUTHENTICATION methods...">
	@PostMapping(API_AUTHENTICATION_LOGIN)
	public ResponseEntity<Jogador> login(@RequestHeader String nick, @RequestHeader String senha) {
		Jogador jogadorProcurado = null;
		jogadorProcurado = dataBaseAPIClient.updateOneOnline(jogadorProcurado.getIdJogador(), true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	//</editor-fold>

}//class
