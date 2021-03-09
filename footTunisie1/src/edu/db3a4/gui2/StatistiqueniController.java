/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.tools.MyConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class StatistiqueniController implements Initializable {

    @FXML
    private BarChart<String, Integer> ResultatChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         XYChart.Series set1 = new XYChart.Series<>();

         try {
            
            String requete = "SELECT resultat.gagant, Count(*) AS Nombre_de_Fois FROM resultat GROUP BY resultat.gagant";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                      set1.getData().add(new XYChart.Data(rs.getString(1),rs.getInt(2)));
            }
              ResultatChart.getData().add(set1);

            }
         catch (SQLException ex) {
        
        }
        
    }    
    
        // TODO
    }    
    

