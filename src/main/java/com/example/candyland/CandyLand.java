/**
 * PROGRAM PURPOSE: To launch the CandyLand game application by setting up the initial
 * menu screen and managing the primary stage. JavaFX is used to load and display the main menu
 * interface, where players can start the game.
 * Authors: Vincent Baccari, Chris Groves, Chase Lewis, Daniela Luna, and Kian Miley
 * Date: 11/22/2024
 * Section: CSC 331-002
 */

package com.example.candyland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CandyLand extends Application {
    /**
     * Initializes the stage and sets the initial scene for the CandyLand game by loading
     * the FXML file for the main menu of the game, setting the title of the stage, and displaying the scene
     * @param stage Primary stage of the CandyLand application
     * @throws IOException thrown if an issue occurs loading the FXML file for the menu scene
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader gameLoader = new FXMLLoader(CandyLand.class.getResource("CandyLand_Menu.fxml"));
        Scene gameMenu = new Scene(gameLoader.load(), 1280, 720);
        stage.setTitle("CandyLand");
        stage.setScene(gameMenu);
        stage.show();
    }
    /**
     * Launches CandyLand game application
     */
    public static void main(String[] args) {launch(); }
}