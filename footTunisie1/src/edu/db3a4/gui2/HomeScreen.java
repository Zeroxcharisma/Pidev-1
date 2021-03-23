/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author House
 */
public class HomeScreen extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
<<<<<<< HEAD
            Parent root = FXMLLoader.load(getClass().getResource("Resultat3.fxml"));
=======
<<<<<<< HEAD
            Parent root = FXMLLoader.load(getClass().getResource("Integration.fxml"));
=======
            Parent root = FXMLLoader.load(getClass().getResource("FrontTournoi.fxml"));
>>>>>>> 4ab6d306a7afdf459b69b89df6fdd58fc02a1f72
>>>>>>> 6f239f02f0f4b0f703e43ccf15366cc01b481369
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("FootTunisie");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/images/logo.png"));
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
