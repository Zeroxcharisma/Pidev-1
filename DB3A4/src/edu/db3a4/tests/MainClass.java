/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

import edu.db3a4.entities.Joueur;
import edu.db3a4.entities.Organisateur;
import edu.db3a4.services.JoueurCrud;
import edu.db3a4.services.OrganisateurCrud;
import edu.db3a4.tools.MyConnection;

/**
 *
 * @author House
 */


public class MainClass {
    

    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        MyConnection mc2 = MyConnection.getInstance();
        System.out.println(mc.hashCode()+"--"+mc2.hashCode());
      // Joueur J =new Joueur(222,"Hedi","BenHamed","Manouba","Email","ASH","2510",1,27253677,0);
      Joueur J =new Joueur(1622175,"Hedi", "Ben Hamed ", "Email","Ash25", "12345678");
                             JoueurCrud JC = new JoueurCrud();
                             JC.updateUser(J);
        // System.out.println(pcd.displayPersons());
    }
}
