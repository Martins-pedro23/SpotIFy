package com.spotify.controllers.artisitControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spotify.connection.ConnectionController;
import com.spotify.models.ArtistModel;
import com.spotify.enums.ArtistSearchParam;

public class SelectArtistByParam {
    public static ArrayList<ArtistModel> handle(ArtistSearchParam param, String value){
        try{
            ArrayList<ArtistModel> artists = new ArrayList<ArtistModel>();
            String sql = "SELECT * FROM Artist WHERE " + param.toString() + " = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int view_count = resultSet.getInt("view_count");
                String bio = resultSet.getString("bio");
                boolean verified = resultSet.getBoolean("verified");
                String[] genre = resultSet.getString("genre").split(";");
                ArtistModel artist = new ArtistModel(id, name, view_count, bio, verified, genre);
                artists.add(artist);
            }
            return artists;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
