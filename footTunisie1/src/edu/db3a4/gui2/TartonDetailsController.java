/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Personne;
import edu.db3a4.services.PersonneCRUD;
import edu.db3a4.tools.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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
 * @author ASUS
 */
public class TartonDetailsController implements Initializable {

    @FXML
    private ImageView detailsgazoniv;
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
    private HBox myTeam;
    @FXML
    private Text t2;
    @FXML
    private HBox status;
    @FXML
    private Text t1;
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
    private Button logout;
    @FXML
    private ImageView fantasyIcon;
    @FXML
    private AnchorPane topane1;
    @FXML
    private Text HierText;
    @FXML
    private TableColumn<Personne, String> id;
    @FXML
    private TableColumn<Personne, String> rNom;
    @FXML
    private TableColumn<Personne, String> rType;
    @FXML
    private TableColumn<Personne, String> rTaille;
    @FXML
    private TableColumn<Personne, String> rLieu;
    @FXML
    private TableView<Personne> affichageT;
    public ObservableList<Personne> observableListLocataire = FXCollections.observableArrayList();
    @FXML
    private Label superficietarton;
    @FXML
    private Label nbterraintarton;

    /**
     * Initializes the controller class.
     */

    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("/res/ivtB.jpg");
        detailsgazoniv.setImage(image);
        superficietarton.setText("875 m2");
        
        
        PersonneCRUD pcd = new PersonneCRUD();
            
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            rNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            rType.setCellValueFactory(new PropertyValueFactory<>("type"));
            rTaille.setCellValueFactory(new PropertyValueFactory<>("taille"));
            rLieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                                                                                                                                              
            affichageT.setItems(pcd.displayTerrainT());
            int i=pcd.b1e4();
            nbterraintarton.setText(Integer.toString(i));
     
    }    

    @FXML
    private void test(MouseEvent event) {
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void tabAffiche(MouseEvent event) {
    }    
}
