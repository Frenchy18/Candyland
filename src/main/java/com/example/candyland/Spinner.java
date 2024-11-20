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
        // Generate a random spin between 720 and 1080 degrees
        int extraRandomSpinDegrees = random.nextInt(361);
        int randomSpinDegrees = 720 + extraRandomSpinDegrees;

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), candyCaneSpinner);
        rotateTransition.setByAngle(randomSpinDegrees);
        rotateTransition.setCycleCount(1);
        rotateTransition.setOnFinished(event -> {
            movePiece(currentPlayer, extraRandomSpinDegrees);  // Move current player based on the spin result
        });
        rotateTransition.play();
    }

    /**
     * Gets random result using spin method which dictates movement of piece
     * across the board/doublylinkedlist using switches for each possible spin result
     * @param piece the particular player being moved during player's turn
     */
    public void movePiece(Players piece, int randomDegrees) {
        String result = getColorFromDegrees(randomDegrees); // Random result based on degrees

        switch (result) {
            case "Red_Single": // red
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Red");
                break;
            case "Green_Single": // green
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Green");
                break;
            case "Blue_Single": // blue
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Blue");
                break;
            case "Yellow_Single": // yellow
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Yellow");
                break;
            case "Orange_Single": // orange
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Orange");
                break;
            case "Purple_Single": // purple
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Purple");
                break;
            case "Red_Double": // red double
                piece.currentSpace = doubleMove(piece, "Red");
                break;
            case "Green_Double": // green double
                piece.currentSpace = doubleMove(piece, "Green");
                break;
            case "Blue_Double": // blue double
                piece.currentSpace = doubleMove(piece, "Blue");
                break;
            case "Yellow_Double": // yellow double
                piece.currentSpace = doubleMove(piece, "Yellow");
                break;
            case "Orange_Double": // orange double
                piece.currentSpace = doubleMove(piece, "Orange");
                break;
            case "Purple_Double": // purple double
                piece.currentSpace = doubleMove(piece, "Purple");
                break;
            case "Pink1": // pink1 (Peppermint)
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink1");
                break;
            case "Pink2": // pink2 (Cupcake)
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink2");
                break;
            case "Pink3": // pink3 (GingerBread)
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink3");
                break;
            case "Pink4": // pink4 (Candy/Lollipop)
                piece.currentSpace = piece.currentSpace.moveForward(piece.currentSpace, "Pink4");
                break;
            default:
                // Handle unexpected results if necessary
                System.out.println("Unknown color: " + result);
        }
    }

    // Returns a string corresponding to the color based on the angle
    private String getColorFromDegrees(int degrees) {
        if (degrees >= 279 && degrees <= 300) return "Red_Single";
        if (degrees >= 94 && degrees <= 116) return "Red_Double";
        if (degrees >= 340 || degrees <= 5) return "Green_Single"; // Wraps around (340-360 and 0-5)
        if (degrees >= 156 && degrees <= 184) return "Green_Double";
        if (degrees >= 226 && degrees <= 249) return "Blue_Single";
        if (degrees >= 45 && degrees <= 68) return "Blue_Double";
        if (degrees >= 69 && degrees <= 93) return "Yellow_Single";
        if (degrees >= 250 && degrees <= 278) return "Yellow_Double";
        if (degrees >= 185 && degrees <= 214) return "Orange_Single";
        if (degrees >= 6 && degrees <= 32) return "Orange_Double";
        if (degrees >= 117 && degrees <= 143) return "Purple_Single";
        if (degrees >= 301 && degrees <= 328) return "Purple_Double";
        if (degrees >= 34 && degrees <= 44) return "Pink1"; // Peppermint
        if (degrees >= 144 && degrees <= 155) return "Pink2"; // Cupcake
        if (degrees >= 215 && degrees <= 225) return "Pink3"; // GingerBread
        if (degrees >= 329 && degrees <= 339) return "Pink4"; // Candy/Lollipop

        // Default case (shouldn't happen)
        return "Unknown";
    }
}
