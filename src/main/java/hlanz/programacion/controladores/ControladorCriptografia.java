package hlanz.programacion.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorCriptografia {

    @FXML
    private Button btnAccion;

    @FXML
    private Button btnElegirArchivo;

    @FXML
    private ComboBox<?> cmbCifrado;

    @FXML
    private RadioButton optCifrar;

    @FXML
    private RadioButton optDescifrar;

    @FXML
    private TextField txtClave;

    @FXML
    private TextArea txtEntrada;

    @FXML
    private TextArea txtSalida;

}
