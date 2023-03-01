package com.proyecto.market.web.security;

import com.proyecto.market.domain.service.UserDetailsService;
import com.proyecto.market.web.security.filter.JwtFilterRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
    public class SecurityConfig{


    private UserDetailsService userDetailsServiceOk;


    private  JwtFilterRequest filterJWT;

    @Bean
    public AuthenticationManager authManager(HttpSecurity http)throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsServiceOk)

                .and()
                .build();
    }

    //SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(filterJWT, UsernamePasswordAuthenticationFilter.class);

        return  http.csrf().disable().authorizeHttpRequests().requestMatchers("/**/autenticated",
                        "/save",
                        "/**/all",
                        "/**/swagger-ui.html",
                        "/v2/api-docs/**",
                        "/swagger.json",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**").permitAll()
                .anyRequest()
                .authenticated()
                .and() .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();

    }


}




