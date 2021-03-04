/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class AffichageController implements Initializable {

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
    private TextField tid;
    @FXML
    private TextField tb2;
    @FXML
    private TextField te1;
    @FXML
    private TextField te2;
    @FXML
    private TextField tb1;
    @FXML
    private TextField tnt;
    @FXML
    private DatePicker tdate;
    @FXML
    private Button btnselect1;
    @FXML
    private Button btnselect11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       ResultatCrud rcr= new ResultatCrud();

       
       
          
               
              

            /// SAUVEGARDE DANS LA BD
       
         
    
          
       
           
            cid.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("id"));
                      ce1.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe1"));
                                 ce2.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe2"));
                                            cs1.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe1"));
                                                       cs2.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe2"));
                                                                 note.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("note"));
                      
                                                                 dmtache.setCellValueFactory(new PropertyValueFactory<Resultat,LocalDate>("date"));
                                                                             
            tr.setItems(rcr.displayPersons());
             
        // TODO
    }    

    @FXML
    private void affiche(ActionEvent event) {
      String id = tid.getText();
        Integer id1 = Integer.parseInt(id);
      ResultatCrud pcd = new  ResultatCrud();
         
        te1.setText(pcd.rechercherres(id1).getNomequipe1());
         te2.setText(pcd.rechercherres(id1).getNomequipe2());
  tb1.setText(String.valueOf(pcd.rechercherres(id1).getScoreequipe1()));
  tb2.setText(String.valueOf(pcd.rechercherres(id1).getScoreequipe2()));
  
   tnt.setText(String.valueOf(pcd.rechercherres(id1).getNote()));
   tdate.setValue((pcd.rechercherres(id1).getDate()));
        
 
 
        
            
    }

    @FXML
    private void test(MouseEvent event) {
        
        
         
         
                      
      
              
    }

    @FXML
    private void delte(ActionEvent event) {
      
Resultat r= tr.getSelectionModel().getSelectedItem();
           ResultatCrud pcd = new  ResultatCrud();

           pcd.supprimerResultat(r);
           tr.setItems(pcd.displayPersons());
    
    }    

    @FXML
    private void update(ActionEvent event) {
          String id = tid.getText();
         Integer id1 = Integer.parseInt(id);
         String nomT = te1.getText();
            String nomTe = te2.getText();
           String nbr_Equipe =tb1 .getText();
            Integer b1 = Integer.parseInt( nbr_Equipe);
             String b2 =tb2.getText();
            Integer bu2 = Integer.parseInt( b2);
            
            
           
            LocalDate dateT = tdate.getValue();
           ResultatCrud pcd= new ResultatCrud();
          pcd.updateResultat(id1, nomT,nomTe, b1, bu2, dateT);
            tr.setItems(pcd.displayPersons());
    }
}
    
               

