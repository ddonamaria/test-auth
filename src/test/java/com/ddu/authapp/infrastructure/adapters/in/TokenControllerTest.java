package com.ddu.authapp.infrastructure.adapters.in;

import com.ddu.authapp.domain.TokenService;
import com.ddu.authapp.infrastructure.adapters.in.api.TokenController;
import com.ddu.authapp.infrastructure.adapters.in.api.TokenResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenControllerTest {

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private TokenController tokenController;

    @Test
    void getToken() {
        when(tokenService.getToken()).thenReturn(new TokenResponseDto());
        var result = tokenController.getToken();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
    }

}