package com.example.lmsbackend.config;

import com.example.lmsbackend.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/", "/home", "/register", "/login", "/api/books").permitAll(); // Permit all for these paths
                    auth.anyRequest().authenticated(); // Any other request must be authenticated
                })
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/home", true) // Redirect to home on success
                        .permitAll() // Allow access to all users
                )
                .logout(LogoutConfigurer::permitAll); // Allow logout for all users

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password encoder bean
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth
                .userDetailsService(userDetailsService) // Set custom user details service
                .passwordEncoder(passwordEncoder); // Injected password encoder
    }
}