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
                int release_year = resultSet.getInt("release_year");
                int view_count = resultSet.getInt("view_count");
                String[] genre = resultSet.getString("genre").split(";");
                AlbumModel album = new AlbumModel(id, name, artist_id, release_year, view_count, genre);
                albums.add(album);
            }
            return albums;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
