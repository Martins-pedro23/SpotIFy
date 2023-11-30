package com.spotify.controllers.playlistControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.PlaylistModel;
import java.util.ArrayList;

public class SelectPlaylistByUser {
    
    public static ArrayList<PlaylistModel> handle(int user_id){
        try{
            ArrayList<PlaylistModel> playlists = new ArrayList<PlaylistModel>();
            String sql = "SELECT * FROM Playlist WHERE user_id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String bio = resultSet.getString("bio");
                int likes = resultSet.getInt("likes");
                String[] songs_id = resultSet.getString("songs_id").split(";");
                int [] songs_id_int = new int[songs_id.length];
                for(int i = 0; i < songs_id.length; i++){
                    songs_id_int[i] = Integer.parseInt(songs_id[i]);
                }
                PlaylistModel playlist = new PlaylistModel(id, name, bio, songs_id_int, likes, user_id);
                playlists.add(playlist);
            }
            return playlists;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }	
}
