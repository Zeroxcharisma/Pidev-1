/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class QuatreEquipeController implements Initializable {

    @FXML
    private ComboBox<String> eq1;
    @FXML
    private ComboBox<String> eq2;
    @FXML
    private ComboBox<String> eq3;
    @FXML
    private ComboBox<String> eq4;
    @FXML
    
    private Button btn;
    String nom,terrain;
    Integer nbr;
    LocalDate date;
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
               
                eq1.getItems().addAll(rs.getString("nom"));
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          try {
            String requete = "SELECT nom FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                eq2.getItems().addAll(rs.getString("nom"));
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           try {
            String requete = "SELECT nom FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                eq3.getItems().addAll(rs.getString("nom"));
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            try {
            String requete = "SELECT nom FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                eq4.getItems().addAll(rs.getString("nom"));
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }    
    public String getEq1(){
    return eq1.getValue();
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("AddTournoi.fxml"));
            Parent root = (Parent)loader.load();
            AddTournoiController tournoi = loader.getController();
            tournoi.Previous(nom,terrain,nbr,date);
            tournoi.LabelEadd(remplir());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        Stage stage1 = (Stage) btn.getScene().getWindow();
    stage1.close();
         
    }
    public String remplir(){
        return eq1.getValue()+","+eq2.getValue()+","+eq3.getValue()+","+eq4.getValue();
    }

    @FXML
    private void del1(ActionEvent event) {
            eq2.getItems().remove(eq1.getValue());
            eq3.getItems().remove(eq1.getValue());
            eq4.getItems().remove(eq1.getValue());
    }

    @FXML
    private void del2(ActionEvent event) {
            eq1.getItems().remove(eq2.getValue());
            eq3.getItems().remove(eq2.getValue());
            eq4.getItems().remove(eq2.getValue());
    }

    @FXML
    private void del4(ActionEvent event) {
            eq2.getItems().remove(eq3.getValue());
            eq1.getItems().remove(eq3.getValue());
            eq4.getItems().remove(eq3.getValue());
    }

    @FXML
    private void del3(ActionEvent event) {
            eq2.getItems().remove(eq4.getValue());
            eq3.getItems().remove(eq4.getValue());
            eq1.getItems().remove(eq4.getValue());
    }
    
}
