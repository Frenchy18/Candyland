/**
 * PROGRAM PURPOSE: To create a spinner class capable of creating a spinner object returning random
 * colors to dictate user movement, calling methods of the player and doublylinkedlist classes in order to
 * store and change data depending on results of spinner
 * Author: Chase Lewis
 * Date: 11/14/2024
 * Section: CSC 331-002
 */
package com.example.candyland;
import java.util.Random;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Allows for creation of spinner object for given player pieces, allowing for traversal through doublylinkedlist
 * to simulate candyland board and movement of individual players throughout the game
 */
public class Spinner {
    private ImageView candyCaneSpinner; // ImageView reference for spinner
    private final Random random = new Random();
    // constructor for Spinner object
    public Spinner (ImageView candyCaneSpinner) {
        this.candyCaneSpinner = candyCaneSpinner;
    }

    /**
     * Spins once to get result for player piece movement
     * @return randomSpin.nextInt(numOptions) the random result of the spin from 0-15 for use in piece movement
     */
    public void spin(Players currentPlayer) {
        // Generate a random spin between 720 and 1440 degrees
        int randomSpinDegrees = 720 + random.nextInt(720);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), candyCaneSpinner);
        rotateTransition.setByAngle(randomSpinDegrees);
        rotateTransition.setCycleCount(2);
        rotateTransition.setOnFinished(event -> {
            movePiece(currentPlayer);  // Move current player based on the spin result
        });
        rotateTransition.play();
    }

    /**
     * Gets random result using spin method which dictates movement of piece
     * across the board/doublylinkedlist using switches for each possible spin result
     * @param piece the particular player being moved during player's turn
     */
    public void movePiece(Players piece) {
        int resultNum = random.nextInt(16); // Random numbers from 0-16 representing slots on Spinner
        switch (resultNum) {
            case 0: // red
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Red");
                break;
            case 1: // green
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Green");
                break;
            case 2: // blue
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Blue");
                break;
            case 3: // yellow
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Yellow");
                break;
            case 4: // orange
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Orange");
                break;
            case 5: // purple
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Purple");
                break;
            case 6: // red double
                for (int numTimes = 0; numTimes < 2; numTimes++) { // move the piece forward twice on red
                    piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Red");
                }
                break;
            case 7: // green double
                for (int numTimes = 0; numTimes < 2; numTimes++) { // move the piece forward twice on green
                    piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Green");
                }
                break;
            case 8: // blue double
                for (int numTimes = 0; numTimes < 2; numTimes++) { // move the piece forward twice on blue
                    piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Blue");
                }
                break;
            case 9: // yellow double
                for (int numTimes = 0; numTimes < 2; numTimes++) { // move the piece forward twice on yellow
                    piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Yellow");
                }
                break;
            case 10: // orange double
                for (int numTimes = 0; numTimes < 2; numTimes++) { // move the piece forward twice on orange
                    piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Orange");
                }
                break;
            case 11: // purple double
                for (int numTimes = 0; numTimes < 2; numTimes++) { // move the piece forward twice on purple
                    piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Purple");
                }
                break;
            case 12: // pink1
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink1"); // move the piece forward or back to pink space 1
                break;
            case 13: // pink2
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink2"); // move the piece forward or back to pink space 2
                break;
            case 14: // pink3
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink3"); // move the piece forward or back to pink space 3
                break;
            case 15: // pink4
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink4"); // move the piece forward or back to pink space 4
                break;
        }
    }

    private Node doubleMove(Players piece, String color) {
        Node current = piece.currentSpace;
        for (int numTimes = 0; numTimes < 2; numTimes++) {
            current = current.moveForward(current, color);
        }
        return current;
    }
}

