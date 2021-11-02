package autoleasing.model.service;

import autoleasing.model.dao.DaoFactory;
import autoleasing.model.dao.UserDao;
import autoleasing.model.entity.Status;
import autoleasing.model.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<User> login(String username) {
        Optional<User> result;
        try (UserDao userDao = daoFactory.createUserDao()) {
            result = userDao.findByUsername(username);
        }
        return result;
    }

    public List<User> findAll() {
        List<User> result;
        try (UserDao userDao = daoFactory.createUserDao()) {
            result = userDao.findAll();
        }
        return result;
    }

    public void updateStatus(Long id, Status status) {
        try (UserDao userDao = daoFactory.createUserDao()) {
            userDao.updateStatus(id,status);
        }
    }
}
