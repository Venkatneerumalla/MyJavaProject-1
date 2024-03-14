package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.EventManagementSystem.dao.GuestsDAO;
import com.project.EventManagementSystem.entities.Guests;

public class GuestsDAOImpl implements GuestsDAO {

  private final SessionFactory sessionFactory;

  public GuestsDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void saveGuest(Guests guest) {
    Session session = sessionFactory.openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      session.save(guest);
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
  public Guests findById(int guestId) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(Guests.class, guestId);
    } finally {
      session.close();
    }
  }

  @Override
  public void updateGuest(Guests guest) {
    Session session = sessionFactory.openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      session.update(guest);
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
  public void deleteGuest(int guestId) {
    Session session = sessionFactory.openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      Guests guest = session.get(Guests.class, guestId);
      if (guest != null) {
        session.delete(guest);
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
  public List<Guests> findGuestsByEventId(int eventId) {
    Session session = sessionFactory.openSession();
    try {
      Query<Guests> query = session.createQuery("FROM Guests WHERE eventId = :eventId", Guests.class);
      query.setParameter("eventId", eventId);
      return query.getResultList();
    } finally {
      session.close();
    }
  }
}
