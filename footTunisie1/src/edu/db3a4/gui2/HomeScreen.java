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
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author House
 */


public class HomeScreen extends Application {
      private MediaView Media; 
 private MediaPlayer mediaplayer;
 private String uri="song.mp3";
 final java.net.URL resource = getClass().getResource("song.mp3");
        
        final MediaPlayer mediaPlayer = new MediaPlayer(new javafx.scene.media.Media(resource.toString()));
    
    @Override
    public void start(Stage primaryStage) {
         mediaPlayer.play();
        try {

         
            Parent root = FXMLLoader.load(getClass().getResource("resultat3.fxml"));

        

       


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
