package demos;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
