package first.labs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClockTest extends Application {
    @Override
    public void start(Stage primaryStage)  {
        final ClockThread clockPane = new ClockThread();

        final Scene scene = new Scene(clockPane, 300, 300);

        clockPane.startClock();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
