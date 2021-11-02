package autoleasing.model.dao;

import autoleasing.model.entity.Status;
import autoleasing.model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User>{

    Optional<User> findByUsername(String username);

    void  updateStatus(Long id, Status status);
}
