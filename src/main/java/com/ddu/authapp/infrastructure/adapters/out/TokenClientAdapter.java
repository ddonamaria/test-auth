package com.ddu.authapp.infrastructure.adapters.out;


import com.ddu.authapp.application.ports.out.TokenClientPort;
import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenRequest;
import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenResponse;
import com.ddu.authapp.infrastructure.exceptions.TokenNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TokenClientAdapter implements TokenClientPort {

    private final VivelibreClient vivelibreClient;

    public TokenClientAdapter(VivelibreClient vivelibreClient) {
        this.vivelibreClient = vivelibreClient;
    }

    @Override
    public String getToken() {
        ViveLibreTokenRequest request = new ViveLibreTokenRequest("auth-vivelibre", "password");
        ViveLibreTokenResponse token = vivelibreClient.getToken("application/json", request);

        if (token == null || token.getToken() == null) {
            throw new TokenNotFoundException("Could not obtain a valid token");
        }

        return token.getToken();
    }
}
