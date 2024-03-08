package com.example.springtanky.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    @Primary
    public HttpSecurity securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        request ->
                                request.requestMatchers("/","/styles/**", "/", "/images/**", "/scripts/**", "/fonts/**", "/search/**","/account/**","/home")
                                        .permitAll()
                                        .requestMatchers("/maps")
                                        .authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/account/login")
                        .loginProcessingUrl("/account/login")
                        .defaultSuccessUrl("/", true)
                        .usernameParameter("email")
                        .permitAll())
                .logout((logout -> logout
                        .permitAll()
                        .logoutUrl("/account/logout")
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                ));
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
