package demos.controllers;

import demos.entities.User;
import demos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public Iterable<User> users(@RequestParam(name = "name", required = false) String name) {
        if (name != null) {
            return repository.findByName(name);
        } else {
            return repository.findAll();
        }
    }

    @GetMapping("/users/{id}")
    public User byId(@PathVariable("id") long id) {
        return repository.findById(id);
    }
}
