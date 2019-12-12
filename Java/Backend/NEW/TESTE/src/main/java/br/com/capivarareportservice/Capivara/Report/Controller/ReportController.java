package br.com.capivarareportservice.Capivara.Report.Controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.capivarareportservice.Capivara.Report.Models.Player;
import br.com.capivarareportservice.Capivara.Report.Repository.ReportRepository;

@RestController
@RequestMapping("/report")
public class ReportController {
@Autowired
private ReportRepository repository;

@RequestMapping(value ="/",method = RequestMethod.GET)
public List<Player> getAllPlayers(){
	return repository.findAll();
}

@RequestMapping(value ="/",method = RequestMethod.GET)
public Player getAById(@PathVariable("id")ObjectId id){
	return repository.findBy_id(id);
}

@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
public void modifyPlayerById(@PathVariable("id") ObjectId id, @Valid @RequestBody Player player) {
	player.set_id(id);
	repository.save(player);
}


@RequestMapping(value = "/", method = RequestMethod.POST)
public Player createPlayer (@Valid @RequestBody Player player) {
	
	player.set_id(ObjectId.get());
	repository.save(player);
	return player;
}

@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
public void deletePlayer(@PathVariable ObjectId id) {
	repository.delete(repository.findBy_id(id));
}
}
