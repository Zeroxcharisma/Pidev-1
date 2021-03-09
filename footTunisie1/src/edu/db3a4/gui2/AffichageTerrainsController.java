/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.tools.MyConnection;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichageTerrainsController implements Initializable {
    

    @FXML
    private TableColumn<Personne, String> rNom;
    @FXML
    private TableColumn<Personne, String> rType;
    @FXML
    private TableColumn<Personne, String> rTaille;
    @FXML
    private TableColumn<Personne, String> rLieu;
    @FXML
    private TableView<Personne> affichage;
public ObservableList<Personne> observableListLocataire = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Personne, Integer> id;
    @FXML
    private TextField id1;
    @FXML
    private TextField nom1;
    @FXML
    private ComboBox<String> type1;
    @FXML
    private TextField taille1;
    @FXML
    private TextField lieu1;
    @FXML
    private Button Rech1;
    @FXML
    private Button Supp1;
    @FXML
    private Button Rech11;
    @FXML
    private Button calcul;
    @FXML
    private TextField Sur1;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                type1.getItems().addAll("Sable","Foot Salle","Tarton","Gazon");
               

       
        PersonneCRUD pcd = new PersonneCRUD();
            
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            rNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            rType.setCellValueFactory(new PropertyValueFactory<>("type"));
            rTaille.setCellValueFactory(new PropertyValueFactory<>("taille"));
            rLieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                                                                                                                                              
            affichage.setItems(pcd.displayTerrain());
                 
    }

    @FXML
    private void RechercherID(ActionEvent event) {
        
        try {
            String requete = "select *FROM terrain where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,id1.getText() );
             ResultSet rs = pst.executeQuery();
              while(rs.next()){
                
               nom1.setText(rs.getString(2));
               type1.setValue(rs.getString(3));
               taille1.setText(rs.getString(4));
                              lieu1.setText(rs.getString(5));
    
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
       
        
    }

    @FXML
    private void SupprimerID(ActionEvent event) throws IOException {
        
       
      
           
           
                      JOptionPane jop = new JOptionPane();
    int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer le terrain?", "Supression", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(option == JOptionPane.OK_OPTION) {
        
        //la fonction supprimer
        Personne r=affichage.getSelectionModel().getSelectedItem();
           PersonneCRUD pcd = new   PersonneCRUD();

          pcd.supprimerPersonne(r);
           affichage.setItems(pcd.displayTerrain());
             
    }       
    }

    @FXML
    private void Modifer(ActionEvent event) {
        String id = id1.getText();
         Integer id1 = Integer.parseInt(id);
         String nomT = nom1.getText();
            String taille = taille1.getText();
            String type = type1.getValue();
            String lieu = lieu1.getText();
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.updateTerrain(id1,nomT,type,taille,lieu);
            affichage.setItems(pcd.displayTerrain());
    }

    @FXML
    private void calculS(ActionEvent event) {
        
        try {
            String requete = "select *FROM terrain where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,id1.getText() );
             ResultSet rs = pst.executeQuery();
              while(rs.next()){
                  
                
               if (taille1.getText().equals("10x20"))
               {
                   Sur1.setText("200 m2");
               } 
               
               else if (taille1.getText().equals("15x25"))
               {
                   Sur1.setText("375 m2");
               }
               
               else if (taille1.getText().equals("25x35"))
               {
                   Sur1.setText("875 m2");
               }
               
               else if (taille1.getText().equals("30x50"))
               {
                   Sur1.setText("1500 m2");
               }
                
    
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void AjouterT(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AjouterTerrains.fxml"));
            Parent root = loader.load();
            nom1.getScene().setRoot(root);
    }

    
    @FXML
    private void DimensionUPD(ActionEvent event) {
        if(type1.getValue().equals("Sable")){
            taille1.setText("10x20");
        }
        
        else if (type1.getValue().equals("Foot Salle")){
            taille1.setText("15x25");
        }
        
        else if (type1.getValue().equals("Tarton")){
            taille1.setText("25x35");
        }
        
        else if (type1.getValue().equals("Gazon")){
            taille1.setText("30x50");
        }
    }

    @FXML
    private void tabAffiche(MouseEvent event) {
        Personne p = affichage.getSelectionModel().getSelectedItem();
            id1.setText(String.valueOf(p.getId()));
            nom1.setText(p.getNom());
            taille1.setText(p.getTaille());
            type1.setValue(p.getType());
            lieu1.setText(p.getLieu());
                  
    }

    @FXML
    private void StatT(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Statistique_1.fxml"));
            Parent root = loader.load();
            //nom1.getScene().setRoot(root); pour utiliser boutton Retour
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Statistique");
            stage.show();
    }

    @FXML
    private void PaieT(ActionEvent event) throws IOException {
        
       FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calcul.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Calcul Paiement");
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
            Stage stage1 = (Stage) lieu1.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

  
    



   



    
    








