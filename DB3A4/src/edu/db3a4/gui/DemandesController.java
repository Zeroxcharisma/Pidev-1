/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui;

import edu.db3a4.entities.User;
import edu.db3a4.services.UserCrud;
import edu.db3a4.tools.MyConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author hedii
 */
public class DemandesController implements Initializable{
    

    @FXML
    private TextField tf_Cin;

    @FXML
    private TextField tf_Nom;

    @FXML
    private TextField tf_Tel;

    @FXML
    private TextField tf_Prenom;

    @FXML
    private Button Btn_Chercher;

    @FXML
    private TableView<User> Tab_view;

    @FXML
    private TableColumn<User, String> Cn_Nom;

    @FXML
    private TableColumn<User, String>  Cn_Prenom;

    @FXML
    private TableColumn<User, Integer>  Cn_Tel;

    @FXML
    private TableColumn<User, String>  Cn_Adresse;

    @FXML
    private TableColumn<User, String>  Cn_Email;

    @FXML
    private TableColumn<User, String>  Cn_Pseudo;

    @FXML
    private Button Btn_Annuler;

    @FXML
    private Button Btn_Accepter;

    @FXML
    private TextField tf_Adresse;

    @FXML
    private TextField tf_Pseudo;
    
    @FXML
    private AnchorPane root;
    private Parent fxml;
    
    @FXML
    private Button Btn_Supprimer;
    
    ObservableList<User> UserList = FXCollections.observableArrayList();
    ResultSet Res;

    @FXML
    void Accepter(ActionEvent event) {
            User user=Tab_view.getSelectionModel().getSelectedItem();
            UserCrud Uc =new UserCrud();
            Uc.ajouter_Ami(Recuperer_Identifiant(),Recuperer_IdAmis(user.getNum_Tel()));
            Uc.ajouter_Ami(Recuperer_IdAmis(user.getNum_Tel()),Recuperer_Identifiant());
            Uc.supprimerDemande_Id(Recuperer_IdAmis(Tab_Event()));
            
            
                 try{
                       fxml = FXMLLoader.load(getClass().getResource("Demandes.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){ex.printStackTrace();}
            
    }

    @FXML
    void Annuler(ActionEvent event) {
        User user=Tab_view.getSelectionModel().getSelectedItem();
        UserCrud Uc=new UserCrud();
        Uc.supprimerDemande_Id(Recuperer_IdAmis(Tab_Event()));
                 try{
                       fxml = FXMLLoader.load(getClass().getResource("Demandes.fxml")); 
                       root.getChildren().removeAll();
                       root.getChildren().setAll(fxml);
                }catch(IOException ex){ex.printStackTrace();}
    }
    public int Recuperer_IdAmis(int Element)
    {
        
        int Id=0;
        try {
            String requete = "SELECT Identifiant FROM User WHERE Num_Tel=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Element);
            Res=pst.executeQuery();
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
    void Chercher(ActionEvent event) {
        
            List<Integer> Identifiant_List =Recuper_Colonne();
            int i,exist=0;
            
            for(i=0;i<Identifiant_List.size();i++)
            {
                
            try{
                String requete= "SELECT Nom,Prenom,Email,Pseudo,Adresse,Cin,Num_Tel From User WHERE (Cin='"+tf_Cin.getText()+"')AND Identifiant='"+Identifiant_List.get(i)+"'";
                Statement st = MyConnection.getInstance().getCnx().createStatement();
                ResultSet rs =  st.executeQuery(requete);
                if(rs.next())
                {
                 tf_Cin.setText(String.valueOf(rs.getInt("Cin")));
                 tf_Tel.setText(String.valueOf(rs.getInt("Num_Tel")));
                 tf_Pseudo.setText(rs.getString("Pseudo"));
                 tf_Nom.setText(rs.getString("Nom"));
                 tf_Prenom.setText(rs.getString("Prenom"));
                 exist=1;
             }
        }catch(SQLException ex){ex.printStackTrace();}
        
        if(exist==0)
        {
            Alert alert= new Alert(AlertType.ERROR,"Aucun ami Trouvé avec Cin = "+tf_Cin.getText()+"");
        }
            }
    }
    
@FXML
public int Tab_Event() 
{
    if(Recupere_Nombre_Enreg()!=0)
    {
        User user=Tab_view.getSelectionModel().getSelectedItem();
       try{
            String requete= "SELECT Nom,Prenom,Email,Pseudo,Adresse,Cin,Num_Tel From User WHERE  Num_Tel='"+user.getNum_Tel()+"'";
           
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =  st.executeQuery(requete);
            if(rs.next())
            {
                tf_Cin.setText(String.valueOf(rs.getInt("Cin")));
                tf_Tel.setText(String.valueOf(rs.getInt("Num_Tel")));
                tf_Pseudo.setText(rs.getString("Pseudo"));
                tf_Adresse.setText(rs.getString("Adresse"));
                tf_Nom.setText(rs.getString("Nom"));
                tf_Prenom.setText(rs.getString("Prenom"));
            }
            }
        catch(SQLException ex)
            {ex.printStackTrace();}
       return user.getNum_Tel();
    }
    else 
        {return 0;}
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
    private int Recuperer_Identifiant()
        {
            int Id=0;
             try {
            String requete = "SELECT Identifiant FROM User WHERE Pseudo=? OR Email=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1,Recuper_Pseudo());
            pst.setString(2,Recuper_Pseudo());
            Res=pst.executeQuery();
            if(Res.next())
            {
                Id=Res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       return Id;
        }
    public List<Integer>  Recuper_Colonne()
    {
         List<Integer> Identifiant_List = new ArrayList<>();
         int Id;
             try {
            String requete = "SELECT Identifiant_Source FROM list_demande WHERE Identifiant_Destination=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Recuperer_Identifiant());
            Res=pst.executeQuery();
            while(Res.next())
            {
                Id=Res.getInt(1);
                Identifiant_List.add(Id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return Identifiant_List; 

    }
        
      public void showUser()
    {
        Tab_view.getItems().clear();
        
         List<Integer> Identifiant_List =Recuper_Colonne();
         int i;
            for(i=0;i<Identifiant_List.size();i++)
            {
            try {
                String requete = "SELECT Nom,Prenom,Email,Pseudo,Adresse,Cin,Num_Tel FROM User Where Identifiant='"+Identifiant_List.get(i)+"'";
                Statement st = MyConnection.getInstance().getCnx().createStatement();
            //st.setInt(1,Recuperer_Identifiant());
                ResultSet rs =  st.executeQuery(requete);
                while(rs.next())
                {
                    User u = new User(rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Email"), rs.getString("Pseudo"), rs.getString("Adresse"), rs.getInt("Cin"), rs.getInt("Num_Tel"));
                    UserList.add(u);
                }
            } 
            catch (SQLException ex) 
                {System.out.println(ex.getMessage());}
         }
            Cn_Nom.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
            Cn_Prenom.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
            Cn_Email.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
            Cn_Adresse.setCellValueFactory(new PropertyValueFactory<User,String>("Adresse"));
            Cn_Pseudo.setCellValueFactory(new PropertyValueFactory<User,String>("Pseudo"));
            Cn_Tel.setCellValueFactory(new PropertyValueFactory<User,Integer>("Num_Tel"));
    }   

      private int Recupere_Nombre_Enreg()
    {
        int count=0;
        try{
        
            String requete = "SELECT  COUNT(*) FROM list_demande WHERE Identifiant_Destination='"+Recuperer_Identifiant()+"'";
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showUser(); 
        Tab_view.setItems(UserList);
        
    }

}