package com.my.baeldung.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SourceNotFoundException extends RuntimeException{
    public SourceNotFoundException() {
    }

    public SourceNotFoundException(String message) {
        super(message);
    }

    public SourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
