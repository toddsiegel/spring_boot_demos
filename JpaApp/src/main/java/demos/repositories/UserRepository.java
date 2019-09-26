package demos.repositories;

import demos.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    Iterable<User> findByName(String name);
}
