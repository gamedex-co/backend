package com.gamedex.backend.auth.dto;

import com.gamedex.backend.user.enums.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPOSTRequest {
    private String username;
    private String email;
    private String password;
    private RoleEnum role;
    private String country;
}
