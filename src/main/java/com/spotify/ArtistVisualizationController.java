package com.spotify;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import com.spotify.controllers.artisitControllers.SelectArtistByIdUseCase;
import com.spotify.models.ArtistModel;

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

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArtistModel artist = SelectArtistByIdUseCase.handle(1);
        System.out.println(artist.getName());
        setData(artist);
    } 

    private void setData (ArtistModel artist) {
        userName.setText(artist.getName());
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
    }
}
