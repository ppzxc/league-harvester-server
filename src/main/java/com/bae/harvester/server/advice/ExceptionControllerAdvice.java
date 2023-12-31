package com.bae.harvester.server.advice;

import java.net.URI;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ErrorResponse exception(Exception e, WebRequest request) {
    log.error("controllerAdvice: Exception", e);
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problemDetail.setTitle("Unknown");
    problemDetail.setDetail("Unknown");
    problemDetail.setInstance(URI.create(((ServletWebRequest) request).getRequest().getRequestURI()));
    problemDetail.setProperties(Map.of("exception", e.getMessage()));
    return ErrorResponse.builder(e, problemDetail).build();
  }
}
