package com.project.Event.servicesImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.EventManagementSystem.dao.EventPlannersDAO; // Assuming EventPlannersDAO interface exists
import com.project.EventManagementSystem.entities.EventPlanners;
import com.project.Event.services.EventPlannersService;

public class EventPlannersServiceImpl implements EventPlannersService {

    private final SessionFactory sessionFactory; // Assuming availability

    public EventPlannersServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveEventPlanner(EventPlanners eventPlanner) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(eventPlanner);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save event planner: " + e.getMessage());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public EventPlanners findById(int eventPlannerId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(EventPlanners.class, eventPlannerId);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateEventPlanner(EventPlanners eventPlanner) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(eventPlanner);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to update event planner: " + e.getMessage());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteEventPlanner(int eventPlannerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            EventPlanners eventPlanner = findById(eventPlannerId);
            if (eventPlanner != null) {
                session.delete(eventPlanner);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete event planner: " + e.getMessage());
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
