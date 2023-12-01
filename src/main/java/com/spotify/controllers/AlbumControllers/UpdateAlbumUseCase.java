package com.spotify.controllers.AlbumControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.AlbumModel;

public class UpdateAlbumUseCase {
    public static boolean handle(AlbumModel album){
        try{
            String sql = "UPDATE Album SET name = ?, artist_id = ?, year = ?, songs = ?, listener_count = ? WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, album.getName());
            preparedStatement.setInt(2, album.getArtistId());
            preparedStatement.setInt(3, album.getYear());
            String songs = "";
            for(int i = 0; i < album.getSongs().length; i++){
                songs += album.getSongs()[i];
                if(i != album.getSongs().length - 1){
                    songs += ";";
                }
            }
            preparedStatement.setString(4, songs);
            preparedStatement.setInt(5, album.getListener_count());
            preparedStatement.setInt(6, album.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
