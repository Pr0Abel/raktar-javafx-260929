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
        Scene scene = null;
        Image windowIconImage = null;
        if (!HelloAppTest.isRunningTest) scene = new Scene(fxmlLoader.load());
        if (!HelloAppTest.isRunningTest) stage.setTitle("Raktár");
        if (!HelloAppTest.isRunningTest) stage.setScene(scene);
        if (!HelloAppTest.isRunningTest) windowIconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("raktar.png")));
        if (!HelloAppTest.isRunningTest) stage.getIcons().add(windowIconImage);
        if (!HelloAppTest.isRunningTest) stage.show();
    }

    public static void main(String[] args) {if (!HelloAppTest.isRunningTest) launch();}
}