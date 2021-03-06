package br.com.capivarawars.endpoint;

//<editor-fold defaultstate="collapsed" desc="imports...">
//import ...
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 09/11/2019, 22:38:43 Last update: -
 *///</editor-fold>
public class EndpointsMapping {

	public static final String //
			API_GENERAL_CREATE = "/create",
			API_GENERAL_SEARCH = "/search",
			API_GENERAL_UPDATE = "/update",
			API_GENERAL_DELETE = "/delete",
			API_GENERAL_CHECK = "/check",			
			
			API_JOGADOR = "/api/database/v1/jogador",
			
			API_JOGADOR_SEARCH_BY_ID = API_GENERAL_SEARCH + "/id/{id}",
			API_JOGADOR_SEARCH_BY_NICK = API_GENERAL_SEARCH + "/nick/{nick}",
			API_JOGADOR_SEARCH_BY_EMAIL = API_GENERAL_SEARCH + "/email/{email}",
			API_JOGADOR_SEARCH_BY_ONLINE = API_GENERAL_SEARCH + "/online/{online}",
			API_JOGADOR_SEARCH_BY_PONTUACAO = API_GENERAL_SEARCH + "/pontuacao",			
			
			
			API_JOGADOR_UPDATE_BY_ID = API_GENERAL_UPDATE + "/{id}",			
			API_JOGADOR_UPDATE_ONLINE = API_GENERAL_UPDATE + "/{id}/online/{online}",			
					
			
			API_JOGADOR_DELETE_BY_ID = API_GENERAL_DELETE + "/id/{id}",
			API_JOGADOR_DELETE_BY_NICK = API_GENERAL_DELETE + "/nick/{nick}",
			API_JOGADOR_DELETE_BY_EMAIL = API_GENERAL_DELETE + "/email/{email}",
			
			
			API_JOGADOR_CHECK_BY_ID = API_GENERAL_CHECK + "/id/{id}",	
			API_JOGADOR_CHECK_BY_NICK = API_GENERAL_CHECK + "/nick/{nick}",			
			API_JOGADOR_CHECK_BY_CREDENTIALS = API_GENERAL_CHECK + "/credentials",			
			API_JOGADOR_CHECK_BY_EMAIL = API_GENERAL_CHECK + "/email/{email}",
			API_JOGADOR_CHECK_ONLINE = API_GENERAL_CHECK + "/online/{id}",
			
			
			
			
			
			API_TEST = "/XXXXX"			
			;

}
