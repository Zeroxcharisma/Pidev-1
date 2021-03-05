/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.services;

import edu.db3a4.entities.Tournoi;
import edu.db3a4.gui2.AffichageTournoiController;
import edu.db3a4.interfaces.ITournoi;
import edu.db3a4.tools.MyConnection;
import java.io.File;
import java.io.InputStream;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ASUS
 */
public class TournoiCRUD implements ITournoi<Tournoi>{
        public ObservableList<Tournoi> observableListLocataire = FXCollections.observableArrayList();


    @Override
    public void ajouterTournoi(Tournoi t) {
        try {
             String requete = "INSERT INTO tournoi (nomTournoi,nbr_equipe,dateTournoi,terrainTournoi,image)"
        + "VALUES ('"+t.getNomTournoi()+"','"+t.getNbr_equipe()+"','"+t.getDateTournoi()+"','"+t.getTerrainTournoi()+"','"+t.getImage().getName()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println(t.getImage().getAbsolutePath());
            System.out.println("Tournoi ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
 
        @Override
    public void supprimerTournoi(Integer id) {
        try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("DELETE FROM tournoi WHERE id = " + id + ";");
            pst.executeUpdate();
            System.out.println("tournoi supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        @Override
    public void updateTournoi(Integer id, String nomT, Integer nbrE, LocalDate date, String terrain) {
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE tournoi SET nomTournoi = '"+nomT+"', nbr_equipe = '"+nbrE+"', dateTournoi = '"+date+"', terrainTournoi = '"+terrain+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("Tournoi modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Tournoi> displayTournoi() {
          try {
            
            String requete = "SELECT * from tournoi";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Tournoi(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4).toLocalDate(),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(AffichageTournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
        @Override
     public Tournoi rechercheTournoi(Integer id) {
                Tournoi p = new Tournoi();

         try {
            String requete = "SELECT * FROM tournoi WHERE id = " + id + ";";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNomTournoi(rs.getString(2));
                p.setNbr_equipe(rs.getInt(3));
                p.setDateTournoi(rs.getDate(4).toLocalDate());
                p.setTerrainTournoi(rs.getString(5));
                File file = new File(rs.getString(6));
                p.setImage(file);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    
}
