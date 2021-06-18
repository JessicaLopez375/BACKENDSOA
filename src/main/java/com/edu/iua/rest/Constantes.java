package com.edu.iua.rest;

public class Constantes {
	
	public static final String URL_API = "/api";
	public static final String URL_API_VERSION = "/final";
	public static final String URL_BASE = URL_API + URL_API_VERSION;

	public static final String URL_REGISTROS= URL_BASE + "/registros";
	public static final String URL_HISTORICO_REGISTROS= URL_BASE + "/historico-registros";
    
    public static final Integer PERIODO_ALMACENAMIENTO = 10;

    public static final String URL_AUTH_INFO = "/auth-info";

	public static final String URL_LOGOUT = "/logout-token";

	public static final String URL_AUTH = URL_BASE + "/auth";
	
	public static final String URL_USERS = URL_BASE + "/users";

    public static final String TOPIC_SEND_WEBSOCKET_GRAPH="/iw3/data";
    public static final String URL_WEBSOCKET_ENPOINT=URL_BASE + "/ws";

}
