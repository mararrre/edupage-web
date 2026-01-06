package com.work.edupageweb.controllers;

import com.work.edupagetest.model.dto.LoginRequestDto;
import com.work.edupagetest.model.dto.LoginResponseDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final JWT jwt; //JWT Улукбек
    private final UserRepository userRepository; // UserRepository Алексей


    public AuthController(PasswordEncoder passwordEncoder, JWT jwt, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.jwt = jwt;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));;
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwt.generateToken(user); // берём токен юзера
        return new LoginResponseDto(token, user.getRole().name()); // возвращаем токен юзера и его роль

    }
}
