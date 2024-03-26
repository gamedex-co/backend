package com.gamedex.backend.auth;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamedex.backend.auth.dto.AuthResponse;
import com.gamedex.backend.auth.dto.LoginPOSTRequest;
import com.gamedex.backend.auth.dto.RegisterPOSTRequest;
import com.gamedex.backend.user.UserEntity;
import com.gamedex.backend.user.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginPOSTRequest request) throws Exception {
        if (request != null) {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

            String token = jwtService.getToken(user);

            return AuthResponse.builder()
                    .accessToken(token)
                    .build();
        }

        throw new Exception("User is null");
    }

    @Override
    public AuthResponse register(RegisterPOSTRequest request) throws Exception {
        if (request != null) {
            UserEntity user = new UserEntity();
            BeanUtils.copyProperties(request, user);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);

            return AuthResponse.builder()
                    .accessToken(jwtService.getToken(user))
                    .build();
        }

        throw new Exception("User is null");
    }

}
