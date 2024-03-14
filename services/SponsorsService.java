package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Sponsors;

public interface SponsorsService {

  // Create (Save)
  public void saveSponsor(Sponsors sponsor);

  // Read (Find)
  public Sponsors findById(int sponsorId);

  // Update
  public void updateSponsor(Sponsors sponsor);

  // Delete
  public void deleteSponsor(int sponsorId);

  // Find all sponsors associated with an event (assuming Many-to-Many relationship)
  public List<Sponsors> findSponsorsByEventId(int eventId);
}
