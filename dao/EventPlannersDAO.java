package com.project.EventManagementSystem.dao;

import com.project.EventManagementSystem.entities.EventPlanners;

public interface EventPlannersDAO {

  // Create (Save)
  public void saveEventPlanner(EventPlanners eventPlanner);

  // Read (Find)
  public EventPlanners findById(int eventPlannerId);

  // Update
  public void updateEventPlanner(EventPlanners eventPlanner);

  // Delete
  public void deleteEventPlanner(int eventPlannerId);
}
