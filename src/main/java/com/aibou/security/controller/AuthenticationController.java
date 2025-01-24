package com.aibou.security.controller;

import com.aibou.security.dto.AuthenticationRequest;
import com.aibou.security.dto.AuthenticationResponse;
import com.aibou.security.dto.UserResponse;
import com.aibou.security.service.AuthenticationService;
import com.aibou.security.dto.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Create a new User", description = "Returns created user")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> register(
             @Valid @RequestBody RegisterRequest request
    ) {
        log.info("Received register request: {}", request);
        var response = authService.register(request);
        log.info("Returning register response: {}", response);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Login", description = "Returns token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "403", description = "Bad credentials")
    })
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        log.info("Received authentication request: {}", request);
        var response = authService.authenticate(request);
        log.info("Return authentication response: {}", response);
        return ResponseEntity.ok(response);
    }
}
