package br.com.capivarawars.database.repository;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 07/11/2019, 21:49:30 Last update: -
 *///</editor-fold>
@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">
    /**
	 * CREATE
	 * 	
	 */
	
	
	
	/**
	 * SEARCH
	 * 	
	 */
	
	public Jogador getByNick(String nick);
	
    public Jogador getByEmail(String email);
	
    public List<Jogador> getByOnline(Boolean online);
	
	@Query("select j from Jogador j order by j.pontuacao desc")
	public List<Jogador> findAllOrderByPontuacao();
	
	/**
	 * EXISTS
	 * 	
	 */	
	
	public Boolean existsByNick(String nick);
	
    public Boolean existsByNickAndSenha(String nick, String senha);
	
	public Boolean existsByEmail(String email);
	
    
    //</editor-fold>
    
}//interface
