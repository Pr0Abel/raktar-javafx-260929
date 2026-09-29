package com.example.raktar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Raktár");
        stage.setScene(scene);
        Image windowIconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("raktar.png")));
        stage.getIcons().add(windowIconImage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}