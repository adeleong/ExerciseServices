package com.adeleon;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adeleon.model.Activity;
import com.adeleon.repository.ActivityRepository;
import com.adeleon.repository.ActivityRepositoryStub;

@Path("activities")//http://localhost:8080/exercise-services/webapi/activities
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		return activityRepository.findAllActivities();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}") //http://localhost:8080/exercise-services/webapi/activities/1234
	public Activity getActivitiy(@PathParam ("activityId") String activityId) {
		return activityRepository.findActivity(activityId);
	}
}
