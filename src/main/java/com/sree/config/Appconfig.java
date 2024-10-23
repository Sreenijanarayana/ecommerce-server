package com.sree.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class Appconfig {

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Stateless session
        .and()
        .authorizeHttpRequests(Authorize -> Authorize
            .requestMatchers("/auth/**").permitAll()  // Allow unauthenticated access to /auth endpoints
            .anyRequest().authenticated())  // Require authentication for other requests
        .csrf().disable()  // Disable CSRF (important for stateless JWT-based apps)
        .cors().configurationSource(new CorsConfigurationSource() {

            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                
                CorsConfiguration cfg = new CorsConfiguration();
                
                // Allow multiple origins
                cfg.setAllowedOrigins(Arrays.asList(
                    "http://localhost:3000",  // React app (development)
                    "http://localhost:4200",  // Angular app (development)
                    "https://shop-ecommerce-azure.vercel.app",  // Main deployed frontend
                    "https://shop-ecommerce-git-master-sreenijanarayanas-projects.vercel.app",  // Another deployed version
                    "https://shop-ecommerce-sreenijanarayanas-projects.vercel.app"  // Another version
                ));
                
                cfg.setAllowedMethods(Collections.singletonList("*"));  // Allow all methods (GET, POST, etc.)
                cfg.setAllowedHeaders(Collections.singletonList("*"));  // Allow all headers
                cfg.setAllowCredentials(true);  // Allow credentials (cookies, auth headers)
                cfg.setExposedHeaders(Arrays.asList("Authorization"));  // Expose Authorization header for frontend access
                cfg.setMaxAge(3600L);  // Cache the CORS configuration for 1 hour
                
                return cfg;
            }
        })
        .and()
        .httpBasic(Customizer.withDefaults())  // Basic HTTP security configuration
        .formLogin();  // Default form login (if required for other parts of the app)
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // To hash and encode passwords
    }
}
