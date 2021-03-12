/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author hedii
 */
public class HomeController implements Initializable{

    @FXML
    private Button Btn_Acceuil;
     @FXML
    private Label Lb_Username;

    @FXML
    private Button Btn_Profil;

    @FXML
    private Button Btn_Tournois;

    @FXML
    private Button Btn_Paris;

    @FXML
    private Button Btn_Finances;

    @FXML
    private Button Btn_DB;

    @FXML
    private Button Btn_Desactiver;

    @FXML
    private Button Btn_Contact;
    @FXML
    private AnchorPane root;
    private Parent fxml;

    @FXML
    void Profil(ActionEvent event) {
                try{
                       fxml = FXMLLoader.load(getClass().getResource("Profil.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){ex.printStackTrace();}
            }
    @FXML
    void Desactiver(ActionEvent event) {
                    try{
                       fxml = FXMLLoader.load(getClass().getResource("Desactiver.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){}
    }
    
    
    @FXML
    void ListContact(ActionEvent event) {
 try{
                       fxml = FXMLLoader.load(getClass().getResource("Contact.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){ex.printStackTrace();}
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

/*
        Scene scene = new Scene(root);
        scene.
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show()
    */

    
}
