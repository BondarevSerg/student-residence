package ru.bondarev.student.residence.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.bondarev.student.residence.security.UserDetailsServiceImp;

import static org.springframework.security.config.Customizer.withDefaults;
/**
 * Конфигурация Security
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsServiceImp userDetailsService;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/new_user").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/students/**",
                        "/residencies/**","/universities/**","/users/**")
                .authenticated()
                .and()
                .userDetailsService(userDetailsService)
                .httpBasic(withDefaults())
                .headers().frameOptions().disable()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
