package com.mycompany.mavenproject4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

public class PrimaryController implements Initializable {

    @FXML
    private TableView<modelo.Persona> tabla;
    @FXML
    private TextField apellido;
    @FXML
    private TextField nombre;
    @FXML
    private Button añadir;

    private ObservableList<modelo.Persona> clase;
    @FXML
    private TableColumn<Persona, String> cNombre;
    @FXML
    private TableColumn<Persona, String> cApellido;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void añadirPersona(ActionEvent event) {
        clase.add(new Persona(nombre.getText(), apellido.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.clase = FXCollections.observableArrayList();
        var p1 = new Persona("Paco", "Romero");
        clase.add(p1);

        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        cApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        cNombre.setCellValueFactory(cellData -> {
            String salida = cellData.getValue().getNombre().toUpperCase();
            return new SimpleStringProperty(salida);
        });

////        cApellido.setCellFactory((TableColumn<Persona, String> column) -> {
////            return new TableCell<>() {
////                protected void updateItem(String s, boolean empty) {
////                    super.updateItem(s, empty);
////                    if (s != null) {
////                        if (s.length() > 5) {
////                            this.setStyle("-fx-background-color:red;");
////                        }
////                    }
////                }
////            ;
////        };
////        });
        this.tabla.setItems(clase);
    }
}
