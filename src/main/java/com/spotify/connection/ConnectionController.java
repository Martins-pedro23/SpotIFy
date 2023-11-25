package com.spotify.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    public static Connection getConnection() {
        try{
            final String url = "jdbc:mysql://localhost:3306/SpotIFy";
            final String user = "root";
            final String password = "mysql";
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
