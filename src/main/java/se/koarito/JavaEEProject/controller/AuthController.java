package se.koarito.JavaEEProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.koarito.JavaEEProject.Response.AuthResponse;
import se.koarito.JavaEEProject.data.requestbody.UserRequest;
import se.koarito.JavaEEProject.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    private ResponseEntity<AuthResponse> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authService.createUser(userRequest));
    }


}
