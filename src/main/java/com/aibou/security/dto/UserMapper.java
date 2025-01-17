package com.aibou.security.dto;

import com.aibou.security.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);
    @Mapping(target = "role", expression = "java(com.aibou.security.domain.Role.USER)")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(registerRequest.getPassword()))")
    User toUser(RegisterRequest registerRequest, PasswordEncoder passwordEncoder);
}
