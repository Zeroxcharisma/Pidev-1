/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.entities;

/**
 *
 * @author House
 */
public class Personne {
    
    private int id;
    private String nom;
    private String type;
    private String taille;
    private String lieu;

    public Personne() {
    }

    public Personne(int id, String nom, String type, String taille ,String lieu) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.taille = taille;
        this.lieu = lieu;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }
    
    public String getTaille() {
        return taille;
    }
    
    public String getLieu() {
        return lieu;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setTaille(String taille) {
        this.taille = taille;
    }
    
    public void setPrenom(String lieu) {
        this.lieu = lieu;
    }
    
    

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", taille=" + taille + ", lieu=" + lieu + '}';
    }
    
    
}
