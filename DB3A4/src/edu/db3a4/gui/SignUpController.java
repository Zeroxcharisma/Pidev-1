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
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


/**
 *
 * @author hedii
 */
public class SignUpController  implements Initializable {
 
    
    @FXML
    private VBox vbox;

    @FXML
    private TextField tf_FirstName;

    @FXML
    private TextField tf_LastName;

    @FXML
    private TextField tf_Email;

    @FXML
    private TextField tf_Pseudo;

    @FXML
    private PasswordField pf_Password;

    @FXML
    private Button Btn_Generer;

    @FXML
    private TextField tf_Adresse;

    @FXML
    private TextField tf_Cin;

    @FXML
    private TextField tf_Tel;

    @FXML
    private CheckBox Check_Organisateur;

    @FXML
    private TextField tf_Rib;

    @FXML
    private Button Btn_inscrire;

    @FXML
    private Label LabelMessage;

    @FXML
    private Label lb_Generator;

    @FXML
    void Checked(ActionEvent event) {
        if(Check_Organisateur.isSelected())
        {
            tf_Rib.setVisible(true);
             
        }
        else
        {
            tf_Rib.setVisible(false);
             
        }
    }


    @FXML
    private void Genere(ActionEvent ecent)
    {
        
        String ch=Generer_Chaine();
        LabelMessage.setText("Votre Mot de Passe Generer est : "+ch);
        pf_Password.setText(ch);
        
    }
    @FXML
    private void addUser(ActionEvent event) 
    {
        String Res_FirstName = tf_FirstName.getText();
        String Res_LastName = tf_LastName.getText();
        String Res_Email = tf_Email.getText();
        String Res_Pseudo= tf_Pseudo.getText();
        String Res_Adresse= tf_Adresse.getText();
        String Res_Password= pf_Password.getText();
        
        if(Test_Vide(Res_FirstName, Res_LastName, Res_Email, Res_Pseudo, Res_Adresse, Res_Password, tf_Cin.getText(), tf_Tel.getText()))
        {
            if(((Valider_Nb(tf_Cin.getText())!=0)||(tf_Cin.getText().length()!=8)))
                {LabelMessage.setText("Le Cin doit etre composé de 8 chiffres ");}
            else if((Valider_Nb(tf_Tel.getText())!=0)||(tf_Tel.getText().length()!=8))
                {LabelMessage.setText("Le Numero de Telphone doit etre composé de 8 chiffres ");}
            else if(Valider_Email(Res_Email)==false)
                 {LabelMessage.setText("Email n'est pas valide !");}
            else if (Valider_MDP(Res_Password)==true){LabelMessage.setText("Mot de passe doit etre Composer par au moins {1Minus,1Majus,1Chiffre}");}
            else
                {           int Res_Cin=Integer.parseInt(tf_Cin.getText());
                            int Res_Tel=Integer.parseInt(tf_Tel.getText());
                 if(Verifer_Access(Res_Pseudo,Res_Email,Res_Cin,Res_Tel)==false)
                    {
                       if(Check_Organisateur.isSelected())
                        { //testvide 
                          
                            // Propre seulment a l'Organisateur
                            
                            int Res_Rib=Integer.parseInt(tf_Rib.getText());
                            
                            if((Valider_Nb(tf_Rib.getText())!=0)||(tf_Rib.getText().length()!=8))
                                   {LabelMessage.setText("Le Rib doit etre composé de 20 chiffres ");}
                            else
                                {
                                    LabelMessage.setText("");
                                    Organisateur O = new Organisateur(Generer_Identifiant()+1,Res_FirstName,Res_LastName,Res_Adresse,Res_Email,Res_Pseudo,Res_Password,1,Res_Tel,Res_Cin,Res_Rib);
                                    OrganisateurCrud OC = new OrganisateurCrud();
                                    OC.ajouterUser(O,"Organisateur");
                                }
                            
                        }
                       
                        else
                        {   
                            LabelMessage.setText("");
                            
                            Joueur J =new Joueur(Generer_Identifiant()+1,Res_FirstName,Res_LastName,Res_Adresse,Res_Email,Res_Pseudo,Res_Password,1,Res_Tel,Res_Cin);
                            JoueurCrud JC = new JoueurCrud();
                            JC.ajouterUser(J, "Simple Joueur");
                        }
                    }
                }
            }
        }
        public boolean Valider_Email(String Email)
    {
        Pattern P=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher M=P.matcher(Email);
        if(M.find() && M.group().equals(Email))
                {
                   return true; 
                }
               /* else{
                     //PopUp_Warning("Email Incorrect", "Vous devez Choisir Email Bein saisi");
                    }*/
        return false;
    }
      public int Verifier_Tel(int Tel)
    {
        int exsist=0;
        try {
            String requete = "SELECT Num_Tel FROM User WHERE Num_Tel=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Tel);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
                {exsist=1;}
            
        } catch (SQLException ex) 
                {System.out.println(ex.getMessage()); }
    return exsist;
    }

        public int Verifier_Cin(int Cin)
    {
        int exsist=0;
        try {
            String requete = "SELECT Cin FROM User WHERE Cin=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Cin);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
                {exsist=1;}
            
        } catch (SQLException ex) 
                {System.out.println(ex.getMessage()); }
    return exsist;
    }
            
