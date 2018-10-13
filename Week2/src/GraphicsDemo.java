import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GraphicsDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final Group root = new Group();
        int width = 300;
        int height = 300;
        int step = 10;

        for (int y = 0; y < height; y += step) {
            addLine(root, y, 0, width, y);
        }

        primaryStage.setScene(
                new Scene(root, width, height));

        primaryStage.show();
    }

    private void addLine(Group root,
                         int startX, int startY,
                         int endX, int endY) {
        
        final Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        root.getChildren().add(line);
    }
}
