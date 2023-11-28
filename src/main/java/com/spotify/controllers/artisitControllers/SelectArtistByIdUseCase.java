package com.spotify.controllers.artisitControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.ArtistModel;


public class SelectArtistByIdUseCase {
    public static ArtistModel handle(int id){
        try{
            String sql = "SELECT * FROM Artist WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Found artist with id: " + id);
                System.out.println("Name: " + resultSet.getString("name"));
                String name = resultSet.getString("name");
                int view_count = resultSet.getInt("view_count");
                String bio = resultSet.getString("bio");
                boolean verified = resultSet.getBoolean("verified");
                String[] genre = resultSet.getString("genre").split(";");
                ArtistModel artist = new ArtistModel(name, view_count, bio, verified, genre);
                artist.setId(id);
                return artist;
            }else{
                throw new SQLException("No artist with id: " + id);
            }
        }catch(SQLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}