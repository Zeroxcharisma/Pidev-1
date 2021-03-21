/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CalculController implements Initializable {
    

    @FXML
    private TextField mpm;
    @FXML
    private TextField pmt;
    @FXML
    private TextField nbmr;
    @FXML
    private TextField dt;
    @FXML
    private TextField ac;
    @FXML
    private ComboBox<String> cbc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cbc.getItems().addAll("Sable","Foot Salle","Tarton","Gazon");
    }    

    @FXML
    private void calculernbr(ActionEvent event) {
        
       int a = Integer.parseInt(pmt.getText());
       int b = Integer.parseInt(dt.getText());
       int c = Integer.parseInt(mpm.getText());
       int d = Integer.parseInt(ac.getText());
       
       int t = ((a*b)-d)/c;
       nbmr.setText(String.valueOf(t));

       
    }

    @FXML
    private void DimensionsUPD(ActionEvent event) {
        if(cbc.getValue().equals("Sable")){
            dt.setText("200");
        }
        
        else if (cbc.getValue().equals("Foot Salle")){
            dt.setText("375");
        }
        
        else if (cbc.getValue().equals("Tarton")){
            dt.setText("875");
        }
        
        else if (cbc.getValue().equals("Gazon")){
            dt.setText("1500");
        }
    }

    @FXML
    private void retourCalcul(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AffichageTerrains.fxml"));
            Parent root = loader.load();
            dt.getScene().setRoot(root);
     
    }
    
}
