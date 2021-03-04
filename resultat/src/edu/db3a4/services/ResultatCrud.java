/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.services;

import edu.db3a4.entities.Resultat;
import edu.db3a4.gui2.DisplayPersonController;
import edu.db3a4.interfaces.IResultat;
import edu.db3a4.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nidha
 */
public class ResultatCrud implements IResultat<Resultat> {
    public ObservableList<Resultat> observableListLocataire = FXCollections.observableArrayList();


    @Override
    public void ajouterResultat(Resultat t) {
       try {
            String requete = "INSERT INTO resultat(equipe_1,equipe_2,score_1,score_2,note,date_matche,gagant)"
                    + "VALUES ('"+t.getNomequipe1()+"','"+t.getNomequipe2()+"','"+t.getScoreequipe1()+"','"+t.getScoreequipe2()+"','"+t.getNote()+"','"+t.getDate()+"','"+t.getGangant()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("resultat ajoutée");
             System.out.println(t.getNomequipe1());
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    
    
  

    @Override
    public    ObservableList<Resultat> displayPersons() {
        
         try {
            String requete = "SELECT * FROM resultat ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            observableListLocataire.add( new Resultat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getDate(7).toLocalDate(),rs.getString(8)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(DisplayPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }

    @Override
    public void supprimerResultat(Resultat t) {
        try {
           String requete = "DELETE FROM resultat where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Personne supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

  

 
    @Override
    public Resultat rechercherres(Integer id) {
         Resultat p = new Resultat();

         try {
            String requete = "SELECT * FROM resultat WHERE id = " + id + ";";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNomequipe1(rs.getString(2));
                p.setNomequipe2(rs.getString(3));
               p.setScoreequipe1(rs.getInt(4));
                p.setScoreequipe2(rs.getInt(5));
                p.setNote(rs.getInt(6));
                p.setDate(rs.getDate(7).toLocalDate());
                p.setGangant(rs.getString(8));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    @Override
    public void updateResultat(Integer id, String e1, String e2, Integer sc1, Integer sc2, LocalDate date) {
     try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE resultat SET equipe_1 = '"+e1+"', equipe_2 = '"+e2+"', score_1 = '"+sc1+"', score_2 = '"+sc2+"', date_matche= '"+date+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("Resultat modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Resultat> matchjour(String date) {
            try {
            String requete = "SELECT *FROM resultat WHERE equipe_1 = "+ date+ "; ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            observableListLocataire.add( new Resultat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getDate(7).toLocalDate(),rs.getString(8)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(DisplayPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
       
    }

 
 
 
    }
    

   


/**
 *
 * @author House
 */
   

