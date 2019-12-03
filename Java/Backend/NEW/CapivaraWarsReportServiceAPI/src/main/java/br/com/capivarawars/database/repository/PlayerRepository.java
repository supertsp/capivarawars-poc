package br.com.capivarawars.database.repository;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.*;
import feign.RequestLine;
import java.util.List;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.*;
//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author joshua, 06/11/2019, 19:46:38
 * Last update: -
 *///</editor-fold>
public interface PlayerRepository extends MongoRepository<Player, ObjectId>{
    
	@RequestLine("GET/players")
    public List<Player> findBy_id(ObjectId _id);
      
    //</editor-fold>
    
}//interface
