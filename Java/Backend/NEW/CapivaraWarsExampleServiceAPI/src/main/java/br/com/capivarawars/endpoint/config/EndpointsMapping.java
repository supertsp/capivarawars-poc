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
			
			URL_DATABASE_API_BASE = "http://localhost:8086/api/database/v1/jogador",
			URL_DATABASE_API_CHECK_ONE_BY_NICK_AND_SENHA = URL_DATABASE_API_BASE + "/check/credentials",
			URL_DATABASE_API_SEARCH_ONE_BY_NICK = URL_DATABASE_API_BASE + "/search/nick/",
			URL_DATABASE_API_UPDATE_ONE_ONLINE = URL_DATABASE_API_BASE + "/update/%d/online/%s",
			
			API_GENERAL_CREATE = "/",			
			API_GENERAL_UPDATE = "/",
			API_GENERAL_DELETE = "/",
			API_GENERAL_SEARCH = "/",
			API_GENERAL_CHECK = "/",			
			
			API_AUTHENTICATION = "/api" + API_VERSION + "/authentication/",
			
			API_AUTHENTICATION_LOGIN = "/login",
			
			
			
			
			API_TEST = "/XXXXX"			
			;

}//class
