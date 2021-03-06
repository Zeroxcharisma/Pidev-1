/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class Stats2Controller implements Initializable {

    @FXML
    private TextField noteequipe;
    @FXML
    private ComboBox<String> equipe;
    @FXML
    private TextField m;
    @FXML
    private TextField bm;
    @FXML
    private TextField be;
    @FXML
    private TextField g;

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
               
                equipe.getItems().addAll(rs.getString("nom"));
                      
                        
                         
                           
        
                   
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
        // TODO
    }    



    @FXML
    private void note(ActionEvent event) {
         String a=equipe.getValue();
         ResultatCrud rcr= new ResultatCrud();
         int b=rcr.score1CAE(a);
         int c=rcr.score2CAE(a);
         int d=rcr.n1CAE(a);
         int e=rcr.n2CAE(a);
         int f=rcr.winner(a);
         int j=rcr.b1e2(a);
         int k=rcr.b2e1(a);
         int x=e+d;
         int p=b+c;
         int n=k+j;
         float r=(float)f/x;
            float w=(float)p/x;
            float q=(float)n/x;
              float ui=r*6;
              float kl=ui+p;
              float notefinal=(float)kl/q;
              if(notefinal>10)
              {
                  notefinal=10;
              }
    noteequipe.setText(String.valueOf(notefinal));
    m.setText(String.valueOf(x));
    bm.setText(String.valueOf(p));
    be.setText(String.valueOf(n));
    g.setText (String.valueOf(f));
    }

    @FXML
    private void stats(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("statistiqueni.fxml"));
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
            Stage stage1 = (Stage) m.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

