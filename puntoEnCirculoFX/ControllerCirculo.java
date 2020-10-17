import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;

public class ControllerCirculo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtCentroX;

    @FXML
    private TextField txtCentroY;

    @FXML
    private TextField txtRadio;

    @FXML
    private TextField txtPuntoX;

    @FXML
    private TextField txtPuntoY;

    @FXML
    private Label lblCentroX;

    @FXML
    private Label lblCentroY;

    @FXML
    private Label lblRadio;

    @FXML
    private Label lblPuntoX;

    @FXML
    private Label lblPuntoY;

    @FXML
    private Button cmdActualizarCoordenadas;

    @FXML
    private Button cmdDeterminarUbicacion;

    @FXML
    private Button cmdAyuda;

    @FXML
    private ImageView imgCirculo;

    @FXML
    private Label lblUbicacion;
    
    private Circulo c;

    @FXML
    void DeterminarUbicacion(ActionEvent event) {
        
        String t = c.getPosicionPunto(Float.parseFloat(txtPuntoX.getText()),Float.parseFloat(txtPuntoY.getText()));
        
        if(t.equalsIgnoreCase("Punto Dentro del Círculo") || t.equalsIgnoreCase("Punto En Borde de Círculo"))
        {
            lblUbicacion.setTextFill(Color.GREEN);
            lblUbicacion.setText(t);
        }
        else if(t.equalsIgnoreCase("Punto Fuera del Círculo"))
        {
            lblUbicacion.setTextFill(Color.RED);
            lblUbicacion.setText(t);
        }
        cmdDeterminarUbicacion.setDisable(true);
        

    }

    @FXML
    void actualizarCoordenadas(ActionEvent event) {
        
        c.setCentroX(Float.parseFloat(txtCentroX.getText()));
        c.setCentroY(Float.parseFloat(txtCentroY.getText()));
        c.setRadio(Float.parseFloat(txtRadio.getText()));
        cmdDeterminarUbicacion.setDisable(false);
    }

    @FXML
    void ayuda(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ayuda");
                alert.setContentText("Determina la ubicacción de un punto relativa a un círculo.");
                alert.showAndWait();

    }

    @FXML
    void initialize() {
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'circulo.fxml'.";
        assert txtCentroX != null : "fx:id=\"txtCentroX\" was not injected: check your FXML file 'circulo.fxml'.";
        assert txtCentroY != null : "fx:id=\"txtCentroY\" was not injected: check your FXML file 'circulo.fxml'.";
        assert txtRadio != null : "fx:id=\"txtRadio\" was not injected: check your FXML file 'circulo.fxml'.";
        assert txtPuntoX != null : "fx:id=\"txtPuntoX\" was not injected: check your FXML file 'circulo.fxml'.";
        assert txtPuntoY != null : "fx:id=\"txtPuntoY\" was not injected: check your FXML file 'circulo.fxml'.";
        assert lblCentroX != null : "fx:id=\"lblCentroX\" was not injected: check your FXML file 'circulo.fxml'.";
        assert lblCentroY != null : "fx:id=\"lblCentroY\" was not injected: check your FXML file 'circulo.fxml'.";
        assert lblRadio != null : "fx:id=\"lblRadio\" was not injected: check your FXML file 'circulo.fxml'.";
        assert lblPuntoX != null : "fx:id=\"lblPuntoX\" was not injected: check your FXML file 'circulo.fxml'.";
        assert lblPuntoY != null : "fx:id=\"lblPuntoY\" was not injected: check your FXML file 'circulo.fxml'.";
        assert cmdActualizarCoordenadas != null : "fx:id=\"cmdActualizarCoordenadas\" was not injected: check your FXML file 'circulo.fxml'.";
        assert cmdDeterminarUbicacion != null : "fx:id=\"cmdDeterminarUbicacion\" was not injected: check your FXML file 'circulo.fxml'.";
        assert cmdAyuda != null : "fx:id=\"cmdAyuda\" was not injected: check your FXML file 'circulo.fxml'.";
        assert imgCirculo != null : "fx:id=\"imgCirculo\" was not injected: check your FXML file 'circulo.fxml'.";
        assert lblUbicacion != null : "fx:id=\"lblUbicacion\" was not injected: check your FXML file 'circulo.fxml'.";
        c = new Circulo();
        cmdDeterminarUbicacion.setDisable(true);
    }
}
