package com.spotify.controllers.musicControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.spotify.connection.ConnectionController;
import com.spotify.models.MusicModel;

import java.util.ArrayList;

public class SelectAllMusicsUseCase {
    public static ArrayList<MusicModel> handle(){
        try{
            ArrayList<MusicModel> musics = new ArrayList<MusicModel>();

            String sql = "SELECT * FROM Songs";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("chegou 0");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int listener_count = resultSet.getInt("listener_count");
                int album_id = resultSet.getInt("album_id");
                Timestamp timestamp = resultSet.getTimestamp(
                    "duration"

                );
                int duration = (int) timestamp.getTime();
                int artist_id = resultSet.getInt("artist_id");

                System.out.println("chegou 1");


                /* converter para int e salvar no musicModel */
                MusicModel music = new MusicModel(
                    id, 
                    name, 
                    listener_count, 
                    album_id, 
                    duration, 
                    artist_id
                );
                musics.add(music);
            }


            return musics;
            
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
