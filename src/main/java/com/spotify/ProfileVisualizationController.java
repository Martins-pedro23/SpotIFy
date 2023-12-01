package com.spotify;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import com.spotify.models.UserModel;

public class ProfileVisualizationController implements Initializable {

    @FXML
    private Label userName;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label age;

    @FXML
    private Label gener;

    private UserModel userMain = new UserModel();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData, Object aditionalData) {
                if (newScreen.equals("perfil")) {
                    if(userData != null) {
                        UserModel user = new UserModel(
                            ((UserModel) userData).getId(),
                            ((UserModel) userData).getName(),
                            ((UserModel) userData).getEmail(),
                            ((UserModel) userData).getPassword(),
                            ((UserModel) userData).getBirth_date(),
                            ((UserModel) userData).getFavorite_genres()
                        );

                        userMain = user;
                        userName.setText(user.getName());
                        name.setText(user.getName());
                        email.setText(user.getEmail());
                        age.setText(user.getBirth_date().toString());
                        gener.setText(user.getFavorite_genres()[0]

                        );
                    }
                }
            }
        });
    }

    @FXML
    private void returnHome() {
        App.changeScreen("home", userMain);
    }

    @FXML
    private void profilePage() {
        
    }

    @FXML
    private void registerMusicPage() {
        App.changeScreen("registermusic", userMain);
    }
}
