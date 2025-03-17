package com.ddu.authapp.infrastructure.adapters.out;

import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenRequest;
import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenResponse;
import com.ddu.authapp.infrastructure.exceptions.TokenNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TokenClientAdapterTest {

    @Mock
    private VivelibreClient vivelibreClient;

    @InjectMocks
    private TokenClientAdapter tokenClientAdapter;

    @BeforeEach
    void setUp() {
        tokenClientAdapter = new TokenClientAdapter(vivelibreClient);
    }

    @Test
    void getToken_returnsOk() {
        ViveLibreTokenRequest request = new ViveLibreTokenRequest("auth-vivelibre", "password");
        ViveLibreTokenResponse response = new ViveLibreTokenResponse("mockedToken");

        when(vivelibreClient.getToken("application/json", request)).thenReturn(response);

        String token = tokenClientAdapter.getToken();

        assertNotNull(token);
        assertEquals("mockedToken", token);
        verify(vivelibreClient, times(1)).getToken("application/json", request);
    }

    @Test
    void getToken_ResponseNull_throwsTokenNotFoundException() {
        ViveLibreTokenRequest request = new ViveLibreTokenRequest("auth-vivelibre", "password");
        when(vivelibreClient.getToken("application/json", request)).thenReturn(null);

        assertThrows(TokenNotFoundException.class, tokenClientAdapter::getToken);
        verify(vivelibreClient, times(1)).getToken("application/json", request);
    }

    @Test
    void getToken_tokenNull_throwsTokenNotFoundException() {
        ViveLibreTokenRequest request = new ViveLibreTokenRequest("auth-vivelibre", "password");
        ViveLibreTokenResponse response = new ViveLibreTokenResponse(null);

        when(vivelibreClient.getToken("application/json", request)).thenReturn(response);

        assertThrows(TokenNotFoundException.class, tokenClientAdapter::getToken);
        verify(vivelibreClient, times(1)).getToken("application/json", request);
    }
}