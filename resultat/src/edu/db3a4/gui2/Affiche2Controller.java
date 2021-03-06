/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class Affiche2Controller implements Initializable {

 
    @FXML
    private TableView<Resultat> tr;
    @FXML
    private TableColumn<Resultat, Integer> cid;
    @FXML
    private TableColumn<Resultat, String> ce1;
    @FXML
    private TableColumn<Resultat, String> ce2;
    @FXML
    private TableColumn<Resultat,Integer> cs1;
    @FXML
    private TableColumn<Resultat,Integer> cs2;
    @FXML
    private TableColumn<Resultat, Integer> note;

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
    private Button btnselect1;
    @FXML
    private Button btnselect11;
    @FXML
    private Button en2;
    private TableColumn<Resultat,String> dmtache1;
    @FXML
    private TableColumn<Resultat,Integer> carton;
    private TableColumn<Resultat,Integer> dmtache111;
    @FXML
    private TableColumn<Resultat,Integer> occ;
    @FXML
    private TextField cartonr;
    @FXML
    private TextField occcc;
    @FXML
    private TableColumn<Resultat,String> ga;
    @FXML
    private TextField winner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ResultatCrud rcr= new ResultatCrud();

       
       
          
               
              

            /// SAUVEGARDE DANS LA BD
       
         
    
          
       
           
            cid.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("id"));
                      ce1.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe1"));
                                 ce2.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe2"));
                                            cs1.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe1"));
                                                       cs2.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe2"));
                                                                 note.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("note"));
                      
                                                        ga.setCellValueFactory(new PropertyValueFactory<Resultat,String>("gangant"));
                                                               
                                                                  
                                                                carton.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("carton"));
                                                                occ.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("occaison"));
                                                                             
            tr.setItems(rcr.displayPersons());
    }    

    @FXML
    private void test(MouseEvent event) {
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
 
        
 
 cartonr.setText(String.valueOf(pcd.rechercherres(id1).getCarton()));
  occcc.setText(String.valueOf(pcd.rechercherres(id1).getOccaison()));
    }

    @FXML
    private void delte(ActionEvent event) {
        JOptionPane jop = new JOptionPane();
    int option = jop.showConfirmDialog(null, "Voulez-vous vraiment vous d??connecter?", "D??connexion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(option == JOptionPane.OK_OPTION) {
         Resultat r= tr.getSelectionModel().getSelectedItem();
           ResultatCrud pcd = new  ResultatCrud();

           pcd.supprimerResultat(r);
           tr.setItems(pcd.displayPersons());
    }
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
            
            
           
           
           ResultatCrud pcd= new ResultatCrud();
          pcd.updateResultat(id1, nomT,nomTe, b1, bu2);
            tr.setItems(pcd.displayPersons());
    }

    @FXML
    private void englishaff(ActionEvent event) {
        try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Affichageneglish.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }

    @FXML
    private void tabv(MouseEvent event) {
       Resultat r = tr.getSelectionModel().getSelectedItem();   
        te1.setText(r.getNomequipe1());
         te2.setText(r.getNomequipe2());
         tid.setText(String.valueOf(r.getId()));
  tb1.setText(String.valueOf(r.getScoreequipe1()));
  tb2.setText(String.valueOf(r.getScoreequipe2()));
  
   tnt.setText(String.valueOf(r.getNote()));
 
        
 
 cartonr.setText(String.valueOf(r.getCarton()));
  occcc.setText(String.valueOf(r.getOccaison()));
       
           
    }

    @FXML
    private void buttonaafiche(ActionEvent event) {
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
    
    
}
