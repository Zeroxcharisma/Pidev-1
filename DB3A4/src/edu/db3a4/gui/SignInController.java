/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui;

import edu.db3a4.tools.MyConnection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hedii
 */
public class SignInController implements Initializable{
    @FXML
    private TextField tf_Pseudo;
    @FXML
    private PasswordField pf_Password;
    @FXML
    private Button Btn_connecter;
    @FXML
    private Label MessageLabel;
    @FXML
    private VBox vbox;
    private Parent fxml;
    
    @FXML
    void openHome() throws IOException {
        String Psd = tf_Pseudo.getText();
        String Pwd = pf_Password.getText();
        if(Verifer_Access(Psd,Pwd)==true)
        {
            Sauvegarder_Pseudo(Psd);
            vbox.getScene().getWindow().hide();
            Stage home = new Stage();
            try{
            fxml =FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene sc = new Scene(fxml);
                home.setScene(sc);
                home.show();
            }catch(IOException ex){ex.printStackTrace();}
        }
        else
        {
                Test_Vide(tf_Pseudo.getText(),pf_Password.getText());
        }
    }
    public int recuperer_id(String Psd)
    {
        int id=0; 
    

        try{
        
            String requete = "SELECT Identifiant FROM User WHERE Pseudo='"+Psd+"'";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet Res;
            Res=st.executeQuery(requete);
            while(Res.next())
            {
                id=Res.getInt(1);
                
            }
            } 
        catch(SQLException ex) 
        {System.out.println(ex.getMessage());}
    
        return id;
    }
    public boolean Verifer_Access(String Pseudo,String Password)
    {
        boolean valide=false;
        try {
            String requete = "SELECT Pseudo,Password FROM User WHERE (Pseudo=? OR Email=?) AND Password=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Pseudo);
            pst.setString(2,Pseudo);
            pst.setString(3,Password);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
                valide=true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return valide;
    }
    public void Test_Vide(String Login,String Pwd)
    {
          String Vide="";
         if(Login.isEmpty()==false && Pwd.isEmpty()==false)
        {
            Vide="Verifier de vos infromations ";
        }
        
         else if(Login.isEmpty()==true && Pwd.isEmpty()==false)
        {
            Vide="Vous devez Taper votre Propre Pseudo/Email !";
        }
         else if(Login.isEmpty()==false && Pwd.isEmpty()==true)
        {
            Vide="Vous devez Taper votre Mot de Passe !";
        }
         else if(Login.isEmpty()==true && Pwd.isEmpty()==true)
        {
            Vide="Vous devez saisir vos infromations !";
        }
         
           MessageLabel.setText(Vide);   
        
          
    }
    public void Sauvegarder_Pseudo(String Pseudo)
    {
        try{
            String Nom_Fichier="Pseudo.txt";
            File file = new File(Nom_Fichier);
            
            if (!file.exists()) 
                {file.createNewFile();}
            PrintWriter writer = new PrintWriter( new FileWriter(Nom_Fichier) );

            writer.write(Pseudo);
            writer.close();
        
        }catch(IOException EX){}
        
    }
  
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
   

}
