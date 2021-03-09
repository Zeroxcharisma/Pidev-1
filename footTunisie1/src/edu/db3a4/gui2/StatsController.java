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
public class StatsController implements Initializable {

    @FXML
    private TableView<Resultat> tr;
    @FXML
    private TableColumn<Resultat,Integer> cid;
    @FXML
    private TableColumn<Resultat,String> ce1;
    @FXML
    private TableColumn<Resultat,String> ce2;
    @FXML
    private TableColumn<Resultat,Integer> cs1;
    @FXML
    private TableColumn<Resultat,Integer> cs2;
    @FXML
    private TableColumn<Resultat, Integer> note;
    @FXML
    private TableColumn<?, ?> dmtache;
    @FXML
    private TableColumn<Resultat,String> ga;
    @FXML
    private TableColumn<Resultat,Integer> carton;
    @FXML
    private TableColumn<Resultat,Integer> occ;
    @FXML
    private Button en2;
    @FXML
    private ComboBox<String> equipe;
    @FXML
    private TextField noteequipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String requete = "SELECT nom_equipe FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                equipe.getItems().addAll(rs.getString("nom_equipe"));
                      
                        
                         
                           
        
                   
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
        // TODO
    }    

    @FXML
    private void tabv(MouseEvent event) {
    }

    @FXML
    private void test(MouseEvent event) {
    }

    @FXML
    private void englishaff(ActionEvent event) {
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
              
    noteequipe.setText(String.valueOf(notefinal));
         
         
        
    }

    @FXML
    private void stats(ActionEvent event) throws IOException {
       try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("statistique.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
    
}
