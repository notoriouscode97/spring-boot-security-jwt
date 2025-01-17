package com.aibou.security.dto;

import com.aibou.security.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);
    @Mapping(target = "role", expression = "java(com.aibou.security.domain.Role.USER)")
    User toUser(RegisterRequest registerRequest);
}
