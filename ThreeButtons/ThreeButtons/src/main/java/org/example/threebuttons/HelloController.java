package org.example.threebuttons;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public Button button1;
    public Button button2;
    public Button button3;
    @FXML
    private Label nameAndTimeLabel;

    public void initialize() {
       // ResourceBundle bundle = ResourceBundle.getBundle("bundle2");
       // button1.setText(bundle.getString("button1.text"));
       // button2.setText(bundle.getString("button2.text"));
       // button3.setText(bundle.getString("button3.text"));
        updateNameAndTimeLabel(Locale.ENGLISH);
    }



    public void setEN(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("en");
        loadView(l);
    }

    public void setIR(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("ir");
        loadView(l);
    }

    public void setJP(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("jp");
        loadView(l);
    }

    public void loadView(Locale locale) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundle", locale));
        try {
            Parent root = fxmlLoader.load();
            Stage s = (Stage) button1.getScene().getWindow();
            s.setScene(new Scene(root));
            updateNameAndTimeLabel(locale);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateNameAndTimeLabel(Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", locale);
        String currentTime = LocalTime.now().format(formatter);
        String languageName = locale.getDisplayLanguage(locale);
        nameAndTimeLabel.setText("Jukka Savela - " + currentTime);
    }
}