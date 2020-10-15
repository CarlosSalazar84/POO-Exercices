import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import java.text.DecimalFormat;

public class ControllerCasaDeCambio {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cmdRegistrar;

    @FXML
    private Label lblEtiqueta1;

    @FXML
    private TextField fldPrecioCompra;

    @FXML
    private Label lblEtiqueta2;

    @FXML
    private TextField fldPrecioVenta;

    @FXML
    private Label lblSubtitulo1;

    @FXML
    private Label lblPrecioDeCompra;

    @FXML
    private Label lblSubtitulo2;

    @FXML
    private Label lblPrecioDeVenta;

    @FXML
    private Label lblSubtitulo3;

    @FXML
    private Label lblGananciaPorBolivar;

    @FXML
    private Label lblTitulo1;

    @FXML
    private Label lblTitulo2;

    @FXML
    private Label lblTitulo3;

    @FXML
    private TextField fldCantidadInyectar;

    @FXML
    private Button cmdInyectar;

    @FXML
    private RadioButton optBolivar;

    @FXML
    private ToggleGroup Inyectar;

    @FXML
    private RadioButton optPesos;

    @FXML
    private Label lblEtiqueta3;

    @FXML
    private Label lblEtiqueta4;

    @FXML
    private Label lblSubtitulo4;

    @FXML
    private Label lblBolivaresComprados;

    @FXML
    private Button cmdComprar;

    @FXML
    private TextField fldCantidadComprar;

    @FXML
    private Button cmdVender;

    @FXML
    private TextField fldCantidadVender;

    @FXML
    private Label lblSubtitulo5;

    @FXML
    private Label lblBolivaresVendidos;

    @FXML
    private Label lblSubtitulo6;

    @FXML
    private Label lblBolivaresEnCaja;

    @FXML
    private Label lblSubtitulo7;

    @FXML
    private Label lblPesosEnCaja;

    @FXML
    private Label lblSubtitulo8;

    @FXML
    private Label lblImpuestos;

    @FXML
    private Label lblSubtitulo9;

    @FXML
    private Label lblGanancias;

    public CasaDeCambio casaDeCambio;

    @FXML
    void cambiarPrecioDelBolivar(ActionEvent event){
        if(fldPrecioCompra.getText().length() > 0 && fldPrecioVenta.getText().length() > 0){
            float PrecioCompra = Float.parseFloat(fldPrecioCompra.getText());
            float PrecioVenta = Float.parseFloat(fldPrecioVenta.getText());

            if(casaDeCambio.cambiarPrecioDelBolivar(PrecioCompra, PrecioVenta)){
                Float aux = casaDeCambio.getGananciaEnUnBolivar();
                lblGananciaPorBolivar.setText(aux.toString());
                lblPrecioDeCompra.setText(fldPrecioCompra.getText());
                lblPrecioDeVenta.setText(fldPrecioVenta.getText());
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Acción inválida");
                alert.setTitle("Mensaje");
                alert.setContentText("Perdemos dinero!, el precio de venta debe ser mayor al de compra");
                alert.showAndWait();
            }
            fldPrecioCompra.clear();
            fldPrecioVenta.clear();
        }
    }

    @FXML
    void comprarBolivares(ActionEvent event){
        if(fldCantidadComprar.getText().length() > 0){
            int value = Integer.parseInt(fldCantidadComprar.getText());

            if(casaDeCambio.comprarBolivares(value)){
                // Cambiar etiqueta bolivaresComprados
                Integer auxInt = casaDeCambio.getBolivaresComprados(); 
                lblBolivaresComprados.setText(auxInt.toString());
                // Cambiar etiqueta bolivaresEnCaja
                Float auxPf = casaDeCambio.getBolivaresEnCaja(); 
                lblBolivaresEnCaja.setText(new DecimalFormat("#.###").format(auxPf));
                // Cambiar etiqueta pesosEnCaja
                auxPf = casaDeCambio.getPesosEnCaja(); 
                lblPesosEnCaja.setText(new DecimalFormat("#.###").format(auxPf));
                // Cambiar etiqueta ganancias
                auxPf = casaDeCambio.getGanancias(); 
                lblGanancias.setText(new DecimalFormat("#.###").format(auxPf));
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Acción inválida");
                alert.setTitle("Mensaje");
                alert.setContentText("El dinero en caja es insuficiente, intente de nuevo");
                alert.showAndWait();
            }
            fldCantidadComprar.clear();
        }
    }

