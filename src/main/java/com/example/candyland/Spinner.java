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
/**
 * Allows for creation of spinner object for given player pieces, allowing for traversal through doublylinkedlist
 * to simulate candyland board and movement of individual players throughout the game
 */
public class Spinner {
    private Player piece1;
    private Player piece2;
    private Player piece3;
    private Player piece4;
    /**
     * Constructs spinner object for 2 players
     * @param piece1 the piece of player 1
     * @param piece2 the piece of player 2
     */
    Spinner (Player piece1, Player piece2) {
        this.piece1 = piece1;
        this.piece2 = piece2;
    }
    /**
     * Constructs spinner object for 3 players
     * @param piece1 the piece of player 1
     * @param piece2 the piece of player 2
     * @param piece3 the piece of player 3
     */
    Spinner (Player piece1, Player piece2, Player piece3) {
        this.piece1 = piece1;
        this.piece2 = piece2;
        this.piece3 = piece3;
    }
    /**
     * Constructs spinner object for 4 players
     * @param piece1 the piece of player 1
     * @param piece2 the piece of player 2
     * @param piece3 the piece of player 3
     * @param piece4 the piece of player 4
     */
    Spinner (Player piece1, Player piece2, Player piece3, Player piece4) {
        this.piece1 = piece1;
        this.piece2 = piece2;
        this.piece3 = piece3;
        this.piece4 = piece4;
    }
    /**
     * Spins once to get result for player piece movement
     * @return randomSpin.nextInt(numOptions) the random result of the spin from 0-15 for use in piece movement
     */
    public int spin() {
        Random randomSpin = new Random();
        int numOptions = 16;
        return randomSpin.nextInt(numOptions);
    }
    /**
     * Gets random result using spin method which dictates movement of piece
     * across the board/doublylinkedlist using switches for each possible spin result
     * @param piece the particular player being moved during player's turn
     */
    public void movePiece(Player piece) {
        int resultNum = spin();
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
}
