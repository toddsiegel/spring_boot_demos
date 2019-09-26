package demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TodosController {
    @Autowired
    private TodoRepository repository;

    @RequestMapping("/todos")
    public Iterable<Todo> index() {
        return repository.findAll();
    }

    @RequestMapping("/todos/{id}/complete")
    public Todo index(@PathVariable("id") Long id) {
        Optional<Todo> todo = repository.findById(id);
        todo.ifPresent(Todo::markComplete);
        return repository.save(todo.get());
    }
}
