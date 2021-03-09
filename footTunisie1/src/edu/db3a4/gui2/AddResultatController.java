/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tests.SmsSender;
import edu.db3a4.tools.MyConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



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
    private ComboBox<Integer> carton;
    @FXML
    private ComboBox<Integer> occaison;
    private ComboBox<Integer> checkid;
    @FXML
    private DatePicker pickerd;
    @FXML
    private ComboBox<Integer> idd1;
    @FXML
    private Button acceuil;


      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

         try {
            String requete = "SELECT nom FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                
                      check1.getItems().addAll(rs.getString("nom"));
                      String h=check1.getValue();
                     check.getItems().addAll(rs.getString("nom"));

                        
                         
                           
        
                   
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
      
        score1.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
      
         score2.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
         
        carton.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        occaison.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        

            try {
            String requete = "SELECT id FROM  evenement";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                
                   idd1.getItems().addAll(rs.getInt("id"));

                        
                         
                           
        
                   
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
                
        
    }    
        // TODO
    

    @FXML
    private void aJOUTERRESULTAT(ActionEvent event) {
     
        Stage primaryStage= new Stage();
          try {
            /// SAUVEGARDE DANS LA BD
               Integer id = idd1.getValue();
            String resNom1 = check1.getValue();
           
            String resnom2 = check.getValue();
            Integer resscore1= score1.getValue();
              Integer resscore2= score2.getValue();
          float a= (float) ((score1.getValue()+ score2.getValue())*0.6);
          float d= (float) (carton.getValue()*0.1);
          float b=(float) (occaison.getValue()*0.5);
          float note=(a+b)-d;
          if(note>10)
          {
           note=10;   
          }
              String S= new String();
              Integer c= carton.getValue();
              Integer o=occaison.getValue();
              
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
              

         Resultat r= new Resultat(id,resNom1,resnom2,resscore1,resscore2,note,S,c,o);
           ResultatCrud rcr= new ResultatCrud();
            
       
           rcr.ajouterResultat(r);
            JOptionPane.showMessageDialog(null, "Resultat ajouté");
        
          
             
            /// SAUVEGARDE DANS LA BD
            
            
            //REDIRECTION
          
             Parent exercices_parent = FXMLLoader.load(getClass().getResource("Affiche2.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
        
            } catch (IOException ex) {
         
        }
    }


    private void en(ActionEvent event) {
     
       try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Englishaad2.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        
    }

    @FXML
    private void changement(ActionEvent event) {
        String res=check1.getValue();
        check.getItems().removeAll(res);
    }

    private void aaaa(ActionEvent event) {
        /// SAUVEGARDE DANS LA BD
        Integer id= checkid.getValue();
        String resNom1 = check1.getValue();
        String resnom2 = check.getValue();
        Integer resscore1= score1.getValue();
        Integer resscore2= score2.getValue();
        float a= (float) ((score1.getValue()+ score2.getValue())*0.6);
        float d= (float) (carton.getValue()*0.1);
        float b=(float) (occaison.getValue()*0.5);
        float note=(a+b)-d;
        String S= new String();
        Integer c= carton.getValue();
        Integer o=occaison.getValue();
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
        Resultat r= new Resultat(id,resNom1,resnom2,resscore1,resscore2,note,S,c,o);
        ResultatCrud rcr= new ResultatCrud();
        rcr.ajouterResultat(r);
        
        JOptionPane.showMessageDialog(null, "Resultat ajouté");
        
    }

    @FXML
    private void buttonajout(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("AddResultat.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
    

    @FXML
    private void buttonaffiche(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Affiche2.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
    

    @FXML
    private void buttonstats(ActionEvent event) {
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Stats2.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }

    @FXML
    private void acceuil(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Integration.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("acceuil");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new javafx.scene.image.Image("/images/logo.png"));
            primaryStage.show();
            Stage stage1 = (Stage) check1.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  

  
    
}
