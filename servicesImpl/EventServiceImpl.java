package com.project.Event.servicesImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.EventManagementSystem.dao.EventDAO; // Assuming EventDAO interface exists
import com.project.EventManagementSystem.entities.Event;
import com.project.Event.services.EventService;

public class EventServiceImpl implements EventService {

    private final SessionFactory sessionFactory; // Assuming availability

    public EventServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveEvent(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(event);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save event: " + e.getMessage());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Event findById(int eventId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Event.class, eventId);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateEvent(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(event);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to update event: " + e.getMessage());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteEvent(int eventId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Event event = findById(eventId);
            if (event != null) {
                session.delete(event);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete event: " + e.getMessage());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = sessionFactory.openSession();
        try {
            // Assuming you have a way to query all events efficiently
            return session.createQuery("from Event").list();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
