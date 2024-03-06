package com.gamedex.backend.auth;

import com.gamedex.backend.auth.dto.AuthResponse;
import com.gamedex.backend.auth.dto.LoginPOSTRequest;
import com.gamedex.backend.auth.dto.RegisterPOSTRequest;

public interface AuthService {

    public AuthResponse login(LoginPOSTRequest request) throws Exception;

    public AuthResponse register(RegisterPOSTRequest request) throws Exception;

}
