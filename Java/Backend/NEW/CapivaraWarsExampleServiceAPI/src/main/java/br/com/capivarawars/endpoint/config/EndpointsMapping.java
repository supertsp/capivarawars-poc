package br.com.capivarawars.endpoint.config;

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 */// </editor-fold>
public class EndpointsMapping {

	public static final String //

	API_VERSION = "/v1", API_PLAYER_SERVICE = "/api" + API_VERSION + "/playerservice",

			// CREATE :: POST
			API_PLAYER_SERVICE_CREATE_ONE = "/player",

			// UPDATE :: PUT
			API_PLAYER_SERVICE_UPDATE_ONE = "/player/{id}",

			// DELETE :: DELETE
			API_PLAYER_SERVICE_DELETE_ONE = "/player/{id}",

			// SEARCH :: GET
			API_PLAYER_SERVICE_SEARCH_ONE = "/player/{id}", API_PLAYER_SERVICE_SEARCH_ALL = "/player",

			// CHECK :: GET
			API_PLAYER_SERVICE_CHECK_ONE_ONLINE = "/player/check/online/{id}",

			// AUTHENTICATION :: POST
			API_PLAYER_SERVICE_LOGIN = "/login",

			// Remover ao terminar :)
			API_TEST = "/XXXXX";

}// class
