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
public class AjouterservatiobController implements Initializable {

      @FXML
    private DatePicker date;
    @FXML
    private Button btnAdd;
    private ComboBox<String> check1;
    private ComboBox<String> check;
    @FXML
    private ComboBox<String> terrain;
    @FXML
    private ComboBox<String> temps;
   
  
    private TextField aaaa;
    private DatePicker aaaaa;
    private TextField b;
  
    private TextField c;
    @FXML
    private TextField txtprix;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
                                 
                                 
                      
                                                                             
        
        // TODO
        
    
           try {
            String requete = "SELECT nom FROM  terrain";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                terrain.getItems().addAll(rs.getString("nom"));

            }
          
        } 
        
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
            try {
            String requete = "SELECT temps FROM  temps";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                temps.getItems().addAll(rs.getString("temps"));

            }
          
        } 
        
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
               
            
            
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
         String Terrain=terrain.getValue();
         String Temps=temps.getValue();
         LocalDate resdate= date.getValue();
         String p= txtprix.getText();
       evenement e = new evenement(22,Terrain,resdate,Temps,p);
           
           evenementCRUD pcd= new   evenementCRUD();
           LocalDate d= pcd.date();
           String s=pcd.temps();
           if(!d.isEqual(resdate)||(!s.equals(Temps)))
           {
                 pcd.addEvenement(e);
            JOptionPane.showMessageDialog(null, "Reservation ajouté");
           
           }
           
       if(d.isEqual(resdate)&&(s.equals(temps)))
       {
           JOptionPane.showMessageDialog(null, "Reservation refuse");
       }
           
         
       
    }



    private void affiche(ActionEvent event) {
           String id = b.getText();
        Integer id1 = Integer.parseInt(id);
        
          evenementCRUD pcd= new   evenementCRUD();

        aaaa.setText(pcd.rechercherres(id1).getTerrain());

   aaaaa.setValue((pcd.rechercherres(id1).getDate()));
                c.setText(pcd.rechercherres(id1).getTemps());


    }


    @FXML
    private void prixcalcule(ActionEvent event) {
        String s=terrain.getValue();
        if(s.equals("T1"))
        {
            txtprix.setText("70");
    }
          if(s.equals("T2"))
        {
            txtprix.setText("90");
    }
              if(s.equals("T3"))
        {
            txtprix.setText("120");
    }
          
    }

    private void recherche(MouseEvent event) {
     
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
    private void buttonaffiche(ActionEvent event) {
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
            Stage stage1 = (Stage) txtprix.getScene().getWindow();
            stage1.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
