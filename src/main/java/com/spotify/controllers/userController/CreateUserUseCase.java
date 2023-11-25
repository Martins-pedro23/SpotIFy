package com.spotify.controllers.userController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;
import com.spotify.models.UserModel;

public class CreateUserUseCase {
    public static UserModel handle(UserModel user) {
        try{
            String sql = "INSERT INTO users (name, email, password, birth_date, favorite_genres) VALUES (?, ?, ?, ?, ?)";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getBirth_date().toString());
            String favorite_genres = "";
            for(int i = 0; i < user.getFavorite_genres().length; i++){
                favorite_genres += user.getFavorite_genres()[i];
                if(i != user.getFavorite_genres().length - 1){
                    favorite_genres += ";";
                }
            }
            preparedStatement.setString(5, favorite_genres);
            preparedStatement.executeUpdate();
            return user;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
