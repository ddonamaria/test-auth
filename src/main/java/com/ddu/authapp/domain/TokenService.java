package com.ddu.authapp.domain;

import com.ddu.authapp.infrastructure.adapters.in.api.TokenResponseDto;

public interface TokenService {

    TokenResponseDto getToken();
}
