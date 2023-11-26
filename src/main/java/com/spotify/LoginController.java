package com.spotify;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import javafx.event.ActionEvent;

import com.spotify.controllers.userControllers.SelectByParamUserCase;
import com.spotify.enums.UserSearchParam;
import com.spotify.models.UserModel;

public class LoginController {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    private void login(ActionEvent event) throws IOException {
        ArrayList<UserModel> userModel = SelectByParamUserCase.handle(UserSearchParam.EMAIL, email.getText());

        if(userModel.size() == 0){
            System.out.println("User not found");
        }else{
            if(userModel.get(0).getPassword().equals(password.getText())){
                System.out.println("User logged in");
            }else{
                System.out.println("Wrong password");
            }
        }
    }
} 
