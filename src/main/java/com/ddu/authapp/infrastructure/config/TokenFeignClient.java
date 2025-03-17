package com.ddu.authapp.infrastructure.config;

import com.ddu.authapp.infrastructure.adapters.out.dto.ViveLibreTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "vivelibreClient", url = "${feign.client.vivelibre.url}")
public interface TokenFeignClient {

    @PostMapping(value = "/token")
    String getToken(@RequestHeader("accept") String contentType, @RequestBody ViveLibreTokenRequest viveLibreTokenRequest);
}
