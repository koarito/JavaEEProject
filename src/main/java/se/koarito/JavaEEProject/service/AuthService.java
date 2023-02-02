package se.koarito.JavaEEProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import se.koarito.JavaEEProject.Response.AuthResponse;
import se.koarito.JavaEEProject.config.PasswordConfig;
import se.koarito.JavaEEProject.data.domain.User;
import se.koarito.JavaEEProject.data.enm.Role;
import se.koarito.JavaEEProject.data.requestbody.AuthRequest;
import se.koarito.JavaEEProject.data.requestbody.UserRequest;
import se.koarito.JavaEEProject.repository.UserRepository;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordConfig passwordConfig;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse createUser(UserRequest requestBody){
        User user = User.builder()
                .firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName())
                .email(requestBody.getEmail())
                .password(passwordConfig.bCryptEncoder().encode(requestBody.getPassword()))
                .role(Role.valueOf(requestBody.getRole()))
                .build();
        userRepository.save(user).getId();
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse authenticate(AuthRequest authRequest){
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();
    //todo - add email or id to payload
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        return AuthResponse.builder().token(jwtToken).build();
    }
}
