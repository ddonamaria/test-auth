package com.ddu.authapp.infrastructure.adapters.out;

import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenRequest;
import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "vivelibre", url = "${feign.client.vivelibre.url}")
public interface VivelibreClient {

    @PostMapping(value = "/token")
    ViveLibreTokenResponse getToken(@RequestHeader("accept") String contentType, @RequestBody ViveLibreTokenRequest viveLibreTokenRequest);
}
