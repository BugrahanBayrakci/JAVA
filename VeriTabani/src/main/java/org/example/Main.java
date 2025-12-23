package org.example;
import java.sql.*;


public class Main {


    static void main() {

        dbHelper helper=new dbHelper();
        java.sql.Statement statement =null;
        ResultSet resultSet;

        try (Connection conn = helper.getConnection() ) {
            statement=conn.createStatement();
            resultSet=statement.executeQuery("select  Code ,name from country ");
            while(resultSet.next()){

                System.out.println(resultSet.getString("Name"));
            }
            System.out.println("MySQL baglandi");
        } catch (SQLException e) {
            helper.showError(e);
        }
    }
    }

