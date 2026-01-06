package com.work.edupageweb.configs;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void initAdmin() {
        boolean adminExists = userRepository.existsByRole(role-based.ADMIN);
        if (!adminExists) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("adminADMIN@edupage.local");
            admin.setPassword(passwordEncoder.encode("@dmin_nimd@"));
            admin.setRole(UserRole.ADMIN);

            userRepository.save(admin);

            System.out.println("Admin Created");
        }

    }
}
