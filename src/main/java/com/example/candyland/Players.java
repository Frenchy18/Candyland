package com.example.candyland;

public class Players {
    public Node currentSpace;
    private String name;           // Name of the player
    private int playerNumber;      // Identifier for the player
    private Piece piece;           // Game piece for the player
    private boolean isWinner;      // If any player has won
    private int totalMoves;        // Total moves to help keep track of rounds

    public Players(String name, int playerNumber, Node startingSpace) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.piece = new Piece(startingSpace);
        this.isWinner = false;
        this.totalMoves = 0;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public com.example.candyland.Node getCurrentSpace() {
        return currentSpace;
    }
//    public Piece getPiece() {
//        return piece;
//    }

    public boolean isWinner() {
        return isWinner;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    // Mutators
    public void setCurrentSpace(com.example.candyland.Node currentSpace) {
        this.currentSpace = currentSpace;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    // Moving piece based on spinner result
    public void movePiece(int spinnerResult) {
        piece.move(spinnerResult);
        totalMoves += spinnerResult;

        System.out.println(name + " moved " + spinnerResult + " spaces.");
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
