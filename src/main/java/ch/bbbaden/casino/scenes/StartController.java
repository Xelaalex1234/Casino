/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.scenes;

import ch.bbbaden.casino.Controller;
import ch.bbbaden.casino.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author felix
 */
public class StartController implements Controller {

    @FXML
    private Button login;
    @FXML
    private Button registrieren;
    @FXML
    private Button adminLogin;

    private StartModel model;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void login(ActionEvent event) {
        model.openLogin();
    }

    @FXML
    private void registrieren(ActionEvent event) {
        model.openRegister();
    }

    @FXML
    private void adminLogin(ActionEvent event) {
    }

    public void update() {

    }

    public void initialize(Model model) {
        this.model = (StartModel) model;
    }
}
