/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tools.MyConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author nidha
 */
public class AddResultatController implements Initializable {

   @FXML
   private Button btnAdd;
    @FXML
    private ComboBox<String> check;
    @FXML
    private ComboBox<String> check1;
    @FXML
    private ComboBox<Integer> score1;
    @FXML
    private ComboBox<Integer> score2;
    @FXML
    private DatePicker date;
    @FXML
    private ImageView icon;
    @FXML
    private Button a;


      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

         try {
            String requete = "SELECT nom_equipe FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                check.getItems().addAll(rs.getString("nom_equipe"));
                      check1.getItems().addAll(rs.getString("nom_equipe"));
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        score1.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
         score2.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        
        
    }    
        // TODO
    

    @FXML
    private void aJOUTERRESULTAT(ActionEvent event) {
     
        Stage primaryStage= new Stage();
          try {
            /// SAUVEGARDE DANS LA BD
            String resNom1 = check1.getValue();
            String resnom2 = check.getValue();
            Integer resscore1= score1.getValue();
              Integer resscore2= score2.getValue();
              Integer note=(score2.getValue()* score1.getValue())*2;
              String S= new String();
              if(resscore1>resscore2)
              {
                  S=resNom1;
                  
              }
               if(resscore1<resscore2)
               {
                   S=resnom2;
               }
               if(resscore1==resscore2)
               {
                   S="Null";
               }
              
 LocalDate resdate= date.getValue();
         Resultat r= new Resultat(15,resNom1,resnom2,resscore1,resscore2,note,resdate,S);
           ResultatCrud rcr= new ResultatCrud();
           rcr.ajouterResultat(r);
            JOptionPane.showMessageDialog(null, "Personne ajouté");
              
            /// SAUVEGARDE DANS LA BD
            
            
            //REDIRECTION
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AddPerson.fxml"));
            Parent root = loader.load();
            
            DisplayPersonController dpc = loader.getController();
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        
            } catch (IOException ex) {
            Logger.getLogger(AddPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void english(MouseEvent event) {
    }

    @FXML
    private void en(ActionEvent event) {
     
       try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("affichage.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        
    }
    
}
