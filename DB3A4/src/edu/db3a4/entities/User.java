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
public class User {
    private int   Identifiant;
    private String Nom;
    private String Prenom;
    private String  Adresse;
    private String Email ;
    private String Pseudo ;
    private String Password ;
    private int List_Message ;
    private int Num_Tel ;
    private int Cin;
    
    

    public User() {
        this.Identifiant =0;
        this.Nom = "";
        this.Prenom = "";
        this.Adresse = "";
        this.Email = "";
        this.Password = "";
        this.List_Message = 0;
        this.Num_Tel = 0;
        this.Cin = 0;
    }

    public User(int Identifiant, String Nom, String Prenom, String Adresse, String Email, String Pseudo, String Password, int List_Message, int Num_Tel, int Cin) {
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Pseudo = Pseudo;
        this.Password = Password;
        this.List_Message = List_Message;
        this.Num_Tel = Num_Tel;
        this.Cin = Cin;
        
    }
        public User(int Identifiant, String Nom, String Prenom, String Adresse, String Email, String Pseudo, String Password,int Num_Tel, int Cin) {
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Pseudo = Pseudo;
        this.Password = Password;
        this.Num_Tel = Num_Tel;
        this.Cin = Cin;
        
    }
    public User(int Identifiant, String Nom, String Prenom,String  Email, String Pseudo,String  Password)
    {
        this.Identifiant=Identifiant;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Pseudo = Pseudo;
        this.Password = Password;
    }
      public User(String Nom, String Prenom,String  Email, String Pseudo, String Adresse,int  Cin,int Num_Tel )
    {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Pseudo = Pseudo;
        this.Adresse = Adresse;
        this.Cin = Cin;
        this.Num_Tel = Num_Tel;
    }
    // Getters 
    public String getEmail() {
        return Email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public int getIdentifiant() {
        return Identifiant;
    }

    public int getList_Message() {
        return List_Message;
    }

    public String getNom() {
        return Nom;
    }

    public int getNum_Tel() {
        return Num_Tel;
    }

    public String getPassword() {
        return Password;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public int getCin() {
        return Cin;
    }
    

        //Setters 
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }

    public void setList_Message(int List_Message) {
        this.List_Message = List_Message;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setNum_Tel(int Num_Tel) {
        this.Num_Tel = Num_Tel;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setPseudo(String Pseudo) {
        this.Pseudo = Pseudo;
    } 

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    @Override
    public String toString() {
        return "Joueur{" + "id=" +Identifiant + ", nom=" + Nom + ", prenom=" + Prenom +", Pseudo=" +Pseudo  + 
                ", Adr=" + Adresse +", Email=" + Email +",Pwd =" + Password +", Message=" + List_Message +
                ", Tel=" + Num_Tel +", Cin=" + Cin +'}';
    }
}

