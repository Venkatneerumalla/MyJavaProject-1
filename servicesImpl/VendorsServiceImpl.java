package com.project.Event.servicesImpl;

import java.util.List;

import com.project.EventManagementSystem.entities.Vendors;
import com.project.Event.services.VendorsService;
import com.project.EventManagementSystem.dao.VendorsDAO; // Assuming VendorsDAO interface exists

public class VendorsServiceImpl implements VendorsService {

    private final VendorsDAO vendorsDAO; // Assuming dependency injection

    public VendorsServiceImpl(VendorsDAO vendorsDAO) {
        this.vendorsDAO = vendorsDAO;
    }

    @Override
    public void saveVendor(Vendors vendor) {
        vendorsDAO.saveVendor(vendor);
    }

    @Override
    public Vendors findById(int vendorId) {
        return vendorsDAO.findById(vendorId);
    }

    @Override
    public void updateVendor(Vendors vendor) {
        vendorsDAO.updateVendor(vendor);
    }

    @Override
    public void deleteVendor(int vendorId) {
        vendorsDAO.deleteVendor(vendorId);
    }

    @Override
    public List<Vendors> getAllVendors() {
        return vendorsDAO.getAllVendors();
    }
}
