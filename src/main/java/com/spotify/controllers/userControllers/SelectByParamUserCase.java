package com.spotify.controllers.userControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spotify.connection.ConnectionController;
import com.spotify.models.UserModel;
import com.spotify.enums.UserSearchParam;


public class SelectByParamUserCase {
    public static ArrayList<UserModel> handle(UserSearchParam param, String value){
        ArrayList<UserModel> users = new ArrayList<UserModel>(); 
        try{
            String sql = "SELECT * FROM User WHERE " + param.getParam() + " = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String birth_date = resultSet.getString("birth_date");
                String[] favorite_genres = resultSet.getString("favorite_genres").split(";");
                UserModel user = new UserModel(name, email, password, birth_date, favorite_genres);
                user.setId(id);
                users.add(user);
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return users;
    }
}
