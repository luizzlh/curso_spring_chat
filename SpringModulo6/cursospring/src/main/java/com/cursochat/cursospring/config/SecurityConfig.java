package com.cursochat.cursospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
      http.authorizeHttpRequests(auth -> auth.requestMatchers("/cadastro", "/lista").permitAll()
      .requestMatchers("/api/**").authenticated()
      .anyRequest().authenticated()
      )
      .formLogin(form -> form
         .loginPage("/login")
         .permitAll()
      )
      .logout(logout -> logout.permitAll());

      return http.build();
   }
}