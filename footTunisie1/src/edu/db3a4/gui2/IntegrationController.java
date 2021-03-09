/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IntegrationController implements Initializable {

    @FXML
    private Button Tournoi;
    @FXML
    private Button terrain;
    @FXML
    private Button resultat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Tournoi(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AddTournoi.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Gestion Tournoi");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/images/logo.png"));
            primaryStage.show();
            Stage stage1 = (Stage) Tournoi.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void terrain(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterTerrains.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Gestion Tournoi");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/images/logo.png"));
            primaryStage.show();
            Stage stage1 = (Stage) Tournoi.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void resultat(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AddResultat.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Gestion Tournoi");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/images/logo.png"));
            primaryStage.show();
            Stage stage1 = (Stage) Tournoi.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
