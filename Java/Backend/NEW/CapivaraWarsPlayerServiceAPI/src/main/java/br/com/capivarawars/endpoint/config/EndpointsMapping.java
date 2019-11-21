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
			API_PLAYER_SERVICE = "/api" + API_VERSION + "/playerservice",
			
			//CREATE :: POST
			API_PLAYER_SERVICE_CREATE_ONE_PLAYER = "/player",
			API_PLAYER_SERVICE_CREATE_ONE_PLAYER_MATCH = "/player/{idPlayer}/match",
			API_PLAYER_SERVICE_CREATE_ONE_PLAYER_CHAMPIONSHIP = "/player/{idPlayer}/championship",
			API_PLAYER_SERVICE_CREATE_ONE_PLAYER_PRIZE = "/player/{idPlayer}/prize",
			
			
			//UPDATE :: PUT
			API_PLAYER_SERVICE_UPDATE_ONE_PLAYER = "/player/{idPlayer}",
			API_PLAYER_SERVICE_UPDATE_ONE_PLAYER_MATCH = "/player/{idPlayer}/match/{idMatch}",
			API_PLAYER_SERVICE_UPDATE_ONE_PLAYER_CHAMPIONSHIP = "/player/{idPlayer}/championship/{idChampionship}",
			API_PLAYER_SERVICE_UPDATE_ONE_PLAYER_PRIZE = "/player/{idPlayer}/prize/{idPrize}",
			
			
			//DELETE :: DELETE
			API_PLAYER_SERVICE_DELETE_ONE_PLAYER = "/player/{idPlayer}",
			API_PLAYER_SERVICE_DELETE_ONE_PLAYER_MATCH = "/player/{idPlayer}/match/{idMatch}",
			API_PLAYER_SERVICE_DELETE_ONE_PLAYER_CHAMPIONSHIP = "/player/{idPlayer}/championship/{idChampionship}",
			API_PLAYER_SERVICE_DELETE_ONE_PLAYER_PRIZE = "/player/{idPlayer}/prize/{idPrize}",
			
			
			//SEARCH :: GET
			API_PLAYER_SERVICE_SEARCH_ONE_PLAYER = "/player/{idPlayer}",
			API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_MATCH = "/player/{idPlayer}/match/{idMatch}",
			API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_CHAMPIONSHIP = "/player/{idPlayer}/championship/{idChampionship}",
			API_PLAYER_SERVICE_SEARCH_ONE_PLAYER_PRIZE = "/player/{idPlayer}/prize/{idPrize}",
			
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS = "/players",
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYERS_BY_SCORE = "/players/score",
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_MATCHES = "/player/{idPlayer}/matches",
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_MATCHES_BY_GAMESTATUS = "/player/{idPlayer}/matches/gamestatus/{gamestatus}",
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_CHAMPIONSHIPS = "/player/{idPlayer}/championships",
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_CHAMPIONSHIPS_BY_GAMESTATUS = "/player/{idPlayer}/championships/gamestatus/{gamestatus}",
			API_PLAYER_SERVICE_SEARCH_ALL_PLAYER_PRIZES = "/player/{idPlayer}/prizes",
			
			//CHECK :: GET
			API_PLAYER_SERVICE_CHECK_ONE_PLAYER_ONLINE = "/player/check/online/{idPlayer}",
			API_PLAYER_SERVICE_CHECK_ONE_PLAYER_NICK = "/player/check/nick/{nick}",
			API_PLAYER_SERVICE_CHECK_ONE_PLAYER_CREDENTIALS = "/player/check/credentials",
			
			
			//AUTHENTICATION :: POST		
			API_PLAYER_SERVICE_LOGIN = "/login",
			API_PLAYER_SERVICE_LOGOUT = "/logout",
			
			
			
			
			API_TEST = "/XXXXX"			
			;

}//class
