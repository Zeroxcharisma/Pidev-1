/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.services;

import edu.db3a4.entities.User;
import edu.db3a4.interfaces.IUSER;
import edu.db3a4.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hedii
 */
public class UserCrud implements IUSER <User,String>{
    
    @Override
    public String ajouterUser(User u,String role) {
       
            String requete = "INSERT INTO User(Identifiant,Nom,Prenom,Adresse,Email,Pseudo,Password,List_Message,Num_Tel,Cin,Role,Rib)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
           
            
         return requete;
    }

    @Override
    public void supprimerUser(User u) {
       try {
            String requete = "DELETE FROM User where Identifiant=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,u.getIdentifiant());
            pst.executeUpdate();
            System.out.println("uoueur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerUser_Id(int Id) {
       try {
            String requete = "DELETE FROM User where Identifiant=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Id);
            pst.executeUpdate();
            System.out.println("Joueur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerAmis_Id(int Id) {
       try {
            String requete = "DELETE FROM list_Amis where Identifiant_Ami=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Id);
            pst.executeUpdate();
            System.out.println("Joueur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerDemande_Id(int Id) {
       try {   
            String requete = "DELETE FROM list_demande where Identifiant_Source=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Id);
            pst.executeUpdate();
            System.out.println("Joueur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void supprimerDemande_Desac(int Id) {
       try {   
            String requete = "DELETE FROM list_demande where Identifiant_Source=? OR Identifiant_Destination ";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1,Id);
            pst.executeUpdate();
            System.out.println("Joueur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public void supprimerAmi(int Id) {
       try {
            String requete = "DELETE FROM list_Amis where Identifiant_User=? OR Identifiant_Ami=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             pst.setInt(1,Id);
             pst.setInt(2,Id);
            pst.executeUpdate();
            System.out.println("Joueur supprimé Ami"+Id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void ajouter_Ami(int Id_User,int Id_Ami)
    {
         try {
            String requete = "INSERT INTO List_Amis(Identifiant_User,Identifiant_Ami)VALUES(?,?)";

            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);           
            pst.setInt(1,Id_User);
            pst.setInt(2,Id_Ami);
            pst.executeUpdate();
            System.out.println("Ami Ajouté");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void Demande_Ami(int Id_User,int Id_Destination)
    {
         try {
            String requete = "INSERT INTO List_Demande(Identifiant_Source,Identifiant_Destination)VALUES(?,?)";

            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);           
            pst.setInt(1,Id_User);
            pst.setInt(2,Id_Destination);
            pst.executeUpdate();
            System.out.println("Demande Envoyé ");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateUser(User u) {
        
        try {
            String requete = "UPDATE User SET Identifiant=?,Nom=?,Prenom=?,Adresse=?,Email=?,Pseudo=?,Password=?,List_Message=?,Num_Tel=? WHERE Identifiant=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            
            pst.setInt(1, u.getIdentifiant());
            pst.setString(2,u.getNom());
            pst.setString(3,u.getPrenom());
            pst.setString(4,u.getAdresse());
            pst.setString(5,u.getEmail());
            pst.setString(6,u.getPseudo());
            pst.setString(7,u.getPassword());
            pst.setInt(8,u.getList_Message());
            pst.setInt(9,u.getNum_Tel());
            pst.setInt(10,u.getIdentifiant());

            
            pst.executeUpdate();
            System.out.println("uoueur modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }

    /**
     *
     * @return
     */
    @Override
    public List<User> displayUsers() {
            List<User> UserList = new ArrayList<>();FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM User";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                User u = new User();
                u.setIdentifiant(rs.getInt("Identifiant"));
                u.setNum_Tel(rs.getInt("Num_Tel"));
                u.setList_Message(rs.getInt("List_Message"));
                
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setPseudo(rs.getString("Pseudo"));
                u.setAdresse(rs.getString("Adresse"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));
                
                UserList.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return UserList;
    }
    
    public ObservableList<User> GetUsers() {
            ObservableList<User> UserList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT Nom,Prenom,Email,Pseudo,Adresse,Cin,Num_Tel FROM User WHERE ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                /*
                User u = new User();
                
                
                u.setNom(rs.getString("Nom"));
                u.setPrenom(rs.getString("Prenom"));
                u.setEmail(rs.getString("Email"));
                u.setPseudo(rs.getString("Pseudo"));
                u.setAdresse(rs.getString("Adresse"));
                u.setIdentifiant(rs.getInt("Cin"));
                u.setNum_Tel(rs.getInt("Num_Tel"));
                 UserList.add(u);
                */
                    
                User u = new User(rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Email"), rs.getString("Pseudo"), rs.getString("Adresse"), rs.getInt("Cin"), rs.getInt("Num_Tel"));
                UserList.add(u);

               
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return UserList;
    }
}
