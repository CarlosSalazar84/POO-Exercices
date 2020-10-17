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
    private Label lblHorario;

    @FXML
    private Label lblMinutero;

    @FXML
    private Label lblSegundero;

    @FXML
    private Button cmdAdelantarHora;

    @FXML
    private Button cmdRetrocederHora;

    @FXML
    private Button cmdAdelantarMinuto;

    @FXML
    private Button cmdRetrocederMinuto;

    @FXML
    private Button cmdAdelantarSegundo;

    @FXML
    private Button cmdRetrocederSegundo;

    @FXML
    private Label lblHora;

    @FXML
    private Label lblPuntos1;

    @FXML
    private Label lblMinuto;

    @FXML
    private Label lblPuntos2;

    @FXML
    private Label lblSegundo;

    @FXML
    private Label lblTitulo;
    
    Reloj r;

    @FXML
    void adelantarMinutero(ActionEvent event) {
        
        r.avanzarMinutero();
        lblMinuto.setText(Integer.toString(r.getMinutos()));
        lblSegundo.setText(Integer.toString(r.getSegundos()));
        lblHora.setText(Integer.toString(r.getHoras()));

    }

    @FXML
    void adelantarSegundero(ActionEvent event) {
        
        r.avanzarSegundero();
        lblMinuto.setText(Integer.toString(r.getMinutos()));
        lblSegundo.setText(Integer.toString(r.getSegundos()));
        lblHora.setText(Integer.toString(r.getHoras()));

    }

    @FXML
    void adelantarhorario(ActionEvent event) {

        r.avanzarHorario();
        lblMinuto.setText(Integer.toString(r.getMinutos()));
        lblSegundo.setText(Integer.toString(r.getSegundos()));
        lblHora.setText(Integer.toString(r.getHoras()));

    }

    @FXML
    void retrocederHorario(ActionEvent event) {
        
        r.retrocederHorario();
        lblMinuto.setText(Integer.toString(r.getMinutos()));
        lblSegundo.setText(Integer.toString(r.getSegundos()));
        lblHora.setText(Integer.toString(r.getHoras()));

    }

    @FXML
    void retrocederMinutero(ActionEvent event) {
        
        r.retrocederMinutero();
        lblMinuto.setText(Integer.toString(r.getMinutos()));
        lblSegundo.setText(Integer.toString(r.getSegundos()));
        lblHora.setText(Integer.toString(r.getHoras()));

    }

    @FXML
    void retrocederSegundero(ActionEvent event) {
        
        r.retrocederSegundero();
        lblMinuto.setText(Integer.toString(r.getMinutos()));
        lblSegundo.setText(Integer.toString(r.getSegundos()));
        lblHora.setText(Integer.toString(r.getHoras()));

    }

    @FXML
    void initialize() {
        assert lblHorario != null : "fx:id=\"lblHorario\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblMinutero != null : "fx:id=\"lblMinutero\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblSegundero != null : "fx:id=\"lblSegundero\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdAdelantarHora != null : "fx:id=\"cmdAdelantarHora\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdRetrocederHora != null : "fx:id=\"cmdRetrocederHora\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdAdelantarMinuto != null : "fx:id=\"cmdAdelantarMinuto\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdRetrocederMinuto != null : "fx:id=\"cmdRetrocederMinuto\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdAdelantarSegundo != null : "fx:id=\"cmdAdelantarSegundo\" was not injected: check your FXML file 'reloj.fxml'.";
        assert cmdRetrocederSegundo != null : "fx:id=\"cmdRetrocederSegundo\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblHora != null : "fx:id=\"lblHora\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblPuntos1 != null : "fx:id=\"lblPuntos1\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblMinuto != null : "fx:id=\"lblMinuto\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblPuntos2 != null : "fx:id=\"lblPuntos2\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblSegundo != null : "fx:id=\"lblSegundo\" was not injected: check your FXML file 'reloj.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'reloj.fxml'.";
        r = new Reloj();

    }
}
