package com.example.ps.domain;

import com.example.ps.entity.UserEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private Date registerTime;

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .registerTime(user.getRegisterTime())
                .build();
    }

    public static User toDomain(UserEntity entity) {
        return User.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .name(entity.getName())
                .email(entity.getEmail())
                .registerTime(entity.getRegisterTime())
                .build();
    }

    public void hashPassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

}
