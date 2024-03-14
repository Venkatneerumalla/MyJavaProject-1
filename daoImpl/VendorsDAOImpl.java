package com.project.EventManagementSystem.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.project.EventManagementSystem.dao.VendorsDAO;
import com.project.EventManagementSystem.entities.Vendors;

public class VendorsDAOImpl implements VendorsDAO {

    private final SessionFactory sessionFactory; // Assuming availability

    public VendorsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveVendor(Vendors vendor) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(vendor);
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Vendors findById(int vendorId) {
        Session session = sessionFactory.openSession();
        try {
            return (Vendors) session.get(Vendors.class, vendorId);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateVendor(Vendors vendor) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteVendor(int vendorId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Vendors vendor = findById(vendorId);
            if (vendor != null) {
                session.delete(vendor);
            }
            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Vendors> getAllVendors() {
        Session session = sessionFactory.openSession();
        try {
            // Assuming you have a way to query all vendors efficiently
            return session.createQuery("from Vendors").list();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
