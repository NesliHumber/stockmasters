package com.stockmasters.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.stockmasters.app.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // PASSWORD ENCODER
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // SECURITY FILTER CHAIN
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                // PUBLIC PAGES (accessible without login)
                .requestMatchers("/", "/about", "/login", "/register", "/css/**").permitAll()

                // VIEWER (READ-ONLY ACCESS)
                // Accessible by VIEWER, STAFF, and ADMIN
                .requestMatchers("/dashboard", "/analytics", "/inventory", "/centers","/products", "/suppliers")
                .hasAnyRole("VIEWER", "STAFF", "ADMIN")

                // STAFF + ADMIN (CAN CREATE / UPDATE DATA)
                .requestMatchers("/products/**", "/suppliers/**")
                .hasAnyRole("STAFF", "ADMIN")

                // ADMIN ONLY (HIGH-LEVEL CONTROL)
                .requestMatchers("/admin/**", "/users/**")
                .hasRole("ADMIN")

                // ALL OTHER REQUESTS REQUIRE AUTHENTICATION
                .anyRequest().authenticated()
            )

            // LOGIN CONFIG (custom login page)
            .formLogin(form -> form
                .loginPage("/login") // custom login page
                .successHandler(new CustomSuccessHandler()) // redirect after successful login to handle user selection
                .failureUrl("/login?error=true") // login error handling
                .permitAll()
            )

            // LOGOUT CONFIG
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // redirect after logout
                .permitAll()
            )

            // ACCESS DENIED HANDLING (403 → custom page instead of Whitelabel error)
            .exceptionHandling(e -> e
                .accessDeniedPage("/access-denied")
            );

        return http.build();
    }
}