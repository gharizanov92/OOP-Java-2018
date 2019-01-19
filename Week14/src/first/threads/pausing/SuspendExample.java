package first.threads.pausing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuspendExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Pane root = new VBox();

        final SuspendableThread target = new SuspendableThread();
        final Thread thread = new Thread(target);

        thread.start();

        final Button start = new Button("start");
        final Button stop = new Button("stop");

        start.setOnAction((e) -> target.resume());
        stop.setOnAction((e) -> target.pause());

        final Scene scene = new Scene(root, 300, 300);

        root.getChildren().addAll(start, stop, new TextArea());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
