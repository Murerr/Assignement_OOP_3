import controller.ClassesController;
import controller.ModuleController;
import controller.StudentController;
import controller.TeacherController;
import database.ConnectionSingleton;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.Connection;

/**
 * Create the GUI
 */
public class Main extends Application { ;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start The Gui
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        try {

            Connection connectionToDatabase = ConnectionSingleton.getInstance();
            BorderPane mainPane = new BorderPane();
            Group root = new Group();
            Scene scene = new Scene(root,1200,800);

            TabPane tp = new TabPane();
            tp.getTabs().add (new StudentController(connectionToDatabase));
            tp.getTabs().add (new TeacherController(connectionToDatabase));
            tp.getTabs().add (new ClassesController(connectionToDatabase));
            tp.getTabs().add (new ModuleController(connectionToDatabase));

            mainPane.setCenter(tp);
            mainPane.prefHeightProperty().bind(scene.heightProperty());
            mainPane.prefWidthProperty().bind(scene.widthProperty());

            root.getChildren().add(mainPane);
            primaryStage.setTitle("Assignement 3 SQL Rudy MURER R00171701");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
