package org.example;

import org.example.dao.DepartementDao;
import org.example.dao.EmployeDao;
import org.example.entities.Departement;
import org.example.entities.Employe;

public class Main {
    public static void main(String[] args) {
        // Créer quelques départements
        Departement departement1 = new Departement();
        departement1.setNom("Département 1");
        Departement departement2 = new Departement();
        departement2.setNom("Département 2");

        // Sauvegarder les départements
        DepartementDao.saveDepartement(departement1);
        DepartementDao.saveDepartement(departement2);

        // Créer quelques employés
        Employe employe1 = new Employe();
        employe1.setNom("John");
        Employe employe2 = new Employe();
        employe2.setNom("Alice");

        // Sauvegarder les employés
        EmployeDao.saveEmploye(employe1);
        EmployeDao.saveEmploye(employe2);

        // Ajouter les employés aux départements
        EmployeDao.addEmployeToDepartement(employe1, departement1);
        EmployeDao.addEmployeToDepartement(employe2, departement2);

        // Rechercher tous les employés d'un département spécifique
        System.out.println("Employés du département 1 : ");
        for (Employe employe : EmployeDao.getEmployesByDepartement(departement1)) {
            System.out.println(employe.getNom());
        }

        // Rechercher le département d'un employé spécifique
        System.out.println("Département de l'employé 2 : ");
        System.out.println(EmployeDao.getDepartementByEmploye(employe2).getNom());

        // Supprimer un employé
        Employe employeeToDelete = EmployeDao.getEmployeById(Long.valueOf(1));
        if (employeeToDelete != null) {
            EmployeDao.deleteEmploye(employeeToDelete);
            System.out.println("Employé supprimé avec succès.");
        }

        // Supprimer un département
        Departement departmentToDelete = DepartementDao.getDepartementById(Long.valueOf(1));
        if (departmentToDelete != null) {
            DepartementDao.deleteDepartement(departmentToDelete);
            System.out.println("Département supprimé avec succès.");
        }
    }
}
