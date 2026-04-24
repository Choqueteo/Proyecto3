package hlanz.programacion.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorCriptoanalisis {

    @FXML
    private Button btnElegirArchivo;

    @FXML
    private Button btnHackear;

    @FXML
    private ComboBox<?> cmbCifrado;

    @FXML
    private Spinner<?> spTolerancia;

    @FXML
    private TextArea txtCifrado;

    @FXML
    private TextField txtClave;

    @FXML
    private TextArea txtDescifrado;

    @FXML
    private TextField txtIdioma;

    @FXML
    private TextField txtResultado;

}
