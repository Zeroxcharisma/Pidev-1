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
public class Organisateur extends User{
    private int Rib;
    
   
    public Organisateur() {
    }

   

    public Organisateur(int Identifiant, String Nom, String Prenom, String Adresse, String Email, String Pseudo, String Password, int List_Message, int Num_Tel,int Cin,int Rib) {
        super(Identifiant, Nom, Prenom, Adresse, Email, Pseudo, Password, List_Message, Num_Tel,Cin);
       this.Rib=Rib;
    }
    public Organisateur(int Identifiant, String Nom, String Prenom, String Adresse, String Email, String Pseudo, String Password,int Num_Tel, int Cin,int Rib) {
        super( Identifiant, Nom, Prenom,Adresse, Email, Pseudo, Password,Num_Tel,Cin);
               this.Rib=Rib;

     }
    public Organisateur(int Identifiant, String Nom, String Prenom, String Email, String Pseudo, String Password) {
        super( Identifiant, Nom, Prenom, Email, Pseudo, Password);
       
    }

    public int getRib() {
        return Rib;
    }

    public void setRib(int Rib) {
        this.Rib = Rib;
    }
    


    public String toString(){
       return super.toString();
    
    }
    
}
