/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Tournoi;
import edu.db3a4.services.TournoiCRUD;
import edu.db3a4.tools.MyConnection;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */








public class AffichageTournoiController implements Initializable {

    @FXML
    private TableView<Tournoi> afficher;
    @FXML
    private TableColumn<Tournoi, Integer> idTournoi;
    @FXML
    private TableColumn<Tournoi, String> nomTournoi;
    @FXML
    private TableColumn<Tournoi, Integer> nbE;
    @FXML
    private TableColumn<Tournoi, LocalDate> DTournoi;
    @FXML
    private TableColumn<Tournoi, String> Ttournoi;
    
    public ObservableList<Tournoi> observableListLocataire = FXCollections.observableArrayList();
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_nom;
    @FXML
    private Button btn_recherche;
    @FXML
    private Button btn_supp;
    @FXML
    private Button btn_modifier;
    @FXML
    private ComboBox<Integer> tf_nbrE;
    @FXML
    private ComboBox<String> cmbTerrain;
    @FXML
    private DatePicker pickerDate;
    @FXML
    private Button ajout;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                tf_nbrE.getItems().addAll(4,6,8,10);

       try {
            String requete = "SELECT nom FROM  terrain";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){              
                cmbTerrain.getItems().addAll(rs.getString("nom"));                     
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            TournoiCRUD pcd = new TournoiCRUD();
            idTournoi.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomTournoi.setCellValueFactory(new PropertyValueFactory<>("nomTournoi"));
            nbE.setCellValueFactory(new PropertyValueFactory<>("nbr_equipe"));
            DTournoi.setCellValueFactory(new PropertyValueFactory<>("dateTournoi"));
            Ttournoi.setCellValueFactory(new PropertyValueFactory<>("terrainTournoi"));
                                                                                                                                              
            afficher.setItems(pcd.displayTournoi());
                 
    }

    @FXML
    private void rechercheTournoi(ActionEvent event) throws IOException {
        
        String id = tf_id.getText();
        Integer id1 = Integer.parseInt(id);
        TournoiCRUD pcd = new TournoiCRUD();
       
         
        tf_nom.setText(pcd.rechercheTournoi(id1).getNomTournoi());
        pickerDate.setValue(pcd.rechercheTournoi(id1).getDateTournoi());
        cmbTerrain.setValue(pcd.rechercheTournoi(id1).getTerrainTournoi());
        tf_nbrE.setValue(pcd.rechercheTournoi(id1).getNbr_equipe()); 
        Image img = new Image(new FileInputStream("C:\\Users\\ASUS\\Desktop\\git\\Pidev\\footTunisie\\src\\images\\"+pcd.rechercheTournoi(id1).getImage()));
        image.setImage(img);
    }

    @FXML
    private void supprimerTournoi(ActionEvent event) {
         String id = tf_id.getText();
         Integer id1 = Integer.parseInt(id);
            TournoiCRUD pcd = new TournoiCRUD();
            pcd.supprimerTournoi(id1);
            afficher.setItems(pcd.displayTournoi());
            
    }

    @FXML
    private void modifierTournoi(ActionEvent event) {
         String id = tf_id.getText();
         Integer id1 = Integer.parseInt(id);
         String nomT = tf_nom.getText();
            String nomTe = cmbTerrain.getValue();
            Integer nbr_Equipe = tf_nbrE.getValue();
            LocalDate dateT = pickerDate.getValue();
            TournoiCRUD pcd = new TournoiCRUD();
            pcd.updateTournoi(id1,nomT,nbr_Equipe,dateT,nomTe);
            afficher.setItems(pcd.displayTournoi());
        
    }
    }    
    