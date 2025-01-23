package com.aibou.security.dto;

import com.aibou.security.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "createdBy", target = "createdBy")
    @Mapping(source = "createdDate", target = "createdDate") // Map createdDate to createdAt
    @Mapping(source = "lastModifiedBy", target = "lastModifiedBy") // Map lastModifiedBy to modifiedBy
    @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
    UserResponse toUserResponse(User user);
    @Mapping(target = "role", expression = "java(com.aibou.security.domain.Role.USER)")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(registerRequest.getPassword()))")
    User toUser(RegisterRequest registerRequest, PasswordEncoder passwordEncoder);
}
