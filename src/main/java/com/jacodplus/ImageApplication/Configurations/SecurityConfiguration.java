package com.jacodplus.ImageApplication.Configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${spring.profiles.active:dev}")
    private String activeProfile;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Disable CSRF for APIs

        if ("dev".equalsIgnoreCase(activeProfile) || "uat".equalsIgnoreCase(activeProfile) || "prod".equalsIgnoreCase(activeProfile)) {
            http.authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()
                    ); // Use basic auth
        } else {
            http.authorizeHttpRequests(auth -> auth
                    .anyRequest().denyAll()
            );
        }

        return http.build(); // IMPORTANT: build the HttpSecurity object
    }
}
