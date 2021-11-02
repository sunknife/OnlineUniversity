package autoleasing.model.dao.implementation;

import autoleasing.model.dao.UserDao;
import autoleasing.model.dao.mapper.UserMapper;
import autoleasing.model.entity.Status;
import autoleasing.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM users")) {
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            UserMapper mapper = new UserMapper();
            while (resultSet.next()) {
                result.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {

    }

    @Override
    public Optional<User> findByUsername(String username) {

        Optional<User> result = Optional.empty();
        try(PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM users WHERE email = ?")) {
            preparedStatement.setString(1, username);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            UserMapper mapper = new UserMapper();
            if (resultSet.next()) {
                result = Optional.of(mapper.extractFromResultSet(resultSet));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public void updateStatus(Long id, Status status) {
        try (PreparedStatement preparedStatement = connection.prepareCall("UPDATE users SET status = ? WHERE id = ?")){
            preparedStatement.setString(1, status.toString());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
