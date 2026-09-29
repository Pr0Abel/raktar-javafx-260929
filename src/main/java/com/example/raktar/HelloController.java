package com.example.raktar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class HelloController {
    @FXML
    private TextField tf_elem;
    @FXML
    private ListView lw_raktar1;
    @FXML
    private ListView lw_raktar2;

    @FXML
    String targy = "";

    private ObservableList<Raktar> raktar = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        File file = new File("Raktar.dat");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String sor;
            while ((sor = reader.readLine()) != null) {
                if (sor.trim().isEmpty()) continue;

                String[] adatok = sor.split(";");
                if (adatok.length == 2) {
                    String id = adatok[0].trim();
                    String targyAdat = adatok[1].trim();

                    if ("1".equals(id)) {
                        lw_raktar1.getItems().add(targyAdat);
                    } else if ("2".equals(id)) {
                        lw_raktar2.getItems().add(targyAdat);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void AddRaktar1(ActionEvent event) {
        String elem = tf_elem.getText().trim();
        if (!elem.isEmpty()) {
            lw_raktar1.getItems().add(elem);
            tf_elem.clear();
        }
    }

    @FXML
    public void AddRaktar2(ActionEvent event) {
        String elem = tf_elem.getText().trim();
        if (!elem.isEmpty()) {
            lw_raktar2.getItems().add(elem);
            tf_elem.clear();
        }
    }

    @FXML
    public void OnCsere1(ActionEvent event) {
        Object kivalasztott = lw_raktar1.getSelectionModel().getSelectedItem();
        if (kivalasztott != null) {
            lw_raktar1.getItems().remove(kivalasztott);
            lw_raktar2.getItems().add(kivalasztott);
        }
    }

    @FXML
    public void OnCsere2(ActionEvent event) {
        Object kivalasztott = lw_raktar2.getSelectionModel().getSelectedItem();
        if (kivalasztott != null) {
            lw_raktar2.getItems().remove(kivalasztott);
            lw_raktar1.getItems().add(kivalasztott);
        }
    }

    @FXML
    public void OnMentes(ActionEvent event) {
        File file = new File("Raktar.dat");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Object elem : lw_raktar1.getItems()) {
                writer.write("1;" + elem.toString());
                writer.newLine();
            }
            
            for (Object elem : lw_raktar2.getItems()) {
                writer.write("2;" + elem.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void OnTorol1(MouseEvent event) {
        int index = lw_raktar1.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            lw_raktar1.getItems().remove(index);
        }
    }

    @FXML
    public void OnTorol2(MouseEvent event) {
        int index = lw_raktar2.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            lw_raktar2.getItems().remove(index);
        }
    }
}