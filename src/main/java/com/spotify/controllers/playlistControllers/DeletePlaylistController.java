package com.spotify.controllers.playlistControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;

public class DeletePlaylistController {
    public static boolean handle(int id){
        try{
            String sql = "DELETE FROM Playlist WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
