package com.com.jwtdemo.service;

import com.com.jwtdemo.model.*;
import com.com.jwtdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        //UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        User _user =userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(_user);
        return AuthResponse.builder()
                .token(token)
                .role(_user.getRole().name())
                .build();

    }

    public AuthResponse register(RegisterRequest request) {//AQUÍ SE REGISTRA EL ROL
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}