    @FXML
    void venderBolivares(ActionEvent event){
        if(fldCantidadVender.getText().length() > 0){
            int value = Integer.parseInt(fldCantidadVender.getText());

            if(casaDeCambio.venderBolivares(value)){
                // Cambiar etiqueta bolivaresVendidos
                Integer auxInt = casaDeCambio.getBolivaresVendidos(); 
                lblBolivaresVendidos.setText(auxInt.toString());
                // Cambiar etiqueta bolivaresEnCaja
                Float auxPf = casaDeCambio.getBolivaresEnCaja(); 
                lblBolivaresEnCaja.setText(new DecimalFormat("#.###").format(auxPf));
                // Cambiar etiqueta pesosEnCaja
                auxPf = casaDeCambio.getPesosEnCaja(); 
                lblPesosEnCaja.setText(new DecimalFormat("#.###").format(auxPf));
                // Cambiar etiqueta ganancias
                auxPf = casaDeCambio.getGanancias(); 
                lblGanancias.setText(new DecimalFormat("#.###").format(auxPf));
                // Cambiar etiqueta impuestos
                auxPf = casaDeCambio.getImpuestos(); 
                lblImpuestos.setText(new DecimalFormat("#.###").format(auxPf));
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Acción inválida");
                alert.setTitle("Mensaje");
                alert.setContentText("El dinero en caja es insuficiente, intente de nuevo");
                alert.showAndWait();
            }
            fldCantidadVender.clear();
        }
    }

    @FXML
    void inyectar(ActionEvent event){
        if(fldCantidadInyectar.getText().length() > 0){
            int value = Integer.parseInt(fldCantidadInyectar.getText());

            if(optBolivar.isSelected()){
                casaDeCambio.inyectarBolivares(value);
                // Cambiar etiqueta bolivaresEnCaja
                Float auxPf = casaDeCambio.getBolivaresEnCaja(); 
                lblBolivaresEnCaja.setText(new DecimalFormat("#.###").format(auxPf));
            }
            else{
                casaDeCambio.inyectarPesos(value);
                // Cambiar etiqueta pesosEnCaja
                Float auxPf = casaDeCambio.getPesosEnCaja(); 
                lblPesosEnCaja.setText(new DecimalFormat("#.###").format(auxPf));
            }
            fldCantidadInyectar.clear();
        }
    }

    @FXML
    void initialize(){
        assert cmdRegistrar != null : "fx:id=\"cmdRegistrar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblEtiqueta1 != null : "fx:id=\"lblEtiqueta1\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert fldPrecioCompra != null : "fx:id=\"fldPrecioCompra\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblEtiqueta2 != null : "fx:id=\"lblEtiqueta2\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert fldPrecioVenta != null : "fx:id=\"fldPrecioVenta\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo1 != null : "fx:id=\"lblSubtitulo1\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblPrecioDeCompra != null : "fx:id=\"lblPrecioDeCompra\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo2 != null : "fx:id=\"lblSubtitulo2\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblPrecioDeVenta != null : "fx:id=\"lblPrecioDeVenta\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo3 != null : "fx:id=\"lblSubtitulo3\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblGananciaPorBolivar != null : "fx:id=\"lblGananciaPorBolivar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblTitulo1 != null : "fx:id=\"lblTitulo1\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblTitulo2 != null : "fx:id=\"lblTitulo2\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblTitulo3 != null : "fx:id=\"lblTitulo3\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert fldCantidadInyectar != null : "fx:id=\"fldCantidadInyectar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert cmdInyectar != null : "fx:id=\"cmdInyectar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert optBolivar != null : "fx:id=\"optBolivar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert Inyectar != null : "fx:id=\"Inyectar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert optPesos != null : "fx:id=\"optPesos\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblEtiqueta3 != null : "fx:id=\"lblEtiqueta3\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblEtiqueta4 != null : "fx:id=\"lblEtiqueta4\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo4 != null : "fx:id=\"lblSubtitulo4\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblBolivaresComprados != null : "fx:id=\"lblBolivaresComprados\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert cmdComprar != null : "fx:id=\"cmdComprar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert fldCantidadComprar != null : "fx:id=\"fldCantidadComprar\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert cmdVender != null : "fx:id=\"cmdVender\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert fldCantidadVender != null : "fx:id=\"fldCantidadVender\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo5 != null : "fx:id=\"lblSubtitulo5\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblBolivaresVendidos != null : "fx:id=\"lblBolivaresVendidos\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo6 != null : "fx:id=\"lblSubtitulo6\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblBolivaresEnCaja != null : "fx:id=\"lblBolivaresEnCaja\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo7 != null : "fx:id=\"lblSubtitulo7\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblPesosEnCaja != null : "fx:id=\"lblPesosEnCaja\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo8 != null : "fx:id=\"lblSubtitulo8\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblImpuestos != null : "fx:id=\"lblImpuestos\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblSubtitulo9 != null : "fx:id=\"lblSubtitulo9\" was not injected: check your FXML file 'casaCambio.fxml'.";
        assert lblGanancias != null : "fx:id=\"lblGanancias\" was not injected: check your FXML file 'casaCambio.fxml'.";

        casaDeCambio = new CasaDeCambio();
    }
}
