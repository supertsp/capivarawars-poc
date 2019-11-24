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
public interface MatchPlayedRepository extends JpaRepository<MatchPlayed, Long>{
    
//    @Query("select j from Jogador j order by j.pontuacao desc")
//	public List<Jogador> findAllOrderByPontuacao();
	
	public MatchPlayed findByIdMatchAndPlayerFK(Long idMatch, Player playerFK);
	
	public List<MatchPlayed> findAllByPlayerFK(Player playerFK);
    
}//interface
