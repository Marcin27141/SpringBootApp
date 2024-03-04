package com.example.springApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        String defaultPassword = "P@ssw0rd";

        UserDetails admin = createUser("admin", defaultPassword, new String[] { "admin" });
        UserDetails normalUser1 = createUser("user1", defaultPassword, new String[0]);
        UserDetails normalUser2 = createUser("user2", defaultPassword, new String[0]);

        return new InMemoryUserDetailsManager(admin, normalUser1, normalUser2);
    }

    private UserDetails createUser(String username, String password, String[] roles) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}