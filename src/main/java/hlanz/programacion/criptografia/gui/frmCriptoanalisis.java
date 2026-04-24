package hlanz.programacion.criptografia.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class frmCriptoanalisis extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader cargador = new FXMLLoader(ClassLoader.getSystemResource("frmCriptoanalisis.fxml"));
            Scene escena = new Scene(cargador.load());
            primaryStage.setScene(escena);
            primaryStage.show();
        }catch (IOException e){
            System.out.println("Error al cargar la escena");
        }
    }
}
