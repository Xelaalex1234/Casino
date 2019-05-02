/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.scenes;

import ch.bbbaden.casino.Controller;
import ch.bbbaden.casino.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author felix
 */
public class RegisterController implements Controller {

    public Button login;
    public TextField username;
    public Button register;
    public PasswordField password;
    public TextField startCoins;
    private RegisterModel registerModel;

    private void limitInput(final TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                if (newValue.length() >= 20) {
                    textField.setText(oldValue);
                } else {
                    textField.setText(newValue.toUpperCase());
                }
            }
        });
    }

    public void on_register(ActionEvent actionEvent) throws NumberFormatException {
        registerModel.register(username.getText(), password.getText(), Integer.parseInt(startCoins.getText()));
    }

    public void update() {

    }

    public void initialize(Model model) {
        registerModel = (RegisterModel) model;

        limitInput(password);
        limitInput(username);

        startCoins.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                if (!newValue.matches("[0-9]*")) {
                    startCoins.setText(oldValue);
                }
            }
        });
    }
}
