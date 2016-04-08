package com.adeleon.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adeleon.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient();
	}
	
	public Activity get(String id){
		
		WebTarget target = client.target("http://localhost:8088/exercise-services/webapi/");
		
		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		System.out.println(response.toString());
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		//String response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println(response);
		return response.readEntity(Activity.class);
	}
	
	public List<Activity> get(){

		WebTarget target = client.target("http://localhost:8088/exercise-services/webapi/");
		
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		
		return response;
	}
}
