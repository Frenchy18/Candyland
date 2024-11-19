package com.example.candyland;

// importing all classes from Candyland package
import com.example.candyland.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
// fix this
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class CandyLandController {
    // creating variable names
    private int numberOfPlayers;

    private DoublyLinkedList gameMoves;
    private Spinner spinner;
    private Players players;

    // start menu fx:id's:
    @FXML private Button buttonStartGame; // Menu screen start
    @FXML private Button buttonEndGame; // Menu screen exit
    @FXML private Button buttonTwoPlayer; // Two player button
    @FXML private Button buttonThreePlayer; // Three player button
    @FXML private Button buttonFourPlayer; // Four player button

    @FXML private ImageView playerOnePiece;
    @FXML private ImageView playerTwoPiece;
    @FXML private ImageView playerThreePiece;
    @FXML private ImageView playerFourPiece;



    // event handlers for the start menu
    @FXML void buttonStartGame(ActionEvent start) {
        try {
            // load the game screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CandyLand_PlayerScreen.fxml"));
            Scene scene = new Scene(loader.load());

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

    @FXML
    public void initialize() {
        System.out.println("Controller initialized!");
        System.out.println("playerOnePiece: " + playerOnePiece);
        System.out.println("playerTwoPiece: " + playerTwoPiece);
        System.out.println("playerThreePiece: " + playerThreePiece);
        System.out.println("playerFourPiece: " + playerFourPiece);

        setPlayersEnabled(0);
    }

    @FXML
    private void buttonTwoPlayers(ActionEvent event) throws IOException {
        navigateToGameScreen(event,2);
    }

    @FXML
    private void buttonThreePlayers(ActionEvent event) throws IOException {
        navigateToGameScreen(event,3);
    }

    @FXML
    private void buttonFourPlayers(ActionEvent event) throws IOException {
        navigateToGameScreen(event,4);
    }

    private void navigateToGameScreen(ActionEvent event, int numPlayers) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandyLand_Game.fxml"));
        Scene scene = new Scene(loader.load());

        CandyLandController controller = loader.getController();
        controller.setPlayersEnabled(numPlayers);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void setPlayersEnabled(int numPlayers) {
        List<ImageView> playerPieces = List.of(playerOnePiece, playerTwoPiece, playerThreePiece, playerFourPiece);

        for (int i = 0; i < playerPieces.size(); i++) {
            ImageView piece = playerPieces.get(i);
            if (piece != null) {
                piece.setVisible(i < numPlayers); // Show pieces for active players
            } else {
                System.out.println("Warning: player piece " + (i + 1) + " is null!");
            }
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


    /** EVENT HANDLERS BELOW HERE
    // 1. Event Handler for when player clicks "start game"
        // next screen pops up
    // 2. Event handler for when "enter players' information" pops up
        // editable text boxes for entering name. player clicks a button after names are entered to start the game.
        //those names will be written in a "player" class. 2 variables in constructor: player name & player number.
    // 3. gameboard pops up, all players will begin @ the king (before the red)..set players = "pieces"?
    // 4. player 1 clicks the spinner.
        //after the spinner result, using dll, player moves based on the result...

     */

    @FXML
    private void calculateButtonPressed(ActionEvent event) {
         }; // this code will open and display the next fxml file

    @FXML
    private void enterPlayers(ActionEvent e) { // EH #2
    }; // this code will use the fx:id's of each player's text field
    // and plug that into the "players" class
    // use the player1(2,3,etc)TextField's getText method to get the player names/numbers
    // then pass those strings to Players constructor.
    // call method selectAll to select the TextField’s text, then
    // call requestFocus to give the TextField the focus. Now the user can immediately type a value in
    // the amountTextField without having to first select its text.

    @FXML
    private void gameBoard(ActionEvent e) { // game board
        gameMoves = new DoublyLinkedList();
        // players = new Players(); // need to add params
        // spinner = new Spinner(); // need to add params

    }; // third event. open the game board and add each player to it.
    // player 1 clicks the spinner. after the spinner result, using dll,
    // player moves based on the spinner result...

}
