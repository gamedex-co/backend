package com.gamedex.backend.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamedex.backend.auth.dto.AuthResponse;
import com.gamedex.backend.auth.dto.LoginPOSTRequest;
import com.gamedex.backend.auth.dto.RegisterPOSTRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Auth")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Login with username and password")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginPOSTRequest request) throws Exception {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterPOSTRequest request) throws Exception {
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }

}
