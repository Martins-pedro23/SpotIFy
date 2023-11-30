package com.spotify.controllers.musicControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spotify.connection.ConnectionController;

public class DeleteMusicUseCase {
    public static boolean handle(int id){
        try{
            String sql = "SELECT * FROM Playlist";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ArrayList<Integer> songs_id = new ArrayList<Integer>();
                String songs = resultSet.getString("songs");
                String[] songs_id_string = songs.split(";");
                for(int i = 0; i < songs_id_string.length; i++){
                    songs_id.add(Integer.parseInt(songs_id_string[i]));
                }
                if(songs_id.contains(id)){
                    songs_id.remove((Integer)id);
                    sql = "UPDATE Album SET songs = ? WHERE id = ?";
                    preparedStatement = connection.prepareStatement(sql);
                    String newSongs = "";
                    for(int i = 0; i < songs_id.size(); i++){
                        newSongs += songs_id.get(i) + ";";
                    }
                    preparedStatement.setString(1, newSongs);
                    preparedStatement.setInt(2, resultSet.getInt("id"));
                    preparedStatement.executeUpdate();
                }
            }

            sql = "DELETE FROM Music WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
