/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Calendar1Controller implements Initializable {

    @FXML
    private Label lab1;
    @FXML
    private Label lab3;
    @FXML
    private Label lab2;
    @FXML
    private Label lab4;
    @FXML
    private Label labd1;
    @FXML
    private Label labd2;
    @FXML
    private Label time1;
    @FXML
    private Label time2;
    @FXML
    private Label lab11;
    @FXML
    private Label lab31;
    @FXML
    private Label lab21;
    @FXML
    private Label lab41;
    @FXML
    private Label labd11;
    @FXML
    private Label labd21;
    @FXML
    private Label time11;
    @FXML
    private Label time21;
    @FXML
    private Label nomT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void sett(String equipe1,String equipe2,String equipe3,
            String equipe4,String date1,String date2, String time, 
            String time3,    String equipe5,String equipe6,String equipe7,
            String equipe8,String date3,String date4, String time5, String time6, String nomTt){
        lab1.setText(equipe1);
        lab3.setText(equipe2);
        lab2.setText(equipe3);
        lab4.setText(equipe4);
        labd1.setText(date1);
        labd2.setText(date2);
        time1.setText(time);
        time2.setText(time3);
        lab11.setText(equipe5);
        lab31.setText(equipe6);
        lab21.setText(equipe7);
        lab41.setText(equipe8);
        labd11.setText(date3);
        labd21.setText(date4);
        time11.setText(time5);
        time21.setText(time6);
        nomT.setText(nomTt);
    }
    
}
