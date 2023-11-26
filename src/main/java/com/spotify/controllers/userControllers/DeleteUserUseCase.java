package com.spotify.controllers.userControllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spotify.connection.ConnectionController;

public class DeleteUserUseCase {
    public static void deleteUser(int id) {
        try{
            String sql = "DELETE FROM User WHERE id = ?";
            Connection connection = ConnectionController.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
