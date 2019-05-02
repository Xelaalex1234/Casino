package ch.bbbaden.casino;

import ch.bbbaden.casino.scenes.StartModel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws SQLException {
        new ModelManager(stage).setModel(new StartModel());

        NormalUser normalUser = new NormalUser();
        normalUser.login("FELIX", "XILEFTON");
        normalUser.addCoins(50, true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
