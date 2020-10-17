import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;



public class ViewCafetera extends Application{
    
    public Scene cargarScene(String fxmlDocPath) throws IOException{
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        
        
        // Create the Pane and all Details
        Pane root = (Pane) loader.load(fxmlStream);

        // Create the Scene
        Scene scene = new Scene(root);
        
        return scene;
    }
    
    
    public void start(Stage stage) throws IOException{
        String fxmlDocPath = "viewCafetera.fxml";
        // Set the Scene to the Stage
        stage.setScene(cargarScene(fxmlDocPath));
        // Set the Title to the Stage
        stage.setTitle("My First FXML Example");
        stage.resizableProperty().setValue(Boolean.FALSE);
        // Display the Stage
        stage.show();
    }
    
    
}
