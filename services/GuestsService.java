package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Guests;

public interface GuestsService {

  // Create (Save)
  public void saveGuest(Guests guest);

  // Read (Find)
  public Guests findById(int guestId);

  // Update
  public void updateGuest(Guests guest);

  // Delete
  public void deleteGuest(int guestId);

  // Find all guests for a specific event
  public List<Guests> findGuestsByEventId(int eventId);
}
