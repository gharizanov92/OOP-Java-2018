package second;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class PropertiesTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Pane root = new VBox();

        final Label textLabel = new Label("Text");
        final TextField textField = new TextField("Text");

        final StringProperty localTextProperty = new SimpleStringProperty();
        localTextProperty.setValue("Text Text");

        textField.textProperty().bindBidirectional(localTextProperty);
        textLabel.textProperty().bind(localTextProperty);

        final Scene scene = new Scene(root, 300, 300);

        primaryStage.titleProperty().bind(
                Bindings.concat("Title: ").concat(localTextProperty)
        );

        final Label formula = new Label("2*x - 2*y = ");
        final Label resultLabel = new Label("");
        final TextField xInput = new TextField();
        final TextField yInput = new TextField();

        final IntegerProperty x = new SimpleIntegerProperty();
        final IntegerProperty y = new SimpleIntegerProperty();

        final NumberBinding subtract = Bindings.subtract(
                Bindings.multiply(x, 2),
                Bindings.multiply(y, 2));

        final IntegerProperty resultProperty = new SimpleIntegerProperty();
        resultProperty.bind(subtract);

        xInput.textProperty().bindBidirectional(x, new NumberStringConverter());
        yInput.textProperty().bindBidirectional(y, new NumberStringConverter());

        resultLabel.textProperty().bindBidirectional(resultProperty, new NumberStringConverter());

        root.getChildren().addAll(
                new HBox(
                    textLabel, textField),
                new HBox(
                    formula, resultLabel),
                new HBox(
                    new Label("Enter X: "),
                        xInput
                ),
                new HBox(
                    new Label("Enter Y: "),
                        yInput
                )
        );

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
