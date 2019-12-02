package br.com.capivarawars.endpoint.config;

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 *///</editor-fold>
public class EndpointsMapping {

	public static final String //
			API_VERSION = "/v1",
			API_REPORT_SERVICE = "/api" + API_VERSION + "/reportservice",
			
			//CREATE :: POST
			API_REPORT_SERVICE_CREATE_ONE_PLAYER = "/player",
			
			//UPDATE :: PUT
			API_REPORT_SERVICE_UPDATE_ONE_PLAYER = "/player/{idPlayer}",
			
			//DELETE :: DELETE
			API_REPORT_SERVICE_DELETE_ONE_PLAYER = "/player/{idPlayer}",
			
			//SEARCH :: GET
			API_REPORT_SERVICE_SEARCH_ONE_PLAYER_BY_ID = "/player/{idPlayer}",
			API_REPORT_SERVICE_SEARCH_ONE_PLAYER_BY_NICK = "/player/nick/{nick}",
			API_REPORT_SERVICE_SEARCH_ONE_PLAYER_BY_EMAIL = "/player/email/{email}",
			
			API_REPORT_SERVICE_SEARCH_ALL_PLAYERS = "/players",
			API_REPORT_SERVICE_SEARCH_ALL_PLAYERS_BY_SCORE = "/players/score",
			API_REPORT_SERVICE_SEARCH_ALL_PLAYER_MATCHES = "/player/{idPlayer}/matches",
			
			
			API_TEST = "/XXXXX";

}//class
