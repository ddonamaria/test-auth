package com.ddu.authapp.infrastructure.adapters.in.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TokenResponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TokenResponseDto {

  @JsonProperty("token")
  private String token;

  @JsonProperty("timestamp")
  private String timestamp;

  public TokenResponseDto token(String token) {
    this.token = token;
    return this;
  }

  /**
   * The token received from the external service.
   * @return token
  */
  @NotNull 
  @Schema(name = "token", example = "RECEIBED_TOKEN", description = "The token received from the external service.", required = true)
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public TokenResponseDto timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Date and time the token was obtained.
   * @return timestamp
  */
  @NotNull 
  @Schema(name = "timestamp", example = "2025-02-27T14:00:00Z", description = "Date and time the token was obtained.", required = true)
  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenResponseDto tokenResponseDto = (TokenResponseDto) o;
    return Objects.equals(this.token, tokenResponseDto.token) &&
        Objects.equals(this.timestamp, tokenResponseDto.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenResponseDto {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

