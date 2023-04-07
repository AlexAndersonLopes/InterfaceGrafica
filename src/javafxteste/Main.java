package javafxteste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/gui/View.fxml.fxml"));
    
    Scene scene = new Scene(root);
    
    Stage stage = primaryStage;
    stage.setScene(scene);
    stage.setTitle("Aprendendo Interface Grafica");
    stage.show();
}


    public static void main(String[] args) {
        launch(args);
    }

}