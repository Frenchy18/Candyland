package com.example.candyland;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;

public class CandyLandController {

    @FXML
    protected void buttonEndGame() {
        System.exit(0);
    }
    /*
    @FXML
    protected void buttonStartGame( event) {
        System.load("CandyLand_PlayerScreen.fxml");
    }
    */

}
