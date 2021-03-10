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
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author hedii
 */
public class ContactController implements Initializable{
    @FXML
    private Button Btn_Amis;

    @FXML
    private Button btn_Suggestions;

    @FXML
    private Button Btn_Demandes;

    @FXML
    private AnchorPane root;
    private Parent fxml;

    @FXML
    void Amis(ActionEvent event) {
        try{
                       fxml = FXMLLoader.load(getClass().getResource("Amis.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){}
            }
    

    @FXML
    void Demandes(ActionEvent event) {
                 try{
                       fxml = FXMLLoader.load(getClass().getResource("Demandes.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){}
    }

    @FXML
    void Suggestions(ActionEvent event) {
             try{
                       fxml = FXMLLoader.load(getClass().getResource("Suggestion.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){ex.printStackTrace();}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
