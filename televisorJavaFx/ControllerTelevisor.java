import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.IOException;

public class ControllerTelevisor{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar barVolumen;

    @FXML
    private Button cmdSubir;

    @FXML
    private Button cmdBajar;

    @FXML
    private Label lblVolumen;

    @FXML
    private Label lblNumVolumen;

    @FXML
    private Label lblCanal;

    @FXML
    private Label lblNumCanal;

    @FXML
    private Button cmdAvanzar;

    @FXML
    private Button cmdRetroceder;

    @FXML
    private Button cmdCambiarEntrada;

    @FXML
    private Label lblEntrada;

    @FXML
    private Label lblTitulo;

    public Televisor televisor;

    @FXML
    void avanzarCanal(ActionEvent event){
        if(televisor.getNumTipoDeEntrada() > 0){
            televisor.avanzarCanal();
            Integer num = televisor.getCanal();
            lblNumCanal.setText(num.toString());
        }
    }

    @FXML
    void retrocederCanal(ActionEvent event){
        if(televisor.getNumTipoDeEntrada() > 0){
            televisor.retrocederCanal();
            Integer num = televisor.getCanal();
            lblNumCanal.setText(num.toString());
        }
    }

    @FXML
    void bajarVolumen(ActionEvent event){
        if(televisor.getNumTipoDeEntrada() > 0){
            televisor.bajarVolumen();
            Integer num = televisor.getVolumen();
            lblNumVolumen.setText(num.toString());
            barVolumen.setProgress(num/20.0);
        }
    }

    @FXML
    void subirVolumen(ActionEvent event){
        if(televisor.getNumTipoDeEntrada() > 0){
            televisor.subirVolumen();
            Integer num = televisor.getVolumen();
            lblNumVolumen.setText(num.toString());
            barVolumen.setProgress(num/20.0);
        }
    }

    @FXML
    void cambiarEntrada(ActionEvent event){
        televisor.setTipoDeEntrada((televisor.getNumTipoDeEntrada()+1));
        lblEntrada.setText(televisor.getTipoDeEntrada());
        Integer num = televisor.getCanal();
        lblNumCanal.setText(num.toString());
        if(televisor.getNumTipoDeEntrada() != 0){
            cmdAvanzar.setDisable(false);
            cmdRetroceder.setDisable(false);
            cmdSubir.setDisable(false);
            cmdBajar.setDisable(false);
        }
        else{
            cmdAvanzar.setDisable(true);
            cmdRetroceder.setDisable(true);
            cmdSubir.setDisable(true);
            cmdBajar.setDisable(true);
        }
    }

    @FXML
    void initialize() {
        assert barVolumen != null : "fx:id=\"barVolumen\" was not injected: check your FXML file 'televisor.fxml'.";
        assert cmdSubir != null : "fx:id=\"cmdSubir\" was not injected: check your FXML file 'televisor.fxml'.";
        assert cmdBajar != null : "fx:id=\"cmdBajar\" was not injected: check your FXML file 'televisor.fxml'.";
        assert lblVolumen != null : "fx:id=\"lblVolumen\" was not injected: check your FXML file 'televisor.fxml'.";
        assert lblNumVolumen != null : "fx:id=\"lblNumVolumen\" was not injected: check your FXML file 'televisor.fxml'.";
        assert lblCanal != null : "fx:id=\"lblCanal\" was not injected: check your FXML file 'televisor.fxml'.";
        assert lblNumCanal != null : "fx:id=\"lblNumCanal\" was not injected: check your FXML file 'televisor.fxml'.";
        assert cmdAvanzar != null : "fx:id=\"cmdAvanzar\" was not injected: check your FXML file 'televisor.fxml'.";
        assert cmdRetroceder != null : "fx:id=\"cmdRetroceder\" was not injected: check your FXML file 'televisor.fxml'.";
        assert cmdCambiarEntrada != null : "fx:id=\"cmdCambiarEntrada\" was not injected: check your FXML file 'televisor.fxml'.";
        assert lblEntrada != null : "fx:id=\"lblEntrada\" was not injected: check your FXML file 'televisor.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'televisor.fxml'.";

        televisor = new Televisor();
        cmdAvanzar.setDisable(true);
        cmdRetroceder.setDisable(true);
        cmdSubir.setDisable(true);
        cmdBajar.setDisable(true);

    }
}

