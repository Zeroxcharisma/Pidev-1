/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.entities;

import java.time.LocalDate;

/**
 *
 * @author maalaoui
 */
public class evenement {
     private int id;
    private String terrain;
  private  LocalDate date = LocalDate.now();  
      private String  temps;
      String prix;

    

    public evenement() {
    }

    public evenement(int id,  String terrain, LocalDate date,String temps,String prix) {
        this.id = id;
        this.terrain = terrain;
        this.date=date;
          this.temps = temps;
        this.prix=prix;
    }

//    public evenement(int aInt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public int getId() {
        return id;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getTemps() {
        return temps;
    }
  

    public LocalDate getDate() {
        return date;
    }

    public String getPrix() {
        return prix;
    }

   

   

    public void setId(int id) {
        this.id = id;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    

    public void setTemps(String temps) {
        this.temps = temps;
    }

  

    public void setDate(LocalDate date) {
        this.date = date;
    }
     @Override
    public String toString() {
        
       
        
        return "evenement{" + "id=" + id + ", terrain=" + terrain +  ",date=" + date +", temps=" + temps +   '}';
    }

    }

  
    
   





