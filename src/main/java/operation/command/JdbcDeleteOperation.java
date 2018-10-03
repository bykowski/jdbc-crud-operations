package operation.command;

import config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeleteOperation {

    private static String SQL = "DELETE FROM cat WHERE cat.id > 1";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DBConfig.INSTANCE.getUrl(), DBConfig.INSTANCE.getUser(), DBConfig.INSTANCE.getPass());
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

