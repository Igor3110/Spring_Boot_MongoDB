package by.trofimov.project.mongodb.dao;

import java.util.UUID;
import by.trofimov.project.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    User findByName(String name);

}
