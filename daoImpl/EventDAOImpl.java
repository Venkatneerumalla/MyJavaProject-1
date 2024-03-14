package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.project.EventManagementSystem.dao.EventDAO;
import com.project.EventManagementSystem.entities.Event;

public class EventDAOImpl implements EventDAO {

  private final SessionFactory sessionFactory;

  public EventDAOImpl(SessionFactory sessionFactory) {
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
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public Event findById(int eventId) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Event.class, eventId);
    } finally {
      session.close();
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
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public void deleteEvent(int eventId) {
    Session session = sessionFactory.openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      Event event = session.get(Event.class, eventId);
      if (event != null) {
        session.delete(event);
      }
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Event> getAllEvents() {
    Session session = sessionFactory.openSession();
    try {
      Query<Event> query = session.createQuery("FROM Event", Event.class);
      return query.getResultList();
    } finally {
      session.close();
    }
  }
}
