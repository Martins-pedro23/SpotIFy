package com.spotify;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.spotify.controllers.musicControllers.SelectMusicByParam;
import com.spotify.enums.MusicSearchParam;
import com.spotify.models.ArtistModel;
import com.spotify.models.MusicModel;
import com.spotify.models.UserModel;

public class ArtistVisualizationController implements Initializable{
    @FXML
    private Label userName;
    @FXML
    private Label artistName;
    @FXML
    private Label artistViews;
    @FXML
    private Label artistBio;
    @FXML
    private Label artistVerification;
    @FXML
    private Label artistGenre;
    @FXML
    private ListView<String> artistSongsList;

    private UserModel userMain = new UserModel();

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {        
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData, Object aditionalData) {
                if (newScreen.equals("artist")) {
                    if(userData != null && aditionalData != null) {
                        UserModel user = new UserModel(
                            ((UserModel) userData).getId(),
                            ((UserModel) userData).getName(),
                            ((UserModel) userData).getEmail(),
                            ((UserModel) userData).getPassword(),
                            ((UserModel) userData).getBirth_date(),
                            ((UserModel) userData).getFavorite_genres()
                        );

                        ArtistModel artist = new ArtistModel(
                            ((ArtistModel) aditionalData).getId(),
                            ((ArtistModel) aditionalData).getName(),
                            ((ArtistModel) aditionalData).getView_count(),
                            ((ArtistModel) aditionalData).getBio(),
                            ((ArtistModel) aditionalData).isVerified(),
                            ((ArtistModel) aditionalData).getGenre()
                        );

                        if (userData != null) {
                            userName.setText(user.getName());
                            userMain = user;

                           
                        }

                        if(aditionalData != null) {
                            artistName.setText(artist.getName());
                            artistViews.setText(artist.getView_count()+"");
                            artistBio.setText(artist.getBio());
                            String verified = artist.isVerified() ? "sim" : "nao";
                            artistVerification.setText(verified);

                            String genre = "";
                            for(int i = 0; i < artist.getGenre().length; i++){
                                genre += artist.getGenre()[i];
                                if(i != artist.getGenre().length - 1){
                                    genre += ", ";
                                }
                            }
                            artistGenre.setText(genre);

                            ArrayList<MusicModel> songs = SelectMusicByParam.handle(
                                MusicSearchParam.ARTIST_ID,
                                "" + artist.getId()
                            );

                            ArrayList<String> songsName = new ArrayList<String>();

                            if (songs != null) {
                                for(int i = 0; i < songs.size(); i++){
                                    songsName.add(songs.get(i).getName() + "-" + songs.get(i).getId() + "-" + songs.get(i).getListenerCount()) ;
                                }
                                artistSongsList.getItems().addAll(songsName);
                            }

                        

                        }

                         

                    }
                }
            }
        });

        setData();
    } 

    private void setData () {
       
    }

    @FXML
    private void returnHome() {
        App.changeScreen("home", userMain);
    }

    @FXML
    private void profilePage() {
        try{
            App.changeScreen("perfil", userMain);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    }

    @FXML
    private void registerMusicPage(){
        try{
            App.changeScreen("registerMusic", userMain);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    }
}
