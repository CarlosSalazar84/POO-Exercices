import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerReloj {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblHoras;

    @FXML
    private Label lblNumeroHor;

    @FXML
    private Button cmdAumentarHor;

    @FXML
    private Label lblMinutos;

    @FXML
    private Label lblNumeroMin;

    @FXML
    private Button cmdAumentarMin;

    @FXML
    private Label lblSegundos;

    @FXML
    private Label lblNumeroSec;

    @FXML
    private Button cmdAumentarSec;
    
    private ModelReloj reloj; 

    @FXML
    void aumentarHora(ActionEvent event) {
        reloj.moverHorario();
        actualizarGUI();
    }

    @FXML
    void aumentarMinuto(ActionEvent event) {
        reloj.moverMinutero();
        actualizarGUI();
    }

    @FXML
    void aumentarSegundo(ActionEvent event) {
        reloj.moverSegundero();
        actualizarGUI();
    }
    
    private void actualizarGUI(){
        lblNumeroHor.setText((( reloj.horas < 10) ? "0" :"") +reloj.horas);
        lblNumeroMin.setText((( reloj.minutos < 10) ? "0" :"") + reloj.minutos);
        lblNumeroSec.setText((( reloj.segundos < 10) ? "0" :"") + reloj.segundos);
    }

    @FXML
    void initialize() {
        assert lblHoras != null : "fx:id=\"lblHoras\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblNumeroHor != null : "fx:id=\"lblNumeroHor\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdAumentarHor != null : "fx:id=\"cmdAumentarHor\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblMinutos != null : "fx:id=\"lblMinutos\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblNumeroMin != null : "fx:id=\"lblNumeroMin\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdAumentarMin != null : "fx:id=\"cmdAumentarMin\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblSegundos != null : "fx:id=\"lblSegundos\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblNumeroSec != null : "fx:id=\"lblNumeroSec\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdAumentarSec != null : "fx:id=\"cmdAumentarSec\" was not injected: check your FXML file 'reloj.fxml'.";
        
        reloj = new ModelReloj();
    }
}