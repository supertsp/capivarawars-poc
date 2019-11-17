package br.com.capivarawarsmongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.capivarawarsmongo.models.Jogador;

//import ...
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
public interface CapivaraWarsMongoRepository extends MongoRepository<Jogador, ObjectId>{
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">
    Jogador findBy_id(ObjectId _id);
    
    
    //</editor-fold>
    
}//interface
