package br.com.capivarawars.database.repository;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.Capybara;
import br.com.capivarawars.database.model.CapybaraDeath;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 24/11/2019, 17:52:13
 * Last update: -
 */// </editor-fold>
public interface CapybaraDeathRepository extends JpaRepository<CapybaraDeath, Long>{

/**
 * TIPS:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
 */
	
	public CapybaraDeath findByCapybaraFKAndIdCapybaraDeath(Capybara capybaraFK, Long idCapybaraDeath);
	
	public List<CapybaraDeath> findAllByCapybaraFK(Capybara capybaraFK);
	
	public List<CapybaraDeath> findByDateForRiseLessThanEqualOrderByDateForRiseDesc(LocalDateTime currentDate); 
	
	public List<CapybaraDeath> findByCapybaraFKAndDateForRiseLessThanEqualOrderByDateForRiseDesc(Capybara capybaraFK, LocalDateTime currentDate); 
			
}//interface
