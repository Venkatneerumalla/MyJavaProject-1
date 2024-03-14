package com.project.Event.servicesImpl;

import java.util.List;

import com.project.EventManagementSystem.entities.Sponsors;
import com.project.Event.services.SponsorsService;
import com.project.EventManagementSystem.dao.SponsorsDAO; // Assuming SponsorsDAO interface exists

public class SponsorsServiceImpl implements SponsorsService {

    private final SponsorsDAO sponsorsDAO; // Assuming dependency injection

    public SponsorsServiceImpl(SponsorsDAO sponsorsDAO) {
        this.sponsorsDAO = sponsorsDAO;
    }

    @Override
    public void saveSponsor(Sponsors sponsor) {
        sponsorsDAO.saveSponsor(sponsor);
    }

    @Override
    public Sponsors findById(int sponsorId) {
        return sponsorsDAO.findById(sponsorId);
    }

    @Override
    public void updateSponsor(Sponsors sponsor) {
        sponsorsDAO.updateSponsor(sponsor);
    }

    @Override
    public void deleteSponsor(int sponsorId) {
        sponsorsDAO.deleteSponsor(sponsorId);
    }

    @Override
    public List<Sponsors> findSponsorsByEventId(int eventId) {
        return sponsorsDAO.findSponsorsByEventId(eventId);
    }
}
