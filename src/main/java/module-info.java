module com.example.raktar {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.raktar to javafx.fxml;
    exports com.example.raktar;
}