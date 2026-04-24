package hlanz.programacion.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class ControladorPrincipal {

    @FXML
    private Button btnAceptar;

    @FXML
    private RadioButton optCriptoanalisis;

    @FXML
    private RadioButton optCriptografia;

    private ToggleGroup grupoOpciones;

    @FXML
    public void initialize() {

        grupoOpciones = new ToggleGroup();
        optCriptografia.setToggleGroup(grupoOpciones);
        optCriptoanalisis.setToggleGroup(grupoOpciones);

        btnAceptar.setOnAction(event -> {
            pulsarAceptar(event);
        });
    }
    private void pulsarAceptar(ActionEvent event) {
        String fxml = "";
        String titulo = "";

        if (optCriptografia.isSelected()) {
            fxml = "/frmCriptografia.fxml";
            titulo = "Criptografía";
        } else if (optCriptoanalisis.isSelected()) {
            fxml = "/frmCriptoanalisis.fxml";
            titulo = "Criptoanálisis";
        }

        abrirVentanaCripto(fxml, titulo);
    }

    private void abrirVentanaCripto(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(btnAceptar.getScene().getWindow());

            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            System.err.println("Error al cargar la ventana: " + e.getMessage());
            e.printStackTrace();
        }
    }
}