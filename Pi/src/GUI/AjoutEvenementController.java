/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author mouin
 */
public class AjoutEvenementController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField etab;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;
    @FXML
    private TextField decs;
    @FXML
    private TextField image;
   
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          if("a".equals(nom.getText())){
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Le type doit etre inséré");
            alert.show();
        }
    }    

    @FXML
    private void AjouterEvenement(ActionEvent event) throws Exception {
         Evenement v =new Evenement(nom.getText(),etab.getText(),debut.getValue().toString(),fin.getValue().toString(),decs.getText(),image.getText());
                
                EvenementService sv=new EvenementService();
                sv.insererEvenement(v);
              
    
        
    }

    @FXML
    private void AficherEvenement(ActionEvent event)  {
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
    

