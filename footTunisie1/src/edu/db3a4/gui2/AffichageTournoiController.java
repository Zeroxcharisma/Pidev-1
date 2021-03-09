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
import java.io.FileNotFoundException;
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
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    private ImageView image;
    @FXML
    private Button gestion;
    @FXML
    private ImageView logoImg;
    @FXML
    private Button btnAjout1;
    
    @FXML
    private TableColumn<Tournoi, String> tbImg;
    @FXML
    private Button calendrier;
    @FXML
    private Button StatsTerrain;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                tf_nbrE.getItems().addAll(4,6,8,10);
                
                Image img;
            img = new Image("/images/logo.png");
              logoImg.setImage(img);
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
            tbImg.setCellValueFactory(new PropertyValueFactory<>("image"));                                                                                                                             
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
        
        Image img = new Image("/images/"+pcd.rechercheTournoi(id1).getImage());
        image.setImage(img);
    }

    @FXML
    private void supprimerTournoi(ActionEvent event) {
        int opt = JOptionPane.showConfirmDialog(null, "Confirmer la suppression ?","Supprimer",JOptionPane.YES_NO_OPTION);
      if(opt==0){
        String id = tf_id.getText();
         Integer id1 = Integer.parseInt(id);
            TournoiCRUD pcd = new TournoiCRUD();
            pcd.supprimerTournoi(id1);
            afficher.setItems(pcd.displayTournoi());}
    }

    @FXML
    private void modifierTournoi(ActionEvent event) {
         int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","Modifier",JOptionPane.YES_NO_OPTION);
      if(opt==0){
        String id = tf_id.getText();
         Integer id1 = Integer.parseInt(id);
         String nomT = tf_nom.getText();
            String nomTe = cmbTerrain.getValue();
            Integer nbr_Equipe = tf_nbrE.getValue();
            LocalDate dateT = pickerDate.getValue();
            TournoiCRUD pcd = new TournoiCRUD();
            pcd.updateTournoi(id1,nomT,nbr_Equipe,dateT,nomTe);
            afficher.setItems(pcd.displayTournoi());   }
                            
    }

    @FXML
    private void gestion(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AddTournoi.fxml"));
            Parent root = loader.load();
            tf_id.getScene().setRoot(root);
    }
    @FXML
    private void tabV(MouseEvent event) throws FileNotFoundException {
         Tournoi tournoi = afficher.getSelectionModel().getSelectedItem();
            tf_id.setText(String.valueOf(tournoi.getId()));
            tf_nom.setText(tournoi.getNomTournoi());
            tf_nbrE.setValue(tournoi.getNbr_equipe());
            pickerDate.setValue(tournoi.getDateTournoi());
            cmbTerrain.setValue(tournoi.getTerrainTournoi());
            Image img = new Image("/images/"+tournoi.getImage());
            image.setImage(img);
    }

    @FXML
    private void afficheCalendar(ActionEvent event) throws IOException {
       TournoiCRUD pcd = new TournoiCRUD();
       if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 4){
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calendar.fxml"));
                   Parent root = (Parent)loader.load();
            Integer id = Integer.parseInt(tf_id.getText());
            String nomTt = tf_nom.getText();
            String date1 = pickerDate.getValue().toString();
            String[] parts = pcd.getEquipes(id).split(",");  
            Random random = new Random();
            int nb = 14+random.nextInt(21-14);
            int nb1 = 14+random.nextInt(21-14);
            CalendarController calendar = loader.getController();
            calendar.sett(parts[0], parts[1], parts[2], parts[3], date1, pickerDate.getValue().plusDays(1).toString(),String.valueOf(nb),String.valueOf(nb1),nomTt);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Calendrier tournoi");
        stage.getIcons().add(new Image("/images/calendar.png"));
            stage.show();}
       else if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 8){
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calendar1.fxml"));
                   Parent root = (Parent)loader.load();
            Integer id = Integer.parseInt(tf_id.getText());
            String date1 = pickerDate.getValue().toString();
            String nomTt = tf_nom.getText();
            String[] parts = pcd.getEquipes(id).split(",");  
            Random random = new Random();
            int nb = 14+random.nextInt(21-14);
            int nb1 = 14+random.nextInt(21-14);
            int nb2 = 14+random.nextInt(21-14);
            int nb3 = 14+random.nextInt(21-14);
            Calendar1Controller calendar = loader.getController();
            calendar.sett(parts[0], parts[1], parts[2], parts[3], date1, 
                    pickerDate.getValue().plusDays(1).toString(),String.valueOf(nb),
                    String.valueOf(nb1),parts[4], parts[5], parts[6], parts[7],
                    pickerDate.getValue().plusDays(2).toString(),pickerDate.getValue().plusDays(3).toString(),
                    String.valueOf(nb2),String.valueOf(nb3),nomTt);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Calendrier tournoi");
        stage.getIcons().add(new Image("/images/calendar.png"));
            stage.show();
       }
           else if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 6){
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calendar2.fxml"));
                   Parent root = (Parent)loader.load();
            Integer id = Integer.parseInt(tf_id.getText());
            String date1 = pickerDate.getValue().toString();
            String nomTt = tf_nom.getText();
            String[] parts = pcd.getEquipes(id).split(",");  
            Random random = new Random();
            int nb = 14+random.nextInt(21-14);
            int nb1 = 14+random.nextInt(21-14);
            int nb2 = 14+random.nextInt(21-14);
            Calendar2Controller calendar = loader.getController();
            calendar.sett(parts[0], parts[1], parts[2], parts[3], date1, 
                    pickerDate.getValue().plusDays(1).toString(),String.valueOf(nb),
                    String.valueOf(nb1),parts[4], parts[5],
                    pickerDate.getValue().plusDays(2).toString(),
                    String.valueOf(nb2),nomTt);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Calendrier tournoi");
        stage.getIcons().add(new Image("/images/calendar.png"));
            stage.show();
       }
      else if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 10){
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calendar3.fxml"));
                   Parent root = (Parent)loader.load();
            Integer id = Integer.parseInt(tf_id.getText());
            String date1 = pickerDate.getValue().toString();
            String nomTt = tf_nom.getText();
            String[] parts = pcd.getEquipes(id).split(",");  
            Random random = new Random();
            int nb = 14+random.nextInt(21-14);
            int nb1 = 14+random.nextInt(21-14);
            int nb2 = 14+random.nextInt(21-14);
            int nb3 = 14+random.nextInt(21-14);
            int nb4 = 14+random.nextInt(21-14);
            Calendar3Controller calendar = loader.getController();
            calendar.sett(parts[0], parts[1], parts[2], parts[3], date1, 
                    pickerDate.getValue().plusDays(1).toString(),String.valueOf(nb),
                    String.valueOf(nb1),parts[4], parts[5], parts[6], parts[7],
                    pickerDate.getValue().plusDays(2).toString(),pickerDate.getValue().plusDays(3).toString(),
                    String.valueOf(nb2),String.valueOf(nb3),
                    parts[8],parts[9],pickerDate.getValue().plusDays(4).toString(),String.valueOf(nb4),
                    nomTt);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Calendrier tournoi");
        stage.getIcons().add(new Image("/images/calendar.png"));
            stage.show();
       }
    }

    @FXML
    private void stats(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Statistique.fxml"));
            Parent root = (Parent)loader.load();
          
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Statistique terrain");
        stage.getIcons().add(new Image("/images/stats.png"));
            stage.show();
    }

    @FXML
    private void acceuil(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Integration.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("acceuil");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new javafx.scene.image.Image("/images/logo.png"));
            primaryStage.show();
            Stage stage1 = (Stage) tf_nom.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    }    
    