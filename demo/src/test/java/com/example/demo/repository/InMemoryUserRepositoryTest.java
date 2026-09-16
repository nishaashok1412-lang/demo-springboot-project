package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;

class InMemoryUserRepositoryTest {

    @Test
    void shouldSaveUserAndReturnList() {
        InMemoryUserRepository repository = new InMemoryUserRepository();

        User user = new User();
        user.setName("Dana");
        user.setEmail("dana@example.com");

        User saved = repository.save(user);

        assertNotNull(saved.getId());
        assertEquals(1, repository.findAll().size());
        assertEquals("Dana", repository.findAll().get(0).getName());
    }
}
