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
 * @author tiago, 06/11/2019, 19:46:38
 * Last update: -
 *///</editor-fold>
public interface PlayerRepository extends JpaRepository<Player, Long>{
    
	public Player findByNick(String nick);
	
	public Player findByEmail(String email);
	
	@Query("SELECT p FROM Player p ORDER BY p.score desc")
	public List<Player> findAllOrderByScoreDesc();
	
	public List<Player> findAllByOnlineOrderByScoreDesc(Boolean online);
    
}//interface
