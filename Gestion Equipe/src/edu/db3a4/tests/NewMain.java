/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

import edu.db3a4.entities.Equipe;
import edu.db3a4.services.EquipeCRUD;
import edu.db3a4.tools.MyConnection;
import java.time.LocalDate;

/**
 *
 * @author Tarek
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Equipe e1 = new Equipe("TESTTT 22 ",10,10,10,LocalDate.parse("2018-12-10"),10);
//        Equipe e2 = new Equipe("Equipe 2",11,27,8,LocalDate.parse("2018-11-01"),8);
       EquipeCRUD pcd = new EquipeCRUD();
       pcd.ajouterEquipe(e1);
//        pcd.ajouterEquipe(e2);
//        pcd.updateEquipe(10,"Validation 2",2,2,2,LocalDate.parse("2011-11-11"),2);
//        pcd.displayEquipe().forEach(System.out::println);
//        pcd.supprimerEquipe(10);
//       pcd.rechercheEquipe(3).forEach(System.out::println);
//       pcd.Moyenne_nombre_joueurs();
//       pcd.trier_Equipe().forEach(System.out::println);
    }
}
