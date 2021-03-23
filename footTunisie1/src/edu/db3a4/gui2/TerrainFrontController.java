/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
public class TerrainFrontController implements Initializable {

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
    private ImageView gazoniv;
    @FXML
    private ImageView sableiv;
    @FXML
    private ImageView footsalleiv;
    @FXML
    private ImageView tartoniv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image image = new Image("/res/ivg.jpg");
        gazoniv.setImage(image);
        
        Image image1 = new Image("/res/ivs.jpg");
        sableiv.setImage(image1);
        
        Image image2 = new Image("/res/ivfs.jpg");
        footsalleiv.setImage(image2);
        
        Image image3 = new Image("/res/ivt.jpg");
        tartoniv.setImage(image3);
        // TODO
    }    

    @FXML
    private void GazonFrontiv(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("GazonDetails.fxml"));
            Parent root = loader.load();
            gazoniv.getScene().setRoot(root);
    }


    @FXML
    private void FootsalleFrontiv(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("FootalleDetails.fxml"));
            Parent root = loader.load();
            gazoniv.getScene().setRoot(root);
    }

    @FXML
    private void TartonFrontiv(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("TartonDetails.fxml"));
            Parent root = loader.load();
            tartoniv.getScene().setRoot(root);
    }

    @FXML
    private void SableFrontiv(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("SableDetails.fxml"));
            Parent root = loader.load();
            sableiv.getScene().setRoot(root);
    }
    
    
    @FXML
    private void test(MouseEvent event) {
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void Trailerchoose(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("TerrainPlayer.fxml"));
            Parent root = loader.load();
            sableiv.getScene().setRoot(root);
    }
    
}
