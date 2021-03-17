/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui;

import edu.db3a4.entities.Joueur;
import edu.db3a4.entities.Organisateur;
import edu.db3a4.services.JoueurCrud;
import edu.db3a4.services.OrganisateurCrud;
import edu.db3a4.tools.MyConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
/**
 *
 * @author hedii
 */
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class ProfilController implements Initializable {

    
    @FXML
    private Label Lb_Message;

    @FXML
    private ImageView IMG_PDP;

    @FXML
    private TextField tf_FirstName;

    @FXML
    private TextField tf_LastName;

    @FXML
    private TextField tf_Email;

    @FXML
    private TextField tf_Pseudo;

    @FXML
    private TextField tf_Password;

    @FXML
    private Button Btn_Valider;

    @FXML
    private TextField tf_Adresse;

    @FXML
    private TextField tf_Cin;

    @FXML
    private TextField tf_Tel;

    @FXML
    private TextField tf_Rib;

    
    @FXML
    void Valider(ActionEvent event) {
        
        
        String Res_FirstName = tf_FirstName.getText();
        String Res_LastName = tf_LastName.getText();
        String Res_Email = tf_Email.getText();
        String Res_Pseudo= tf_Pseudo.getText();
        String Res_Adresse=tf_Adresse.getText();
        String Res_Password= tf_Password.getText();
        int Res_Cin=Integer.parseInt(tf_Cin.getText());
        int Res_Tel=Integer.parseInt(tf_Tel.getText());
        int Res_Rib=Integer.parseInt(tf_Rib.getText());
       
        if(Test_Vide(Res_FirstName, Res_LastName, Res_Email, Res_Pseudo, Res_Adresse, Res_Password, tf_Cin.getText(), tf_Tel.getText(),tf_Rib.getText()))
        {  
            if(Verifier_Email(Res_Email))
            {
                if((Chercher_Email(Res_Email)== false)&&(Chercher_Pseudo(Res_Pseudo)== false))
                    {   
                        Lb_Message.setText("");
                        if(Test_Role().equals("Organisateur"))
                        {  
                            Organisateur O = new Organisateur(Recuperer_Identifiant(),Res_FirstName, Res_LastName,Res_Adresse, Res_Email, Res_Pseudo, Res_Password, Res_Tel, Res_Cin, Res_Rib);
                            OrganisateurCrud OC= new OrganisateurCrud();
                            OC.updateUser(O);
                        }
                        else
                        {   
                             Joueur J =new Joueur(Recuperer_Identifiant(),Res_FirstName, Res_LastName,Res_Adresse, Res_Email, Res_Pseudo, Res_Password, Res_Tel, Res_Cin);
                             JoueurCrud JC = new JoueurCrud();
                             JC.updateUser(J);
                        }
               
                  
                    PopUp_Confirmation("Success", "Réussite de la mise à jour du Modification !");
            }}
           
        }
    }
    public boolean Verifier_Email(String Email)
    {
        Pattern P=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher M=P.matcher(Email);
        if(M.find() && M.group().equals(Email))
                {
                   return true; 
                }
                else{
                    Lb_Message.setText("Email n'est pas valide !");
                     //PopUp_Warning("Email Incorrect", "Vous devez Choisir Email Bein saisi");
                    }
        return false;
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
    public String  Test_Role()
    {
        
        String Psd=Recuper_Pseudo();
        String role="";
        try{
        
            String requete = "SELECT Role FROM User WHERE Pseudo='"+Psd+"' OR Email='"+Psd+"'";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet Res;
            Res=st.executeQuery(requete);
            while(Res.next())
            {
                role=Res.getString(1);
            }
            
            } 
        catch(SQLException ex) 
        {System.out.println(ex.getMessage());}
        return role;
    }
    public void Recupere_ligne() // me permet d'affciher les valeurs dans les TextFields
    {
        String Psd=Recuper_Pseudo();
        try{
        
            String requete = "SELECT Nom,Prenom,Email,Pseudo,Password,Cin,Num_Tel,Rib FROM User WHERE Pseudo='"+Psd+"'OR Email='"+Psd+"'";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet Res;
            Res=st.executeQuery(requete);
            while(Res.next())
            {
                tf_FirstName.setText(Res.getString(1));
                tf_LastName.setText(Res.getString(2));
                tf_Email.setText(Res.getString(3));
                tf_Pseudo.setText(Res.getString(4));
                tf_Password.setText(Res.getString(5));
                tf_Cin.setText(String.valueOf(Res.getInt(6)));
                tf_Tel.setText(String.valueOf(Res.getInt(7)));
                tf_Rib.setText(String.valueOf(Res.getInt(8)));
            }
            } 
        catch(SQLException ex) 
        {System.out.println(ex.getMessage());}
    }
    public String Recuper_Pseudo()//Recuperer le Pseudo sauvegarder dans le fichier
    {   String Pseudo="";
    try{
    String Nom_Fichier="Pseudo.txt";
    File file = new File(Nom_Fichier);
    Scanner sc = new Scanner(file);
    while(sc.hasNextLine())
    {
        Pseudo=sc.nextLine();
    }
    
    }catch(FileNotFoundException ex){}
        return Pseudo;
    }
    public boolean Chercher_Pseudo(String Pseudo)
    {
        boolean valide=false;
         int Id=Recuperer_Identifiant();
        try {
            String requete = "SELECT Pseudo FROM User WHERE Pseudo=? AND Identifiant !=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Pseudo);
            pst.setInt(2,Id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
                valide=true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if(valide==true )
        {Lb_Message.setText("Pseudo deja exsitant !! ");}
        return valide;     
 }
        private int Recuperer_Identifiant()
        {
            int Id=0;
             try {
            String requete = "SELECT Identifiant FROM User WHERE Pseudo=? OR Email=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Recuper_Pseudo());
            pst.setString(2,Recuper_Pseudo());
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
        private boolean Chercher_Email(String Email)
    {   
        boolean valide=false;
        int Id=Recuperer_Identifiant();
        try {
            String requete = "SELECT Email FROM User WHERE Email=? AND Identifiant !=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Email);
            pst.setInt(2,Id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
                valide=true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if(valide==true )
        {Lb_Message.setText("Email deja exsitant ! ");}
        return valide;     
 }
         private boolean Test_Vide(String Res_FirstName ,String Res_LastName ,String Res_Email ,String Res_Pseudo,String Res_Adresse,String Res_Password,String Res_Cin,String Res_Tel,String Res_Rib)
    {
         String Vide="";
          
          if(Res_FirstName.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Nom";
                Lb_Message.setText(Vide);
                return false ;
            }
          else  if(Res_LastName.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Prenom";
                Lb_Message.setText(Vide);
                return false ;
            }
          else  if(Res_Email.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Email";
                Lb_Message.setText(Vide);
                return false ;
            }
          else  if(Res_Pseudo.isEmpty()==true)
            {
                Vide="Vous devez Choisir Un Pseudo";
                Lb_Message.setText(Vide);
                return false ;    
            }
          else  if(Res_Password.isEmpty()==true)
            {
                Vide="Vous devez saisir Un Mot de Passe";
                Lb_Message.setText(Vide);
                return false ;
            }
       
          
          else  if(Res_Cin.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Numero de Cin";
                Lb_Message.setText(Vide);
                return false ;
            }
          else  if(Res_Tel.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Numero de Telpohnne";
                Lb_Message.setText(Vide);
                return false ;
            }
           else  if(Res_Rib.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Rib";
                Lb_Message.setText(Vide);
                return false ;
            }

          
          
       return true;   
        
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Recupere_ligne();
        if(Test_Role().equals("Organisateur"))
        {tf_Rib.setVisible(false);}
        else{tf_Rib.setVisible(true);}

    }
    
    
    
    
}
