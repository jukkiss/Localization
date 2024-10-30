module org.example.threebuttons {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.threebuttons to javafx.fxml;
    exports org.example.threebuttons;
}