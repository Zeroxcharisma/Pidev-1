/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.interfaces;

import edu.db3a4.entities.Tournoi;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ASUS
 * @param <T>
 */
public interface ITournoi<T> {
     public void ajouterTournoi(T t);
     public void supprimerTournoi(Integer t);
     public void updateTournoi(Integer id, String nomT, Integer nbrE, LocalDate date, String terrain);
     public List<T> displayTournoi();
     public Tournoi rechercheTournoi(Integer t);
}
