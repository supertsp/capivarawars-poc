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
			
			URL_DATABASE_API_BASE = "http://localhost:8086/api/database/v1/jogador",
			URL_DATABASE_API_CHECK_ONE_BY_NICK_AND_SENHA = URL_DATABASE_API_BASE + "/check/credentials",
			URL_DATABASE_API_SEARCH_ONE_BY_NICK = URL_DATABASE_API_BASE + "/search/nick/",
			URL_DATABASE_API_UPDATE_ONE_ONLINE = URL_DATABASE_API_BASE + "/update/%d/online/%s",
			
			API_GENERAL_CREATE = "/create",
			API_GENERAL_SEARCH = "/search",
			API_GENERAL_UPDATE = "/update",
			API_GENERAL_DELETE = "/delete",
			API_GENERAL_CHECK = "/check",			
			
			API_AUTHENTICATION = "/api/authentication/v1/",
			
			API_AUTHENTICATION_LOGIN = "/login",
			
			
			
			
			API_TEST = "/XXXXX"			
			;

}
