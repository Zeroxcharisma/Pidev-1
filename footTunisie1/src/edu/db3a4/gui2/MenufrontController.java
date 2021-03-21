/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class MenufrontController implements Initializable {

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
    private Text t8;
    @FXML
    private Button btnMenuEp;
    @FXML
    private Button btnResize;
    @FXML
    private AnchorPane topane1;
    @FXML
    private Text HierText;
    @FXML
    private ImageView fantasyIcon;
    @FXML
    private Button logout;
    @FXML
    private Text fantasy;
    @FXML
    private HBox topMenu;
    @FXML
    private Button btnThemes1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void MenuExpand(ActionEvent event) {
    }

    @FXML
    private void enterResize(MouseEvent event) {
    }

    @FXML
    private void test(MouseEvent event) {
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Integration.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
