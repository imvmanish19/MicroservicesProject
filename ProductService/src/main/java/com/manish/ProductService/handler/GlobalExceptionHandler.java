package com.manish.ProductService.handler;

import com.manish.ProductService.error.ErrorResponse;
import com.manish.ProductService.error.ProductException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleProductException(ProductException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getResponseCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(ex.getHttpCode()));
    }
}
