/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.services;

import edu.db3a4.entities.Equipe;
import edu.db3a4.gui2.DisplayPersonController;
import edu.db3a4.interfaces.IEquipe;
import edu.db3a4.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Tarek
 */
public class EquipeCRUD implements IEquipe<Equipe>{
    public ObservableList<Equipe> observableListLocataire = FXCollections.observableArrayList();
    
    @Override
    public void ajouterEquipe(Equipe e) {
        try {
            String requete = "INSERT INTO equipe (nom_Equipe,nbr_Joueurs_Equipe,nbr_Points_Equipe,nbr_Prix_Equipe,date_Equipe,Classement_Equipe)"
                    + "VALUES ('"+e.getNom_Equipe()+"','"+e.getNbr_Joueurs_Equipe()+"','"+e.getNbr_Points_Equipe()+"','"+e.getNbr_Prix_Equipe()+"','"+e.getDate_Equipe()+"','"+e.getClassement_Equipe()+"')";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Equipe ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
        public void supprimerEquipe(Integer id_Equipe) {
        try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("DELETE FROM equipe WHERE id_Equipe = " + id_Equipe + ";");
            pst.executeUpdate();
            System.out.println("equipe supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        @Override  
        public void updateEquipe(Integer id_Equipe, String nomE, Integer nbr_j_Equipe,Integer nbr_p_Equipe, Integer nbr_pr_Equipe , LocalDate date, Integer classement_E) {
            try {
                PreparedStatement pst = MyConnection.getInstance().getCnx()
                        .prepareStatement("UPDATE equipe SET nom_Equipe = '"+nomE+"', nbr_Joueurs_Equipe = '"+nbr_j_Equipe+"', nbr_Points_Equipe = '"+nbr_p_Equipe+"', nbr_Prix_Equipe = '"+nbr_pr_Equipe+"', date_Equipe = '"+date+"' , Classement_Equipe = '"+classement_E+"' WHERE id_Equipe = '"+id_Equipe+"'");
                pst.executeUpdate();
                System.out.println("Equipe modifiée");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    @Override
    public ObservableList<Equipe> displayEquipe() {
          try {
            
            String requete = "SELECT * from equipe";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                
                observableListLocataire.add( new Equipe(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate(),rs.getInt(7)));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(DisplayPersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
        
    }
 
//        @Override
//     public ObservableList<Equipe> rechercheEquipe(int id_Equipe) {
//  try {
//            
//            String requete = "SELECT * from equipe WHERE id_Equipe = " + id_Equipe + ";";
//            Statement st;
//            st = MyConnection.getInstance().getCnx()
//                    .createStatement();
//             ResultSet rs =  st.executeQuery(requete);
//            while(rs.next()){
//                
//                observableListLocataire.add( new Equipe(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate(),rs.getInt(7)));
//            }
//            }
//         catch (SQLException ex) {
//            Logger.getLogger(DisplayPersonController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          
//          return observableListLocataire;
//    }
     
//    @Override
//     public Equipe rechercheEquipe(int id ) {
//                Equipe p = new Equipe();
//
//         try {
//          String requete = "SELECT * FROM equipe WHERE id_Equipe = " + id + ";";
//            Statement st = MyConnection.getInstance().getCnx()
//                    .createStatement();
//            ResultSet rs =  st.executeQuery(requete);
//            while(rs.next()){
//                p.set_id_Equipe(rs.getInt("id_Equipe"));
//                p.set_nom_Equipe(rs.getString(2));
//                p.set_nbr_Joueurs_Equipe(rs.getInt(3));
//                p.set_nbr_Points_Equipe(rs.getInt(4));
//                p.set_nbr_Prix_Equipe(rs.getInt(5));
//                p.set_date_Equipe(rs.getDate(6).toLocalDate());
//                p.set_Classement_Equipe(rs.getInt(7));
//                
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return p;
//    }
    
@Override
   public List<Equipe> rechercheEquipe(int id) {
        List<Equipe> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM equipe where id_Equipe='"+id+"'" ;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Equipe(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate(),rs.getInt(7)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
   
   public Equipe rechercheEquipe2(int id) {
         Equipe p = new Equipe();

        try {
            String requete = "SELECT * FROM equipe where id_Equipe='"+id+"'" ;
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                p.set_id_Equipe(rs.getInt("id_Equipe"));
                p.set_nom_Equipe(rs.getString(2));
                p.set_nbr_Joueurs_Equipe(rs.getInt(3));
                p.set_nbr_Points_Equipe(rs.getInt(4));
                p.set_nbr_Prix_Equipe(rs.getInt(5));
                p.set_date_Equipe(rs.getDate(6).toLocalDate());
                p.set_Classement_Equipe(rs.getInt(7));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return p;
    }
     
    @Override
    public List<Equipe> trier_Equipe() {
        List<Equipe> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Equipe " + " ORDER BY Classement_Equipe ASC";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Equipe(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDate(6).toLocalDate(),rs.getInt(7)));

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        System.out.println("La table exercice a été triée");

        return list;
       }
    
      public int Moyenne_nombre_joueurs() {

        int i = 0;
        String requete = "SELECT AVG(nbr_Joueurs_Equipe) as n FROM equipe";

        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                i = rs.getInt("n");
                System.out.println("la moyenne de nombre des joueurs par equipe est " + i);

            }
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        return i;
    }
   
}


