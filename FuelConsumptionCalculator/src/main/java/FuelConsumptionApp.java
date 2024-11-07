import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Locale;

public class FuelConsumptionApp extends Application {
    private Label distanceLabel, fuelLabel, resultLabel;
    private TextField distanceField, fuelField;
    private Button calculateButton, enButton, frButton, jpButton, irButton;
    private ResourceBundle bundle;
    private Locale currentLocale;

    @Override
    public void start(Stage stage) {
        // Initial locale (English by default)
        setLocale(Locale.ENGLISH);

        // Create UI components
        distanceLabel = new Label(bundle.getString("distance.label"));
        fuelLabel = new Label(bundle.getString("fuel.label"));
        resultLabel = new Label();
        distanceField = new TextField();
        fuelField = new TextField();
        calculateButton = new Button(bundle.getString("calculate.button"));

        // Language buttons
        enButton = new Button("EN");
        frButton = new Button("FR");
        jpButton = new Button("JP");
        irButton = new Button("IR");

        // Calculate button action
        calculateButton.setOnAction(e -> calculateFuelConsumption());

        // Language switch actions
        enButton.setOnAction(e -> switchLanguage("en", "US"));
        frButton.setOnAction(e -> switchLanguage("fr", "FR"));
        jpButton.setOnAction(e -> switchLanguage("ja", "JP"));
        irButton.setOnAction(e -> switchLanguage("fa", "IR"));

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
                distanceLabel, distanceField,
                fuelLabel, fuelField,
                calculateButton, resultLabel,
                new HBox(5, enButton, frButton, jpButton, irButton)
        );

        // Setup the stage
        stage.setTitle("Jukka Savela!");
        stage.setScene(new Scene(layout, 300, 250));
        stage.show();
    }

    private void setLocale(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle("message", currentLocale);

        if (distanceLabel != null) {
            // Update UI texts
            distanceLabel.setText(bundle.getString("distance.label"));
            fuelLabel.setText(bundle.getString("fuel.label"));
            calculateButton.setText(bundle.getString("calculate.button"));
        }
    }

    private void switchLanguage(String lang, String country) {
        Locale locale = new Locale(lang, country);
        setLocale(locale);
    }

    private void calculateFuelConsumption() {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double fuel = Double.parseDouble(fuelField.getText());
            double consumption = (fuel / distance) * 100;
            resultLabel.setText(String.format(bundle.getString("result.label"), consumption));
        } catch (NumberFormatException e) {
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
