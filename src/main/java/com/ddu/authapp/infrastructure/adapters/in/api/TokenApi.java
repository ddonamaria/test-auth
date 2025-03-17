/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ddu.authapp.infrastructure.adapters.in.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.openapitools.api.ApiUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T15:11:18.820157300+01:00[Europe/Madrid]")
@Validated
@Tag(name = "token", description = "the token API")
public interface TokenApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /token : get Token
     * Returns a token obtained from an external service, accompanied by the current date and time in ISO 8601 format. 
     *
     * @return Successful. (status code 200)
     *         or Token not found. (status code 404)
     *         or Internal server error. (status code 500)
     */
    @Operation(
        operationId = "getToken",
        summary = "get Token",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TokenResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Token not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/token",
        produces = { "application/json" }
    )
    default ResponseEntity<TokenResponseDto> getToken(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"token\" : \"RECEIVED_TOKEN\", \"timestamp\" : \"2025-02-27T14:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
