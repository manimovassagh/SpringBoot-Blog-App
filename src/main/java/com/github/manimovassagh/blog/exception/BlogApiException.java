package com.github.manimovassagh.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * Exception to handle custom error messages and path it to user
 */

@Getter
public class BlogApiException extends RuntimeException{
    /**
     * status path to user
     */
    private HttpStatus status;
    private  String message;


    public BlogApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
