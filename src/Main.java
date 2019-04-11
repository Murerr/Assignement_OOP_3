import controller.StudentController;
import database.ConnectionToDatabase;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.sql.*;

/**
 * Create the GUI
 */
public class Main extends Application { ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

                Connection connection = ConnectionToDatabase.getInstance();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `Student");

            BorderPane mainPane = new BorderPane();
            Group root = new Group();
            Scene scene = new Scene(root,1200,800);

            TabPane tp = new TabPane();
            tp.getTabs().add (new StudentController(connection));

            mainPane.setCenter(tp);
            mainPane.prefHeightProperty().bind(scene.heightProperty());
            mainPane.prefWidthProperty().bind(scene.widthProperty());

            root.getChildren().add(mainPane);
            primaryStage.setTitle("Assignement 2 Rudy MURER R00171701");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
