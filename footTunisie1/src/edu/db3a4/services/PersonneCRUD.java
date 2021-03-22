/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.services;

import edu.db3a4.entities.Personne;
import edu.db3a4.gui2.AffichageTerrainsController;
import edu.db3a4.gui2.GazonDetailsController;
import edu.db3a4.interfaces.IPersonne;
import edu.db3a4.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author House
 */
public class PersonneCRUD implements IPersonne<Personne>{
    public ObservableList<Personne> observableListLocataire = FXCollections.observableArrayList();
    int i=0;

    @Override
    public void ajouterPersonne(Personne t) {
        try {
            String requete = "INSERT INTO terrain (nom,type,taille,lieu)"
                    + "VALUES ('"+t.getNom()+"','"+t.getType()+"','"+t.getTaille()+"','"+t.getLieu()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("Terrain ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
   /* public void ajouterPersonne2(Personne t){
        try {
            String requete= "INSERT INTO personne(nom, prenom)"
                    + "VALUES (?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.executeUpdate();
            System.out.println("Personne inserée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } */

    @Override
    public void supprimerPersonne(Personne t) {
     
            try {
           String requete = "DELETE FROM terrain where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Personne supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void updateTerrain(Integer id, String nomT, String type, String taille, String lieu) {
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE terrain SET nom = '"+nomT+"', type = '"+type+"', taille = '"+taille+"', lieu = '"+lieu+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("terrain modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
   public ObservableList<Personne> displayTerrain() {
          try {
            
            String requete = "SELECT * from terrain";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(AffichageTerrainsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
   
   public ObservableList<Personne> displayTerrainG() {
          try {
            
            String requete = "SELECT * from terrain where type= 'gazon'";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(GazonDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
   

    public int b1e2() {
         try {
            String requete = "SELECT count(*) as num FROM  terrain  where type='gazon'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i; 
    }
    
    
    
    // sabledetails front 
    
    public ObservableList<Personne> displayTerrainS() {
          try {
            
            String requete = "SELECT * from terrain where type= 'sable'";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(GazonDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
   

    public int b1e3() {
         try {
            String requete = "SELECT count(*) as num FROM  terrain  where type='sable'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i; 
    }
    
    // tartondetails front 
    
    public ObservableList<Personne> displayTerrainT() {
          try {
            
            String requete = "SELECT * from terrain where type= 'tarton'";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(GazonDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
   

    public int b1e4() {
         try {
            String requete = "SELECT count(*) as num FROM  terrain  where type='tarton'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i; 
    }
    
    
    // footsalledetails front 
    
    public ObservableList<Personne> displayTerrainFS() {
          try {
            
            String requete = "SELECT * from terrain where type= 'foot salle'";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(GazonDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
   

    public int b1e5() {
         try {
            String requete = "SELECT count(*) as num FROM  terrain  where type='foot salle'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i; 
    }
   
   
    
}
