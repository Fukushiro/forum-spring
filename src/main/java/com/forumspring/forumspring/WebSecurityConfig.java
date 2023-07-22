package com.forumspring.forumspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {



//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
////        UserDetails user = User.builder()
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build();
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password("password")
////                .roles("USER", "ADMIN")
////                .build();
//
//        UserDetails user2 =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER", "ADMIN")
//                        .build();
//
//        UserDetails user3 = User.withUsername("user")
//                .password("password")
//                .roles("USER", "ADMIN")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .authorities("USER")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(admin);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        System.out.println(http);
//        http.csrf(csrf->csrf.disable()).cors(cors->cors.disable()).authorizeHttpRequests((requests) -> requests
//                .requestMatchers( "/").permitAll()
//                .requestMatchers("/posts").hasRole("USER")
//                .requestMatchers(
//                        "/users/auth", "/posts/{id}", "/comments/post/{idPost}", "/comments/subcomments/{idComment}"
//                ).hasRole("USER")
//                .anyRequest().authenticated()
//        ).httpBasic(withDefaults());
//
//        return http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
