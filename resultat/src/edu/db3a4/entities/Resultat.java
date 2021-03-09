/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.entities;

/**
 *
 * @author nidha
 */

import java.time.LocalDate;
 import java.util.Date;

/**
 *
 * @author nidha
 */
public class Resultat {
        private int id;
    private String nomequipe1;
    private String nomequipe2;
     private int scoreequipe1;
      private  int scoreequipe2;
      private float note;
      
  private  LocalDate date = LocalDate.now();  
   private String gangant;
      public Resultat () {
    }
      public Resultat (int id,String nomeequipe1,String nomeequipe2,int scoreequipe1,int scoreequipe2,float note, LocalDate date,String gangant)
      {
          this.id=id;
          this.nomequipe1=nomeequipe1;
                  this.nomequipe2=nomeequipe2;
                  this.scoreequipe1=scoreequipe1;
                  this.scoreequipe2=scoreequipe2;
                  this.note=note;
                  this.date=date;
                  this.gangant=gangant;
                  
      }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomequipe1(String nomequipe1) {
        this.nomequipe1 = nomequipe1;
    }

    public void setNomequipe2(String nomequipe2) {
        this.nomequipe2 = nomequipe2;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setScoreequipe1(int scoreequipe1) {
        this.scoreequipe1 = scoreequipe1;
    }

    public void setScoreequipe2(int scoreequipe2) {
        this.scoreequipe2 = scoreequipe2;
    }

    public void setGangant(String gangant) {
        this.gangant = gangant;
    }

    public int getId() {
        return id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGangant() {
        return gangant;
    }

    

  
    

    public String getNomequipe1() {
        return nomequipe1;
    }

    public String getNomequipe2() {
        return nomequipe2;
    }

    public float getNote() {
        return note;
    }

    public int getScoreequipe1() {
        return scoreequipe1;
    }

    public int getScoreequipe2() {
        return scoreequipe2;
    }

    public LocalDate getDate() {
        return date;
    }

   

  
      
  
     public String toString() {
        return ""  + id + "," + nomequipe1 + "," + nomequipe2+ "," + scoreequipe1+"," + scoreequipe2+", note=" + note+"," + date+'}';
    }
}

