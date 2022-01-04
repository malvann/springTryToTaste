package com.my.baeldung.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullableRequest extends RuntimeException {
    public NullableRequest() {
    }

    public NullableRequest(String message) {
        super(message);
    }

    public NullableRequest(String message, Throwable cause) {
        super(message, cause);
    }

    public NullableRequest(Throwable cause) {
        super(cause);
    }
}
