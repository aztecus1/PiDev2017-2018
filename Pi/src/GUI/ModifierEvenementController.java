/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author mouin
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField etab;
    @FXML
    private TextField disc;
    @FXML
    private TextField image;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;
      private Evenement a;
    
    public ModifierEvenementController(Evenement a) {
        this.a = a;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              nom.setText(a.getNom());
              etab.setText(a.getRefEtab());
              debut.setValue(LocalDate.parse(a.getDateDebut()));
              fin.setValue(LocalDate.parse(a.getDateFin()));
              disc.setText(a.getDescription());
              image.setText(a.getIimage());
       

    }    

    @FXML
    private void ModifierEvenement(ActionEvent event) {
                a.setNom(nom.getText());
                a.setRefEtab(etab.getText());
                a.setDateDebut(debut.getValue().toString());
                a.setDateFin(fin.getValue().toString());
                a.setDescription(disc.getText());
                a.setImage(image.getText());
                


                EvenementService sv=new EvenementService();
                sv.updateEvenement(a);
            try {
            Parent root = FXMLLoader.load(getClass().getResource("listeEvenement.fxml"));
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("Liste");
            s.setScene(scene);
            s.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ListeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 }
