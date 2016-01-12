package com.adeleon.repository;

import java.util.List;

import com.adeleon.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

}