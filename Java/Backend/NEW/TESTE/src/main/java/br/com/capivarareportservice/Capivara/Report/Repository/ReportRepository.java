package br.com.capivarareportservice.Capivara.Report.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.bson.types.ObjectId;
import br.com.capivarareportservice.Capivara.Report.Models.Player;

public interface ReportRepository extends MongoRepository<Player, String>{
	Player findBy_id(ObjectId _id);
}

