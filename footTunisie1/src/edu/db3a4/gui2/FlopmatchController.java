/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Resultat;
import edu.db3a4.services.ResultatCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nidha
 */
public class FlopmatchController implements Initializable {

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
    @FXML
    private Label cartoon;

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
        tableHistory.setItems(rcr.FlopMacthe(5));
         ObservableList<Resultat> list = rcr.FlopMacthe(5);
       FilteredList<Resultat> Filtered = new FilteredList<>(list,e-> true);
        recherche.textProperty().addListener((Observablevalue,OldValue,NewValue)->{
            Filtered.setPredicate((Predicate<? super Resultat>) ab ->{
                if (NewValue ==null || NewValue.isEmpty()){
                    return true;
                }
               
                
                String lowerCaseFilter  = NewValue.toLowerCase();
                 
                if(ab.getNomequipe1().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(ab.getNomequipe2().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(ab.getGangant().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(String.valueOf(ab.getId()).contains(NewValue)){
                    return true;
                    }else if(String.valueOf(ab.getScoreequipe1()).contains(NewValue)){
                    return true;
                    }else if(String.valueOf(ab.getScoreequipe2()).contains(NewValue)){
                    return true;
                }else if(String.valueOf(ab.getOccaison()).contains(NewValue)){
                    return true;
                    }else if(String.valueOf(ab.getNote()).contains(NewValue)){
                    return true;
                }
                return false;
                
            });
            SortedList<Resultat> sorted = new SortedList<> (Filtered);
            sorted.comparatorProperty().bind(  tableHistory.comparatorProperty());
                      tableHistory.setItems(sorted);
        });
      
        
    }    

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }



    @FXML
    private void resultat(MouseEvent event) {
           Resultat r = tableHistory.getSelectionModel().getSelectedItem();   
     
      
  labelscore1.setText(String.valueOf(r.getScoreequipe1()));
  labelscore2.setText(String.valueOf(r.getScoreequipe2()));
labelequipe1.setText(r.getNomequipe1());
labelequipe2.setText(r.getNomequipe2());
   labelnote.setText(String.valueOf(r.getNote()));
cartoon.setText(String.valueOf(r.getCarton()));
labeloccasion.setText(String.valueOf(r.getOccaison()));
    }

    @FXML
    private void stats(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Statsfrontresultat.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    private void flopmatch(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("flopmatch.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    private void topmatch(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("topmatch.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    private void terrain(MouseEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("terrainfront.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    private void tournoi(MouseEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("fronttournoi.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

        
        
   
}
