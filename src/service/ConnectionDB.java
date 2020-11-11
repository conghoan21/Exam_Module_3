package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/product_management?serverTimezone=UTC";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Hoanpro9xxxx";

    public static Connection getConnect(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
