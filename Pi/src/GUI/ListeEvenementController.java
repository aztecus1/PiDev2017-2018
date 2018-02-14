/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import service.EvenementService;

/**
 * FXML Controller class
 *
 * @author mouin
 */
public class ListeEvenementController implements Initializable {

    @FXML
    private TableView<Evenement> tableEvenement;
    @FXML
    private TableColumn<Evenement, String> ref;
    @FXML
    private TableColumn<Evenement, String> nom;
    @FXML
    private TableColumn<Evenement, String> etab;
    @FXML
    private TableColumn<Evenement, String> debut;
    @FXML
    private TableColumn<Evenement, String> fin;
    @FXML
    private TableColumn<Evenement, String> desc;
    @FXML
    private TableColumn<Evenement, String> image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             EvenementService service = new EvenementService();
        
        ObservableList<Evenement> listeEvenement = FXCollections.observableArrayList(service.selectEvenement());
        tableEvenement.setItems(listeEvenement);
        ref.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getRef());
            }
        });
        nom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom());
            }
        });
        etab.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getRefEtab());
            }
        });
        debut.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDateDebut());
            }
        });
        fin.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDateFin());
            }
        });
        desc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDescription());
            }
        });
         image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Evenement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Evenement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getIimage());
            }
        });
        
      
    }    

    @FXML
    private void ModifierEv(ActionEvent event) {
          try {
            ModifierEvenementController cont = new ModifierEvenementController(tableEvenement.getSelectionModel().getSelectedItem());
            final FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("ModifierEvenement.fxml"));
            loader.setController(cont);
            final Parent root = loader.load();
            final Scene scene = new Scene(root, 800, 600);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(tableEvenement.getScene().getWindow());
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void SupprimerEvenement(ActionEvent event) {
          try {
            int id = tableEvenement.getSelectionModel().getSelectedItem().getRef();
            EvenementService s = new EvenementService();
            s.DeletEvenementByID(id);
            Parent root = FXMLLoader.load(getClass().getResource("listeEvenement.fxml"));
            Scene scene = new Scene(root);
            Stage x = (Stage) this.tableEvenement.getScene().getWindow();
            x.setTitle("Ajout Voiture");
            x.setScene(scene);
            x.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterEv(ActionEvent event) {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("AjoutEvenement.fxml"));
            Scene scene = new Scene(root);
            Stage s = (Stage) this.tableEvenement.getScene().getWindow();
            s.setTitle("Ajout Evenement");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }

