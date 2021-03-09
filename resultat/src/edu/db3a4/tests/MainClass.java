/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.services.ResultatCrud;
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
       ResultatCrud pcd = new   ResultatCrud();
       int k=pcd.displayequipe2();

  int d=  pcd.score1CAE("TZB");
  int e=pcd.score2CAE("TZB");
  int f=pcd.n1CAE("TZB");
  int y=pcd.n2CAE("TZB");
  int l=pcd.winner("TZB");
      
          int c=f+y;
          System.out.println(c);
         float u=(float)l/c;
         float ui=u*6;
              System.out.println(ui);
         
       
                                   
                            
                        
                            
     
    }
}
