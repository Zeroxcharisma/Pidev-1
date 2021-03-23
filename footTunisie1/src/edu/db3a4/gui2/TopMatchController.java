/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class TopMatchController implements Initializable {

     @FXML
    private AnchorPane MenuAnchorPane;
    @FXML
    private ImageView backimg;
    @FXML
    private Pane blackPane;
    @FXML
    private Pane blackPane1;
    @FXML
    private Pane topBlackTab;
    @FXML
    private Rectangle rectanimB;
    @FXML
    private BorderPane borderMenu;
    @FXML
    private AnchorPane topane;
    @FXML
    private Pane sideBarBorder;
    @FXML
    private Pane sideUp;
    @FXML
    private Pane sideDown;
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
    private ImageView fantasyIcon;
    @FXML
    private AnchorPane topane1;
    @FXML
    private Text HierText;
    @FXML
    private Button logout;
    @FXML
    private TableView<Resultat> tableHistory;
    @FXML
    private TableColumn<?, ?> cs;
    @FXML
    private TableColumn<?, ?> yc;
    private Text nomequipe;
    @FXML
    private Label labelequipe1;
    @FXML
    private Label labelscore1;
    @FXML
    private Label labelscore2;
    @FXML
    private Label labelequipe2;
    @FXML
    private Label labelnote;
    @FXML
    private Label labeloccasion;
    @FXML
    private Label labelcartoon;
    @FXML
    private TableColumn<Resultat, Integer> idmatch;
    @FXML
    private TableColumn<Resultat, String> equipe1;
    @FXML
    private TableColumn<Resultat, String> equipe2;
    @FXML
    private TableColumn<Resultat, Integer> butequipe1;
    @FXML
    private TableColumn<Resultat, Integer> butequipe2;
    @FXML
    private TableColumn<Resultat, Integer> note;
    @FXML
    private TableColumn<Resultat,String> gagant;
    @FXML
    private TableColumn<Resultat, Integer> occaison;
    @FXML
    private TableColumn<Resultat,Integer> carton;
    private ObservableList<Resultat> RecData = FXCollections.observableArrayList();
    private TextField test;
    @FXML
    private TextField recherche;
    @FXML
    private ImageView detailsgazoniv;
    @FXML
    private Label superficiegazon;
    @FXML
    private Label nbterraingazon;
    @FXML
    private Pane playerOption;
    @FXML
    private Text plnforOption;
    @FXML
    private Button btnReplace;
    @FXML
    private Button btnInformation;
    @FXML
    private Button btnRemove;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ResultatCrud rcr= new ResultatCrud();

       
       
        
         
    
          
       
           
            idmatch.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("id"));
                      equipe1.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe1"));
                                 equipe2.setCellValueFactory(new PropertyValueFactory<Resultat,String>("nomequipe2"));
                                            butequipe1.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe1"));
                                                       butequipe2.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("scoreequipe2"));
                                                                 note.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("note"));
                      
                                                        gagant.setCellValueFactory(new PropertyValueFactory<Resultat,String>("gangant"));
                                                               
                                                                  
                                                                carton.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("carton"));
                                                                occaison.setCellValueFactory(new PropertyValueFactory<Resultat,Integer>("occaison"));
                                                                             
          
         
                // Wrap t
      // TODO
      int i=6;
        tableHistory.setItems(rcr.TopMacthe(8));
      
        
    }    

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void test(MouseEvent event) {
    }


    @FXML
    private void resultat(MouseEvent event) {
           Resultat r = tableHistory.getSelectionModel().getSelectedItem();   
     
      
  labelscore1.setText(String.valueOf(r.getScoreequipe1()));
  labelscore2.setText(String.valueOf(r.getScoreequipe2()));
labelequipe1.setText(r.getNomequipe1());
labelequipe2.setText(r.getNomequipe2());
   labelnote.setText(String.valueOf(r.getNote()));
 labelcartoon.setText(String.valueOf(r.getCarton()));
 labeloccasion.setText(String.valueOf(r.getOccaison()));
    }

        
        
   
    
    
}
