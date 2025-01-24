package com.aibou.security.service;

import com.aibou.security.config.security.CustomUserDetails;
import com.aibou.security.config.security.CustomUserDetailsService;
import com.aibou.security.config.security.JwtService;
import com.aibou.security.domain.Role;
import com.aibou.security.domain.User;
import com.aibou.security.dto.AuthenticationRequest;
import com.aibou.security.dto.AuthenticationResponse;
import com.aibou.security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @Test
    public void testSaveAdminUser() {
        User user = User.builder()
                .firstName("Dusan")
                .lastName("Dimic")
                .username("dimilica")
                .email("dusan@gmail.com")
                .password(passwordEncoder.encode("dusan123"))
                .role(Role.ADMIN)
                .build();

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId()); // Ensure ID is au
    }

    @Test
    public void testSaveUser() {
        User user = User.builder()
                .firstName("Uros")
                .lastName("Milovanovic")
                .username("urkela")
                .email("uros@gmail.com")
                .password(passwordEncoder.encode("dusan123"))
                .role(Role.USER)
                .build();

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId()); // Ensure ID is au
    }

    @Test
    public void testAuthenticate_Success() {
        // Arrange
        String email = "dusan@gmail.com";
        String password = "dusan123";

        // Save a test user to the database (or in-memory storage)
        CustomUserDetails userDetails = createTestUser(email);

        // Create an authentication request
        AuthenticationRequest request = new AuthenticationRequest(email, password);

        // Act
        AuthenticationResponse response = authenticationService.authenticate(request);

        // Assert
        assertNotNull(response.getToken());
        assertTrue(jwtService.isTokenValid(response.getToken(), userDetails));
    }

    private CustomUserDetails createTestUser(String email) {
        return userDetailsService.loadUserByUsername(email);
    }
}