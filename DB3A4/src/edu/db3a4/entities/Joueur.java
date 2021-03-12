/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.entities;

/**
 *
 * @author hedii
 */
public class Joueur extends User{
  
        // Atrributs
    
       //Constructeur Par defaut
    public Joueur() {
    }
    
    public Joueur(int Identifiant, String Nom, String Prenom, String Adresse, String Email, String Pseudo, String Password, int List_Message, int Num_Tel,int Cin) {
        super(Identifiant, Nom, Prenom, Adresse, Email, Pseudo, Password, List_Message, Num_Tel,Cin);
       
    }
     public Joueur(int Identifiant, String Nom, String Prenom, String Adresse, String Email, String Pseudo, String Password,int Num_Tel, int Cin) {
        super( Identifiant, Nom, Prenom,Adresse, Email, Pseudo, Password,Num_Tel,Cin);
     }
    
public Joueur(int Identifiant, String Nom, String Prenom, String Email, String Pseudo, String Password) {
        super( Identifiant, Nom, Prenom, Email, Pseudo, Password);
       
    }
    
    public String toString(){
       return super.toString();
    
    }

}
