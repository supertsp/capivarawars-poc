package br.com.capivarawars.controller;

import br.com.capivarawars.ListaAcessos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.capivarawars.database.TodosJogadoresDAO;
import br.com.capivarawars.database.model.JogadorDAO;
import br.com.capivarawars.security.Credenciais;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AcessoController {

    private TodosJogadoresDAO todosJogadoresDAO;

    @Autowired
    public AcessoController(TodosJogadoresDAO todosJogadoresDAO) {
        this.todosJogadoresDAO = todosJogadoresDAO;
    }
        
    @PostMapping("/cadastrar")
    public ResponseEntity<JogadorDAO> cadastrarJogador(@RequestBody JogadorDAO jogador) {
        todosJogadoresDAO.save(jogador);
        return ResponseEntity.ok(jogador);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
        JogadorDAO procurado = todosJogadoresDAO.existe(credenciais);

        if (procurado == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    "Infelizmente esse usuário não existe... :(  Tente cadastrar um novo Jogador"
            );
        }
        
//        if (procurado.getCredenciais()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
//                    "Infelizmente sua senha está errada... :'(  Tente digitar novamente"
//            );
//        }

        if (procurado.isOnline()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    procurado.getCredenciais().getNick() + ", você já está online... 8)"
            );
        }
        procurado.setOnline(true);
        ListaAcessos.addNick(procurado.getCredenciais().getNick());
        return ResponseEntity.ok("Login Efetuado :)");
    }

    @PostMapping("/logout/{nick}")
    public ResponseEntity<String> validarLogout(@PathVariable("nick") String nick) {
        JogadorDAO procurado = todosJogadoresDAO.procurarPorNick(nick);

        if (procurado != null) {
            if (procurado.isOnline()) {
                procurado.setOnline(false);
                return ResponseEntity.ok("Logout Efetuado :)");
            } else {
                return ResponseEntity.ok("Esse usuário ainda não efetuou o login :O");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                "Infelizmente esse usuário não existe... :(  Tente cadastrar um novo Jogador"
        );
    }

}
