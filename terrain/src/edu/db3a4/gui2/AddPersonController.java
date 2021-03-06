/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.tests.SmsSender;
import java.awt.Dialog;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author House
 */
public class AddPersonController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private ComboBox <String> tfType;
    @FXML
    private TextField tfTaille;
    @FXML
    private TextField tfLieu;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tfType.getItems().addAll("Sable","Foot Salle","Tarton","Gazon");
        
      }    

    @FXML
    private void ajouterPersonne(ActionEvent event) {
        
        if ((tfNom.getText() != null && !tfNom.getText().isEmpty() && tfType.getValue() != null && tfLieu.getText() != null && !tfLieu.getText().isEmpty())){
       
            /// SAUVEGARDE DANS LA BD
            String resNom = tfNom.getText();
            String resType = tfType.getValue();
            String resTaille = tfTaille.getText();
            String resLieu = tfLieu.getText();
            Personne p = new Personne(14, resNom, resType, resTaille, resLieu);
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.ajouterPersonne(p);
            JOptionPane.showMessageDialog(null, "Terrain ajout??");
   
            SmsSender S=new  SmsSender();
            S.send("FootTunisie : votre terrain et ajout?? avec succ??s ! Nom du terrain ,"+resNom + " | "+"Lieu : "+resLieu,"b");
     
                   
            //notif
            Notifications notificationBuilder = Notifications.create().title("Terrain ajout?? avec succ??s !")
                     .text("").graphic(null)
                     .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER).darkStyle()
                    .onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Clicked on notification");
    
                }
                    });
            notificationBuilder.showInformation();
        } //fermeture de if 
        
        else {JOptionPane.showMessageDialog(null, "Merci de completer les champ manquants"); }      
                   
            
            //REDIRECTIO
    }

    @FXML

    private void dimensionUPD(ActionEvent event) {
        if(tfType.getValue().equals("Sable")){
            tfTaille.setText("10x20");
        }
        
        else if (tfType.getValue().equals("Foot Salle")){
            tfTaille.setText("15x25");
        }
        
        else if (tfType.getValue().equals("Tarton")){
            tfTaille.setText("25x35");
        }
        
        else if (tfType.getValue().equals("Gazon")){
            tfTaille.setText("30x50");
        }   
    }
    
    
    
    
    @FXML
    private void AfficherT(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AffichageTerrains.fxml"));
            Parent root = loader.load();
            tfNom.getScene().setRoot(root);
    }


    @FXML
    private void pc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Statistique.fxml"));
            Parent root = loader.load();
            tfNom.getScene().setRoot(root);
    }

    @FXML
    private void PaiAjout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calcul.fxml"));
            Parent root = loader.load();
            tfNom.getScene().setRoot(root);
    }

}