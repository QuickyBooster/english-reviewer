package com.quicky.englishreviewer.security.config;

import com.quicky.englishreviewer.security.service.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(0)
    public SecurityFilterChain loginFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(AntPathRequestMatcher.antMatcher("/authentication**"))
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> auth.requestMatchers("**").permitAll())
                .userDetailsService(jpaUserDetailsService)
                .formLogin(form->form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/authentication/login")
                        .loginProcessingUrl("/j_spring_security_check")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/authentication/login=error")
                )
                .logout(log->log
                        .logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                )
                .build();
    }
    @Bean
    @Order(1)
    public SecurityFilterChain homeFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> auth.requestMatchers("**").permitAll())
                .headers(frame->frame.frameOptions().disable())
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain othersFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated())
                .build();
    }

}