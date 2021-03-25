/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a4.gui2;

import edu.db3a4.entities.Tournoi;
import edu.db3a4.services.TournoiCRUD;
import edu.db3a4.tests.MailSender;
import edu.db3a4.tools.MyConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FrontTournoiController implements Initializable {

    @FXML
    private AnchorPane MenuAnchorPane;
    @FXML
    private ImageView backimg;
    @FXML
    private Pane blackPane;
    @FXML
    private Pane blackPane1;
    @FXML
   
    private TableView<Tournoi> afficher;
    @FXML
    private TableColumn<Tournoi, Integer> idTournoi;
    @FXML
    private TableColumn<Tournoi, String> nomTournoi;
    @FXML
    private TableColumn<Tournoi, Integer> nbE;
    @FXML
    private TableColumn<Tournoi, LocalDate> DTournoi;
    @FXML
    private TableColumn<Tournoi, String> Ttournoi;
    @FXML
    private TableColumn<Tournoi, String> tbImg;
    @FXML
    private ImageView image;
    @FXML
    private Label etatTournoi;
    @FXML
    private Button calendrier;
    @FXML
    private Button StatsTerrain;
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
    private ComboBox<Integer> tf_nbrE;
    @FXML
    private TextField tf_nom;
    @FXML
    private ComboBox<String> cmbTerrain;
    @FXML
    private DatePicker pickerDate;
    @FXML
    private TextField tf_id;
    @FXML
    private Rating rating;
    @FXML
    private Button Rate;
    @FXML
    private Label NoteTournoi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         TournoiCRUD pcd = new TournoiCRUD();
            idTournoi.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomTournoi.setCellValueFactory(new PropertyValueFactory<>("nomTournoi"));
            nbE.setCellValueFactory(new PropertyValueFactory<>("nbr_equipe"));
            DTournoi.setCellValueFactory(new PropertyValueFactory<>("dateTournoi"));
            Ttournoi.setCellValueFactory(new PropertyValueFactory<>("terrainTournoi"));
            tbImg.setCellValueFactory(new PropertyValueFactory<>("image"));                                                                                                                             
            afficher.setItems(pcd.displayTournoi());
           
    }    

    @FXML
    private void tabV(MouseEvent event) throws FileNotFoundException {
         Tournoi tournoi = afficher.getSelectionModel().getSelectedItem();
              tf_id.setText(String.valueOf(tournoi.getId()));
            tf_nom.setText(tournoi.getNomTournoi());
            tf_nbrE.setValue(tournoi.getNbr_equipe());
            pickerDate.setValue(tournoi.getDateTournoi());
            cmbTerrain.setValue(tournoi.getTerrainTournoi());
            Image img = new Image("/cup/"+tournoi.getImage());
            image.setImage(img);
            TournoiCRUD pcd = new TournoiCRUD();
            LocalDate lt = LocalDate.now(); 
            
            String[] parts = pcd.getEquipes(tournoi.getId()).split(",");
             try {
            
            String requete = "SELECT * FROM tournoi WHERE id = " + tournoi.getId() + ";";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                if (rs.getInt("scoreEq1")>rs.getInt("scoreEq2") && rs.getInt("scoreFinal1")>rs.getInt("scoreFinal2"))
                    etatTournoi.setText("Tournoi términer "+parts[0]+" à gagner le tournoi");
                if (rs.getInt("scoreEq2")>rs.getInt("scoreEq1") && rs.getInt("scoreFinal1")>rs.getInt("scoreFinal2"))
                    etatTournoi.setText("Tournoi términer "+parts[1]+" à gagner le tournoi");
                if (rs.getInt("scoreEq3")>rs.getInt("scoreEq4") && rs.getInt("scoreFinal2")>rs.getInt("scoreFinal1"))
                    etatTournoi.setText("Tournoi términer "+parts[2]+" à gagner le tournoi");
                if (rs.getInt("scoreEq3")<rs.getInt("scoreEq4") && rs.getInt("scoreFinal1")<rs.getInt("scoreFinal2"))
                    etatTournoi.setText("Tournoi términer "+parts[3]+" à gagner le tournoi");
                if (rs.getDate("dateTournoi").toLocalDate().isAfter(lt))
                    etatTournoi.setText("le tournoi commence dans "+ChronoUnit.DAYS.between(lt, rs.getDate("dateTournoi").toLocalDate())+" jours");
                  int value = rs.getInt("scoreEq1");
                if(rs.getDate("dateTournoi").toLocalDate().isBefore(lt) && value == 0   )
                    etatTournoi.setText("attente des resultats");
                Float a = rs.getFloat("rate")/rs.getFloat("nbrRate");
                if (a.isNaN())
                NoteTournoi.setText("Non disponible");
                else{
                    DecimalFormat frmt = new DecimalFormat();
		frmt.setMaximumFractionDigits(2);
                NoteTournoi.setText(String.valueOf(frmt.format(a)));
                }
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(AffichageTournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void afficheCalendar(ActionEvent event)  throws IOException {
     LocalDate lt = LocalDate.now(); 
        if (tf_id.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Veuillez selectionner un tournoi");
    }
     else{
        TournoiCRUD pcd = new TournoiCRUD();
       if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 4 && pcd.getDate(Integer.parseInt(tf_id.getText())).isAfter(lt)  ){
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Calendar.fxml"));
                   Parent root = (Parent)loader.load();
            Integer id = Integer.parseInt(tf_id.getText());
            String nomTt = tf_nom.getText();
            String date1 = pickerDate.getValue().toString();
            String[] parts = pcd.getEquipes(id).split(",");  
            Random random = new Random();
            int nb = 14+random.nextInt(21-14);
            int nb1 = 14+random.nextInt(21-14);
            CalendarController calendar = loader.getController();
            calendar.sett(parts[0], parts[1], parts[2], parts[3], date1, pickerDate.getValue().plusDays(1).toString(),String.valueOf(nb),String.valueOf(nb1),nomTt);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Calendrier tournoi");
        stage.getIcons().add(new Image("/images/calendar.png"));
            stage.show();}
      else if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 4 && pcd.getDate(Integer.parseInt(tf_id.getText())).isBefore(lt) && etatTournoi.getText() != "attente des resultats"  ){
        FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("resultCal.fxml"));
                   Parent root = (Parent)loader.load();
            Integer id = Integer.parseInt(tf_id.getText());
            String nomTt = tf_nom.getText();
            String date1 = pickerDate.getValue().toString();
            String[] parts = pcd.getEquipes(id).split(",");  
            ResultCalController calendar = loader.getController();
            try {
            
            String requete = "SELECT * FROM tournoi WHERE id = " + id + ";";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                calendar.sett(parts[0], parts[1], parts[2], parts[3],nomTt,rs.getInt("scoreEq1"),rs.getInt("scoreEq2"),rs.getInt("scoreEq3"),rs.getInt("scoreEq4"),rs.getInt("scoreFinal1"),rs.getInt("scoreFinal2"));
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(AffichageTournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Calendrier tournoi");
        stage.getIcons().add(new Image("/images/calendar.png"));
            stage.show();}
        else if (pcd.getNombre(Integer.parseInt(tf_id.getText()))== 4 && pcd.getDate(Integer.parseInt(tf_id.getText())).isBefore(lt) && etatTournoi.getText().equals("attente des resultats")  ){
       String Newligne=System.getProperty("line.separator");
            JOptionPane.showMessageDialog(null, "Les resultats ne sont pas encore saisie"+Newligne+" Un mail va etre envoyer a la direction des resultats");
        	//	EmailUtil.sendEmail(session, toEmail,"tournoi", "TLSEmail Testing Body");
                MailSender mail = new MailSender();
            String[] args = null;
             //   mail.main(args,tf_nom.getText());

        }
    }
    }

    @FXML
    private void stats(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Statistique.fxml"));
            Parent root = (Parent)loader.load();
          
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
             stage.setTitle("Statistique terrain");
        stage.getIcons().add(new Image("/images/stats.png"));
            stage.show();
    }

    @FXML
    private void test(MouseEvent event) {
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void rating(ActionEvent event) {
          try {
            
            String requete = "SELECT * from tournoi where id = '"+Integer.parseInt(tf_id.getText())+"'";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                  try {
                      Integer a = ((int) rating.getRating()) + rs.getInt("rate");   
                      Integer b = rs.getInt("nbrRate") + 1;
                      if (etatTournoi.getText().equals("attente des resultats") || etatTournoi.getText().contains("le tournoi commence dans") )
            JOptionPane.showMessageDialog(null, "Vous ne pouvez pas encore noter ce tournoi");
            
                      else {PreparedStatement pst = MyConnection.getInstance().getCnx() 
                    .prepareStatement("UPDATE tournoi SET rate = '"+a+"', nbrRate = '"+b+"' WHERE id = '"+Integer.parseInt(tf_id.getText())+"'");
          
                      pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Tournoi noté");
                      }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(AffichageTournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
             try {
            String requete = "SELECT * from tournoi where id = '"+Integer.parseInt(tf_id.getText())+"'";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                 Integer bb = rs.getInt("nbrRate");
                      Integer b = rs.getInt("nbrRate") + 1;
                 Float a = rs.getFloat("rate")/rs.getFloat("nbrRate");
                if (a.isNaN())
                NoteTournoi.setText("Non disponible");
                else{
                    DecimalFormat frmt = new DecimalFormat();
		frmt.setMaximumFractionDigits(2);
                NoteTournoi.setText(String.valueOf(frmt.format(a)));
                }             
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(AffichageTournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @FXML
    private void Resultats(MouseEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Resultat3.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
           Logger.getLogger(AddResultatController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
