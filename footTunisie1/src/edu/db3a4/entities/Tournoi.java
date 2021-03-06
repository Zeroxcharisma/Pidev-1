/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.entities;

import java.awt.Image;
import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Tournoi {
    private int id;
    private String nomTournoi;
    private Integer nbr_equipe;
    private LocalDate dateTournoi;
    private String terrainTournoi;
    private File image;
    private String equipes;
    private int scoreEq1;
    private int scoreEq2;
    private int scoreEq3;
    private int scoreEq4;
    private String scoreFinal;

    
    public Tournoi() {
    }

   
 public Tournoi(int id, String nomTournoi, Integer nbr_equipe, LocalDate dateTournoi, String terrainTournoi) {
        this.id = id;
        this.nomTournoi = nomTournoi;
        this.nbr_equipe = nbr_equipe;
        this.dateTournoi = dateTournoi;
        this.terrainTournoi = terrainTournoi;
    }
 public Tournoi(int id, String nomTournoi, Integer nbr_equipe, LocalDate dateTournoi, String terrainTournoi, File image, String equipes) {
        this.id = id;
        this.nomTournoi = nomTournoi;
        this.nbr_equipe = nbr_equipe;
        this.dateTournoi = dateTournoi;
        this.terrainTournoi = terrainTournoi;
        this.image = image;
        this.equipes = equipes;
    }
    public LocalDate getDateTournoi() {
        return dateTournoi;
    }

    public File getImage() {
        return image;
    }

    public void setEquipes(String equipes) {
        this.equipes = equipes;
    }

    public String getEquipes() {
        return equipes;
    }
    
    
    public void setImage(File image) {
        this.image = image;
    }

    public int getScoreEq1() {
        return scoreEq1;
    }

    public int getScoreEq2() {
        return scoreEq2;
    }

    public int getScoreEq3() {
        return scoreEq3;
    }

    public int getScoreEq4() {
        return scoreEq4;
    }

    public String getScoreFinal() {
        return scoreFinal;
    }
    
    public void setScoreFinal(String scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public void setScoreEq4(int scoreEq4) {
        this.scoreEq4 = scoreEq4;
    }

    public void setScoreEq3(int scoreEq3) {
        this.scoreEq3 = scoreEq3;
    }

    public void setScoreEq2(int scoreEq2) {
        this.scoreEq2 = scoreEq2;
    }

    public void setScoreEq1(int scoreEq1) {
        this.scoreEq1 = scoreEq1;
    }

  

    public int getId() {
        return id;
    }

    public Integer getNbr_equipe() {
        return nbr_equipe;
    }

    public String getNomTournoi() {
        return nomTournoi;
    }

    public String getTerrainTournoi() {
        return terrainTournoi;
    }

    public void setDateTournoi(LocalDate dateTournoi) {
        this.dateTournoi = dateTournoi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbr_equipe(Integer nbr_equipe) {
        this.nbr_equipe = nbr_equipe;
    }

    public void setNomTournoi(String nomTournoi) {
        this.nomTournoi = nomTournoi;
    }

    public void setTerrainTournoi(String terrainTournoi) {
        this.terrainTournoi = terrainTournoi;
    }
    
     @Override
    public String toString() {
        return "Tournoi{" + "id=" + id + ", nomTournoi=" + nomTournoi + ", nombre equipe=" + nbr_equipe + ",date tournoi =" + dateTournoi +  ",terrain tournoi =" + terrainTournoi +   '}';
    }
}
