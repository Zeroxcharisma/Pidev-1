/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.tests;


import edu.db3a4.tools.MyConnection;

/**
 *
 * @author House
 */
public class MainClass {
    
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        MyConnection mc2 = MyConnection.getInstance();
        System.out.println(mc.hashCode()+"--"+mc2.hashCode());
        
    }
}
