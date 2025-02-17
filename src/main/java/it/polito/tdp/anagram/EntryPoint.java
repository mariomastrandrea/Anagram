package it.polito.tdp.anagram;

import it.polito.tdp.anagram.model.MyAnagramModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene_anagram.fxml"));
        Parent root = loader.load();
        FXMLController controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        MyAnagramModel model = new MyAnagramModel();
        controller.setModel(model);
        
        stage.setTitle("Es. Anagrammi");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }

}
