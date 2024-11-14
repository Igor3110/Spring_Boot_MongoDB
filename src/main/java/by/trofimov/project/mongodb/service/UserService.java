package by.trofimov.project.mongodb.service;

import java.util.List;
import by.trofimov.project.mongodb.entity.User;

public interface UserService {

    List<User> findAll();

    User findByName(String name);

    User saveOrUpdate(User user);

    void deleteUser(User user);

}
