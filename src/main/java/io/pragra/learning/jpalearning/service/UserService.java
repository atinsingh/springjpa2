package io.pragra.learning.jpalearning.service;

import io.pragra.learning.jpalearning.entity.User;
import io.pragra.learning.jpalearning.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User addUser(User user) {
        return repo.save(user);
    }
}
