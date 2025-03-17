package com.ddu.authapp.application.usecases;

import com.ddu.authapp.application.ports.out.TokenClientPort;
import com.ddu.authapp.domain.TokenService;
import com.ddu.authapp.infrastructure.adapters.in.api.TokenResponseDto;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static com.ddu.authapp.infrastructure.config.Constants.DATE_TIME_FORMAT_PATTERN;

@Service
public class TokenServiceImpl implements TokenService {
    
    private final TokenClientPort tokenClientPort;

    public TokenServiceImpl(TokenClientPort tokenClientPort) {
        this.tokenClientPort = tokenClientPort;
    }

    @Override
    public TokenResponseDto getToken() {
        String vivelibreToken = tokenClientPort.getToken();
        return buildTokenResponseDto(vivelibreToken);
    }

    private TokenResponseDto buildTokenResponseDto(String token) {
        TokenResponseDto tokenResponseDto = new TokenResponseDto();
        tokenResponseDto.setToken(token);
        tokenResponseDto.setTimestamp(getOffsetDateTimeNow());
        return tokenResponseDto;
    }

    private String getOffsetDateTimeNow() {
        OffsetDateTime nowUtc = OffsetDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN);
        return nowUtc.format(formatter);
    }
}
