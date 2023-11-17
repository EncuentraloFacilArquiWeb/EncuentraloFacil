package com.com.EncuentraloFacil.config;

import com.com.EncuentraloFacil.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        return http
                // ? CSRF: Es el que se encarga de manejar los tokens CSRF (Spring Security) ? //

                .csrf(csrf -> csrf.disable())

                // ? CORS: Permite que la aplicación acepte solicitudes CORS de cualquier origen (*) para métodos HTTP comunes (GET, HEAD, POST) ? //

                .cors(cors -> cors.configurationSource(request -> {

                    CorsConfiguration configuration = new CorsConfiguration();

                    // Define los métodos permitidos

                    configuration.setAllowedMethods(Arrays.asList(

                            HttpMethod.GET.name(),

                            HttpMethod.POST.name(),

                            HttpMethod.PUT.name(),

                            HttpMethod.DELETE.name(),

                            HttpMethod.PATCH.name(),

                            HttpMethod.OPTIONS.name()

                    ));

                    // Permite cualquier origen y cualquier encabezado

                    configuration.setAllowedOrigins(Arrays.asList("*"));

                    configuration.setAllowedHeaders(Arrays.asList("*"));

                    return configuration;

                }))
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/api/product").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
