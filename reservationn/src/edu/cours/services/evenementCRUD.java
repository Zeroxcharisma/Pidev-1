/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.services;
import edu.cours.entities.evenement;
import edu.cours.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author maalaoui
 */
     public class evenementCRUD {
            public ObservableList<evenement> observableListLocataire = FXCollections.observableArrayList();
     public void addEvenement(evenement e){
   
  
    
    try {
             String requete= "INSERT INTO evenement(terrain,idequipe1,idequipe2,date)" +  "VALUES ('"+e.getterrain()+"','"+e.getidequipe1()+"','"+e.getidequipe2()+"','"+e.getDate()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("resultat ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    
    
    
    
       /* try {
            PreparedStatement pst1 =  new MyConnection().cn.prepareStatement(requete);            
        
           
             pst1.setInt(1,e.getId());
             pst1.setString(2,e.getterrain());
             pst1.setString(3,e.getidequipe1());
             pst1.setString(4,e.getidequipe2());
             pst1.setDate(5,e.getDate());
            pst1.executeUpdate();
            System.out.println("evenement ajoutée");
        */
       
        
        } 
         public   ObservableList<evenement> displaye() {
             
        try {
            String requete = "SELECT *FROM evenement ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
           observableListLocataire.add(new evenement(rs.getInt("id"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate()));
            }
            }
         catch (SQLException ex) {
           
        }
return observableListLocataire;
         }
       public void supprimerResultat(evenement t) {
        try {
           String requete = "DELETE FROM evenement where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("reservation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public evenement rechercherres(Integer id) {
       evenement e = new evenement();

         try {
            String requete = "SELECT * FROM evenement WHERE id = " + id + ";";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                e.setId(rs.getInt("id"));
               e.setterrain(rs.getString(2));
               e.setidequipe1(rs.getString(3));
               e.setidequipe2(rs.getString(4));
               e.setDate(rs.getDate(5).toLocalDate());
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }
        public void updateResultat(Integer id, String e1, String e2, String sc1, LocalDate date) {
     try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE evenement  SET terrain = '"+e1+"', idequipe1= '"+e2+"', idequipe2 = '"+sc1+"', date= '"+date+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
  