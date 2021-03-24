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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class ResultatchoixController implements Initializable {

    @FXML
    private ComboBox<String> idd1;
    @FXML
    private Button btnAdd;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          idd1.getItems().addAll("resultat amical","resultat tournoi");
        // TODO
    }    

    @FXML
    private void aJOUTERRESULTAT(ActionEvent event) {
        String a=idd1.getValue();
        if(a.equals("resultat amical"))
        {
             try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Addresultat.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AjouterservatiobController.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
        else
        {
            try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Resultattournoi.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AjouterservatiobController.class.getName()).log(Level.SEVERE, null, ex);
       }   
        }
                
    }

    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void buttonajout(ActionEvent event) {
    }

    @FXML
    private void buttonaffiche(ActionEvent event) {
    }

    @FXML
    private void buttonstats(ActionEvent event) {
    }
    
}
