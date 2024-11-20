package com.example.candyland;

public class Piece {
    private Node currentSpace;

    // Constructor: Initialize the piece with its starting position
    public Piece(Node startingSpace) {
        this.currentSpace = startingSpace;

    }
    // Get the current space of the piece
    public Node getCurrentSpace() {
        return currentSpace;
    }

    // Move the piece by a given number of spaces
    public void move(int spaces) {
        Node nextSpace = currentSpace;
        for (int i = 0; i < spaces; i++) {
            if (nextSpace.next == null) {
                System.out.println("Piece cannot move further; reached the end of the board.");
                break; // Stop if there's no more space to move to
            }
            nextSpace = nextSpace.next;
        }
        currentSpace = nextSpace; // Update the current position of the piece
    }

    // Debugging helper
    @Override
    public String toString() {
        return "Piece{" +
                "currentSpace=" + (currentSpace != null ? currentSpace.spaceNumber : "null") +
                '}';
    }
}
