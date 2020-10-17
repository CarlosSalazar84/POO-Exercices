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


public class ControllerLinea {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblX1;

    @FXML
    private Label lblY1;

    @FXML
    private TextField txtX1;

    @FXML
    private TextField txtY1;

    @FXML
    private Button cmdActualizarCoordenadas;

    @FXML
    private Button cmdDeterminarUbicacion;

    @FXML
    private Button cmdAyuda;

    @FXML
    private Label lblX2;

    @FXML
    private Label lblY2;

    @FXML
    private TextField txtX2;

    @FXML
    private TextField txtY2;

    @FXML
    private ImageView imgPlano;

    @FXML
    private Label lblUbicacion;

    @FXML
    private Label lblTitulo;

    private Linea l;

    @FXML
    void actualizarCoordenadas(ActionEvent event) {
        l.setX1(Float.parseFloat(txtX1.getText()));
        l.setY1(Float.parseFloat(txtY1.getText()));
        l.setX2(Float.parseFloat(txtX2.getText()));
        l.setY2(Float.parseFloat(txtY2.getText()));
        cmdDeterminarUbicacion.setDisable(false);
    }

    @FXML
    void ayuda(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setContentText("Determina la ubicación de la línea respecto al plano.");
        alert.showAndWait();

    }

    @FXML
    void determinarUbicacion(ActionEvent event) {
        lblUbicacion.setText(l.getUbicacion());
        cmdDeterminarUbicacion.setDisable(true);
    }

    private void actualizarGUI()
    {
        lblUbicacion.setText(""+l.getUbicacion());
        txtX1.setText(""+l.getX1());
        txtY1.setText(""+l.getY1());
        txtX2.setText(""+l.getX2());
        txtY2.setText(""+l.getY2());
    }

    @FXML
    void initialize() {
        assert lblX1 != null : "fx:id=\"lblX1\" was not injected: check your FXML file 'linea.fxml'.";
        assert lblY1 != null : "fx:id=\"lblY1\" was not injected: check your FXML file 'linea.fxml'.";
        assert txtX1 != null : "fx:id=\"txtX1\" was not injected: check your FXML file 'linea.fxml'.";
        assert txtY1 != null : "fx:id=\"txtY1\" was not injected: check your FXML file 'linea.fxml'.";
        assert cmdActualizarCoordenadas != null : "fx:id=\"cmdActualizarCoordenadas\" was not injected: check your FXML file 'linea.fxml'.";
        assert cmdDeterminarUbicacion != null : "fx:id=\"cmdDeterminarUbicacion\" was not injected: check your FXML file 'linea.fxml'.";
        assert cmdAyuda != null : "fx:id=\"cmdAyuda\" was not injected: check your FXML file 'linea.fxml'.";
        assert lblX2 != null : "fx:id=\"lblX2\" was not injected: check your FXML file 'linea.fxml'.";
        assert lblY2 != null : "fx:id=\"lblY2\" was not injected: check your FXML file 'linea.fxml'.";
        assert txtX2 != null : "fx:id=\"txtX2\" was not injected: check your FXML file 'linea.fxml'.";
        assert txtY2 != null : "fx:id=\"txtY2\" was not injected: check your FXML file 'linea.fxml'.";
        assert imgPlano != null : "fx:id=\"imgPlano\" was not injected: check your FXML file 'linea.fxml'.";
        assert lblUbicacion != null : "fx:id=\"lblUbicacion\" was not injected: check your FXML file 'linea.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'linea.fxml'.";
        this.l= new Linea();
        cmdDeterminarUbicacion.setDisable(true);
    }
}
