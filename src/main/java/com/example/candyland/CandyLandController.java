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
import javafx.animation.RotateTransition;
import javafx.animation.Interpolator;
import javafx.scene.effect.MotionBlur;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class CandyLandController {
    // creating variable names
    private DoublyLinkedList gameMoves;
    private Spinner spinner;
    private Players players;

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
    private void exitGameButton() {
        System.exit(0);
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

    @FXML private ImageView Spinner_Spinner;
    @FXML
    private void spinTheWheel(ActionEvent event) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2),Spinner_Spinner);
        rotateTransition.setByAngle(1080);
        rotateTransition.setInterpolator(Interpolator.EASE_OUT);
        rotateTransition.setCycleCount(1);

        MotionBlur motionBlur = new MotionBlur();
        Spinner_Spinner.setEffect(motionBlur);

        rotateTransition.setOnFinished(e -> {
            Spinner_Spinner.setEffect(null);

            double randomAngle = Math.random() * 360;
            RotateTransition slowTransition = new RotateTransition(Duration.seconds(1),Spinner_Spinner);
            slowTransition.setToAngle(randomAngle);
            slowTransition.setInterpolator(Interpolator.EASE_OUT);
            slowTransition.setCycleCount(1);
            slowTransition.setOnFinished(ev -> {
                int result = calculateSpinnerNumber(randomAngle);
                System.out.println("Spinner result: "+result);
            });
            slowTransition.play();
        });

        rotateTransition.play();
    }

    private int calculateSpinnerNumber(double angle) {
        int numSegments = 16;
        double segmentSize = 360.0 / numSegments;

        return (int) (angle / segmentSize);
    }




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
    private void gameBoard(ActionEvent e) { // game board
        gameMoves = new DoublyLinkedList();
        // players = new Players(); // need to add params
        // spinner = new Spinner(); // need to add params

    }; // third event. open the game board and add each player to it.
    // player 1 clicks the spinner. after the spinner result, using dll,
    // player moves based on the spinner result...

}
