package com.tech.mojo.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private HttpStatus httpStatus;
    private boolean isSuccess;
    private String message;

    public Response(HttpStatus notAcceptable, boolean b, String message) {
        this.httpStatus=notAcceptable;
        this.isSuccess=b;
        this.message=message;
    }
}
