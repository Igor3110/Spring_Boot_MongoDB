package by.trofimov.project.mongodb.service;

import java.util.List;
import by.trofimov.project.mongodb.dao.UserRepository;
import by.trofimov.project.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Transactional
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
