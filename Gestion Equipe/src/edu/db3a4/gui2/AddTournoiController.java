/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Personne;
import edu.db3a4.entities.Tournoi;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.services.TournoiCRUD;
import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddTournoiController implements Initializable {

    private DatePicker dateTournoi;
    private ComboBox<Integer> nbrEquipe;
    private ComboBox<String> terrain;
    private TextField nomTournoi;
    @FXML
    private TextField nom_eq;
    @FXML
    private Button btn_ajouter_equipe;
    @FXML
    private DatePicker date_eq;
    @FXML
    private TextField nbr_joueurs;
    @FXML
    private TextField nbr_points;
    @FXML
    private TextField classement_eq;
    @FXML
    private TextField nbr_prix;
    @FXML
    private Button gestion;
    @FXML
    private Button btnAjout1;
    @FXML
    private Button StatTerrain;
    @FXML
    private ImageView logoImg;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nbrEquipe.getItems().addAll(4,6,8,10);
         try {
            String requete = "SELECT nom FROM  terrain";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                terrain.getItems().addAll(rs.getString("nom"));
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    private void ajouterTournoi(ActionEvent event) {
    
            /// SAUVEGARDE DANS LA BD
            String nomT = nomTournoi.getText();
            String nomTerrain = terrain.getValue();
            Integer nbr_Equipe = nbrEquipe.getValue();
            LocalDate dateT = dateTournoi.getValue();
            
            Tournoi p = new Tournoi(14, nomT, nbr_Equipe, dateT, nomTerrain);
            TournoiCRUD pcd = new TournoiCRUD();
            pcd.ajouterTournoi(p);
            JOptionPane.showMessageDialog(null, "Tournoi ajouté");
            
            
    
    }

    @FXML
    private void ajouter_Equipe(ActionEvent event) {
    }

    @FXML
    private void gestion(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    @FXML
    private void acceuil(ActionEvent event) {
    }
    
}
