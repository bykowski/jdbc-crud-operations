package operation.command;

import config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreateOperation {

    private static String SQL =
            "CREATE TABLE `cat` (\n" +
            "  `id` int NOT NULL,\n" +
            "  `name` varchar(100) NOT NULL,\n" +
            "  `age` int NOT NULL,\n" +
            "  `sex` varchar(100) NOT NULL\n" +
            ") DEFAULT CHARSET=utf8;";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DBConfig.INSTANCE.getUrl(), DBConfig.INSTANCE.getUser(), DBConfig.INSTANCE.getPass());
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

