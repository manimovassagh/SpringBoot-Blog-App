package com.github.manimovassagh.blog.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private UserDetailsService userDetailsService;

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(HttpMethod.GET, "/api/**")
                                .permitAll().anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//                @Bean
//                UserDetailsService userDetailsService() {
//                    UserDetails mani = User.builder()
//                            .username("mani")
//                            .password(passwordEncoder().encode("mmmmmm"))
//                            .roles("USER").build();
//
//                    UserDetails admin = User.builder()
//                            .username("admin")
//                            .password(passwordEncoder().encode("admin"))
//                            .roles("ADMIN").build();
//                    return new InMemoryUserDetailsManager(mani, admin);
//                }

}
