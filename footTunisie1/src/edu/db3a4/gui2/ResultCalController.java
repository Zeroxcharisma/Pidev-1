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
public class ResultCalController implements Initializable {

    @FXML
    private Label lab4;
    @FXML
    private Label scoreEq3;
    @FXML
    private Label scoreEq4;
    @FXML
    private Label lab2;
    @FXML
    private Label lab3;
    @FXML
    private Label lab1;
    @FXML
    private Label scoreEq1;
    @FXML
    private Label scoreEq2;
    @FXML
    private Label nomT;
    @FXML
    private Label Final2;
    @FXML
    private Label Final1;
    @FXML
    private Label scoreF1;
    @FXML
    private Label scoreF2;
    @FXML
    private Label gagnant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void sett(String equipe1,String equipe2,String equipe3,String equipe4, String nomTt, Integer score1, Integer score2, Integer score3, Integer score4, Integer scoreFf1, Integer scoreFf2){
        lab1.setText(equipe1);
        lab3.setText(equipe2);
        lab2.setText(equipe3);
        lab4.setText(equipe4);
        scoreEq1.setText(String.valueOf(score1));
        scoreEq2.setText(String.valueOf(score2));
        scoreEq3.setText(String.valueOf(score3));
        scoreEq4.setText(String.valueOf(score4));
        if (score1>score2)
            Final1.setText(equipe1);
        if (score2>score1)
            Final1.setText(equipe2);
        if (score3>score4)
            Final2.setText(equipe3);
        if (score4>score3)
            Final2.setText(equipe4);
        if (scoreFf1>scoreFf2)
            gagnant.setText(Final1.getText());
        if (scoreFf1<scoreFf2)
            gagnant.setText(Final2.getText());
        scoreF1.setText(String.valueOf(scoreFf1));
        scoreF2.setText(String.valueOf(scoreFf2));
        nomT.setText(nomTt);
    }
    
}
