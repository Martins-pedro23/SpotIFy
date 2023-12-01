package com.spotify.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    public static Connection getConnection() {
        try{
            final String url = "jdbc:mysql://root:BGg3E6dCGGfBHhhDdEA4c4CDG-C2AC5F@monorail.proxy.rlwy.net:55261/railway";
            final String user = "root";
            final String password = "BGg3E6dCGGfBHhhDdEA4c4CDG";
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