    public int Verifier_Pseudo(String Pseudo)
    {
        int exsist=0;
        try {
            String requete = "SELECT Pseudo FROM User WHERE Pseudo=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Pseudo);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
                {exsist=1;}
            
        } catch (SQLException ex) 
                {System.out.println(ex.getMessage()); }
    return exsist;
    }
    public int Verifier_Email(String Email)
    {
        int exsist=0;
        try {
            String requete = "SELECT Email FROM User WHERE Email=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Email);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
                {exsist=1;}
           }catch (SQLException ex) 
                    {System.out.println(ex.getMessage());}
    return exsist;
    }
   public boolean Verifer_Access(String Pseudo,String Email,int Cin,int Tel ) // cette fonction permet de verifier l'existance du mail ou PSeudo 
    {
        boolean valide=false;
       
        if(Verifier_Pseudo(Pseudo)!=0)
            { LabelMessage.setText("Pseudo exsiste deja !");  return true;}
        if(Verifier_Email(Email)!=0)
            {LabelMessage.setText("Email exsiste deja !");  return true ;}
         if(Verifier_Cin(Cin)!=0)
            {LabelMessage.setText("Cin exsiste deja !");  return true ;}
          if(Verifier_Tel(Tel)!=0)
            {LabelMessage.setText("Tel exsiste deja !");  return true ;}
         
    return valide;
    }
         private boolean Test_Vide(String Res_FirstName ,String Res_LastName ,String Res_Email ,String Res_Pseudo,String Res_Adresse,String Res_Password,String Res_Cin,String Res_Tel)
    {
          String Vide;
          
          if(Res_FirstName.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Nom";
                LabelMessage.setText(Vide);
                return false ;
            }
          else  if(Res_LastName.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Prenom";
                LabelMessage.setText(Vide);
                return false ;
            }
          else  if(Res_Email.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Email";
                LabelMessage.setText(Vide);
                return false ;
            }
          else  if(Res_Pseudo.isEmpty()==true)
            {
                Vide="Vous devez Choisir Un Pseudo";
                LabelMessage.setText(Vide);
                return false ;    
            }
          else  if(Res_Password.isEmpty()==true)
            {
                Vide="Vous devez saisir Un Mot de Passe";
                LabelMessage.setText(Vide);
                return false ;
            }
       
          
          else  if(Res_Cin.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Numero de Cin";
                LabelMessage.setText(Vide);
                return false ;
            }
          else  if(Res_Tel.isEmpty()==true)
            {
                Vide="Vous devez saisir Votre Numero de Telpohnne";
                LabelMessage.setText(Vide);
                return false ;
            }

          
       return true;   
    }
   
    public boolean Valider_MDP(String Mdp)
    {
        if((Compter_NB_MAJUS(Mdp)>1) &&(Compter_NB_MINUS(Mdp)>1)&& (Compter_NB_CHIFFRES(Mdp)>1))
        {
            return true ;
        }
        return false;
    }
     public int Compter_NB_MAJUS(String Mdp)
    {
       int Cpt=0,i;
	
	for(i=0;i<Mdp.length();i++)
	{
		if(Character.isUpperCase(Mdp.charAt(i)))
			{Cpt++;}
		
	}
        return Cpt;
    }
     
    public int Compter_NB_MINUS(String Mdp)
    {
        int Cpt=0,i;
	
	for(i=0;i<Mdp.length();i++)
	{
		if(Character.isLowerCase(Mdp.charAt(i)))
			{Cpt++;}
		
	}
        return Cpt;
    }
         
    public int Compter_NB_CHIFFRES(String Mdp)
    {
        int Cpt=0,i;
    
        for(i=0;i<Mdp.length();i++)
        {
            if ( Mdp.charAt(i)>='0' && Mdp.charAt(i)<='9')
      		{Cpt++;}		
	}
        return Cpt;
    }
    
   
private int Valider_Nb(String Ch)//Compter Nombres des lettres
{
    int Cpt=0;
    int i=0;
    
    for(i=0;i<Ch.length();i++)
        {
         if ( Character.toUpperCase(Ch.charAt(i)) >= 'A' && Character.toUpperCase(Ch.charAt(i)) <= 'Z')
      		{Cpt++;}		
	}
    return Cpt;
}    


 private String Generer_Chaine()//GENERER UN MDP
 {
        Random rand = new Random();
        String alphabet = "abcd12350123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int longueur = alphabet.length();
        String ch = "";
        for(int i = 0; i <8; i++) 
        {
            int k = rand.nextInt(longueur);
            ch+=alphabet.charAt(k);
        }  
        
        return ch;
 }
private int Recupere_Nombre_Enreg()
    {
        int count=0;
        try{
        
            String requete = "SELECT  COUNT(*) FROM User";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet Res;
            Res=st.executeQuery(requete);
            while(Res.next())
            {
                count=Res.getInt(1);
            }
            } 
        catch(SQLException ex) 
        {System.out.println(ex.getMessage());}
        return count ;
    }
    
    private int  Generer_Identifiant()
    {
        int x = 10000000;
        int Alea =  0 + (int)(Math.random() * ((x - 0) + 1));// Min + (int)(Math.random() * ((Max - Min) + 1)); Max= Ide ,Min =0
        
        return Alea; 
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tf_Rib.setVisible(false);
    }    

    
}