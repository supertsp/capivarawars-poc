package br.com.capivarawars.endpoint.handler;

// <editor-fold defaultstate="collapsed" desc="imports...">
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
@RestController
@RequestMapping(API_PLAYER_SERVICE)
public class AuthenticationEndpoint {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private DataBaseAPIClient dataBaseAPIClient;

	// <editor-fold desc="CREATE methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="UPDATE methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="DELETE methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="SEARCH methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="CHECK methods..." defaultstate="collapsed">
	// </editor-fold>
	// <editor-fold desc="AUTHENTICATION methods..." defaultstate="collapsed">
	@PostMapping(API_PLAYER_SERVICE_LOGIN)
	public ResponseEntity<Jogador> login(@RequestHeader String nick, @RequestHeader String senha) {
		Jogador jogadorProcurado = new Jogador();
		jogadorProcurado.setIdJogador(1L);
		jogadorProcurado = dataBaseAPIClient.updateOneOnline(jogadorProcurado.getIdJogador(), true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	// </editor-fold>

}// class
