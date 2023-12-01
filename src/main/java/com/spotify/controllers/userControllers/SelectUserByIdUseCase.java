package com.spotify.controllers.userControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.UserModel;


public class SelectUserByIdUseCase {
    public static UserModel handle(int id){
        try{
            String sql = "SELECT * FROM User WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

                return new UserModel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("favorite_genres").split(";")
                );

            }else{
                return null;
            }
        }catch(SQLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}