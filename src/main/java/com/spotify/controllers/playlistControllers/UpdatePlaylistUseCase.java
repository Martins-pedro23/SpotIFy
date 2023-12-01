package com.spotify.controllers.playlistControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.PlaylistModel;

public class UpdatePlaylistUseCase {
    public static boolean handle(PlaylistModel playlist){
        try{
            String sql = "UPDATE Playlist SET name = ?, user_id = ?, bio = ?, songs_id = ?, likes = ? WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, playlist.getName());
            preparedStatement.setInt(2, playlist.getUser_id());
            preparedStatement.setString(3, playlist.getBio());
            String songs_id = "";
            for(int i = 0; i < playlist.getSongs_id().length; i++){
                songs_id += playlist.getSongs_id()[i];
                if(i != playlist.getSongs_id().length - 1){
                    songs_id += ";";
                }
            }
            preparedStatement.setString(4, songs_id);
            preparedStatement.setInt(5, playlist.getLikes());
            preparedStatement.setInt(6, playlist.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
