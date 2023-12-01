package com.spotify;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.spotify.controllers.musicControllers.CreateMusicUseCase;
import com.spotify.models.MusicModel;
import com.spotify.models.UserModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class RegisterMusicController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField duration;

    @FXML
    private TextField idArtist;

    @FXML
    private Button returnButton;

    private UserModel userMain = new UserModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      

        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData, Object aditionalData) {
                if (newScreen.equals("registermusic")) {
                 /* transformar userData como UserModel */

                    System.out.println("RegisterMusic" + userData);
                     UserModel user = new UserModel(
                        ((UserModel) userData).getId(),
                        ((UserModel) userData).getName(),
                        ((UserModel) userData).getEmail(),
                        ((UserModel) userData).getPassword(),
                        ((UserModel) userData).getBirth_date(),
                        ((UserModel) userData).getFavorite_genres()
                     );

                    userMain = user;

                }
            }
        });
        setData();

    } 

    private void setData() {}

    @FXML
    private void createMusic() {
        MusicModel music = new MusicModel();
        music.setName(name.getText());
        music.setDuration(
            Integer.parseInt(duration.getText())
        );
        music.setArtistId(Integer.parseInt(idArtist.getText()));

        Random random = new Random();

        music.setListenerCount(random.nextInt(1000000) + 1);


        var result = CreateMusicUseCase.handle(music);

        if(result == true){
            System.out.println("Music created");
            try{
                App.changeScreen("home", userMain);
            }   catch(Exception e){
                System.out.println("Error changing page");
            }
        }
    }

    @FXML
    private void returnButton() {
        try{
            App.changeScreen("home", userMain);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    }

}
