/**
 * PROGRAM PURPOSE: To create a player class for storing, changing, and retrieving information about each player
 * in CandyLand, for usage in gameplay and display of current location of player objects
 * Authors: Vincent Baccari, Chris Groves, Chase Lewis, Daniela Luna, and Kian Miley
 * Date: 11/22/2024
 * Section: CSC 331-002
 */

package com.example.candyland;

public class Players {
    public Node currentSpace;
    private String name;           // Name of the player
    private int playerNumber;      // Identifier for the player
    /**
     * Creates a new player object with info about the current location of the player
     * initialized as the starting space of the board, and a passed in name
     * and player number, for usage in display, traversal, and gameplay of CandyLand
     * @param name the name associated with the player
     * @param playerNumber the number of the player
     * @param startingSpace the initial space the player starts at
     */
    public Players(String name, int playerNumber, Node startingSpace) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.currentSpace = startingSpace;
    }
    /**
     * Returns name of player object
     * @return name, name of player object
     */
    public String getName() {
        return name;
    }
    /**
     * Returns number of player object
     * @return playerNumber, number of player object
     */
    public int getPlayerNumber() {
        return playerNumber;
    }
    /**
     * Returns current space player object is on
     * @return currentSpace, current space player object is located at
     */
    public Node getCurrentSpace() {
        return currentSpace;
    }
    /**
     * Changes location of player object
     * @param currentSpace, the space the player object should be moved to
     */
    public void setCurrentSpace(Node currentSpace) {
        this.currentSpace = currentSpace;
    }
    /**
     * Overrides toString method to display all info for player object
     * @return string containing all information for player object
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNumber=" + playerNumber +
                ", currentSpace=" + getCurrentSpace().spaceNumber +
                '}';
    }
}
