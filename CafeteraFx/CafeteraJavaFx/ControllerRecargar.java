
/**
 * @author: Andrés Camilo Castellanos andrescamilocasa@ufps.edu.co
 * @version: 0.01
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class ControllerRecargar {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DialogPane recargarDialogPane;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtPrecio;
    
    String getTxtCantidad(){
        return txtCantidad.getText();
    }
    
    String getTxtCosto(){
        return txtPrecio.getText();
    }

    @FXML
    void initialize() {
        assert recargarDialogPane != null : "fx:id=\"recargarDialogPane\" was not injected: check your FXML file 'recargar.fxml'.";
        assert txtCantidad != null : "fx:id=\"txtCantidad\" was not injected: check your FXML file 'recargar.fxml'.";
        assert txtPrecio != null : "fx:id=\"txtPrecio\" was not injected: check your FXML file 'recargar.fxml'.";

    }
}