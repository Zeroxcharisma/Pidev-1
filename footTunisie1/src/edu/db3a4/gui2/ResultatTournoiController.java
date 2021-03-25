/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.services.ResultatCrud;
import edu.db3a4.services.TournoiCRUD;
import edu.db3a4.tests.MailSender;
import edu.db3a4.tests.MailSender_1;
import edu.db3a4.tools.MyConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ResultatTournoiController implements Initializable {

    @FXML
    private ComboBox<Integer> idd1;
    @FXML
    private ComboBox<Integer> scoreequipe1;
    @FXML
    private ComboBox<Integer> scoreequipe2;
    @FXML
    private TextField demifinal;
    @FXML
    private TextField demifinal2;
    @FXML
    private ComboBox<Integer> scoreequipe3;
    @FXML
    private ComboBox<Integer> scoreequipe4;
    @FXML
    private ComboBox<Integer> final1;
    @FXML
    private ComboBox<Integer> final2;
    @FXML
    private Button btnAdd;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scoreequipe1.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        scoreequipe2.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        scoreequipe3.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        scoreequipe4.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        final1.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
        final2.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);

  try {
            String requete = "SELECT * FROM  tournoi";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){ 
                                 int value = rs.getInt("scoreEq1");
                if( value == 0 )
                idd1.getItems().addAll(rs.getInt("id"));                     
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
    }    

    @FXML
    private void aJOUTERRESULTAT(ActionEvent event) {
        ResultatCrud pcd = new ResultatCrud();
        pcd.updateTournoi(idd1.getValue(),scoreequipe1.getValue() , scoreequipe2.getValue(), scoreequipe3.getValue(), scoreequipe4.getValue(), final1.getValue(), final2.getValue());
        JOptionPane.showMessageDialog(null, "Resultat tournoi  ajouté et mail envoyez au gestion des tournoi");
        
    MailSender_1 mail = new MailSender_1();
            String[] args = null;
            String a = "numero "+idd1.getValue();
             mail.main(args,a);
             
    }

    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void buttonajout(ActionEvent event) {
    }

    @FXML
    private void buttonaffiche(ActionEvent event) {
    }

    @FXML
    private void buttonstats(ActionEvent event) {
    }

    @FXML
    private void changement(ActionEvent event) {
        TournoiCRUD pcd = new TournoiCRUD();
        String[] parts =  pcd.getEquipes(idd1.getValue()).split(",");
        demifinal.setText(parts[0]+" vs "+parts[1]);
        demifinal2.setText(parts[2]+" vs "+parts[3]);
        
    }
    
}
