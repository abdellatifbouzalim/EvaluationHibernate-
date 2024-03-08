package org.example.dao;

import org.example.entities.Departement;
import org.example.entities.Employe;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeDao {

    public static List<Employe> getEmployesByDepartement(Departement departement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employe> employes = null;
        try {
            Query query = session.createQuery("FROM Employe WHERE departement = :departement");
            query.setParameter("departement", departement);
            employes = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employes;
    }

    public static Departement getDepartementByEmploye(Employe employe) {
        return employe.getDepartement();
    }

    public static void addEmployeToDepartement(Employe employe, Departement departement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            employe.setDepartement(departement);
            session.save(employe);
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

    public static void deleteEmploye(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(employe);
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

    public static void saveEmploye(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(employe);
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
    public static Employe getEmployeById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employe employe = null;
        try {
            employe = session.get(Employe.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employe;
    }


}
