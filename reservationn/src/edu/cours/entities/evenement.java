/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.entities;

import java.time.LocalDate;

/**
 *
 * @author maalaoui
 */
public class evenement {
     private int id;
    private String terrain;
    private String  idequipe1;
    private String  idequipe2;
  private  LocalDate date = LocalDate.now();  
    

    public evenement() {
    }

    public evenement(int id,  String terrain, String idequipe1, String idequipe2, LocalDate date) {
        this.id = id;
        this.terrain = terrain;
        this.idequipe1 = idequipe1;
        this.idequipe2 = idequipe2;
                  this.date=date;
        
    }

    public evenement(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId() {
        return id;
    }

    public String getterrain() {
        return terrain;
    }

    public String getidequipe1() {
        return idequipe1;
    }
    public String getidequipe2() {
        return idequipe2;
    }

    public LocalDate getDate() {
        return date;
    }

   

   

    public void setId(int id) {
        this.id = id;
    }

    public void setterrain(String terrain) {
        this.terrain = terrain;
    }

    public void setidequipe1(String idequipe1) {
        this.idequipe1 = idequipe1;
    }

    public void setidequipe2(String idequipe2) {
        this.idequipe2 = idequipe2;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
     @Override
    public String toString() {
        
        //return ""  + id + "," + terrain + "," + idequipe1 + "," + idequipe2+"," + date+'}';
        //return ""  + id + "," + terrain + "," + idequipe1+"," + date+'}'; 
        
        return "evenement{" + "id=" + id + ", terrain=" + terrain + ", idequipe1=" + idequipe1 + ",idequipe2 =" + idequipe2 +  ",date=" + date +   '}';
    }

    }

  
    
   





