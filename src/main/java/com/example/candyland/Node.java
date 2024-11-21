/**
 * PROGRAM PURPOSE: To create a node class capable of storing data associated with space on CandyLand board, as well
 * as x and y coordinates for usage in display, for usage in DoublyLinkedList for complete CandyLand game board.
 * Authors: Vincent Baccari, Chris Groves, Chase Lewis, Daniela Luna, and Kian Miley
 * Date: 11/22/2024
 * Section: CSC 331-002
 */

package com.example.candyland;


public class Node {
    int event;
    String eventMessage;
    int spaceNumber;
    String color;
    Node prev;
    Node next;
    private double x;
    private double y;
    /**
     * Creates a new node representing a square on the CandyLand game board.
     * Each node contains information about the square's space number, color, event type, event message,
     * and coordinates for display purposes.
     * @param spaceNumber the number of the space on the game board (0 to 65)
     * @param color the color of the square
     * @param event the event associated with this space (0 if none)
     * @param eventMessage a message describing the event if one exists
     * @param x the x-coordinate for display
     * @param y the y-coordinate for display
     */
    public Node(int spaceNumber, String color, int event, String eventMessage, double x, double y) {
        this.event = event;
        this.eventMessage = eventMessage;
        this.color = color;
        this.spaceNumber = spaceNumber;
        this.x = x;
        this.y = y;
        this.prev = null;
        this.next = null;
    }
    /**
     * Moves the player forward to the next space with color spun
     * @param currentSpace the current location of the player
     * @param color the color of the space the player should move to
     * @return current, the new current space the player has moved to
     */
    public Node moveForward(Node currentSpace, String color) {
        if (color.equalsIgnoreCase("Pink1") || color.equalsIgnoreCase("Pink2") ||
                color.equalsIgnoreCase("Pink3") || color.equalsIgnoreCase("Pink4")) {
            while (currentSpace.prev != null) {
                currentSpace = currentSpace.prev;
            }
        }
        Node current = currentSpace.next; // Start with the next node
        while (current != null) {
            System.out.println("Traversing Node: " + current.spaceNumber + " with color: " + current.color);
            if (current.color.equalsIgnoreCase(color)) {
                System.out.println("Found target node: " + current.spaceNumber + " (" + current.color + ")");
                return current; // Found the next node of the specified color
            }
            current = current.next; // Continue traversing
        }
        System.out.println("No matching node found for color: " + color);
        return null; // No matching node found
    }
    /**
     * Returns number associated with node
     * @return spaceNumber, number of node
     */
    public int getSpaceNumber() {
        return spaceNumber;
    }
    /**
     * Returns x coordinate of node
     * @return x, x coordinate of node
     */
    public double getX() {
        return x;
    }
    /**
     * Returns y coordinate of node
     * @return y, y coordinate of node
     */
    public double getY() {
        return y;
    }
    /**
     * Returns color associated with node
     * @return color, color of node
     */
    public String getColor() {
        return color;
    }
}
