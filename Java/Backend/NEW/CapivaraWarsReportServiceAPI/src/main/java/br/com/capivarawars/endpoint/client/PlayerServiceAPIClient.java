package br.com.capivarawars.endpoint.client;

// <editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.Player;
import br.com.capivarawars.endpoint.handler.JogadorEndpoint;
import feign.Param;
import feign.RequestLine;
import java.util.List;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestHeader;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author WINDOWS 8.1 JOSHUA, 20/11/2019, 19:13:15 Last update: -
 */// </editor-fold>
public interface PlayerServiceAPIClient{

	@RequestLine("GET /players")
	public List<Player> searchAllPlayers();
}
