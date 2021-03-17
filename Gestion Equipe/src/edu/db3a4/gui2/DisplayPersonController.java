/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author House
 */
public class DisplayPersonController implements Initializable {

    @FXML
    private TextField rNom;
    @FXML
    private TextField rPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    public void setrNom(String value) {
        this.rNom.setText(value);
    }

    public void setrPrenom(String value) {
        this.rPrenom.setText(value);
    }

    
    
    
}
