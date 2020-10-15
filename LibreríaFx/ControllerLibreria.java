import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class ControllerLibreria{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cmdGuardar;

    @FXML
    private Button cmdActualizar;

    @FXML
    private Button cmdRegistrarPrestamo;

    @FXML
    private Button cmdRegistrarDevolucion;

    @FXML
    private Label lblEncabezado1;

    @FXML
    private Label lblEncabezado2;

    @FXML
    private Label lblTextCopiasPrestadas;

    @FXML
    private Label lblTextTitulo;

    @FXML
    private Label lblTextAutores;

    @FXML
    private Label lblTextAnio;

    @FXML
    private Label lblTextEditorial;

    @FXML
    private Label lblTextPrecio;

    @FXML
    private Label lblTextNumPaginas;

    @FXML
    private Label lblTextNumCopias;

    @FXML
    private Label lblTextCopiasDisponibles;

    @FXML
    private TextField fldTitulo;

    @FXML
    private TextField fldAutores;

    @FXML
    private TextField fldAnioEdicion;

    @FXML
    private TextField fldEditorial;

    @FXML
    private TextField fldPrecio;

    @FXML
    private TextField fldNumPaginas;

    @FXML
    private TextField fldNumCopias;

    @FXML
    private Label lblCopiasDisponibles;

    @FXML
    private Label lblCopiasPrestadas;

    @FXML
    private ComboBox<String> cboHistorial;

    @FXML
    private Label lblHistorialCopias;

    @FXML
    private Label lblSubtitulo;

    @FXML
    private Label lblSubtitulo1;

    @FXML
    private Label lblEtiqueta1;

    @FXML
    private Label lblEtiqueta2;

    public Libro libro;

    private int [] historialCopias = new int[100];

    private int posicion;

    @FXML
    void actualizarPantalla(ActionEvent event){
        Integer aux;
        fldTitulo.setText(libro.getTitulo());
        fldAutores.setText(libro.getAutores());
        aux = libro.getAnioEdicion();
        fldAnioEdicion.setText(aux.toString());
        aux = libro.getPrecio();
        fldPrecio.setText(aux.toString());
        fldEditorial.setText(libro.getEditorial());
        aux = libro.getNumeroDePaginas();
        fldNumPaginas.setText(aux.toString());
        aux = libro.getNumeroDeCopias();
        fldNumCopias.setText(aux.toString());
    }

    @FXML
    void guardarCambios(ActionEvent event){
        Integer aux;
        libro.setTitulo(fldTitulo.getText());
        libro.setAutores(fldAutores.getText());
        if(fldAnioEdicion.getText().length() > 0){
            aux = Integer.parseInt(fldAnioEdicion.getText());
            libro.setAnioEdicion(aux);
        }
        libro.setEditorial(fldEditorial.getText());
        if(fldPrecio.getText().length() > 0){
            aux = Integer.parseInt(fldPrecio.getText());
            libro.setPrecio(aux);
        }
        if(fldNumPaginas.getText().length() > 0){
            aux = Integer.parseInt(fldNumPaginas.getText());
            libro.setNumeroDePaginas(aux);
        }
        if(fldNumCopias.getText().length() > 0){
            aux = Integer.parseInt(fldNumCopias.getText());
            if(libro.cambiarNumeroDeCopias(aux)){
                aux = libro.getNumeroDeCopiasDisponibles();
                lblCopiasDisponibles.setText(aux.toString());
                aux = libro.getNumeroDeCopiasPrestadas();
                lblCopiasPrestadas.setText(aux.toString());
                historialCopias[posicion] = libro.getNumeroDeCopias();
                cboHistorial.getItems().add("Version " + posicion);
                posicion++;
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Acción inválida");
                alert.setTitle("Error");
                alert.setContentText("El numero de copias no puede ser menor que las existencias");
                alert.showAndWait();
                fldNumCopias.clear();
            }
        }

    }

    @FXML
    void registrarDevolucion(ActionEvent event){
        Integer aux;
        if(!libro.devolver()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Acción inválida");
            alert.setTitle("Error");
            alert.setContentText("No existen copias prestadas actualmente");
            alert.showAndWait();
        }
        aux = libro.getNumeroDeCopiasDisponibles();
        lblCopiasDisponibles.setText(aux.toString());
        aux = libro.getNumeroDeCopiasPrestadas();
        lblCopiasPrestadas.setText(aux.toString());
    }

    @FXML
    void registrarPrestamo(ActionEvent event){
        Integer aux;
        if(!libro.prestar()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Acción inválida");
            alert.setTitle("Error");
            alert.setContentText("No hay existencias actualmente");
            alert.showAndWait();
        }
        aux = libro.getNumeroDeCopiasDisponibles();
        lblCopiasDisponibles.setText(aux.toString());
        aux = libro.getNumeroDeCopiasPrestadas();
        lblCopiasPrestadas.setText(aux.toString());
    }

    @FXML
    void seleccionarVersion(ActionEvent event){
        int pos = cboHistorial.getSelectionModel().getSelectedIndex();
        Integer aux = historialCopias[pos];
        lblHistorialCopias.setText(aux.toString());        
    }

    @FXML
    void initialize() {
        assert cmdGuardar != null : "fx:id=\"cmdGuardar\" was not injected: check your FXML file 'libreria.fxml'.";
        assert cmdActualizar != null : "fx:id=\"cmdActualizar\" was not injected: check your FXML file 'libreria.fxml'.";
        assert cmdRegistrarPrestamo != null : "fx:id=\"cmdRegistrarPrestamo\" was not injected: check your FXML file 'libreria.fxml'.";
        assert cmdRegistrarDevolucion != null : "fx:id=\"cmdRegistrarDevolucion\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblEncabezado1 != null : "fx:id=\"lblEncabezado1\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblEncabezado2 != null : "fx:id=\"lblEncabezado2\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextCopiasPrestadas != null : "fx:id=\"lblTextCopiasPrestadas\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextTitulo != null : "fx:id=\"lblTextTitulo\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextAutores != null : "fx:id=\"lblTextAutores\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextAnio != null : "fx:id=\"lblTextAnio\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextEditorial != null : "fx:id=\"lblTextEditorial\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextPrecio != null : "fx:id=\"lblTextPrecio\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextNumPaginas != null : "fx:id=\"lblTextNumPaginas\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextNumCopias != null : "fx:id=\"lblTextNumCopias\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblTextCopiasDisponibles != null : "fx:id=\"lblTextCopiasDisponibles\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldTitulo != null : "fx:id=\"fldTitulo\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldAutores != null : "fx:id=\"fldAutores\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldAnioEdicion != null : "fx:id=\"fldAnioEdicion\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldEditorial != null : "fx:id=\"fldEditorial\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldPrecio != null : "fx:id=\"fldPrecio\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldNumPaginas != null : "fx:id=\"fldNumPaginas\" was not injected: check your FXML file 'libreria.fxml'.";
        assert fldNumCopias != null : "fx:id=\"fldNumCopias\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblCopiasDisponibles != null : "fx:id=\"lblCopiasDisponibles\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblCopiasPrestadas != null : "fx:id=\"lblCopiasPrestadas\" was not injected: check your FXML file 'libreria.fxml'.";
        assert cboHistorial != null : "fx:id=\"cboLibro\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblHistorialCopias != null : "fx:id=\"lblHistorialCopias\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblSubtitulo != null : "fx:id=\"lblSubtitulo\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblSubtitulo1 != null : "fx:id=\"lblSubtitulo1\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblEtiqueta1 != null : "fx:id=\"lblEtiqueta1\" was not injected: check your FXML file 'libreria.fxml'.";
        assert lblEtiqueta2 != null : "fx:id=\"lblEtiqueta2\" was not injected: check your FXML file 'libreria.fxml'.";

        cboHistorial.getItems().add("Initialize version");
        historialCopias[0] = 0;
        posicion = 1;
        libro = new Libro();
    }
}
