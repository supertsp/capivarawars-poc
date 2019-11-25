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
			API_CAPYBARA_SERVICE = "/api" + API_VERSION + "/capybaraservice",
			
			//CREATE :: POST
			API_CAPYBARA_SERVICE_CREATE_ONE_CAPYBARA = "/capybara",
			API_CAPYBARA_SERVICE_CREATE_ONE_CAPYBARA_DEATH = "/capybara/{idCapybara}/death",
			API_CAPYBARA_SERVICE_CREATE_ONE_COLOR = "/color",
			
			
			//UPDATE :: PUT
			API_CAPYBARA_SERVICE_UPDATE_ONE_CAPYBARA = "/capybara/{idCapybara}",
			API_CAPYBARA_SERVICE_UPDATE_ONE_CAPYBARA_HP = "/capybara/{idCapybara}/hp/{hp}",
			API_CAPYBARA_SERVICE_UPDATE_ONE_CAPYBARA_DEATH = "/capybara/{idCapybara}/death/{idDeath}",
			API_CAPYBARA_SERVICE_UPDATE_ONE_COLOR = "/color/{idColor}",
			
			
			//DELETE :: DELETE
			API_CAPYBARA_SERVICE_DELETE_ONE_CAPYBARA = "/capybara/{idCapybara}",			
			API_CAPYBARA_SERVICE_DELETE_ONE_CAPYBARA_DEATH = "/capybara/{idCapybara}/death/{idDeath}",		
			API_CAPYBARA_SERVICE_DELETE_ONE_COLOR = "/color/{idColor}",
			
			
			//SEARCH :: GET
			API_CAPYBARA_SERVICE_SEARCH_ONE_CAPYBARA_BY_ID = "/capybara/{idCapybara}",
			API_CAPYBARA_SERVICE_SEARCH_ONE_CAPYBARA_DEATH_BY_ID = "/capybara/{idCapybara}/death/{idDeath}",
			API_CAPYBARA_SERVICE_SEARCH_ONE_COLOR_BY_ID = "/color/{idColor}",
			
			API_CAPYBARA_SERVICE_SEARCH_ALL_CAPYBARAS = "/capybaras",
			API_CAPYBARA_SERVICE_SEARCH_ALL_CAPYBARA_DEATHS = "/capybara/{idCapybara}/deaths",
			API_CAPYBARA_SERVICE_SEARCH_ALL_LIVE_CAPYBARAS = "/capybaras/live",
			API_CAPYBARA_SERVICE_SEARCH_ALL_CAPYBARAS_BY_ID_PLAYER = "/capybaras/player/{idPlayer}",			
			API_CAPYBARA_SERVICE_SEARCH_ALL_COLORS = "/colors",
			
			//CHECK :: GET
			API_CAPYBARA_SERVICE_CHECK_ONE_CAPYBARA_DIED = "/capybara/{idCapybara}/check/died",
			
			
			
			
			API_TEST = "/XXXXX"			
			;

}//class
