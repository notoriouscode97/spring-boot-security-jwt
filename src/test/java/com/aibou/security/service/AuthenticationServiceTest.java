package com.aibou.security.service;

import com.aibou.security.domain.Role;
import com.aibou.security.domain.User;
import com.aibou.security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class AuthenticationServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = User.builder()
                .firstName("Dusan")
                .lastName("Dimic")
                .username("dimilica")
                .email("dusan@gmail.com")
                .password("dusan123")
                .role(Role.ADMIN)
                .build();

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId()); // Ensure ID is au
    }
}