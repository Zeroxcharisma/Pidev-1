/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tools.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class SondageController implements Initializable {

    @FXML
    private BorderPane aa;
    @FXML
    private PieChart pc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
         pc.setTitle("resultat");
     ResultatCrud rcr= new ResultatCrud();
        int i= rcr.displayequipe1();
        int a=rcr.displayequipe2();
        int b=rcr.displayequipe3();
        int c=rcr.displayequipe4();
        int d=rcr.displayequipe5();
        int e=rcr.displayequipe6();
        int r=rcr.displayequipe7();
        int k=rcr.displayequipe18();
                
                ObservableList <PieChart.Data> ol = FXCollections.observableArrayList(
                       
                         new PieChart.Data("CAE",a),
                         new PieChart.Data("CA",i),
                         new PieChart.Data("YNA",b),
                                  new PieChart.Data("MKH",c),
                         new PieChart.Data("TZB",d),
                                  new PieChart.Data("CAp",e),
                         new PieChart.Data("boj",r),
                           new PieChart.Data("NUL",k)
                        
                             
                        
                        
                );
                final Label caption = new Label("");
caption.setTextFill(Color.DARKORANGE);
caption.setStyle("-fx-font: 24 arial;");



               
                           

                   
                     pc.setData(ol);
        aa.setCenter(pc);
        pc.setLegendSide(Side.LEFT);
        pc.setMinSize(500, 300);
        
        
        FadeTransition f = new FadeTransition(Duration.seconds(4),pc);
        f.setFromValue(0);
        f.setToValue(1);
        
        f.play();    
            
          
      
           
         
     
        
          
                     for (PieChart.Data data : pc.getData())
                     {
                         data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>() {
                             @Override
                             public void handle(MouseEvent event) {
                               JOptionPane.showMessageDialog(null,"equipe -- "+ data.getName()+ "nombre de victoire --" +(int)data.getPieValue());
                               
            
                               
                             }
                         });
                     }

              
    }    
    
}
