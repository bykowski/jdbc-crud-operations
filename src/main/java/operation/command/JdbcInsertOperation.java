package operation.command;

import config.DBConfig;

import java.sql.*;

public class JdbcInsertOperation {

    private static String SQL = "INSERT INTO cat(id, name, age, sex) VALUES (104,'eeeee',1,'female')";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DBConfig.INSTANCE.getUrl(), DBConfig.INSTANCE.getUser(), DBConfig.INSTANCE.getPass());
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

