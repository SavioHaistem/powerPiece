package db;
import exceptions.DbException;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static Connection connection = null;
    public static Connection getConnection() throws DbException {
        String basepath = new File("").getAbsolutePath();
        try {
            Class.forName("org.sqlite.JDBC");
            if (connection == null) {
                String url = "jdbc:sqlite:" + basepath + "/src/db/akumas.db";
                connection = DriverManager.getConnection(url);
                System.out.println("connection successes");
                return connection;
            }
            return connection;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("classForNameError");
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("connection closed");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void setConnection(Connection connection) {
        DB.connection = connection;
    }
}