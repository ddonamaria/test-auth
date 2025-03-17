package com.ddu.authapp.infrastructure.adapters.out.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViveLibreTokenRequest {
    private String username;
    private String password;
}
