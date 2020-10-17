import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;

public class ControllerRectangulo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtOrigenX;

    @FXML
    private TextField txtOrigenY;

    @FXML
    private TextField txtAncho;

    @FXML
    private TextField txtAlto;

    @FXML
    private TextField txtPuntoX;

    @FXML
    private TextField txtPuntoY;

    @FXML
    private Label lblOrigenX;

    @FXML
    private Label lblOrigenY;

    @FXML
    private Label lblAncho;

    @FXML
    private Label lblAlto;

    @FXML
    private Label lblPuntoX;

    @FXML
    private Label lblPuntoY;

    @FXML
    private Button cmdActualizarCoordenadas;

    @FXML
    private Button cmdDeterminarPosicion;

    @FXML
    private Button cmdAyuda;

    @FXML
    private Label lblUbicacion;

    @FXML
    private ImageView imgRectangulo;

    @FXML
    private Label lblTitulo;
    
    private Rectangulo r;

    @FXML
    void actualizarCoordenadas(ActionEvent event) {
        
        r.setOrigenX(Float.parseFloat(txtOrigenX.getText()));
        r.setOrigenY(Float.parseFloat(txtOrigenY.getText()));
        r.setAncho(Float.parseFloat(txtAncho.getText()));
        r.setAlto(Float.parseFloat(txtAlto.getText()));
        cmdDeterminarPosicion.setDisable(false);

    }

    @FXML
    void ayuda(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setContentText("Determina la ubicación de un punto relativa a un rectángulo");
        alert.showAndWait();

    }

    @FXML
    void determinarPosicion(ActionEvent event) {
        
        lblUbicacion.setText(r.getPosicionPunto(Float.parseFloat(txtPuntoX.getText()),Float.parseFloat(txtPuntoY.getText())));
        cmdDeterminarPosicion.setDisable(true);

    }

    @FXML
    void initialize() {
        assert txtOrigenX != null : "fx:id=\"txtOrigenX\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert txtOrigenY != null : "fx:id=\"txtOrigenY\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert txtAncho != null : "fx:id=\"txtAncho\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert txtAlto != null : "fx:id=\"txtAlto\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert txtPuntoX != null : "fx:id=\"txtPuntoX\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert txtPuntoY != null : "fx:id=\"txtPuntoY\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblOrigenX != null : "fx:id=\"lblOrigenX\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblOrigenY != null : "fx:id=\"lblOrigenY\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblAncho != null : "fx:id=\"lblAncho\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblAlto != null : "fx:id=\"lblAlto\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblPuntoX != null : "fx:id=\"lblPuntoX\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblPuntoY != null : "fx:id=\"lblPuntoY\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert cmdActualizarCoordenadas != null : "fx:id=\"cmdActualizarCoordenadas\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert cmdDeterminarPosicion != null : "fx:id=\"cmdDeterminarPosicion\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert cmdAyuda != null : "fx:id=\"cmdAyuda\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblUbicacion != null : "fx:id=\"lblUbicacion\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert imgRectangulo != null : "fx:id=\"imgRectangulo\" was not injected: check your FXML file 'rectangulo.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'rectangulo.fxml'.";
        cmdDeterminarPosicion.setDisable(true);
        r= new Rectangulo();

    }
}
