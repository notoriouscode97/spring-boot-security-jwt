package com.aibou.security.service;

import com.aibou.security.domain.User;
import com.aibou.security.dto.UserMapper;
import com.aibou.security.dto.UserResponse;
import com.aibou.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        log.info("Get Users: users size:{}", users.size());
        return users.stream().map(userMapper::toUserResponse).toList();
    }

    public Optional<User> getUserByEmail(String email) {
        log.info("Get user by email:{}", email);
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByUsername(String username) {
        log.info("Get user by username:{}", username);
        return userRepository.findByUsername(username);
    }
}
