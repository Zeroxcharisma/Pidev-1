/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

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
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author nidha
 */
public class Sondage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
           
       BorderPane bp = new BorderPane();
        PieChart pc = new PieChart();
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
                   
                     pc.setData(ol);
        bp.setCenter(pc);
        pc.setLegendSide(Side.LEFT);
        
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
              
                     
      
         Scene scene = new Scene(bp,600,800);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
