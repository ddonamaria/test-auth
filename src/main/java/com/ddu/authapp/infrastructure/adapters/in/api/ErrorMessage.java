package com.ddu.authapp.infrastructure.adapters.in.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorMessage {

  private HttpStatus status;
  private String message;

}
