/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.services.ResultatCrud;
import edu.db3a4.tools.MyConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class StatsfrontController implements Initializable {

    @FXML
    private AnchorPane MenuAnchorPane;
    @FXML
    private Pane sideTransparentPane;
    @FXML
    private Pane sideBorderPane;
    @FXML
    private Pane hoverPane;
    @FXML
    private Pane topTransparentPane;
    @FXML
    private ImageView backimg;
    @FXML
    private Pane blackPane11;
    @FXML
    private Pane hexPlane1;
    @FXML
    private Pane hexPlane2;
    @FXML
    private Pane hexPlane3;
    @FXML
    private Pane hexPlane;
    @FXML
    private Pane topBorderPane;
    @FXML
    private Pane blackPane;
    @FXML
    private Pane blackPane1;
    @FXML
    private ImageView topimage;
    @FXML
    private Pane topBlackTab;
    @FXML
    private Rectangle rectanimB;
    @FXML
    private Button btnResize;
    @FXML
    private AnchorPane topane1;
    @FXML
    private Text HierText;
    @FXML
    private Button logout;
    @FXML
    private HBox topMenu;
    @FXML
    private Button btnThemes1;
    @FXML
    private Pane mainPane;
    @FXML
    private Text point;
    @FXML
    private Text matchs;
    @FXML
    private Text matchsg;
    @FXML
    private Text bm;
    @FXML
    private Text bs;
    @FXML
    private VBox note;
    @FXML
    private Text gwbox;
    @FXML
    private ComboBox<String> equipe;
    @FXML
    private Text mj;
    @FXML
    private Text mgg;
    @FXML
    private Text bmm;
    @FXML
    private Text bee;
    @FXML
    private Text notee;
    private BarChart<String,Integer> ResultatChart;
    @FXML
    private AnchorPane sidePane;
    @FXML
    private VBox sidePaneVbox;
    @FXML
    private HBox status;
    @FXML
    private Text t1;
    @FXML
    private HBox myTeam;
    @FXML
    private Text t2;
    @FXML
    private HBox points;
    @FXML
    private Text t3;
    @FXML
    private HBox transfers;
    @FXML
    private Text t4;
    @FXML
    private HBox leagues;
    @FXML
    private Text t5;
    @FXML
    private HBox fixtures;
    @FXML
    private Text t6;
    @FXML
    private HBox statistics;
    @FXML
    private Text t7;
    @FXML
    private HBox rules;
    @FXML
    private Text t8;
    @FXML
    private ImageView fantasyIcon;
    @FXML
    private PieChart pc;
    ObservableList <PieChart.Data> ol = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pc.setTitle("resultat");

         try {
            
            String requete = "SELECT resultat.gagant, Count(*) AS Nombre_de_Fois FROM resultat GROUP BY resultat.gagant";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                       
                       
                        
                        ol.addAll(new PieChart.Data(rs.getString(1),rs.getInt(2)));
                        
                             
                        
                        
           
                                                  pc.setData(ol);
       
        pc.setLegendSide(Side.LEFT);
        
        FadeTransition f = new FadeTransition(Duration.seconds(4),pc);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();  
            }
       
            }
         catch (SQLException ex) {
        
        }
         
                     for (PieChart.Data data : pc.getData())
                     {
                         data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>() {
                             @Override
                             public void handle(MouseEvent event) {
                               JOptionPane.showMessageDialog(null,"equipe -- "+ data.getName()+ "nombre de victoire --" +(int)data.getPieValue());   
                             }
                         });
                     }
              
        try {
            String requete = "SELECT *FROM  equipe";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
               
                equipe.getItems().addAll(rs.getString("nom"));
                      
                        
                         
                           
        
                   
                      
              
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
        // TODO
    }    

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }


    @FXML
    private void enterResize(MouseEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
         String a=equipe.getValue();
         ResultatCrud rcr= new ResultatCrud();
         int b=rcr.score1CAE(a);
         int c=rcr.score2CAE(a);
         int d=rcr.n1CAE(a);
         int e=rcr.n2CAE(a);
         int f=rcr.winner(a);
         int j=rcr.b1e2(a);
         int k=rcr.b2e1(a);
         int x=e+d;
         int p=b+c;
         int n=k+j;
         float r=(float)f/x;
            float w=(float)p/x;
            float q=(float)n/x;
              float ui=r*6;
              float kl=ui+p;
              float notefinal=(float)kl/q;
              if(notefinal>10)
              {
                  notefinal=10;
              }
              int pointt= f*3;
             point.setText(String.valueOf(pointt));
   notee.setText(String.valueOf(notefinal));
    mj.setText(String.valueOf(x));
    bmm.setText(String.valueOf(p));
    bee.setText(String.valueOf(n));
    mgg.setText (String.valueOf(f));
    }

    @FXML
    private void test(MouseEvent event) {
    }
        
    
    
}
