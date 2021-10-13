package com.service.core.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class RestDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleException(Exception ex) {
        log.error(RestConstant.RESPONSE_SERVER_ERROR, ex);
        return new ResponseEntity<>(ErrorMessage.builder().message(RestConstant.RESPONSE_SERVER_ERROR).details(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
