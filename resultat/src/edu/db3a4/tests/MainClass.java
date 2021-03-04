/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.tools.MyConnection;
import java.time.LocalDate;

/**
 *
 * @author House
 */
public class MainClass {
    
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        MyConnection mc2 = MyConnection.getInstance();
        System.out.println(mc.hashCode()+"--"+mc2.hashCode());
        Personne p = new Personne(2, "Iheb", "Mohamed");
        PersonneCRUD pcd = new PersonneCRUD();
        pcd.updatePersonne(p);
              LocalDate date = LocalDate.now();  
              System.out.println(date);
              
       // System.out.println(pcd.displayPersons());
    }
}
