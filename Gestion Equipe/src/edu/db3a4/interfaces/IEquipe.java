/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.interfaces;

import edu.db3a4.entities.Equipe;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tarek
 * @param <E>
 */
public interface IEquipe<E> {
     public void ajouterEquipe(E e);
     public void supprimerEquipe(Integer e);
     public void updateEquipe(Integer id, String nomE, Integer nbr_j_Equipe,Integer nbr_p_Equipe, Integer nbr_pr_Equipe , LocalDate date, Integer classement_E);
     public List<E> displayEquipe();
//     public Equipe rechercheEquipe(int id);
     public List <E> rechercheEquipe(int e);
     public List <E> trier_Equipe() ;
     public int Moyenne_nombre_joueurs();
}
