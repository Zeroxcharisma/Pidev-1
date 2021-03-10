/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.interfaces;

import edu.db3a4.entities.User;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author hedii
 */
public interface IUSER <T,String>{
    
     public String ajouterUser(T t,String role);
     public void supprimerUser(T t);
     public void updateUser(T t);
     public List<T> displayUsers();
     public ObservableList<User> GetUsers() ;
}