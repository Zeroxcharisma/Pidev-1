/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import com.mysql.jdbc.Blob;
import edu.db3a4.entities.Tournoi;
import edu.db3a4.services.TournoiCRUD;
import edu.db3a4.tools.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddTournoiController implements Initializable {

    @FXML
    private DatePicker dateTournoi;
    @FXML
    private ComboBox<Integer> nbrEquipe;
    @FXML
    private ComboBox<String> terrain;
    @FXML
    private Button btnAjout;
    @FXML
    private TextField nomTournoi;

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

    @FXML
    private void ajouterTournoi(ActionEvent event) throws FileNotFoundException {
    
            /// SAUVEGARDE DANS LA BD
            String nomT = nomTournoi.getText();
            String nomTerrain = terrain.getValue();
            Integer nbr_Equipe = nbrEquipe.getValue();
            LocalDate dateT = dateTournoi.getValue();
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);
            FileInputStream fileInput = new FileInputStream(selectedFile);
            
            Tournoi p = new Tournoi(14, nomT, nbr_Equipe, dateT, nomTerrain);          
            TournoiCRUD pcd = new TournoiCRUD();
            pcd.ajouterTournoi(p);
            JOptionPane.showMessageDialog(null, "Tournoi ajouté");
       
 
    }

    
    }
    

