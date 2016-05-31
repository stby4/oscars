package ch.fhnw.oop.oscar.view.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * OscarFXApplication
 * Created by Hinrich on 31.05.2016.
 */
public class OscarFXApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = new OscarFXView();
        Scene scene = new Scene(parent);

        primaryStage.setTitle("Oscars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
