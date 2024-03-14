package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;

public interface EventService {

  // Create (Save)
  public void saveEvent(Event event);

  // Read (Find)
  public Event findById(int eventId);

  // Update
  public void updateEvent(Event event);

  // Delete
  public void deleteEvent(int eventId);

  // Find all events
  public List<Event> getAllEvents();
}


