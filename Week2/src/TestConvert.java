import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Arrays;

public class TestConvert extends Application {

    public static final String CELSIUS_OPTION = "Celsius";
    public static final String FAHRENHEIT_OPTION = "Fahrenheit";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final String scaleChoice = getScaleChoice();
        final double initialTemperature = getTemperature(scaleChoice);

        double resultTemperature = 0;

        if (FAHRENHEIT_OPTION.equals(scaleChoice)) {
            final Fahrenheit fahrenheit = new Fahrenheit();
            fahrenheit.setTemperature(initialTemperature);
            resultTemperature = fahrenheit.convertToCelsius();
        } else {
            final Celsius celsius = new Celsius();
            celsius.setTemperature(initialTemperature);
            resultTemperature = celsius.convertToFahrenheit();
        }

        displayResult(resultTemperature);
    }

    private void displayResult(double resultTemperature) {
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Result");
        alert.setHeaderText("Temperature, converted in %s: ");
        alert.setContentText("" + resultTemperature);

        alert.showAndWait();
    }

    private double getTemperature(final String temperatureScale) {
        final TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Temperature input");
        dialog.setHeaderText(String.format("Enter temperature in %s", temperatureScale));
        dialog.setContentText("Temperature: ");

        return Double.parseDouble(dialog.showAndWait().get());
    }

    private String getScaleChoice() {
        final ChoiceDialog dialog = new ChoiceDialog(CELSIUS_OPTION,
                Arrays.asList(CELSIUS_OPTION, FAHRENHEIT_OPTION));

        dialog.setTitle("Enter scale");
        dialog.setHeaderText("Enter scale");
        dialog.setContentText("Enter scale");

        return dialog.showAndWait().get().toString();
    }
}
