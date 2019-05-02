package ch.bbbaden.casino.scenes;

import ch.bbbaden.casino.Controller;
import ch.bbbaden.casino.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class LoginController implements Controller {

    public Button btn_back;
    private Label label;
    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    private LoginModel loginModel;

    private void handleButtonAction(ActionEvent event) {
    }

    private void limitInput(final TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                textField.setText(newValue.toUpperCase());
            }
        });
    }

    @FXML
    private void on_login(ActionEvent event) {
        loginModel.login(username.getText(), password.getText());
    }

    public void username_onKey(KeyEvent keyEvent) {
        if (keyEvent.getCharacter().equals("\r")) {
            password.requestFocus();
            password.selectAll();
        }
    }

    public void password_onKey(KeyEvent keyEvent) {
        if (keyEvent.getCharacter().equals("\r")) {
            if (username.getText().equals("")) {
                username.requestFocus();
            } else {
                loginModel.login(username.getText(), password.getText());
            }
        }
    }

    public void btn_back_onAction(ActionEvent actionEvent) {
        loginModel.showStartMenu();
    }

    public void update() {
        username.setText(loginModel.getUsername());
        password.setText(loginModel.getPassword());
    }

    public void initialize(Model model) {
        loginModel = (LoginModel) model;
        limitInput(username);
        limitInput(password);
    }
}