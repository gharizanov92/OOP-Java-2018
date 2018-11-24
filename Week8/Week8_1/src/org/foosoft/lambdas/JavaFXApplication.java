package org.foosoft.lambdas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();

        root.setVgap(10);
        root.setHgap(20);
        root.setAlignment(Pos.BASELINE_CENTER);

        root.setPadding(new Insets(20, 10, 10, 10));

        root.getChildren().addAll(new Button("Click"),
                new Button("Click"),
                new Button("Click"),
                new Button("Click"),
                new Button("Click"),
                new Button("Click"),
                new Button("Click"),
                new Button("Click"));

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}
