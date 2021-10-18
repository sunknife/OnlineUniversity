package autoleasingspring.service;

import autoleasingspring.entity.Status;
import autoleasingspring.entity.User;
import autoleasingspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserStatus(Long id, Status status) {
        userRepository.updateUserStatusById(status,id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    };

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
