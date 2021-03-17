/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.guiEquipe;

import java.net.URL;
import edu.db3a4.entities.Equipe;
import edu.db3a4.services.EquipeCRUD;
import edu.db3a4.tools.MyConnection;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AddEquipeController implements Initializable {

    @FXML
    private TextField nom_eq;
    @FXML
    private Button btn_ajouter_equipe;
    @FXML
    private DatePicker date_eq;
    @FXML
    private TextField nbr_joueurs;
    @FXML
    private TextField nbr_points;
    @FXML
    private TextField classement_eq;
    @FXML
    private TextField nbr_prix;
    @FXML
    private Button gestion;
    @FXML
    private Button btnAjout1;
    @FXML
    private Button StatTerrain;
    @FXML
    private ImageView logoImg;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_Equipe(ActionEvent event) {
        
        final String nom_equipe = this.nom_eq.getText();
        final Integer nbr_joueurss = Integer.parseInt(this.nbr_joueurs.getText());
        final Integer points = Integer.parseInt(this.nbr_points.getText());
        final Integer prix = Integer.parseInt(this.nbr_prix.getText());
        final LocalDate dateT = (LocalDate)this.date_eq.getValue();
        final Integer classe = Integer.parseInt(this.classement_eq.getText());
        final Equipe p = new Equipe(nom_equipe, nbr_joueurss, points, prix, dateT, classe);
        final EquipeCRUD pcd = new EquipeCRUD();
        pcd.ajouterEquipe(p);
        JOptionPane.showMessageDialog(null, "Equipe ajoutée");
    }

    @FXML
    private void gestion(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("GestionEquipe.fxml"));
            Parent root = loader.load();
            nom_eq.getScene().setRoot(root);
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void stats(ActionEvent event) {
    }

    @FXML
    private void acceuil(ActionEvent event) {
    }
    
}
