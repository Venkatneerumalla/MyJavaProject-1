package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.project.EventManagementSystem.dao.SponsorsDAO;
import com.project.EventManagementSystem.entities.Sponsors;

public class SponsersDAOImpl implements SponsorsDAO {

    private final SessionFactory sessionFactory; // Assuming availability

    public SponsersDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSponsor(Sponsors sponsor) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(sponsor);
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Sponsors findById(int sponsorId) {
        Session session = sessionFactory.openSession();
        try {
            return (Sponsors) session.get(Sponsors.class, sponsorId);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateSponsor(Sponsors sponsor) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(sponsor);
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteSponsor(int sponsorId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Sponsors sponsor = findById(sponsorId);
            if (sponsor != null) {
                session.delete(sponsor);
            }
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Sponsors> findSponsorsByEventId(int eventId) {
        Session session = sessionFactory.openSession();
        try {
            // Assuming a Many-to-Many relationship with Event entity (modify if different)
            Criteria criteria = session.createCriteria(Sponsors.class);
            criteria.createAlias("events", "event"); // Join with events table
            criteria.add(Restrictions.eq("event.eventId", eventId)); // Filter by event ID

            return criteria.list();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
