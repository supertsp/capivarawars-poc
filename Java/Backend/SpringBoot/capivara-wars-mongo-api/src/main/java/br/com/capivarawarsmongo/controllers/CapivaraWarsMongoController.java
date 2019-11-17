package br.com.capivarawarsmongo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
//</editor-fold>
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.capivarawarsmongo.models.Jogador;
import br.com.capivarawarsmongo.repositories.CapivaraWarsMongoRepository;

@RestController
@RequestMapping("/api")
public class CapivaraWarsMongoController {
    

    @Autowired
    private CapivaraWarsMongoRepository repository;

    @RequestMapping(value = "/jogadorMongo", method = RequestMethod.GET)
    public List<Jogador> getAll(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/jogadorMongo/{id}", method = RequestMethod.GET)
    public Jogador getById(@PathVariable("id") ObjectId idJogador){
        return repository.findBy_id(idJogador);
    }
    
    @RequestMapping(value = "/jogadorMongo/{id}", method = RequestMethod.PUT)
    public void modifyJogadorById(@PathVariable("id") ObjectId idJogador, @Valid @RequestBody Jogador jogador){
        jogador.setIdJogador(idJogador);
        repository.save(jogador);
    }
    
    @RequestMapping(value = "/jogadorMongo", method = RequestMethod.POST)
    public Jogador createAnimal(@Valid @RequestBody Jogador jogador){
//        jogador.setIdJogador(ObjectId.get()); //O Mongo cria automaticamente
        repository.save(jogador);
        return jogador;
    }
    
    @RequestMapping(value = "/jogadorMongo/{id}", method = RequestMethod.DELETE)
    public Jogador deleteById(@PathVariable("id") ObjectId idJogador){
        Jogador jogador = repository.findBy_id(idJogador);
        repository.deleteById(idJogador);
        return jogador;
    }       
}
