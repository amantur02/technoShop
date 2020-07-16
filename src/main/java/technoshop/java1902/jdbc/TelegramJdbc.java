package technoshop.java1902.jdbc;

import technoshop.java1902.entity.CommentByUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelegramJdbc {
    DbWorker dbWorker = new DbWorker();

    public Integer selectFromUsers(String password) {
        String SQL = "select id from users where password = ?";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setString(1, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String createTelegramRegistration(Long telegramId, Integer userId) {
        String SQL = "insert into telegram_registration(telegram_id, users_id) values (?,?)";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setLong(1, telegramId);
            preparedStatement.setInt(2,userId);
            preparedStatement.execute();

            return "Пользователь успешно сохранен";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Произошла не предвиденная ошибка!";
    }
    public Integer selectFromTelegramRegistration(Long telegram_id) {
        String SQL = "select users_id from telegram_registration where telegram_id = ?";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setLong(1, telegram_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String createComments(String namePhones,Integer userId, String commit) {
        String SQL = "insert into comments(name_phones, text, user_id) values (?,?,?)";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setString(1,namePhones);
            preparedStatement.setString(2, commit);
            preparedStatement.setInt(3,userId);
            preparedStatement.execute();

            return "Комментарий успешно сохранен";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Произошла не предвиденная ошибка!";
    }
    public String selectFromMyComment(Integer userId) {
        String SQL = "select name_phones, text from comments where user_id = ?";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                String name = rs.getString(1);
                String text = rs.getString(2);
                String response = "Смартфон: " + name + "\n" +
                        "Комментарий: " + text;
                return response;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> selectFromComment(String namePhones) {
        String SQL = "select text,user_id from comments where name_phones = ?";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setString(1, namePhones);
            ResultSet rs = preparedStatement.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next())
            {
                String userId = String.valueOf(rs.getInt(2));
                String text = rs.getString(1);
                list.add(userId + "-" + text);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public String selectFromUsersWhereId(Long id) {
        String SQL = "select login from users where id = ?";
        try (Connection conn = dbWorker.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
