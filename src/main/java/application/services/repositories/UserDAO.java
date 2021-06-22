package application.services.repositories;

import application.entities.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
