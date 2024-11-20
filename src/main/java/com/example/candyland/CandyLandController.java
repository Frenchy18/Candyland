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
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;


import java.util.ArrayList;
import java.util.List;

public class CandyLandController {
    // creating variable names
    private DoublyLinkedList gameMoves;
    private Spinner spinner;
    private Players players;
    private int currentTurn;
    private List<Players> playersList;


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
        controller.setNumPlayers(numPlayers);

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

    private void setNumPlayers(int numPlayers) {
        gameMoves = new DoublyLinkedList();
        gameMoves.initializeBoard();
        playersList = new ArrayList<>();
        com.example.candyland.Node startNode = gameMoves.getStart();
        for (int i = 0; i < numPlayers; i++) {
            Players player = new Players("Player "+(i+1), i+1,startNode);
            player.setCurrentSpace(startNode);
            playersList.add(player);
        }
    }

    @FXML private ImageView Spinner_Spinner;
    @FXML
    private void spinTheWheel(ActionEvent event) {
        if (playersList == null || playersList.isEmpty()) {
            System.out.println("Error: playersList is empty");
            return;
        }
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
                String moveType = determineMoveType(randomAngle);
                System.out.println("Spinner landed on: "+moveType);

                Players currentPlayer = playersList.get(currentTurn);
                movePlayer(currentPlayer,moveType);

                currentTurn = (currentTurn+1) % playersList.size();

            });
            slowTransition.play();
        });

        rotateTransition.play();
    }


    private String determineMoveType(double angle) {
        if (angle >= 279 && angle <= 300) return "Red_Single)";
        if (angle >= 94 && angle <= 116) return "Red_Double";
        if ((angle >= 340 && angle <= 360) || (angle >= 0 && angle <= 6)) return "Green_Single";
        if (angle >= 156 && angle <= 184) return "Green_Double";
        if (angle >= 226 && angle <= 249) return "Blue_Single";
        if (angle >= 45 && angle <= 68) return "Blue_Double";
        if (angle >= 69 && angle <= 93) return "Yellow_Single";
        if (angle >= 250 && angle <= 278) return "Yellow_Double";
        if (angle >= 185 && angle <= 214) return "Orange_Single";
        if (angle >= 7 && angle <= 33) return "Orange_Double";
        if (angle >= 117 && angle <= 143) return "Purple_Single";
        if (angle >= 301 && angle <= 328) return "Purple_Double";
        if (angle >= 34 && angle <= 44) return "Pink_1_Peppermint";
        if (angle >= 144 && angle <= 155) return "Pink_2_Cupcake";
        if (angle >= 215 && angle <= 225) return "Pink_3_GingerBread";
        if (angle >= 329 && angle <= 339) return "Pink_4_Candy";

        return "Unknown";
    }

    private void moveToNextSpace(Players player, String moveType) {
        Node currentSpace = player.getCurrentSpace();
        Node targetSpace = currentSpace;

        switch (moveType) {
            case "Red_Single":
                targetSpace = currentSpace.moveForward(currentSpace, "Red");
                break;
            case "Red_Double":
                targetSpace = currentSpace.moveForward(currentSpace, "Red");
                if (targetSpace != null) targetSpace = targetSpace.moveForward(targetSpace, "Red");
                break;
            case "Green_Single":
                targetSpace = currentSpace.moveForward(currentSpace,"Green");
                break;
            case "Green_Double":
                targetSpace = currentSpace.moveForward(currentSpace,"Green");
                if (targetSpace != null) targetSpace = targetSpace.moveForward(targetSpace, "Green");
                break;
            case "Blue_Single":
                targetSpace = currentSpace.moveForward(currentSpace,"Blue");
                break;
            case "Blue_Double":
                targetSpace = currentSpace.moveForward(currentSpace,"Blue");
                if (targetSpace != null) targetSpace = targetSpace.moveForward(targetSpace,"Blue");
                break;
            case "Yellow_Single":
                targetSpace = currentSpace.moveForward(currentSpace,"Yellow");
                break;
            case "Yellow_Double":
                targetSpace = currentSpace.moveForward(currentSpace,"Yellow");
                if (targetSpace != null) targetSpace = targetSpace.moveForward(targetSpace,"Yellow");
                break;
            case "Orange_Single":
                newSpace = currentSpace.moveForward(currentSpace,"Orange");
                break;
            case "Orange_Double":
                newSpace = currentSpace.moveForward(currentSpace,"Orange");
                if (newSpace != null) newSpace = newSpace.moveForward(newSpace, "Orange");
                break;
            case "Purple_Single":
                newSpace = currentSpace.moveForward(currentSpace,"Purple");
                break;
            case "Purple_Double":
                newSpace = currentSpace.moveForward(currentSpace,"Purple");
                if (newSpace != null) newSpace = newSpace.moveForward(newSpace,"Purple");
                break;
            case "Pink_1_Peppermint":
            case "Pink_2_Cupcake":
            case "Pink_3_GingerBread":
            case "Pink_4_Candy":
                newSpace = currentSpace.moveForward(currentSpace,moveType.split("_")[1]);
                break;
        }

    }

    private void movePlayer(Players player, String moveType) {
        com.example.candyland.Node currentSpace = player.getCurrentSpace();
        com.example.candyland.Node newSpace = currentSpace;

        switch (moveType) {
            case "Red_Single":
            case "Red_Double":
            case "Green_Single":
            case "Green_Double":
            case "Blue_Single":
            case "Blue_Double":
            case "Yellow_Single":
            case "Yellow_Double":
            case "Orange_Single":
            case "Orange_Double":
            case "Purple_Single":
            case "Purple_Double":
            case "Pink_1_Peppermint":
            case "Pink_2_Cupcake":
            case "Pink_3_GingerBread":
            case "Pink_4_Candy":
                moveToNextSpace(currentSpace, moveType);
                break;
        }

        if (newSpace != null) {
            player.setCurrentSpace(newSpace);
            movePieceOnBoard(player,newSpace);

            if (newSpace == gameMoves.getEnd()) {
                player.setWinner(true);
                System.out.println(player.getName() + " has won the game!");
            }
        }
    }

    private ImageView getPlayerPiece(int playerNumber) {
        switch (playerNumber) {
            case 1: return playerOnePiece;
            case 2: return playerTwoPiece;
            case 3: return playerThreePiece;
            case 4: return playerFourPiece;
            default: return null;
        }
    }

    private void movePieceOnBoard(Players player, com.example.candyland.Node space) {
        ImageView piece = getPlayerPiece(player.getPlayerNumber());

        if (piece != null && targetSpace != null) {
            animatePiece(piece,targetSpace.getX(),targetSpace.get());
        }
    }

    private void animatePiece(ImageView piece, double targetX, double targetY) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2),piece);
        transition.setToX(targetX);
        transition.setToY(targetY);
        transition.play();
    }


}
