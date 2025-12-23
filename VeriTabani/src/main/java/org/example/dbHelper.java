package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbHelper {

    private String url = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "12345";
public Connection getConnection() throws SQLException {

   return DriverManager.getConnection(url, user, password);

}

public void showError(SQLException exception){
    System.out.println("Error: "+ exception.getMessage());
}

}
