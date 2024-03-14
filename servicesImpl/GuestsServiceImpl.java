package com.project.Event.servicesImpl;

import java.util.List;

import com.project.EventManagementSystem.entities.Guests;
import com.project.Event.services.GuestsService;
import com.project.EventManagementSystem.dao.GuestsDAO; // Assuming GuestsDAO interface exists

public class GuestsServiceImpl implements GuestsService {

    private final GuestsDAO guestsDAO; // Assuming dependency injection

    public GuestsServiceImpl(GuestsDAO guestsDAO) {
        this.guestsDAO = guestsDAO;
    }

    @Override
    public void saveGuest(Guests guest) {
        guestsDAO.saveGuest(guest);
    }

    @Override
    public Guests findById(int guestId) {
        return guestsDAO.findById(guestId);
    }

    @Override
    public void updateGuest(Guests guest) {
        guestsDAO.updateGuest(guest);
    }

    @Override
    public void deleteGuest(int guestId) {
        guestsDAO.deleteGuest(guestId);
    }

    @Override
    public List<Guests> findGuestsByEventId(int eventId) {
        return guestsDAO.findGuestsByEventId(eventId);
    }
}
