package com.project.EventManagementSystem.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.EventManagementSystem.dao.EventPlannersDAO;
import com.project.EventManagementSystem.entities.EventPlanners;

public class EventPlannersDAOImpl implements EventPlannersDAO {

  private final SessionFactory sessionFactory;

  public EventPlannersDAOImpl(SessionFactory sessionFactory) {
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
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public EventPlanners findById(int eventPlannerId) {
    Session session = sessionFactory.openSession();
    try {
      return session.get(EventPlanners.class, eventPlannerId);
    } finally {
      session.close();
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
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public void deleteEventPlanner(int eventPlannerId) {
    Session session = sessionFactory.openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      EventPlanners eventPlanner = session.get(EventPlanners.class, eventPlannerId);
      if (eventPlanner != null) {
        session.delete(eventPlanner);
      }
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
  }
}
