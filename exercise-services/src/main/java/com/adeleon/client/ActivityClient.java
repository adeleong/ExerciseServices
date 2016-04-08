package com.adeleon.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.adeleon.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient();
	}
	
	public Activity get(String id){
		
		WebTarget target = client.target("http://localhost:8088/exercise-services/webapi/");
		
		Activity response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Activity.class);
		
		//String response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println(response);
		return response;
	}
}
