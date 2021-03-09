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
             String requete= "INSERT INTO evenement(terrain,date,temps,prix)" +  "VALUES ('"+e.getTerrain()+"','"+e.getDate()+"','"+e.getTemps()+"','"+e.getPrix()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("reservation ajoutée");
            
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
           observableListLocataire.add(new evenement(rs.getInt("id"),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5)));
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
               e.setTerrain(rs.getString(2));
               e.setDate(rs.getDate(3).toLocalDate());
                e.setTemps(rs.getString(4));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }
        public void updateResultat(Integer id, String e1,  LocalDate date, String temps) {
     try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE evenement  SET terrain = '"+e1+"', date= '"+date+"', temps= '"+temps+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
          public   LocalDate  date() {
               LocalDate i=  LocalDate.now();
         try {
          String requete = "SELECT *FROM evenement ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
 
            while(rs.next() ){
               i = rs.getDate(3).toLocalDate();
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
        
       
    }
           public   String  temps() {
              String s = null;
         try {
          String requete = "SELECT *FROM evenement ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
 
            while(rs.next() ){
               s = rs.getString(4);
              

                  return s; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return s;
        
       
    }
    public int b1e2() {
 int i = 0;
         try {
            String requete = "SELECT sum(prix) as num FROM  evenement ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
                i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
           
        return i;
        
       
    }
    public int b2e2()
             {
 int i = 0;
         try {
            String requete = "SELECT count(*) as num FROM  evenement ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
                i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
           
        return i;
        
       
    }
    
}
  