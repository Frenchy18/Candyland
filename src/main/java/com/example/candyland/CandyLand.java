package com.example.candyland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CandyLand extends Application {
    /**
     * Currently loads but does not show images. (Will work on fix)
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader gameLoader = new FXMLLoader(CandyLand.class.getResource("Candyland_Menu.fxml"));
        Scene gameMenu = new Scene(gameLoader.load(), 1100, 720);
        stage.setTitle("CandyLand");
        stage.setScene(gameMenu);
        stage.show();
    }

    public static void main(String[] args) {launch(); }

}
