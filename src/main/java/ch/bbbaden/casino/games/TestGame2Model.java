package ch.bbbaden.casino.games;

import ch.bbbaden.casino.NormalUser;

public class TestGame2Model extends Game {
    public TestGame2Model(NormalUser normalUser) {
        super("/fxml/TestGame2.fxml", "Test", "/images/Baccarat_Logo.png", normalUser);
    }
}
