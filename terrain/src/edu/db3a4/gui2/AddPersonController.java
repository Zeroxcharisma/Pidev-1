/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
import java.awt.Dialog;
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
import javafx.scene.control.ComboBox;
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
        
        tfType.getItems().addAll("tarton","piste","bat7a");
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) {
       
            /// SAUVEGARDE DANS LA BD
            String resNom = tfNom.getText();
            String resType = tfType.getValue();
            String resTaille = tfTaille.getText();
            String resLieu = tfLieu.getText();
            
            Personne p = new Personne(14, resNom, resType, resTaille, resLieu);
            PersonneCRUD pcd = new PersonneCRUD();
            pcd.ajouterPersonne(p);
            JOptionPane.showMessageDialog(null, "Personne ajouté");
            
            //REDIRECTIO
    }
    
}
