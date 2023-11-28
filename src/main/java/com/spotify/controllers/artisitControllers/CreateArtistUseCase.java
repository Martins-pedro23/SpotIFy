package com.spotify.controllers.artisitControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.ArtistModel;


public class CreateArtistUseCase {
    public static ArtistModel handle(ArtistModel artist){
        try{
            String sql = "INSERT INTO Artist (name, view_count, bio, verified, genre) VALUES (?, ?, ?, ?, ?)";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setInt(2, artist.getView_count());
            preparedStatement.setString(3, artist.getBio());
            preparedStatement.setBoolean(4, artist.isVerified());
            String genre = "";
            for(int i = 0; i < artist.getGenre().length; i++){
                genre += artist.getGenre()[i];
                if(i != artist.getGenre().length - 1){
                    genre += ";";
                }
            }
            preparedStatement.setString(5, genre);
            preparedStatement.executeUpdate();
            return artist;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
