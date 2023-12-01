package com.spotify;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.spotify.controllers.artisitControllers.SelectAllArtistUseCase;
import com.spotify.controllers.musicControllers.SelectAllMusicsUseCase;
import com.spotify.controllers.musicControllers.SelectMusicByParam;
import com.spotify.controllers.artisitControllers.SelectArtistByParam;
import com.spotify.enums.MusicSearchParam;
import com.spotify.enums.ArtistSearchParam;
import com.spotify.models.ArtistModel;
import com.spotify.models.MusicModel;
import com.spotify.models.UserModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HomeVisualizationController implements Initializable {
     
    @FXML
    private ListView<String> ArtistsList;

    @FXML
    private ListView<String> SongsList;


    @FXML
    private Label name;

    @FXML
    private Button RegisterMusicButton;

    @FXML
    private TextField searchArtistField;

    @FXML
    private TextField searchMusicField;

    ArtistModel firstArtist = new ArtistModel();
    MusicModel firstMusic = new MusicModel();


    private UserModel userMain = new UserModel();

    @FXML
    private void RegisterMusicButton() {
        System.out.println("vai trocar" + userMain.getName());
        if(userMain != null) {
            try{
            System.out.println("rodou para criar musica");
            App.changeScreen("registermusic", userMain);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<ArtistModel> artist = SelectAllArtistUseCase.handle();
        
        ArrayList<String> artistName = new ArrayList<String>();
        if (artist != null) {
            for(int i = 0; i < artist.size(); i++){
                artistName.add(artist.get(i).getName());
            }
            ArtistsList.getItems().addAll(artistName);
        }

            ArrayList<MusicModel> songs = SelectAllMusicsUseCase.handle();
        
         ArrayList<String> songsName = new ArrayList<String>();

         if (songs != null) {
            for(int i = 0; i < songs.size(); i++){
                songsName.add(songs.get(i).getName() + "-" + songs.get(i).getId() + "-" + songs.get(i).getListenerCount()) ;
            }
            SongsList.getItems().addAll(songsName);
         }



        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData, Object aditionalData) {
                if (newScreen.equals("home")) {
                    System.out.println("Home" + userData);
                    if(userData != null) {
                        UserModel user = new UserModel(
                            ((UserModel) userData).getId(),
                            ((UserModel) userData).getName(),
                            ((UserModel) userData).getEmail(),
                            ((UserModel) userData).getPassword(),
                            ((UserModel) userData).getBirth_date(),
                            ((UserModel) userData).getFavorite_genres()
                         );
                    
                        if(user != null) {
                            System.out.println("exite");
                            name.setText(user.getName());
                            userMain = user;
                        } 

                    }
                    setData();
                }
            }
        });
        

        setData();

    } 


    @FXML
    private void searchMusicMethod() {
        
        if(searchMusicField != null) {
            ArrayList<MusicModel> music = SelectMusicByParam.handle(
                MusicSearchParam.NAME,
                new String(searchMusicField.getText())

            );
            ArrayList<String> musicName = new ArrayList<String>();
            if (music != null) {
                for(int i = 0; i < music.size(); i++){
                    musicName.add(music.get(i).getName());
                }
                SongsList.getItems().clear();
                SongsList.getItems().addAll(musicName);

                firstMusic = music.get(0);
            }



            
        }
    }

    @FXML
    private void searchArtistMethod() {
            
            if(searchArtistField != null) {
                ArrayList<ArtistModel> artist = SelectArtistByParam.handle(
                    ArtistSearchParam.NAME,
                    new String(searchArtistField.getText())

                );
                ArrayList<String> artistName = new ArrayList<String>();
                if (artist != null) {
                    for(int i = 0; i < artist.size(); i++){
                        artistName.add(artist.get(i).getName());
                    }
                    ArtistsList.getItems().clear();
                    ArtistsList.getItems().addAll(artistName);

                    firstArtist = artist.get(0);
                }
            }
        
    }

    @FXML
    private void pageArtistMethod() {
        try{
            System.out.println("Artista selecionado" + firstArtist.getName());
            App.changeScreen("artist", userMain, firstArtist);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    } 

    @FXML
    private void pageMusicMethod() {
        try{
            App.changeScreen("music", userMain, firstMusic);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    }
    
    @FXML
    private void profilePage() {
        try{
            App.changeScreen("perfil", userMain);
        }   catch(Exception e){
            System.out.println("Error changing page");
        }
    }

    private void setData () {
        
    }


}
