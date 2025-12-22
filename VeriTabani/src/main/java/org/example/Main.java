package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Main {
    static void main() {
        String url = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("MySQL baglandi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

