module com.example.raktar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.raktar to javafx.fxml;
    exports com.example.raktar;
}