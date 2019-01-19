package first;

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
import sun.net.idn.StringPrep;

import java.util.Scanner;

public class PropertiesTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Pane root = new VBox();

        final Label textLabel = new Label("Test");
        final TextField textField = new TextField("Test");

        final StringProperty localStringTitleProperty = new SimpleStringProperty();
        localStringTitleProperty.setValue("Initial");

        textField.textProperty().bindBidirectional(localStringTitleProperty);
        textLabel.textProperty().bind(localStringTitleProperty);

        final Label equationLabel = new Label("2 * x - 3 * y = ");
        final Label resultLabel = new Label();
        final TextField xInput = new TextField();
        final TextField yInput = new TextField();

        final IntegerProperty x = new SimpleIntegerProperty();
        final IntegerProperty y = new SimpleIntegerProperty();

        final NumberBinding result =
                Bindings.subtract(Bindings.multiply(2, x), Bindings.multiply(3, y));
        final IntegerProperty resultProperty = new SimpleIntegerProperty();
        resultProperty.bind(result);

        xInput.textProperty().bindBidirectional(x, new NumberStringConverter());
        yInput.textProperty().bindBidirectional(y, new NumberStringConverter());
        resultLabel.textProperty().bindBidirectional(resultProperty, new NumberStringConverter());

        root.getChildren().addAll(new HBox(textField, textLabel),
                new HBox(equationLabel, resultLabel),
                new HBox(new Label("Enter X: "), xInput),
                new HBox(new Label("Enter Y: "), yInput));

        final Scene scene = new Scene(root, 300, 300);

        primaryStage.titleProperty()
                .bind(Bindings.concat("Title: ").concat(localStringTitleProperty));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
