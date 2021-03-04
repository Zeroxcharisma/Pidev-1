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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private TextField type1;
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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
               type1.setText(rs.getString(3));
               taille1.setText(rs.getString(4));
                              lieu1.setText(rs.getString(5));
    
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
       
        
    }

    @FXML
    private void SupprimerID(ActionEvent event) throws IOException {
        
       
        Stage primaryStage= new Stage();
         try {
            String requete = "DELETE FROM terrain where id=?";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,id1.getText() );
   pst.executeUpdate();
    
            
            System.out.println("Personne supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                PersonneCRUD pcd = new PersonneCRUD();

                   affichage.setItems(pcd.displayTerrain());

    }

    @FXML
    private void Modifer(ActionEvent event) {
        String id = id1.getText();
         Integer id1 = Integer.parseInt(id);
         String nomT = nom1.getText();
            String taille = taille1.getText();
            String type = type1.getText();
            String lieu = lieu1.getText();
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.updateTerrain(id1,nomT,type,taille,lieu);
            affichage.setItems(pcd.displayTerrain());
    }
    }



    
    








