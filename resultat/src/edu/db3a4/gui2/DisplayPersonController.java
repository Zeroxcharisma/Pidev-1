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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author House
 */
public class DisplayPersonController implements Initializable {

      private TextField rPrenom;
    @FXML
    private TableView<Resultat> tr;
    @FXML
    private TableColumn<Resultat,Integer> cid;
    @FXML
    private TableColumn<Resultat, String> ce1;
    @FXML
    private TableColumn<Resultat,String> ce2;
    @FXML
    private TableColumn<Resultat, Integer> cs1;
    @FXML
    private TableColumn<Resultat, Integer> cs2;
    @FXML
    private TableColumn<Resultat,Integer> note;
    @FXML
    private TableColumn<Resultat,LocalDate> dmtache;
    

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     ResultatCrud rcr= new  ResultatCrud();
                   
         

            /// SAUVEGARDE DANS LA BD
       
         
    
          
       
            cid.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("id"));
                      ce1.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe1"));
                                 ce2.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe2"));
                                            cs1.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe1"));
                                                       cs2.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe1"));
                                                                 note.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("note"));
                      
                                                                 dmtache.setCellValueFactory(new PropertyValueFactory<Resultat,LocalDate>("date"));
                                                                             
            tr.setItems((ObservableList<Resultat>) rcr.displayPersons());
                 
            
           
             
            
           
        }
          
     
    }    

  

