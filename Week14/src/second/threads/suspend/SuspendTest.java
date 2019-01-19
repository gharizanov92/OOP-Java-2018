package second.threads.suspend;

import javafx.application.Application;
import javafx.stage.Stage;

public class SuspendTest extends Application {

    public static void main(String[] args) {
        final SuspendableTask target = new SuspendableTask();
        final Thread thread = new Thread(target);

        thread.start();

        target.pauseTask();
        target.resumeTask();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
