/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.interfaces;

import edu.db3a4.entities.Resultat;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author nidha
 */
public interface IResultat <T> {
      public void ajouterResultat(T t);
     public void supprimerResultat(T t);
     public void updateResultat(Integer id,String e1,String e2,Integer sc1,Integer sc2);
     public  ObservableList<T> displayPersons();
     public Resultat rechercherres(Integer id);
         public ObservableList<T> matchjour();
 public  ObservableList<T> displayPersonss();
  public int displayequipe1();
    public int displayequipe2();
      public int displayequipe3();
        public int displayequipe4();
          public int displayequipe5();
            public int displayequipe6();
              public int displayequipe7();
                public int displayequipe18();
                 public int score1();
                    public int score1CAE(String a);
                      public int score2CAE(String a);
                        public int n1CAE(String a);
                          public int n2CAE(String a);
                      public int winner(String a);
                      public int b2e1(String a);
                             public int b1e2(String a);
                
        
    
}