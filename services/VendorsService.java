package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Vendors;

public interface VendorsService {

  // Create (Save)
  public void saveVendor(Vendors vendor);

  // Read (Find)
  public Vendors findById(int vendorId);

  // Update
  public void updateVendor(Vendors vendor);

  // Delete
  public void deleteVendor(int vendorId);

  // Find all vendors
  public List<Vendors> getAllVendors();
}
