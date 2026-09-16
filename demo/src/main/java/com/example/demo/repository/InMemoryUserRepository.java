package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Long nextId = (long) (users.size() + 1);
        user.setId(nextId);
        users.add(user);
        return user;
    }
}
