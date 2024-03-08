package org.example.dao;

import org.example.entities.Departement;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class DepartementDao {

    public static void saveDepartement(Departement departement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(departement);
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

    public static void deleteDepartement(Departement departement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(departement);
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

    public static Departement getDepartementById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Departement departement = null;
        try {
            departement = session.get(Departement.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return departement;
    }
}

