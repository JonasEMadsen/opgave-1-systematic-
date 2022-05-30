package com.he3f.hero;

import java.util.HashMap;
import java.util.Map;

import com.he3f.rest.RestServer;

public class TestRestServer {

	private static TestRestServer instance = null;
	private RestServer restServer;
	private Map<Object, RestServer> clientList;

	public static TestRestServer getInstance() {
		if (instance == null) {
            instance = new TestRestServer();
			instance.setRestServer(new RestServer());
			instance.setClientList(new HashMap<Object, RestServer>());
		}
		return instance;
	}

	protected TestRestServer() {
		// Exists only to defeat instantiation.
	}

	public RestServer register(Object caller) {
		return register(caller, false);
	}

	public RestServer register(Object caller, boolean priaveRestServer) {
		if (priaveRestServer) {
			clientList.put(caller, new RestServer());
		} else {
			clientList.put(caller, restServer);
		}
		return clientList.get(caller);

	}


	private void setClientList(Map<Object, RestServer> clientList) {
		this.clientList = clientList;
	}

	public Map<Object, RestServer> getClientList() {
		return clientList;
	}

	private void setRestServer(RestServer restServer) {
		this.restServer = restServer;
	}

	public RestServer getRestServer() {
		return restServer;
	}


}
