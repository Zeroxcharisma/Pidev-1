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
     public void updateResultat(Integer id,String e1,String e2,Integer sc1,Integer sc2, LocalDate date);
     public  ObservableList<T> displayPersons();
     public Resultat rechercherres(Integer id);
         public ObservableList<T> matchjour(String date);

    
}