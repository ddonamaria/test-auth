package com.ddu.authapp.infrastructure.adapters.in.api;

import com.ddu.authapp.domain.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController implements TokenApi {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<TokenResponseDto> getToken() {
        return ResponseEntity.ok(tokenService.getToken());
    }
}
