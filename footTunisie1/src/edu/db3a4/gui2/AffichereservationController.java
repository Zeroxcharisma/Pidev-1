/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.evenement;
import edu.db3a4.services.evenementCRUD;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * @author chahine
 */
public class AffichereservationController implements Initializable {


    @FXML
    private TableView<evenement> tr;
    @FXML
    private TableColumn<evenement,Integer> cid;
    @FXML
    private TableColumn<evenement,String> ct;
        @FXML
    private TableColumn<evenement,String> cp;
     @FXML
    private TableColumn<evenement,String> ctemps;
    @FXML
    private TableColumn<evenement,LocalDate> cd;
     public ObservableList<evenement> observableListLocataire = FXCollections.observableArrayList();
    @FXML
    private Button S;
  
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
  
    @FXML
    private TextField c;
    @FXML
    private TextField prixnet;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
                                 
                                 
                      
                                                                             
        
            
               
            
            
//            try {
//            String requete = "SELECT * FROM  terrain WHERE prix = " + txtprix + ";";
//            Statement st = MyConnection.getInstance().getCnx()
//                    .createStatement();
//            ResultSet rs =  st.executeQuery(requete);
//               if(rs.next()){
//                txtprix.setText(rs.getString("prix"));
//                    }else{
//                txtprix.setText("");
//}
// 
//    } 
//        catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }    
            







        
        
        
          try {
            String requete = "SELECT *FROM evenement ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
           observableListLocataire.add(new evenement(rs.getInt("id"),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5)));
            }
            }
         catch (SQLException ex) {
         }
          
          
          
          
          
          cid.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
                                ct.setCellValueFactory(new PropertyValueFactory<evenement,String>("terrain"));
                                      cd.setCellValueFactory(new PropertyValueFactory<evenement,LocalDate>("date"));
                                                            ctemps.setCellValueFactory(new PropertyValueFactory<evenement,String>("temps"));
                                                              cp.setCellValueFactory(new PropertyValueFactory<evenement,String>("prix"));

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

    private void ajout(ActionEvent event) {

           
         
       
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

        aaaa.setText(pcd.rechercherres(id1).getTerrain());

   aaaaa.setValue((pcd.rechercherres(id1).getDate()));
                c.setText(pcd.rechercherres(id1).getTemps());
                int a=pcd.b1e2();
                int b=pcd.b2e2();
                int c=b*16;
              int  prixfinal=a-c;
                
prixnet.setText(String.valueOf(prixfinal));

    }

    @FXML
    private void modifier(ActionEvent event) {
         String id = b.getText();
         Integer id1 = Integer.parseInt(id);
         String nbr_Equipe =aaaa .getText(); 
         LocalDate dateT = aaaaa.getValue();
         String temps = c.getText();

           evenementCRUD pcd= new   evenementCRUD();
          pcd.updateResultat(id1,nbr_Equipe,dateT,temps);
            tr.setItems((ObservableList<evenement>) pcd.displaye());
    }

    private void prixcalcule(ActionEvent event) {
      
          
    }

    @FXML
    private void recherche(MouseEvent event) {
        evenement e=tr.getSelectionModel().getSelectedItem();
         aaaaa.setValue(e.getDate());
         aaaa.setText(e.getTerrain());
         b.setText(String.valueOf(e.getId()));
  c.setText(e.getTemps());
    }

    @FXML
    private void PRIXFINAL(ActionEvent event) {
           evenementCRUD pcd= new   evenementCRUD();



 
                int a=pcd.b1e2();
                int b=pcd.b2e2();
                int c=b*16;
              int  prixfinal=a-c;
                
prixnet.setText(String.valueOf(prixfinal));
        
    }

    @FXML
    private void buttonajout(ActionEvent event) {
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Ajouterservatiob.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AjouterservatiobController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
    
        @FXML
    private void buttonaafiche(ActionEvent event) {
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Affichereservation.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AjouterservatiobController.class.getName()).log(Level.SEVERE, null, ex);
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
            Stage stage1 = (Stage) prixnet.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
