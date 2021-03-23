/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.services;

import edu.db3a4.entities.Resultat;

import edu.db3a4.interfaces.IResultat;
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
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.util.Duration;

/**
 *
 * @author nidha
 */
public class ResultatCrud implements IResultat<Resultat> {
    public ObservableList<Resultat> observableListLocataire = FXCollections.observableArrayList();
    int i=2;


    @Override
    public void ajouterResultat(Resultat t) {
       try {
            String requete = "INSERT INTO resultat(id,equipe_1,equipe_2,score_1,score_2,note,gagant,carton,occaison)"
                    + "VALUES ('"+t.getId()+"','"+t.getNomequipe1()+"','"+t.getNomequipe2()+"','"+t.getScoreequipe1()+"','"+t.getScoreequipe2()+"','"+t.getNote()+"','"+t.getGangant()+"','"+t.getCarton()+"','"+t.getOccaison()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("resultat ajoutée");
             System.out.println(t.getNomequipe1());
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    
    
  

    @Override
    public    ObservableList<Resultat> displayPersons() {
        
         try {
            String requete = "SELECT * FROM resultat ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            observableListLocataire.add( new Resultat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));
            }
            }
         catch (SQLException ex) {
          
        }
          
          return observableListLocataire;
        
    }

    @Override
    public void supprimerResultat(Resultat t) {
        try {
           String requete = "DELETE FROM resultat where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Personne supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

  

 
    @Override
    public Resultat rechercherres(Integer id) {
         Resultat p = new Resultat();

         try {
            String requete = "SELECT * FROM resultat WHERE id = " + id + ";";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNomequipe1(rs.getString(2));
                p.setNomequipe2(rs.getString(3));
               p.setScoreequipe1(rs.getInt(4));
                p.setScoreequipe2(rs.getInt(5));
                p.setNote(rs.getInt(6));
               
                p.setGangant(rs.getString(7));
               p.setCarton(rs.getInt(8));
               p.setOccaison(rs.getInt(9));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    @Override
    public void updateResultat(Integer id, String e1, String e2, Integer sc1, Integer sc2) {
     try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE resultat SET equipe_1 = '"+e1+"', equipe_2 = '"+e2+"', score_1 = '"+sc1+"', score_2 = '"+sc2+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("Resultat modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 

    @Override
    public ObservableList<Resultat> matchjour() {
        LocalDate date=LocalDate.now();
          try {
            String requete = "SELECT *FROM resultat WHERE date_matche = "+ date+ "; ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            observableListLocataire.add( new Resultat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));
            }
            }
         catch (SQLException ex) {
          
        }
          
          return observableListLocataire;
    }

    @Override
    public ObservableList<Resultat> displayPersonss() {
       try {
            String requete = "SELECT id,equipe_1,equipe_2,max(score_1) FROM resultat ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            observableListLocataire.add( new Resultat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));
            }
            }
         catch (SQLException ex) {
         
        }
          
          return observableListLocataire;
    }

    @Override
    public int displayequipe1() {
    
       try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='CA'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
      
    }

    @Override
    public int displayequipe2() {
     try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='CAE'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
    }

    @Override
    public int displayequipe3() {
     try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='YNA'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
    }

    @Override
    public int displayequipe4() {
        try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='MKH'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
    }

    @Override
    public int displayequipe5() {
        try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='TZB'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
    }

    @Override
    public int displayequipe6() {
       try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='CAP'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
    }

    @Override
    public int displayequipe7() {
      try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='boj'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
      
    }

    @Override
    public int displayequipe18() {
        
try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='NULL'";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
    }

    @Override
    public int score1() {
        try {
            String requete = "SELECT sum(score_1) as num FROM  resultat";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
        
        
    }

    @Override
    public int score1CAE(String a) {
        try {
            String requete = "SELECT sum(score_1) as num FROM  resultat  where equipe_1='"+a+"'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
        
    }

    @Override
    public int score2CAE(String a) {
              try {
            String requete = "SELECT sum(score_2) as num FROM  resultat  where equipe_2='"+a+"'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
    }

    @Override
    public int n1CAE(String a) {
        try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where equipe_1= '"+a+"'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
    }
     
    

    @Override
    public int n2CAE(String a) {
         try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where equipe_2='"+a+"'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
    }

    @Override
    public int winner(String a) {
        try {
            String requete = "SELECT COUNT(*) as num FROM  resultat where gagant='"+a+"'; ";
            
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
                int i = rs.getInt("num");
                
                
                return i;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultatCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
          
   
        return i;
        
    }

    @Override
    public int b2e1(String a) {
         try {
            String requete = "SELECT sum(score_1) as num FROM  resultat  where equipe_2='"+a+"'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
        
    }

    @Override
    public int b1e2(String a) {
         try {
            String requete = "SELECT sum(score_2) as num FROM  resultat  where equipe_1='"+a+"'; ";
             
            
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
 
            while(rs.next() ){
               int i = rs.getInt("num");
              

                  return i; 
         
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return i;
        
       
    }
       public void updateTournoi(Integer id, Integer score1, Integer score2,Integer score3, Integer score4,Integer scoreF1,Integer scoreF2) {
     try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE tournoi SET scoreEq1 = '"+score1+"', scoreEq2 = '"+score2+"', scoreEq3 = '"+score3+"', scoreEq4 = '"+score4+"',scoreFinal1 = '"+scoreF1+"', scoreFinal2 = '"+scoreF2+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("tournoi modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 
     public    ObservableList<Resultat> TopMacthe(Integer id) {
        
         try {
              String requete = "SELECT *FROM resultat where note='"+id+"'; ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            observableListLocataire.add( new Resultat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));
            }
            }
         catch (SQLException ex) {
          
        }
          
          return observableListLocataire;
        
    }
 
    }
    

   


/**
 *
 * @author House
 */
   

