package br.com.capivarawars.database;

import java.util.ArrayList;
import java.util.List;

import br.com.capivarawars.database.model.JogadorDAO;
import br.com.capivarawars.security.Credenciais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosJogadoresDAO extends JpaRepository<JogadorDAO, Long>{
    
    @Query("select j from JogadorDAO j where j.credenciais = :credenciais")
    public JogadorDAO existe(@Param("credenciais") Credenciais credenciais);
    
    @Query("select j from JogadorDAO j where j.credenciais.nick = :nick")
    public JogadorDAO procurarPorNick(@Param("nick") String nick);
    
    

}
