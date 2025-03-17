package com.ddu.authapp.application.usecases;

import com.ddu.authapp.application.ports.out.TokenClientPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenServiceImplTest {

    @Mock
    private TokenClientPort tokenClientPort;

    @InjectMocks
    private TokenServiceImpl tokenServiceImpl;

    @Test
    void getToken() {
        when(tokenClientPort.getToken()).thenReturn("mockedToken");

        var result = tokenServiceImpl.getToken();

        assertNotNull(result);
        assertNotNull(result.getToken());
        assertNotNull(result.getTimestamp());
    }

}