package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demo.model.User;
import com.example.demo.repository.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void shouldCreateUserAndReturnList() {
        UserService userService = new UserServiceImpl(new InMemoryUserRepository());

        User user = new User();
        user.setName("Carol");
        user.setEmail("carol@example.com");

        User created = userService.createUser(user);

        assertNotNull(created.getId());
        assertEquals("Carol", created.getName());
        assertEquals("carol@example.com", created.getEmail());
        assertEquals(1, userService.getUsers().size());
    }
}
