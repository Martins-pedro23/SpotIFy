package com.spotify.controllers.userControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.UserModel;

public class UpdateUserUseCase {
    public static void updateUser(UserModel user) {
        try{
            String sql = "UPDATE users SET name = ?, email = ?, password = ?, birth_date = ?, favorite_genres = ? WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getBirth_date());
            String favorite_genres = "";
            for(int i = 0; i < user.getFavorite_genres().length; i++){
                favorite_genres += user.getFavorite_genres()[i];
                if(i != user.getFavorite_genres().length - 1){
                    favorite_genres += ";";
                }
            }
            preparedStatement.setString(5, favorite_genres);
            preparedStatement.setInt(6, user.getId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
