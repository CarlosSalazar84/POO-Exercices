import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.text.NumberFormat;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblLado1;

    @FXML
    private TextField txtLado1;

    @FXML
    private Label lblLado2;

    @FXML
    private TextField txtLado2;

    @FXML
    private Label lblLado3;

    @FXML
    private TextField txtLado3;

    @FXML
    private Button cmdDeterminar;

    @FXML
    private ImageView imgTriangulo;

    private Triangulo triangulo;

    @FXML
    void determinarTriangulo(ActionEvent event) {
        triangulo.lado1 = Float.parseFloat(txtLado1.getText());
        triangulo.lado2 = Float.parseFloat(txtLado2.getText());
        triangulo.lado3 = Float.parseFloat(txtLado3.getText());
        cambiarImagen(triangulo.getTipo());
    } 
    
    void cambiarImagen(String tipoTriangulo){
        String ruta;
        if(triangulo.esRectangulo())
            ruta= "/images/rectangulo"+tipoTriangulo+".jpg";
        else
            ruta= "/images/"+tipoTriangulo+".png";
            
        Image image = new Image (ruta); //establece la imagen deseada en la variable imagen haciendo uso de la clase javafx.scene.image.Image
            
        imgTriangulo.setImage(image);
    }

    @FXML
    void initialize() {
        assert lblLado1 != null : "fx:id=\"lblLado1\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert txtLado1 != null : "fx:id=\"txtLado1\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert lblLado2 != null : "fx:id=\"lblLado2\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert txtLado2 != null : "fx:id=\"txtLado2\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert lblLado3 != null : "fx:id=\"lblLado3\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert txtLado3 != null : "fx:id=\"txtLado3\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert cmdDeterminar != null : "fx:id=\"cmdDeterminar\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        assert imgTriangulo != null : "fx:id=\"imgTriangulo\" was not injected: check your FXML file 'vistaTriangulo.fxml'.";
        
        this.triangulo = new Triangulo();
    }
    
}
