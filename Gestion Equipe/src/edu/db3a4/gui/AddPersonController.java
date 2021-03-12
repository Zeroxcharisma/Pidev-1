/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author House
 */
public class AddPersonController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button tfBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) {
        try {
            //// SAVE PERSON IN DB
            String resNom = tfNom.getText();
            String resPrenom = tfPrenom.getText();
            Personne p = new Personne(20, resNom, resPrenom);
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.ajouterPersonne(p);
            JOptionPane.showMessageDialog(null, "Personne ajouté");
            
            //REDIRECTION
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("PersonDetails.fxml"));
            Parent root = loader.load();
            PersonDetailsController pct = loader.getController();
            pct.setrNom(tfNom.getText());
            pct.setrPrenom(tfPrenom.getText());
            tfPrenom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            Logger.getLogger(AddPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
