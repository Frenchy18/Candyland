/**
 * PROGRAM PURPOSE: To control all scenes of the CandyLand game, allowing users to choose the number of players,
 * spin for each players turn, with methods to control the spinner, player movement, as well as display of all
 * movement of players and spinner, until the board has been traversed fully by one player, at which point a winner is
 * declared and the game ends
 * Authors: Vincent Baccari, Chris Groves, Chase Lewis, Daniela Luna, and Kian Miley
 * Date: 11/22/2024
 * Section: CSC 331-002
 */
package com.example.candyland;

// importing all classes from Candy land package

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
    private boolean gameWon;

    @FXML private ImageView playerOnePiece, playerTwoPiece, playerThreePiece, playerFourPiece;
    /**
     * Initializes the game board by setting up the linked list of spaces, called automatically when
     * the controller is loaded.
     */
    @FXML
    public void initialize() {
        gameWon = false;
        gameMoves = new DoublyLinkedList();
        gameMoves.initializeBoard();

    }
    /**
     * Sets the number of players in the game, assigns each player a starting position on first space of board.
     * @param numPlayers the number of players in the game
     */
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


    /**
     * Moves the player to the target space based on the spin result.
     * @param player the player object
     * @param moveType the type of move based on the spinner result, such as red, or double orange
     */
    @FXML
    Button activateSpinnerButton;
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
                if (targetSpace != null) {
                    if (targetSpace.getSpaceNumber() == 7) {
                        targetSpace = gameMoves.findSpaceByNumber(31);
                    }
                }
            }
        } else {
            targetSpace = currentSpace.moveForward(currentSpace, color); // Move to the first square only
            if (targetSpace != null) {
                if (targetSpace.getSpaceNumber() == 7) {
                    targetSpace = gameMoves.findSpaceByNumber(31);
                }
            }
        }

        if (targetSpace == null && currentSpace.spaceNumber >= 53) {
            gameWon = true;
            targetSpace = currentSpace.moveForward(currentSpace,"End");
            movePieceOnBoard(player ,targetSpace);
            System.out.println("Player "+ (currentTurn + 1) +" You won!");
            playerTurnLabel.setText("Player " + (currentTurn + 1) + ", you won!");
            activateSpinnerButton.setDisable(true);
            return;

        }
        if (targetSpace == null) {
            System.out.println("Error: No valid target space for moveType: "+moveType);
            return;
        }

        // Update the player's current space and move the piece
        player.setCurrentSpace(targetSpace);
        movePieceOnBoard(player, targetSpace);

        System.out.println("Player " + player.getName() + " moved to space: " + targetSpace.getSpaceNumber() +
                " (" + targetSpace.getColor() + ")");
    }
    /**
     * Moves the player's piece on the board graphically based on the target space's coordinates.
     * @param player the player whose piece needs to be moved
     * @param targetSpace the target space the player is moving to
     */
    private void movePieceOnBoard(Players player, com.example.candyland.Node targetSpace) {
        ImageView playerPiece = getPlayerPiece(player.getPlayerNumber());

        if (playerPiece != null && targetSpace != null) {
            double targetX = targetSpace.getX();
            double targetY = targetSpace.getY();

            int PlayersCount = countPlayersOnSpace(targetSpace);
            if (PlayersCount > 1) {
                // Add small offsets based on the number of players on the same space
                targetX -= 4 * PlayersCount;
            }

            TranslateTransition transition = new TranslateTransition(Duration.seconds(2),playerPiece);
            transition.setToX(targetX - playerPiece.getLayoutX());
            transition.setToY(targetY - playerPiece.getLayoutY());
            transition.play();
        } else {
            System.out.println("Error: Player piece or target space is null");
        }
    }
    /**
     * Checks if other players already on space
     * @param targetSpace the space being moved to
     * @return numPlayers the number of players on the space, includes player currently moving
     */
    private int countPlayersOnSpace(com.example.candyland.Node targetSpace) {
        int numPlayers = 0;
        for (Players player : playersList) {
            if (player.getCurrentSpace().equals(targetSpace)) {
                numPlayers++;
            }
        }
        return numPlayers;
    }
    /**
     * Returns the ImageView associated with the specified player number for usage in movement graphically
     * @param playerNumber the number of the player piece
     * @return the ImageView for the player piece
     */
    private ImageView getPlayerPiece(int playerNumber) {
        switch (playerNumber) {
            case 1: return playerOnePiece;
            case 2: return playerTwoPiece;
            case 3: return playerThreePiece;
            case 4: return playerFourPiece;
            default: return null;
        }
    }
    /**
     * Spins the wheel to determine the next move for the current player, animating the spinner and
     * processing the result when the spin finishes.
     */
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

            int randomAngle = (int) (Math.random() * 360);
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
                if (!gameWon) {
                    playerTurnLabel.setText("Player " + (currentTurn + 1) + ", it's your turn!");
                }
            });
            slowTransition.play();
        });

        rotateTransition.play();
    }
    /**
     * Determines the move type , including color and whether movement is doubled, based on the spinner's angle.
     * @param angle the angle the spinner lands at
     * @return a string representing the move type, such as red single or orange double
     */
    private String determineMoveType(int angle) {
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
    /**
     * Starts the game by initializing the game board and moving to game screen.
     * @param start the ActionEvent triggered by the "Start Game" button
     */
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
    /**
     * Ends the game by closing the current window.
     * @param exit the ActionEvent triggered by the "End Game" button
     */
    @FXML
    private void buttonEndGame(ActionEvent exit) {
        // get the current stage and close it
        Stage stage = (Stage) ((Node) exit.getSource()).getScene().getWindow();
        stage.close();
    }
    /**
     * Exits the game entirely by terminating the program.
     */
    @FXML
    private void exitGameButton() {
        System.exit(0);
    }
    /**
     * Navigates to the game screen with two players selected.
     * @param event the ActionEvent triggered by the "Two Players" button
     * @throws IOException thrown if there's an error loading the FXML
     */
    @FXML
    private void buttonTwoPlayers(ActionEvent event) throws IOException {
        navigateToGameScreen(event,2);
    }
    /**
     * Navigates to the game screen with three players selected.
     * @param event the ActionEvent triggered by the "Three Players" button
     * @throws IOException thrown if there's an error loading the FXML
     */
    @FXML
    private void buttonThreePlayers(ActionEvent event) throws IOException {
        navigateToGameScreen(event,3);
    }
    /**
     * Navigates to the game screen with four players selected.
     * @param event the ActionEvent triggered by the "Four Players" button
     * @throws IOException thrown if there's an error loading the FXML
     */
    @FXML
    private void buttonFourPlayers(ActionEvent event) throws IOException {
        navigateToGameScreen(event,4);
    }
    /**
     * Navigates to the game screen based on the selected number of players.
     * @param event the ActionEvent triggered by the button
     * @param numPlayers the number of players to set up
     * @throws IOException if there's an error loading the FXML
     */
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
    /**
     * Sets the visibility of player pieces based on the number of players.
     * @param numPlayers the number of players
     */
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
