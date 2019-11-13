package br.com.capivarawars.endpoints.handler;

//<editor-fold defaultstate="collapsed" desc="imports...">
import java.util.List;
import java.util.ArrayList;
import br.com.capivarawars.database.model.*;
import br.com.capivarawars.database.repository.*;
import static br.com.capivarawars.endpoints.EndpointsMapping.*;
import br.com.capivarawars.security.Cripotografia;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 09/11/2019, 22:21:29 Last update: -
 *///</editor-fold>
@RestController
@RequestMapping(API_JOGADOR)
public class JogadorEndpoint {

	//<editor-fold defaultstate="collapsed" desc="attributes...">
	@Autowired
	private JogadorRepository jogadorRepository;
	//</editor-fold>
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="constructors...">
	//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="methods...">
	
	/**
	 * CREATE
	 * 	
	 */
	
//	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(API_GENERAL_CREATE)
	public ResponseEntity<Jogador> create(@RequestBody Jogador novoJogador) {
		if (novoJogador.preencheuCamposObrigatorios()) {

			if (!jogadorRepository.existsByNick(novoJogador.getNick())
					&& !jogadorRepository.existsByEmail(novoJogador.getEmail())) {
				jogadorRepository.save(novoJogador);

				return ResponseEntity.ok(novoJogador);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new Jogador());
			}

		}

		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(novoJogador);
	}
	
	
	/**
	 * SEARCH
	 * 	
	 */
	
	@GetMapping(API_GENERAL_SEARCH)
	public ResponseEntity<List<Jogador>> searchAll() {
		return ResponseEntity.ok(jogadorRepository.findAll());
	}
	
	@GetMapping(API_JOGADOR_SEARCH_BY_ONLINE)
	public ResponseEntity<List<Jogador>> searchAllByOnline(@PathVariable("online") Boolean online) {
		List<Jogador> jogadoresProcurados = jogadorRepository.findAllByOnlineOrderByPontuacaoDesc(online);

		if (jogadoresProcurados != null) {
			return ResponseEntity.ok(jogadoresProcurados);
		}

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(API_JOGADOR_SEARCH_BY_PONTUACAO)
	public ResponseEntity<List<Jogador>> searchAllByPontuacao() {
		List<Jogador> jogadoresProcurados = jogadorRepository.findAllOrderByPontuacao();

		if (jogadoresProcurados != null) {
			return ResponseEntity.ok(jogadoresProcurados);
		}

		return ResponseEntity.noContent().build();
	}	
	
	@GetMapping(API_JOGADOR_SEARCH_BY_ID)
	public ResponseEntity<Jogador> searchOneById(@PathVariable("id") Long id) {
		try {
			Jogador jogadorProcurado = jogadorRepository.findById(id).get();
			return ResponseEntity.ok(jogadorProcurado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

	@GetMapping(API_JOGADOR_SEARCH_BY_NICK)
	public ResponseEntity<Jogador> searchOneByNick(@PathVariable("nick") String nick) {
		Jogador jogadorProcurado = jogadorRepository.getByNick(nick);

		if (jogadorProcurado != null) {
			return ResponseEntity.ok(jogadorProcurado);
		}

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(API_JOGADOR_SEARCH_BY_EMAIL)
	public ResponseEntity<Jogador> searchOneByEmail(@PathVariable("email") String email) {
		Jogador jogadorProcurado = jogadorRepository.getByEmail(email);

		if (jogadorProcurado != null) {
			return ResponseEntity.ok(jogadorProcurado);
		}

		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * UPDATE
	 * 	
	 */
	
	@Transactional
	@PutMapping(API_JOGADOR_UPDATE_BY_ID)
	public ResponseEntity<Boolean> updateOneById(@PathVariable("id") Long id, @RequestBody Jogador atualizacaoJogador) {
		Jogador jogadorTemp = searchOneById(id).getBody();
		
		if (jogadorTemp != null) {
			
			if (atualizacaoJogador.getNick() != null) {
				jogadorTemp.setNick(atualizacaoJogador.getNick());
			}
			
			if (atualizacaoJogador.getSenha() != null) {
				jogadorTemp.setSenhaSemSHA256(atualizacaoJogador.getSenha());
			}
			
			if (atualizacaoJogador.getDataHoraCriacaoConta()!= null) {
				jogadorTemp.setDataHoraCriacaoConta(atualizacaoJogador.getDataHoraCriacaoConta());
			}
			
			if (atualizacaoJogador.getUrlFoto()!= null) {
				jogadorTemp.setUrlFoto(atualizacaoJogador.getUrlFoto());
			}
			
			
			return ResponseEntity.ok(true);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
	}
	
	
	/**
	 * DELETE
	 * 	
	 */
	
	@DeleteMapping(API_JOGADOR_DELETE_BY_ID)
	public ResponseEntity<Boolean> deleteOneById(@PathVariable("id") Long id) {
		try {
			jogadorRepository.deleteById(id);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
		}
	}
	
	@Transactional
	@DeleteMapping(API_JOGADOR_DELETE_BY_NICK)
	public ResponseEntity<Boolean> deleteOneByNick(@PathVariable("nick") String nick) {
		Jogador jogadorTemp = searchOneByNick(nick).getBody();
		
		if (jogadorTemp != null) {
			jogadorRepository.deleteByNick(nick);
			return ResponseEntity.ok(true);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
	}
	
	@Transactional
	@DeleteMapping(API_JOGADOR_DELETE_BY_EMAIL)
	public ResponseEntity<Boolean> deleteOneByEmail(@PathVariable("email") String email) {
		Jogador jogadorTemp = searchOneByEmail(email).getBody();
		
		if (jogadorTemp != null) {
			jogadorRepository.deleteByEmail(email);
			return ResponseEntity.ok(true);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
	}
	
	
	/**
	 * EXISTS
	 * 	
	 */
	
	@GetMapping(API_JOGADOR_EXISTS_BY_NICK)
	public ResponseEntity<Boolean> existsByNick(@PathVariable("nick") String nick) {
		if (jogadorRepository.existsByNick(nick)) {
			return ResponseEntity.ok(true);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
	}

	@GetMapping(API_JOGADOR_EXISTS_BY_CREDENTIALS)
	public ResponseEntity<Boolean> existsByNickAndSenha(@RequestHeader String nick, @RequestHeader String senha) {
		senha = Cripotografia.getSHA256(senha);
		if (jogadorRepository.existsByNickAndSenha(nick, senha)) {
			return ResponseEntity.ok(true);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
	}
	
	@GetMapping(API_JOGADOR_EXISTS_BY_EMAIL)
	public ResponseEntity<Boolean> existsByEmail(@PathVariable("email") String email) {
		if (jogadorRepository.existsByEmail(email)) {
			return ResponseEntity.ok(true);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
	}	
	//</editor-fold>

}//class