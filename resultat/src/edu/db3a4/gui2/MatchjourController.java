/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tools.MyConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class MatchjourController implements Initializable {

    @FXML
    private TableView<Resultat> tr;
    @FXML
    private TableColumn<Resultat,String> ce1;
    @FXML
    private TableColumn<Resultat, String> ce2;
     public ObservableList<Resultat> observableListLocataire = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Resultat,Integer> cid;
    @FXML
    private TableColumn<Resultat,Integer> cs1;
    @FXML
    private TableColumn<Resultat,Integer> cs2;
    @FXML
    private TableColumn<Resultat,Integer> note;
    @FXML
    private TableColumn<Resultat,LocalDate> dmtache;
    @FXML
    private Button btnselect;
    @FXML
    private TextField tb2;
    @FXML
    private TextField te1;
    @FXML
    private TextField tid;
    @FXML
    private TextField te2;
    @FXML
    private TextField tb1;
    @FXML
    private TextField tnt;
    @FXML
    private Button btnselect1;
    @FXML
    private Button btnselect11;
    @FXML
    private DatePicker tdate;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

System.out.println();

 
        
       
    

      
       
          
               
              

            /// SAUVEGARDE DANS LA BD
       
         
    
          
       
           
          
         
    
          
    }      
           
        // TODO
      

    @FXML
    private void test(MouseEvent event) {
    }

    @FXML
    private void affiche(ActionEvent event) {
        
    
             
            }
    

    @FXML
    private void delte(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }
    
}
