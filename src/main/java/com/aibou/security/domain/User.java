package com.aibou.security.domain;

import com.aibou.security.config.security.Auditable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "_user")
@Schema(description = "User entity")
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique Identifier of the User", example = "1")
    private Integer id;
    @Schema(description = "First name of the User", example = "John")
    private String firstName;
    @Schema(description = "Last name of the User", example = "Doe")
    private String lastName;
    @Schema(description = "Username of the User", example = "johndoe123")
    private String username;
    @Schema(description = "Email of the User", example = "johndoe@gmail.com")
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
