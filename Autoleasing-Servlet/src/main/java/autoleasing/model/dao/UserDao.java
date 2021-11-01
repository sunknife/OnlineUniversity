package autoleasing.model.dao;

import autoleasing.model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User>{

    Optional<User> findByUsername(String username);
}
