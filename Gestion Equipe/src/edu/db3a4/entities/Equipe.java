/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Tarek
 */
public class Equipe {
    
    private int id_Equipe;
    private String nom_Equipe;
    private Integer nbr_Joueurs_Equipe;
    private Integer nbr_Points_Equipe;
    private Integer nbr_Prix_Equipe;
    private LocalDate date_Equipe;
    private Integer Classement_Equipe;
    

    public Equipe(){
    }

    public Equipe(int id_Equipe, String nom_Equipe, Integer nbr_Joueurs_Equipe, Integer nbr_Points_Equipe , Integer nbr_Prix_Equipe , LocalDate date_Equipe, Integer Classement_Equipe) {
        this.id_Equipe = id_Equipe;
        this.nom_Equipe = nom_Equipe;
        this.nbr_Joueurs_Equipe = nbr_Joueurs_Equipe;
        this.nbr_Points_Equipe = nbr_Points_Equipe;
        this.nbr_Prix_Equipe = nbr_Prix_Equipe;
        this.date_Equipe = date_Equipe;
        this.Classement_Equipe = Classement_Equipe;
    }
    
        public Equipe(String nom_Equipe, Integer nbr_Joueurs_Equipe, Integer nbr_Points_Equipe , Integer nbr_Prix_Equipe , LocalDate date_Equipe, Integer Classement_Equipe) {
        this.nom_Equipe = nom_Equipe;
        this.nbr_Joueurs_Equipe = nbr_Joueurs_Equipe;
        this.nbr_Points_Equipe = nbr_Points_Equipe;
        this.nbr_Prix_Equipe = nbr_Prix_Equipe;
        this.date_Equipe = date_Equipe;
        this.Classement_Equipe = Classement_Equipe;
    }
    
//    public int get_Id_Equipe() {
//        return id_Equipe;
//    }

    public int getId_Equipe() {
        return id_Equipe;
    }
//    
//    
//        
//    public String get_Nom_Equipe() {
//        return nom_Equipe;
//    }
//    
//    public Integer get_Nbr_Joueurs_Equipe() {
//        return nbr_Joueurs_Equipe;
//    }
//    
//     public Integer get_Nbr_Points_Equipe() {
//        return nbr_Points_Equipe;
//    }
//    
//     public Integer get_Nbr_Prix_Equipe() {
//        return nbr_Prix_Equipe;
//    }
//    
//     public LocalDate get_Date_Equipe() {
//        return date_Equipe;
//    }
//     
//     public Integer get_Classement_Equipe() {
//        return Classement_Equipe;
//    }

    public Integer getClassement_Equipe() {
        return Classement_Equipe;
    }

    public LocalDate getDate_Equipe() {
        return date_Equipe;
    }

    public Integer getNbr_Joueurs_Equipe() {
        return nbr_Joueurs_Equipe;
    }

    public Integer getNbr_Points_Equipe() {
        return nbr_Points_Equipe;
    }

    public Integer getNbr_Prix_Equipe() {
        return nbr_Prix_Equipe;
    }

    public String getNom_Equipe() {
        return nom_Equipe;
    }
     
    
            
    public void set_id_Equipe(int id_Equipe) {
        this.id_Equipe = id_Equipe;
    }
    
     public void set_nom_Equipe(String nom_Equipe) {
        this.nom_Equipe = nom_Equipe;
    }
     
     public void set_nbr_Joueurs_Equipe(Integer nbr_Joueurs_Equipe) {
        this.nbr_Joueurs_Equipe = nbr_Joueurs_Equipe;
    }
     
     public void set_nbr_Points_Equipe(Integer nbr_Points_Equipe) {
        this.nbr_Points_Equipe = nbr_Points_Equipe;
    }
     
     public void set_nbr_Prix_Equipe(Integer nbr_Prix_Equipe) {
        this.nbr_Prix_Equipe = nbr_Prix_Equipe;
    }
     
    public void set_date_Equipe(LocalDate date_Equipe) {
        this.date_Equipe = date_Equipe;
    }
    
     public void set_Classement_Equipe(Integer Classement_Equipe) {
        this.Classement_Equipe = Classement_Equipe;
    }
     
@Override
    public String toString() {
        return "Equipe{" + "id=" + id_Equipe + ", nom Equipe=" + nom_Equipe + ", nombre Joueurs=" + nbr_Joueurs_Equipe + ",nombre Points =" + nbr_Points_Equipe +  ",nombre Prix =" + nbr_Prix_Equipe + ",Date creation Equipe =" + date_Equipe + ",Classement Equipe =" + Classement_Equipe + '}';
    }

    public void set_Id(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}