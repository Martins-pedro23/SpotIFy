package com.spotify.controllers.musicControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.MusicModel;

public class SelectAllMusicsUseCase {
    public static MusicModel[] handle(){
        try{
            String sql = "SELECT * FROM Music";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            int size = 0;
            while(resultSet.next()){
                size++;
            }
            resultSet.beforeFirst();
            MusicModel[] musics = new MusicModel[size];
            int i = 0;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int listener_count = resultSet.getInt("listener_count");
                int album_id = resultSet.getInt("album_id");
                int duration = resultSet.getInt("duration");
                int artist_id = resultSet.getInt("artist_id");
                MusicModel music = new MusicModel(id, name, listener_count, album_id, duration, artist_id);
                musics[i] = music;
                i++;
            }
            return musics;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
