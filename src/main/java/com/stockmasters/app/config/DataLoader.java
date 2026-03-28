package com.stockmasters.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.stockmasters.app.model.User;
import com.stockmasters.app.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataLoader(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {

        // 🔐 TEMP: generate BCrypt password
        System.out.println(encoder.encode("1234"));

        if (repo.findByUsername("admin").isEmpty()) {

            repo.save(new User(
                    "admin",
                    encoder.encode("admin123"),
                    "ROLE_ADMIN"
            ));
        }
    }
}
