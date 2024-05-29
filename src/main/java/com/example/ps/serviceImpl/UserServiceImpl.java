package com.example.ps.serviceImpl;

import com.example.ps.domain.User;
import com.example.ps.entity.UserEntity;
import com.example.ps.repository.UserRepository;
import com.example.ps.security.JwtUtil;
import com.example.ps.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public User registerUser(User user) {
        user.hashPassword(passwordEncoder);
        UserEntity entity = User.toEntity(user);
        entity.setRegisterTime(new Date());
        userRepository.save(entity);
        return User.toDomain(entity);
    }

    @Override
    public String loginUser(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(username);
       // User user = User.toDomain(userEntity);
     //   user.setPassword(token); // Set token as password field for demonstration
        return jwtUtil.generateToken(username);
    }

    @Override
    @Transactional
    public User changePassword(String username, String oldPassword, String newPassword) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(oldPassword, userEntity.getPassword())) {
            throw new RuntimeException("Invalid current password");
        }

        userEntity.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(userEntity);
        return User.toDomain(userEntity);
    }
}
