package com.example.candyland;

import javafx.scene.image.ImageView;

public class Players {
    public Node currentSpace;
    private String name;           // Name of the player
    private int playerNumber;      // Identifier for the player
    private Piece piece;           // Game piece for the player
    private boolean isWinner;      // If any player has won
    private int totalMoves;        // Total moves to help keep track of rounds

    public Players(String name, int playerNumber, Node startingSpace, ImageView pieceImageView) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.piece = new Piece(startingSpace);
        this.isWinner = false;
        this.totalMoves = 0;
        this.currentSpace = startingSpace;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }


    // Check if the player has won
    public boolean checkWin(Node finalSpace) {
        if (piece.getCurrentSpace() == finalSpace) {
            this.isWinner = true;
            System.out.println(name + " has reached the final space and won!");
        }
        return isWinner;
    }

    // Debugging Helper
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNumber=" + playerNumber +
                ", currentSpace=" + piece.getCurrentSpace().spaceNumber +
                ", isWinner=" + isWinner +
                ", totalMoves=" + totalMoves +
                '}';
    }
}
