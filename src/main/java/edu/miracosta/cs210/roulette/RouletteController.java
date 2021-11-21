package edu.miracosta.cs210.roulette;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RouletteController {

    @FXML
    private Button spinButton;

    @FXML
    protected void onSpinButtonClick() {
        String text = spinButton.getText();
        if (text.equals("Spin!")) {
            spinButton.setText("Stop");
        } else {
            spinButton.setText("Spin!");
        }

    }
}
