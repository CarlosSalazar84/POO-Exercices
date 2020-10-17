
/**
 * @author: Andrés Camilo Castellanos andrescamilocasa@ufps.edu.co
 * @version: 0.01
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import java.io.FileInputStream;
import java.text.NumberFormat;
import javafx.scene.control.Dialog;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tab1;

    @FXML
    private ImageView imgVasoDeCafe;

    @FXML
    private MenuItem cmdCafSencillo;

    @FXML
    private MenuItem cmdCafNormal;

    @FXML
    private MenuItem cmdCafDoble;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button cmdPrepararCafe;

    @FXML
    private Button cmdRegistrarFactura;

    @FXML
    private Tab tab2;

    @FXML
    private TextField txtCanCafe;

    @FXML
    private Button cmdRecargarCafe;

    @FXML
    private TextField txtCanAzucar;

    @FXML
    private Button cmdRecargarAzucar;

    @FXML
    private TextField txtCanVasos;

    @FXML
    private Button cmdRecargarVasos;

    @FXML
    private TextField txtCafPrecio;

    @FXML
    private Button cmdCambiarCafPrecio;

    @FXML
    private TextField txtEgresos;

    @FXML
    private TextField txtIngresos;

    @FXML
    private TextField txtGananciasSinIva;

    @FXML
    private DialogPane recargarDialogPane;

    @FXML
    private TextField txtGananciasNetas;

    @FXML
    private Label lblMontoCafe;

    @FXML
    private Label lblMontoAzucar;

    @FXML
    private Label lblEnDeuda1;

    @FXML
    private Label lblEnDeuda2;

    private Cafetera cafetera;

    private ControllerRecargar controllerRecargar;

    @FXML
    void cambiarCafPrecio(ActionEvent event) {
        String precio;
        precio = boxSimpleAlert("Cambiar precio base del cafe", "Precio");
        if(precio != null){
            txtCafPrecio.setText(precio);
            cafetera.setPrecioBaseCafe(Integer.parseInt(precio));
        }
        actualizarGUI();
    }

    @FXML
    void registrarFactura(ActionEvent event)  throws IOException{
        Image imagen = new Image("copaVacia.jpg");
        imgVasoDeCafe.setImage(imagen);
        cafetera.registrarFactura(cafetera.calcularPrecio());
        alertaConfirmacion();
        actualizarGUI();
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);
    }

    @FXML
    void recargarAzucar(ActionEvent event) throws IOException{
        if( boxAlert() ){
            cafetera.recargarAzucar(Integer.parseInt(controllerRecargar.getTxtCantidad()),Integer.parseInt(controllerRecargar.getTxtCosto()));
            cafetera.registrarFactura(0);
        }
        
        actualizarGUI();
    }

    @FXML
    void recargarCafe(ActionEvent event) throws IOException{
        if( boxAlert() ){
            cafetera.recargarCafe(Integer.parseInt(controllerRecargar.getTxtCantidad()),Integer.parseInt(controllerRecargar.getTxtCosto()));
            cafetera.registrarFactura(0);
        }

        actualizarGUI();
    }

    @FXML
    void recargarVasos(ActionEvent event) throws IOException{
        if(boxAlert()){
            cafetera.recargarVasos(Integer.parseInt(controllerRecargar.getTxtCantidad()),Integer.parseInt(controllerRecargar.getTxtCosto()));
            cafetera.registrarFactura(0);
        }

        actualizarGUI();
    }

    @FXML
    void prepararCafe(ActionEvent event) throws IOException{
        if(cafetera.prepararCafe()){
            if(cafetera.getCafeDeseado()!=0 && cafetera.getAzucarDeseada()!=0){
                Image imagen = new Image("copas2.jpg");
                imgVasoDeCafe.setImage(imagen);
                cmdRegistrarFactura.setDisable(false);
                cmdPrepararCafe.setDisable(true);
            }
            else{ alertError("Asegurese de elegir la cantidad de ingredientes", "Apreciado cliente, por favor consulte el error con un empleado" );}
        }
        else{
            alertError("Insuficientes insumos", "Apreciado cliente, por favor consulte el error con un empleado" );
        }
        actualizarGUI();

        //cmdPrepararCafe.setEffect(shadow);
    }

    @FXML
    void hacerCafeDoble(ActionEvent event) {
        cafetera.setCafeDeseado(3);
        lblMontoCafe.setText("Café doble");
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);
        actualizarGUI();
    }

    @FXML
    void hacerCafeNormal(ActionEvent event) {
        cafetera.setCafeDeseado(2);
        lblMontoCafe.setText("Café Normal");
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);
        actualizarGUI();
    }

    @FXML
    void hacerCafeSencillo(ActionEvent event) {
        cafetera.setCafeDeseado(1);
        lblMontoCafe.setText("Café sencillo");
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);
        actualizarGUI();
    }

    @FXML
    void hacerBajoAzucar(ActionEvent event) {
        cafetera.setAzucarDeseada(2);
        lblMontoAzucar.setText("Bajo de azúcar");
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);
        actualizarGUI();
    }

    @FXML
    void hacerNormalAzucar(ActionEvent event) {
        cafetera.setAzucarDeseada(3);
        lblMontoAzucar.setText("Normal de azúcar");
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);
        actualizarGUI();
    }

    @FXML
    void hacerSinAzucar(ActionEvent event) {
        cafetera.setAzucarDeseada(1);
        lblMontoAzucar.setText("Sin azúcar");
        cmdRegistrarFactura.setDisable(true);
        cmdPrepararCafe.setDisable(false);  
        actualizarGUI();
    }

    boolean boxAlert() throws IOException{
        boolean trial = false;
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "recargar.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        DialogPane dialogPane = (DialogPane)loader.load(fxmlStream);
        controllerRecargar = loader.getController();

        Dialog dialog = new Dialog();
        dialog.setDialogPane(dialogPane);
        dialog.setTitle("Recargar cafe");

        dialog.showAndWait();

        if(dialog.getResult() == ButtonType.OK){
            if(controllerRecargar.getTxtCosto().isEmpty() || controllerRecargar.getTxtCantidad().isEmpty()){
                alertError("Asegurese de escribir la cantidad y el precio", "");
                boxAlert();
            }
            else if(Integer.parseInt(controllerRecargar.getTxtCosto()) < 0 || Integer.parseInt(controllerRecargar.getTxtCosto()) < 0){
                alertError("La cantidad y el precio no pueden ser negativas", "");
                boxAlert();
            }
            trial = true;
        }
        return trial;
    }

    String boxSimpleAlert (String titulo, String contenido){
        String result;
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titulo);
        dialog.setContentText(contenido);
        dialog.showAndWait();
        result = dialog.getResult();
        return result;
    }

    void alertError(String mensaje, String subMensaje) throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR, subMensaje, ButtonType.OK);
        alert.setHeaderText(mensaje);
        alert.setTitle("Error");
        alert.showAndWait();
    }

    void alertaConfirmacion() throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Su factura ha sido registrada." , ButtonType.OK);
        alert.setHeaderText("Apreciado cliente:");
        alert.setTitle("Confirmación");
        alert.showAndWait();
    }

    void actualizarGUI(){
        txtCanCafe.setText(""+cafetera.getCafe()+" g");
        txtCanAzucar.setText(""+cafetera.getAzucar()+" g");
        txtCanVasos.setText(""+cafetera.getVasos()+" u");
        txtGananciasNetas.setText("$ "+NumberFormat.getInstance().format(cafetera.getGananciasNetas()));
        txtEgresos.setText("$ "+NumberFormat.getInstance().format(cafetera.getEgresos()));
        txtIngresos.setText("$ "+NumberFormat.getInstance().format(cafetera.getIngresos()));
        txtGananciasSinIva.setText("$ "+NumberFormat.getInstance().format(cafetera.getGananciasBrutas()));
        txtCafPrecio.setText("$ "+NumberFormat.getInstance().format(cafetera.getPrecioBaseCafe()) + " (por gramo)");
        txtPrecio.setText("$"+NumberFormat.getInstance().format(cafetera.calcularPrecio()));
        if(cafetera.getGananciasBrutas()<0) lblEnDeuda1.setVisible(true);
        else lblEnDeuda1.setVisible(false);
        if(cafetera.getGananciasNetas()<0) lblEnDeuda2.setVisible(true);
        else lblEnDeuda2.setVisible(false);
    }

    @FXML
    void initialize() {
        assert tab1 != null : "fx:id=\"tab1\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert imgVasoDeCafe != null : "fx:id=\"imgVasoDeCafe\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdCafSencillo != null : "fx:id=\"cmdCafSencillo\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdCafNormal != null : "fx:id=\"cmdCafNormal\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdCafDoble != null : "fx:id=\"cmdCafDoble\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtPrecio != null : "fx:id=\"txtPrecio\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdPrepararCafe != null : "fx:id=\"cmdPrepararCafe\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdRegistrarFactura != null : "fx:id=\"cmdRegistrarFactura\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert tab2 != null : "fx:id=\"tab2\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtCanCafe != null : "fx:id=\"txtCanCafe\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdRecargarCafe != null : "fx:id=\"cmdRecargarCafe\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtCanAzucar != null : "fx:id=\"txtCanAzucar\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdRecargarAzucar != null : "fx:id=\"cmdRecargarAzucar\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtCanVasos != null : "fx:id=\"txtCanVasos\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdRecargarVasos != null : "fx:id=\"cmdRecargarVasos\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtCafPrecio != null : "fx:id=\"txtCafPrecio\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert cmdCambiarCafPrecio != null : "fx:id=\"cmdCambiarCafPrecio\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtEgresos != null : "fx:id=\"txtEgresos\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtGananciasSinIva != null : "fx:id=\"txtGananciasSinIva\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert txtGananciasNetas != null : "fx:id=\"txtGananciasNetas\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert lblMontoCafe != null : "fx:id=\"lblMontoCafe\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert lblMontoAzucar != null : "fx:id=\"lblMontoAzucar\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert lblEnDeuda1 != null : "fx:id=\"lblEnDeuda1\" was not injected: check your FXML file 'viewCafetera.fxml'.";
        assert lblEnDeuda2 != null : "fx:id=\"lblEnDeuda2\" was not injected: check your FXML file 'viewCafetera.fxml'.";

        cafetera = new Cafetera();

        actualizarGUI();
    }
}
