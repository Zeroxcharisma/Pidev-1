/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.gui;

import edu.cours.entities.evenement;
import edu.cours.services.evenementCRUD;
import edu.cours.tools.MyConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author chahine
 */
public class FXMLController implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private Button btnAdd;
    @FXML
    private ComboBox<String> check1;
    @FXML
    private ComboBox<String> check;
    @FXML
    private ComboBox<String> terrain;
    @FXML
    private TableView<evenement> tr;
    @FXML
    private TableColumn<evenement,Integer> cid;
    @FXML
    private TableColumn<evenement,String> ce1;
    @FXML
    private TableColumn<evenement,String> ce2;
    @FXML
    private TableColumn<evenement,String> ct;
    @FXML
    private TableColumn<evenement,LocalDate> cd;
     public ObservableList<evenement> observableListLocataire = FXCollections.observableArrayList();
    @FXML
    private Button S;
    @FXML
    private TextField aa;
    @FXML
    private TextField aaa;
    @FXML
    private TextField aaaa;
    @FXML
    private DatePicker aaaaa;
    @FXML
    private Button S1;
    @FXML
    private TextField b;
    @FXML
    private Button S2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
                                 
                                 
                      
                                                                             
        
        // TODO
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
        
          try {
            String requete = "SELECT *FROM evenement ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
           observableListLocataire.add(new evenement(rs.getInt("id"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate()));
            }
            }
         catch (SQLException ex) {
         }
          cid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
                      ce1.setCellValueFactory(new PropertyValueFactory<evenement,String>("terrain"));
                          ce2.setCellValueFactory(new PropertyValueFactory<evenement,String>("idequipe1"));
                                ct.setCellValueFactory(new PropertyValueFactory<evenement,String>("idequipe1"));
                                      cd.setCellValueFactory(new PropertyValueFactory<evenement,LocalDate>("date"));
                                      tr.setItems((observableListLocataire));
        
        
        
        
        
        
        
        
          /*evenementCRUD crd= new  evenementCRUD();
 
          
       cid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
                      ce1.setCellValueFactory(new PropertyValueFactory<evenement,String>("terrain"));
                          ce2.setCellValueFactory(new PropertyValueFactory<evenement,String>("idequipe1"));
                                ct.setCellValueFactory(new PropertyValueFactory<evenement,String>("idequipe1"));
                                      cd.setCellValueFactory(new PropertyValueFactory<evenement,LocalDate>("date"));
                                  tr.setItems((ObservableList<evenement>) crd.displaye());
            cid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
                      ce1.setCellValueFactory(new PropertyValueFactory<evenement,String>("idequipe1"));
                          ce2.setCellValueFactory(new PropertyValueFactory<evenement,String>("idequipe2"));
                                ct.setCellValueFactory(new PropertyValueFactory<evenement,String>("terrain"));
                                      cd.setCellValueFactory(new PropertyValueFactory<evenement,LocalDate>("date"));
                                      tr.setItems((ObservableList<evenement>) crd.displaye());*/
                
    }    

    @FXML
    private void ajout(ActionEvent event) {
        String resNom1 = check1.getValue();
            String resnom2 = check.getValue();
         String Terrain=terrain.getValue();
             LocalDate resdate= date.getValue();
              
       evenement e = new evenement(22,Terrain,resNom1,resnom2,resdate);
           evenementCRUD pcd= new   evenementCRUD();
         pcd.addEvenement(e);
            JOptionPane.showMessageDialog(null, "Reservation ajouté");
            tr.setItems((ObservableList<evenement>) pcd.displaye());
    }

    @FXML
    private void test(MouseEvent event) {
        
    }

    @FXML
    private void DELET(ActionEvent event) {
        evenement e= tr.getSelectionModel().getSelectedItem();
          
  evenementCRUD pcd= new   evenementCRUD();
           pcd.supprimerResultat(e);
           tr.setItems((ObservableList<evenement>) pcd.displaye());
    }

    @FXML
    private void affiche(ActionEvent event) {
           String id = b.getText();
        Integer id1 = Integer.parseInt(id);
        
          evenementCRUD pcd= new   evenementCRUD();
        aa.setText(pcd.rechercherres(id1).getidequipe1());
          aaa.setText(pcd.rechercherres(id1).getidequipe2());
        aaaa.setText(pcd.rechercherres(id1).getterrain());

   aaaaa.setValue((pcd.rechercherres(id1).getDate()));
        
    }

    @FXML
    private void modifier(ActionEvent event) {
         String id = b.getText();
         Integer id1 = Integer.parseInt(id);
         String nomT = aa.getText();
            String nomTe = aaa.getText();
           String nbr_Equipe =aaaa .getText();
            
            
           
            LocalDate dateT = aaaaa.getValue();
           evenementCRUD pcd= new   evenementCRUD();
          pcd.updateResultat(id1,nbr_Equipe,nomT,nomTe,dateT);
            tr.setItems((ObservableList<evenement>) pcd.displaye());
    }
    

    
}
