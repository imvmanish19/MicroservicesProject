package com.manish.ProductService.error;

public class ProductException extends RuntimeException {

    String responseCode;
    int httpCode;
    public ProductException(String responseCode, int httpCode, String message) {
        super(message);
        this.responseCode = responseCode;
        this.httpCode = httpCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}
