package operation.query;

import config.DBConfig;
import model.Cat;

import java.sql.*;

public class JdbcSelectOperation {

    private static String SQL = "SELECT id, name, age, sex FROM cat";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DBConfig.INSTANCE.getUrl(), DBConfig.INSTANCE.getUser(), DBConfig.INSTANCE.getPass());
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                Cat cat = new Cat(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("sex"));
                System.out.println(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

