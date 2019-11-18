package br.com.capivarawars.endpoint.service;

//<editor-fold defaultstate="collapsed" desc="imports...">

import br.com.capivarawars.model.Jogador;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestHeader;

//import ...
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 14/11/2019, 09:51:15
 * Last update: -
 *///</editor-fold>
public interface DataBaseAPIClient {
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="abstract methods...">
    @RequestLine("PATCH /v1/jogador/update/{id}/online/{online}")	
	public Jogador updateOneOnline(@Param("id") Long id, @Param("online") Boolean online,
	@RequestHeader(value="X-HTTP-Method-Override", defaultValue="PATCH") String xHttpMethodOveride);
    //</editor-fold>
    
}//interface
