package GUI;

import com.example.spring.model.Пользователь;

import java.sql.*;
import java.util.Optional;

public class ПользовательServiceGUI {
    public Optional<Пользователь> findByЛогин(String username) {
        Пользователь пользователь = null;
        final String DB_URL = "jdbc:postgresql://localhost:5432/3";
        final String USERNAME = "postgres";
        final String PASSWORD = "1234";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Пользователь WHERE Логин = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                пользователь = new Пользователь();
                пользователь.setЛогин(resultSet.getString("Логин"));
                пользователь.setПароль(resultSet.getString("Пароль"));
                пользователь.setId(resultSet.getInt("Код_пользователя"));
                пользователь.setНазваниеРоли(resultSet.getString("Название_роли"));
            }
            statement.close();
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(пользователь);
    }
}
