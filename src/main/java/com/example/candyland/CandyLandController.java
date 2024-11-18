package com.example.candyland;

// importing all classes from Candyland package
import com.example.candyland.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CandyLandController {
    // creating variable names
    private DoublyLinkedList gameMoves;
    private Spinner spinner;
    private Players players;

    // all fd:id's will be added to this section
    @FXML
    private Label labelExampleUntilGUIisComplete; // label to show player's current space

    @FXML
    private Button buttonExampleUntilGUIisComplete; // Spinner button

    /** EVENT HANDLERS BELOW HERE
    // 1. Event Handler for when player clicks "start game"
        // next screen pops up
    // 2. Event handler for when "enter players' information" pops up
        // editable text boxes for entering name. player clicks a button after names are entered to start the game.
        //those names will be written in a "player" class. 2 variables in constructor: player name & player number.
    // 3. gameboard pops up, all players will begin @ the king (before the red)..set players = "pieces"?
    // 4. player 1 clicks the spinner.
        //after the spinner result, using dll, player moves based on the result...

     */

    @FXML
    private void calculateButtonPressed(ActionEvent event) {// this is where the first EH will go
         }; // this code will open and display the next fxml file

    @FXML
    private void enterPlayers(ActionEvent e) { // EH #2
    }; // this code will use the fx:id's of each player's text field
    // and plug that into the "players" class
    // use the player1(2,3,etc)TextField's getText method to get the player names/numbers
    // then pass those strings to Players constructor.
    // call method selectAll to select the TextField’s text, then
    // call requestFocus to give the TextField the focus. Now the user can immediately type a value in
    // the amountTextField without having to first select its text.

    @FXML
    private void gameBoard(ActionEvent e) { // game board
        gameMoves = new DoublyLinkedList();
        // players = new Players(); // need to add params
        // spinner = new Spinner(); // need to add params

    }; // third event. open the game board and add each player to it.
    // player 1 clicks the spinner. after the spinner result, using dll,
    // player moves based on the spinner result...




    // ending the game
    //@FXML
    //protected void buttonEndGame() {
      //  System.exit(0);
    //}
}
