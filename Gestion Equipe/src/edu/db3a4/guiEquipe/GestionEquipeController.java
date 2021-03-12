/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.guiEquipe;

import edu.db3a4.entities.Equipe;
import edu.db3a4.entities.Tournoi;
import edu.db3a4.services.EquipeCRUD;
import edu.db3a4.services.TournoiCRUD;
import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class GestionEquipeController implements Initializable {


    @FXML
    private Button btn_recherche;

    @FXML
    private Button btn_modifier;

    @FXML
    private TextField tf_nom;
    
    @FXML
    private TextField tf_id;

    @FXML
    private TextField nbr_points;

    @FXML
    private TextField nbr_joueurs;

    @FXML
    private TextField nbr_prix;

    @FXML
    private TextField classement_eq;

    @FXML
    private Button btnGestion;

    @FXML
    private Button btnAjout;

    @FXML
    private Button calendrier;

    @FXML
    private Button StatsTerrain;
    
    @FXML
    private DatePicker date_creation;

    @FXML
    private TableView<Equipe> afficher;

    @FXML
    private TableColumn<Equipe, Integer> idEquipe;

    @FXML
    private TableColumn<Equipe, String> nomEquipe;

    @FXML
    private TableColumn<Equipe, Integer> nbr_pts;

    @FXML
    private TableColumn<Equipe, Integer> nbr_j;

    @FXML
    private TableColumn<Equipe, Integer> nbr_p;

    @FXML
    private TableColumn<Equipe, Integer> classement;
    
    @FXML
    private TableColumn<Equipe, LocalDate> creation;
    
    public ObservableList<Equipe> observableListLocataire = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        try {
//            Statement st;
//            st = MyConnection.getInstance().getCnx()
//                    .createStatement();
//            
//            ResultSet rs = st.executeQuery("SELECT * FROM equipe");
//            while (rs.next()) {
//                observableListLocataire.add( new Equipe(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate(),rs.getInt(7)));
//            }
//} catch (SQLException ex) {
//            Logger.getLogger(GestionEquipeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
            EquipeCRUD pcd = new EquipeCRUD();
            idEquipe.setCellValueFactory(new PropertyValueFactory<>("id_Equipe"));
            nomEquipe.setCellValueFactory(new PropertyValueFactory<>("nom_Equipe"));
            nbr_pts.setCellValueFactory(new PropertyValueFactory<>("nbr_Points_Equipe"));
            nbr_j.setCellValueFactory(new PropertyValueFactory<>("nbr_Joueurs_Equipe"));
            nbr_p.setCellValueFactory(new PropertyValueFactory<>("nbr_Prix_Equipe"));
            classement.setCellValueFactory(new PropertyValueFactory<>("Classement_Equipe"));
            creation.setCellValueFactory(new PropertyValueFactory<>("date_Equipe"));
            afficher.setItems(pcd.displayEquipe());
           
    }    

    @FXML
    private void rechercheEquipe(ActionEvent event) {
                
        String id = tf_id.getText();
        Integer id1 = Integer.parseInt(id);
        EquipeCRUD pcd = new EquipeCRUD();
       
         
        tf_id.setText(String.valueOf(pcd.rechercheEquipe2(id1).getId_Equipe()));
        tf_nom.setText(pcd.rechercheEquipe2(id1).getNom_Equipe());
        nbr_points.setText(String.valueOf(pcd.rechercheEquipe2(id1).getNbr_Points_Equipe()));
        nbr_joueurs.setText(String.valueOf(pcd.rechercheEquipe2(id1).getNbr_Joueurs_Equipe()));
        nbr_prix.setText(String.valueOf(pcd.rechercheEquipe2(id1).getNbr_Prix_Equipe()));
        classement_eq.setText(String.valueOf(pcd.rechercheEquipe2(id1).getClassement_Equipe()));
        date_creation.setValue(pcd.rechercheEquipe2(id1).getDate_Equipe()); 
        
    }

    @FXML
    private void modifierEquipe(ActionEvent event) {
         int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","Modifier",JOptionPane.YES_NO_OPTION);
      if(opt==0){
         String id = tf_id.getText();
         Integer id1 = Integer.parseInt(id);
         String nom_eq = tf_nom.getText();
         Integer nbr_joueurss = Integer.parseInt(nbr_joueurs.getText());
         Integer nbr_pointss = Integer.parseInt(nbr_points.getText());
         Integer nbr_prixx = Integer.parseInt(nbr_prix.getText());
         Integer classementt = Integer.parseInt(classement_eq.getText());
         LocalDate dateT = (LocalDate)date_creation.getValue();
         EquipeCRUD pcd = new EquipeCRUD();
         pcd.updateEquipe(id1,nom_eq,nbr_joueurss,nbr_pointss,nbr_prixx,dateT,classementt);
         afficher.setItems(pcd.displayEquipe());   }
                            
    }

    @FXML
    private void supprimerEquipe(ActionEvent event) {
                int opt = JOptionPane.showConfirmDialog(null, "Confirmer la suppression ?","Supprimer",JOptionPane.YES_NO_OPTION);
      if(opt==0){
        String id = tf_id.getText();
         Integer id1 = Integer.parseInt(id);
            EquipeCRUD pcd = new EquipeCRUD();
            pcd.supprimerEquipe(id1);
            afficher.setItems(pcd.displayEquipe());}
    }

    @FXML
    private void gestion(ActionEvent event) {
        
        
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AddEquipe.fxml"));
            Parent root = loader.load();
            tf_id.getScene().setRoot(root);
    }

    @FXML
    private void afficheCalendar(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    @FXML
    private void tabV(MouseEvent event) {
    }
    
}
