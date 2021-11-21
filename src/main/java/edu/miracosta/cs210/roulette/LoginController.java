package edu.miracosta.cs210.roulette;

public class LoginController {
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {
        return this.mainController;
    }
}
