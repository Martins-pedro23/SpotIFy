package com.spotify.controllers.AlbumControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.AlbumModel;
import com.spotify.enums.AlbumSearchParam;

import java.sql.ResultSet;
import java.util.ArrayList;



public class SelectFromAlbumByParam {
    public static ArrayList<AlbumModel> handle(AlbumSearchParam param, String value){
        try{
            ArrayList<AlbumModel> albums = new ArrayList<AlbumModel>();
            String sql = "SELECT * FROM Album WHERE " + param.toString() + " = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int artist_id = resultSet.getInt("artist_id");
                int year = resultSet.getInt("year");
                String song = resultSet.getString("songs");
                String[] songs = song.split(";");
                int[] songsID = new int[songs.length];
                for(int i = 0; i < songs.length; i++){
                    songsID[i] = Integer.parseInt(songs[i]);
                }
                int listener_count = resultSet.getInt("listener_count");
                AlbumModel album = new AlbumModel(id, name, artist_id, year, songsID, listener_count);
                albums.add(album);
            }
            return albums;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
