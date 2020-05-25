package MyProject.db;

import MyProject.servlets.HerokuEnv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlConnection {
private final static String URL="jdbc:postgresql://localhost:5432/postgres";
private final static String Name="postgres";
private final static String Password="secret";

    public  Connection connection;


    public static Connection getConnection(){
        try {
            //, Name, Password
            return   DriverManager.getConnection(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
           // return DriverManager.getConnection(URL, Name, Password);

        } catch (SQLException ex) {
            throw new RuntimeException("Something went wrong", ex);
        }
    }

    public PreparedStatement preparedStatement (String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

}
