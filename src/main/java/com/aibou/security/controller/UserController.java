package com.aibou.security.controller;

import com.aibou.security.domain.User;
import com.aibou.security.dto.UserResponse;
import com.aibou.security.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get All Users", description = "Return list of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found"),
            @ApiResponse(responseCode = "404", description = "Users not found")
    })
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        log.info("Received request to get all users");
        var response = userService.getUsers();
        log.info("Returning list of users: {}", response);
        return ResponseEntity.ok(response);
    }
}
