package com.spotify.controllers.musicControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.MusicModel;

public class CreateMusicUseCase {
    public static boolean handle(MusicModel music){
        try{
            String sql = "INSERT INTO Songs(name, listener_count, album_id, duration, artist_id) VALUES(?, ?, ?, ?, ?)";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, music.getName());
            preparedStatement.setInt(2, music.getListenerCount());
            preparedStatement.setInt(3, music.getAlbumId());
            preparedStatement.setInt(4, music.getDuration());
            preparedStatement.setInt(5, music.getArtistId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
