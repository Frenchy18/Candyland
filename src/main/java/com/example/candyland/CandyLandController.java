package com.example.candyland;

// importing all classes from Candy land package

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
// fix this
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import javafx.animation.RotateTransition;
import javafx.animation.Interpolator;
import javafx.scene.effect.MotionBlur;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;


import java.util.ArrayList;
import java.util.List;

public class CandyLandController {
    // creating variable names
    private DoublyLinkedList gameMoves;
    private int currentTurn;
    private List<Players> playersList;

    @FXML private ImageView playerOnePiece, playerTwoPiece, playerThreePiece, playerFourPiece;

    @FXML
    public void initialize() {
        gameMoves = new DoublyLinkedList();
        gameMoves.initializeBoard();

    }

    private void setNumPlayers(int numPlayers) {
        if (gameMoves.getStart() == null) {
            System.out.println("Error: The board's starting node is null");
            return;
        }
        playersList = new ArrayList<>();
        com.example.candyland.Node startNode = gameMoves.getStart();

        for (int i = 0; i < numPlayers; i++) {
            Players player = new Players("Player "+(i+1), i+1,startNode);
            playersList.add(player);
            System.out.println("Player " + (i+1) + " assigned to space: " + startNode.spaceNumber);
        }
    }

    private void movePlayer(Players player, String moveType) {
        com.example.candyland.Node currentSpace = player.getCurrentSpace();
        com.example.candyland.Node targetSpace = null;

        if (currentSpace == null) {
            System.out.println("Error: Player " + player.getName() + " is not on the board (currentSpace is null).");
            return;
        }

        String[] moveParts = moveType.split("_");
        String color = moveParts[0];
        boolean isDouble = moveParts.length > 1 && moveParts[1].equalsIgnoreCase("Double");

        // Traverse to the target space
        if (isDouble) {
            targetSpace = currentSpace.moveForward(currentSpace, color); // Move to the first square
            if (targetSpace != null) {
                targetSpace = targetSpace.moveForward(targetSpace, color); // Move to the second square
            }
        } else {
            targetSpace = currentSpace.moveForward(currentSpace, color); // Move to the first square only
        }

        if (targetSpace == null && currentSpace.spaceNumber >= 60) {
            targetSpace = currentSpace.moveForward(currentSpace,"End");
            System.out.println("Player "+ (currentTurn) +" You won!");
            playerTurnLabel.setText("Player " + (currentTurn) + ", you won!");
            System.exit(0);
        } else if (targetSpace == null) {
            System.out.println("Error: Null exception");
        }

        // Update the player's current space and move the piece
        player.setCurrentSpace(targetSpace);
        movePieceOnBoard(player, targetSpace);

        System.out.println("Player " + player.getName() + " moved to space: " + targetSpace.getSpaceNumber() +
                " (" + targetSpace.getColor() + ")");
    }

    private void movePieceOnBoard(Players player, com.example.candyland.Node targetSpace) {
        ImageView playerPiece = getPlayerPiece(player.getPlayerNumber());

        if (playerPiece != null && targetSpace != null) {
            double targetX = targetSpace.getX();
            double targetY = targetSpace.getY();

            TranslateTransition transition = new TranslateTransition(Duration.seconds(2),playerPiece);
            transition.setToX(targetX - playerPiece.getLayoutX());
            transition.setToY(targetY - playerPiece.getLayoutY());
            transition.play();
        } else {
            System.out.println("Error: Player piece or target space is null");
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

    @FXML private ImageView Spinner_Spinner;
    @FXML private Label playerTurnLabel;
    @FXML
    private void spinTheWheel() {
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
                playerTurnLabel.setText("Player " + (currentTurn +1) + ", it's your turn!");
            });
            slowTransition.play();
        });

        rotateTransition.play();
    }

    private String determineMoveType(double angle) {
        if (angle >= 279 && angle <= 300) return "Red_Single";
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
        if (angle >= 34 && angle <= 44) return "Pink1_Peppermint";
        if (angle >= 144 && angle <= 155) return "Pink2_Cupcake";
        if (angle >= 215 && angle <= 225) return "Pink3_GingerBread";
        if (angle >= 329 && angle <= 339) return "Pink4_Candy";

        System.out.println("Error: Invalid spinner angle: "+angle);
        return "Unknown";
    }

    // event handlers for the start menu
    @FXML void buttonStartGame(ActionEvent start) {
        gameMoves = new DoublyLinkedList();
        gameMoves.initializeBoard();
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
                piece.setVisible(i < numPlayers); // Showpieces for active players
            } else {
                System.out.println("Warning: player piece " + (i + 1) + " is null!");
            }
        }
    }
}
