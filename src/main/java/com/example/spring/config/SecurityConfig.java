package com.example.spring.config;

import com.example.spring.impl.МойПользовательDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService пользовательDetailsService(){

        return new МойПользовательDetailsService();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("http://localhost:3000/", "http://localhost:3000/basket", "http://localhost:3000/register","http://localhost:3000/katalog").permitAll()
                        .requestMatchers("http://localhost:3000/orders").authenticated()
                        .anyRequest().permitAll()
)
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("http://localhost:3000/login").permitAll()
//                                .loginProcessingUrl("http://localhost:3000/login").permitAll()
//                                .defaultSuccessUrl("http://localhost:3000/",true)
//                                .permitAll()
//                )

                .build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(пользовательDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


//        http.logout(lout -> lout.logoutSuccessUrl("/login?logout"));
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login")
//
//                )


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/basket", "/register","/katalog").permitAll()
//                        .anyRequest().denyAll()
//                )
////                .formLogin((form) -> form
////                        .loginPage("/login") // Страница входа
////                        .permitAll() // Разрешить доступ к странице входа всем
////                )
//                .httpBasic();
//
//        return http.build();
//    }
}