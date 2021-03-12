/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui;

import com.sun.java.swing.plaf.windows.resources.windows;
import edu.db3a4.services.UserCrud;
import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author hedii
 */
public class DesactiverController  implements Initializable{
          @FXML
    private TextField tf_Pseudo;

    @FXML
    private PasswordField pf_Password;

    @FXML
    private Button Btn_Valider;
      @FXML
    private Label Lb_Message;
    @FXML
    private AnchorPane root;
     private Parent fxml;

     
     
      private int Recuperer_Identifiant(String Ch)
        {
            int Id=0;
             try {
            String requete = "SELECT Identifiant FROM User WHERE Pseudo=? OR Email=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Ch);
            pst.setString(2,Ch);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
                Id=Res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       return Id;
        }
    @FXML
    void Desactiver(ActionEvent event)
    {
        // sitoutes les conditions valides 
        //faire appela la fonction suuprimer
        String Pseudo = tf_Pseudo.getText();
        String Password = pf_Password.getText();
            
            if(Test_Vide(Pseudo, Password))
            {Lb_Message.setText("");
                int n = JOptionPane.showConfirmDialog(null,"Voulez Vous vraiment Desactiver votre compte ","Confirmer",JOptionPane.YES_NO_OPTION);

                if(n == JOptionPane.YES_OPTION)
                {int x =Verifier_Pseudo_Email(Pseudo, Password);
                if(x!=0)
                {
                    
                    UserCrud Uc= new UserCrud();
                    Uc.supprimerUser_Id(x);
                    Uc.supprimerAmi(x);
                    Uc.supprimerDemande_Desac(x);
                    
                    root.getScene().getWindow().hide();
                    Stage home = new Stage();
                    try{
                            fxml =FXMLLoader.load(getClass().getResource("Main.fxml"));
                            Scene sc = new Scene(fxml);
                            sc.setFill(Color.TRANSPARENT);
                            home.setScene(sc);
                            home.initStyle(StageStyle.TRANSPARENT);
                            home.show();
                           
        
                        }
                     catch(IOException ex)
                        {ex.printStackTrace();}
                }
                 else
                    {
                        //PopUp_Warning("Inexistant ","Veuillez verifier Vos infromations !");
                        Lb_Message.setText("Merci de bien verifier vos infromtions !");
                    }
            }
         }
               
     }
    
     public boolean Test_Vide(String Pseudo,String Password)
    {
         String Vide="";
          
          if(Pseudo.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Pseudo";
                Lb_Message.setText(Vide);
                return false ;
            }
          else  if(Password.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Password";
                Lb_Message.setText(Vide);
                return false ;
            }
          return true;
    }
      public void PopUp_Confirmation(String erreur,String Contenu)
    {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(erreur);
        alert.setHeaderText(null);
        alert.setContentText(Contenu);
        alert.showAndWait();
    } 
   
   public void PopUp_Warning(String erreur,String Contenu)
    {
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle(erreur);
        alert.setHeaderText(null);
        alert.setContentText(Contenu);
        alert.showAndWait();
    }
 
    private int Verifier_Pseudo_Email(String Chaine,String Password)
    {
        int exsist=0;
        
        try {
            String requete = "SELECT Identifiant FROM User WHERE  (Pseudo=? OR Email =?) AND Password =? ";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Chaine);
            pst.setString(2,Chaine);
            pst.setString(3,Password);

            
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
                exsist=Res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
        return exsist;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
