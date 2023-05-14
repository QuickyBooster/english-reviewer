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
    @Order(1)
    public SecurityFilterChain loginFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/authentication**")).permitAll()
                        .requestMatchers("/home**").permitAll()
                        .requestMatchers("/error**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf->csrf.disable())
                .userDetailsService(jpaUserDetailsService)
                .formLogin(form->form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/authentication/login")
                        .loginProcessingUrl("/j_spring_security_check")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/authentication/login=error")
                )
                .httpBasic(Customizer.withDefaults())
                .logout(log->log
                        .logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                )
                .headers(headers -> headers
                        .frameOptions()
                        .sameOrigin()
                )
                .build();
    }
    @Bean
    @Order(0)
    public SecurityFilterChain homeFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> auth.requestMatchers("**").permitAll())
                .headers(frame->frame.frameOptions().disable())
                .build();
    }


}