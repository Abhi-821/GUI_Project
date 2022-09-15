import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Rahul Chowdhary Student id:991658927
 * @author Abhi Sharma Student id:991661414
 */
public class GroupProject extends Application
{

    /**
     *
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception
{
// Load the FXML file.
Parent parent =
FXMLLoader.load(getClass().getResource("GroupProject.fxml"));
// Build the scene graph.
Scene scene = new Scene(parent);
// Display our window, using the scene graph.
 scene.getStylesheets().add(getClass().getResource("layout1.css").toExternalForm());
stage.setTitle("Group Project");
stage.setScene(scene);
stage.show();
}

    /**
     *
     * @param args
     * main method
     */
    public static void main(String[] args)
{
// Launch the application.
launch(args);
}
}
