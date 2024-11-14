package by.trofimov.project.mongodb.controller;

import java.util.List;
import java.util.UUID;
import by.trofimov.project.mongodb.dao.UserRepository;
import by.trofimov.project.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/users", params = {"name"})
    public ResponseEntity<User> findUserByName(@RequestParam String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }

    @PostMapping("users")
    public User saveUser(@RequestBody User user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }

    @PutMapping("users")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("users")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return ResponseEntity.ok("User with id " + user.getId() + " was successfully deleted");
    }

}
