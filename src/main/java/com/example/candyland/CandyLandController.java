package com.example.candyland;

// importing all classes from Candyland package
import com.example.candyland.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
// fix this
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import java.util.Random;

public class CandyLandController {
    // creating variable names
    private Spinner spinner;



    // start menu fx:id's:
    @FXML private Button buttonStartGame; // Menu screen start
    @FXML private Button buttonEndGame; // Menu screen exit

    // event handlers for the start menu
    @FXML void buttonStartGame(ActionEvent start) {
        try {
            // load the game screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CandyLand_PlayerScreen.fxml"));
            System.out.println();
            Scene scene = new Scene(loader.load());
            System.out.println();

            // get the current stage
            Stage stage = (Stage) ((Node) start.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void buttonEndGame(ActionEvent exit) {
        // get the current stage and close it
        Stage stage = (Stage) ((Node) exit.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML private Button buttonTwoPlayers;
    @FXML void setButtonTwoPlayers(ActionEvent start) {
        try {
            // load the game screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CandyLand_Game.fxml"));
            Scene scene = new Scene(loader.load());

            // get the current stage
            Stage stage = (Stage) ((Node) start.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private Button buttonThreePlayers;
    @FXML void setButtonThreePlayers(ActionEvent start) {
        try {
            // load the game screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CandyLand_Game.fxml"));
            Scene scene = new Scene(loader.load());

            // get the current stage
            Stage stage = (Stage) ((Node) start.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private Button buttonFourPlayers;
    @FXML void setButtonFourPlayers(ActionEvent start) {
        try {
            // load the game screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CandyLand_Game.fxml"));
            Scene scene = new Scene(loader.load());

            // get the current stage
            Stage stage = (Stage) ((Node) start.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Player chooses to go back from PlayerScreen
    @FXML private Button playerBackButton;
    @FXML void setPlayerBackButton(ActionEvent back){
        try {
            // load the game screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Candyland_Menu.fxml"));
            Scene scene = new Scene(loader.load());

            // get the current stage
            Stage stage = (Stage) ((Node) back.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Game board fx:id's
    @FXML private ImageView GameStartSquare; // where each player will start
    @FXML private ImageView Red_1;
    @FXML private ImageView Green_1;
    @FXML private ImageView Blue_1;
    @FXML private ImageView Yellow_1;
    @FXML private ImageView Orange_1;
    @FXML private ImageView Purple_1;
    @FXML private ImageView Red_2;
    @FXML private ImageView Green_2;
    @FXML private ImageView Blue_2;
    @FXML private ImageView Yellow_2;
    @FXML private ImageView Orange_2;
    @FXML private ImageView Purple_2;
    @FXML private ImageView Red_3;
    @FXML private ImageView Green_3;
    @FXML private ImageView Blue_3;
    @FXML private ImageView Yellow_3;
    @FXML private ImageView Orange_3;
    @FXML private ImageView Purple_3;
    @FXML private ImageView Red_4;
    @FXML private ImageView Green_4;
    @FXML private ImageView Blue_4;
    @FXML private ImageView Yellow_4;
    @FXML private ImageView Orange_4;
    @FXML private ImageView Purple_4;
    @FXML private ImageView Red_5;
    @FXML private ImageView Green_5;
    @FXML private ImageView Blue_5;
    @FXML private ImageView Yellow_5;
    @FXML private ImageView Orange_5;
    @FXML private ImageView Purple_5;
    @FXML private ImageView Red_6;
    @FXML private ImageView Green_6;
    @FXML private ImageView Blue_6;
    @FXML private ImageView Yellow_6;
    @FXML private ImageView Orange_6;
    @FXML private ImageView Purple_6;
    @FXML private ImageView Red_7;
    @FXML private ImageView Green_7;
    @FXML private ImageView Blue_7;
    @FXML private ImageView Yellow_7;
    @FXML private ImageView Orange_7;
    @FXML private ImageView Purple_7;
    @FXML private ImageView Red_8;
    @FXML private ImageView Green_8;
    @FXML private ImageView Blue_8;
    @FXML private ImageView Yellow_8;
    @FXML private ImageView Orange_8;
    @FXML private ImageView Purple_8;
    @FXML private ImageView Red_9;
    @FXML private ImageView Green_9;
    @FXML private ImageView Blue_9;
    @FXML private ImageView Yellow_9;
    @FXML private ImageView Orange_9;
    @FXML private ImageView Purple_9;
    @FXML private ImageView Red_10;
    @FXML private ImageView Green_10;
    @FXML private ImageView Blue_10;
    @FXML private ImageView Yellow_10;
    @FXML private ImageView Orange_10;
    @FXML private ImageView Purple_10;
    @FXML private ImageView GameEndSquare;
    @FXML private ImageView Pink_3_Gingerbread;
    @FXML private ImageView Pink_1_Peppermint;
    @FXML private ImageView Pink_2_Cupcake;
    @FXML private ImageView Pink_4_Candy;
    @FXML private ImageView Spinner_Spinner;
    @FXML private Button activateSpinnerButton;
    @FXML private Button exitGameButton;
    @FXML private Label playerTurnLabel;

    // SPINNER
    @FXML private ImageView candyCaneSpinner;
    @FXML private Button spinButton;


    // INITIALIZING THE PLAYERS

    @FXML private ImageView playerOnePiece;
    @FXML private ImageView playerTwoPiece;
    @FXML private ImageView playerThreePiece;
    @FXML private ImageView playerFourPiece;

    // setting player variables
    private Players player1;
    private Players player2;
    private Players player3;
    private Players player4;
    private Players currentPlayer; // Tracks the current player

    private DoublyLinkedList gameMoves;

    @FXML
    public void initialize(){
        gameMoves = new DoublyLinkedList();
        initializeGameBoard();

        // Initializing players at the start position
        player1 = new Players("Player 1", 1, gameMoves.findSpaceNumber(1), playerOnePiece);
        player2 = new Players("Player 2", 2, gameMoves.findSpaceNumber(1), playerTwoPiece);
        player3 = new Players("Player 3", 3, gameMoves.findSpaceNumber(1), playerThreePiece);
        player4 = new Players("Player 4", 4, gameMoves.findSpaceNumber(1), playerFourPiece);

        // Set the first player to start
        currentPlayer = player1;

        // initialize the Spinner with the ImageView candycane
        spinner = new Spinner(candyCaneSpinner);
    }

    private void initializeGameBoard(){
        // Adding each square to the DLL
        gameMoves.append(1, "Start");
        gameMoves.append(2, "Red");
        gameMoves.append(3, "Green");
        gameMoves.append(4, "Blue");
        gameMoves.append(5, "Yellow");
        gameMoves.append(6, "Orange");
        gameMoves.append(7, "Purple");
        gameMoves.append(8, "Red");
        gameMoves.append(9, "Green");
        gameMoves.append(10, "Blue");
        gameMoves.append(11, "Yellow");
        gameMoves.append(12, "Orange");
        gameMoves.append(13, "Purple");
        gameMoves.append(14, "Peppermint");
        gameMoves.append(15, "Red");
        gameMoves.append(16, "Green");
        gameMoves.append(17, "Blue");
        gameMoves.append(18, "Yellow");
        gameMoves.append(19, "Orange");
        gameMoves.append(20, "Purple");
        gameMoves.append(21, "Red");
        gameMoves.append(22, "Green");
        gameMoves.append(23, "Blue");
        gameMoves.append(24, "Yellow");
        gameMoves.append(25, "Orange");
        gameMoves.append(26, "Purple");
        gameMoves.append(27, "Cupcake");
        gameMoves.append(28, "Red");
        gameMoves.append(29, "Green");
        gameMoves.append(30, "Blue");
        gameMoves.append(30, "Yellow");
        gameMoves.append(32, "Orange");
        gameMoves.append(33, "Purple");
        gameMoves.append(34, "Red");
        gameMoves.append(35, "Green");
        gameMoves.append(36, "Blue");
        gameMoves.append(37, "Yellow");
        gameMoves.append(38, "Orange");
        gameMoves.append(39, "Purple");
        gameMoves.append(40, "Gingerbread Man");
        gameMoves.append(41, "Red");
        gameMoves.append(42, "Green");
        gameMoves.append(43, "Blue");
        gameMoves.append(44, "Yellow");
        gameMoves.append(45, "Orange");
        gameMoves.append(46, "Purple");
        gameMoves.append(47, "Red");
        gameMoves.append(48, "Green");
        gameMoves.append(49, "Blue");
        gameMoves.append(50, "Yellow");
        gameMoves.append(51, "Orange");
        gameMoves.append(52, "Purple");
        gameMoves.append(53, "Lollipop");
        gameMoves.append(54, "Red");
        gameMoves.append(55, "Green");
        gameMoves.append(56, "Blue");
        gameMoves.append(57, "Yellow");
        gameMoves.append(58, "Orange");
        gameMoves.append(59, "Purple");
        gameMoves.append(60, "Red");
        gameMoves.append(61, "Green");
        gameMoves.append(62, "Blue");
        gameMoves.append(63, "Yellow");
        gameMoves.append(64, "Orange");
        gameMoves.append(65, "Purple");
        gameMoves.append(66, "Final Square");

    }
    @FXML
    private void spinButton(ActionEvent e) {
        if (spinner != null && currentPlayer != null) {
            spinner.spin(currentPlayer); // Spin to move to the current player
            currentPlayer = getNextPlayer(); // Next player's turn
        } else {
            System.out.println("Spinner or current player is not initialized");
        }
        // Test String to indicate if click is registered
        System.out.println("Spin button clicked!");

    }

    private Players getNextPlayer() {
        // Cycle to the next player
        if (currentPlayer == player1) {
            return player2;
        } else if (currentPlayer == player2) {
            return player3;
        } else if (currentPlayer == player3) {
            return player4;
        } else {
            return player1; // Cycle back to player1 after player4
        }
    }

    // ending the game
    @FXML
    protected void buttonEndGame() {
        System.exit(0);
    }
}
