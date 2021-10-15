package autoleasingspring.controller;

import autoleasingspring.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*@RestController
@RequestMapping("/api/users")
public class UserController {
    private List<User> users;
    @GetMapping
    public List<User> getAll() {
        return users;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        this.users.add(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.users.removeIf(user -> user.getId().equals(id));
    }
}*/
