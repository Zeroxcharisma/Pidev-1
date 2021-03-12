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

/**
 *
 * @author hedii
 */
public class JoueurCrud extends UserCrud implements IUSER <User,String>{

    @Override
    public String ajouterUser(User u,String role) {
        try {
                  
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(super.ajouterUser(u,role));
            pst.setInt(1,u.getIdentifiant());
            pst.setString(2, u.getNom());
            pst.setString(3, u.getPrenom());
            pst.setString(4, u.getAdresse());
            pst.setString(5,u.getEmail());
            pst.setString(6,u.getPseudo());
            pst.setString(7,u.getPassword());
            pst.setInt(8,u.getList_Message());
            pst.setInt(9,u.getNum_Tel());
            pst.setInt(10,u.getCin());
            pst.setString(11,role);
            pst.setNull(12,0);
            
            pst.executeUpdate();
            System.out.println("Joueur inseré");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
       
       return role;
    
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
    

    @Override
    public void updateUser(User u) {
        
       try {
            String requete = "UPDATE User SET Nom=?,Prenom=?,Email=?,Pseudo=?,Password=? WHERE Identifiant=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            
            pst.setString(1,u.getNom());
            pst.setString(2,u.getPrenom());
            pst.setString(3,u.getEmail());
            pst.setString(4,u.getPseudo());
            pst.setString(5,u.getPassword());
            pst.setInt(6,u.getIdentifiant());

            
            pst.executeUpdate();
            System.out.println("User modifié");
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
            List<User> UserList = new ArrayList<>();
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
    
}
