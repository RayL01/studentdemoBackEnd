package com.lhr.studentdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/19/15:25
 * @Description:
 */

@RestControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(value = {ApiRequestException.class})
  public ResponseEntity<Object> handleIllegalStateException(ApiRequestException e) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    ApiException apiException = new ApiException(
            e.getMessage(),
            e,
            badRequest,
            ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(apiException, badRequest);
  }
}
