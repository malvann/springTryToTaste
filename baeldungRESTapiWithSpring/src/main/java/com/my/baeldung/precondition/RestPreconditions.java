package com.my.baeldung.precondition;

import com.my.baeldung.exception.NullableRequest;
import com.my.baeldung.exception.SourceNotFoundException;

public class RestPreconditions {
    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new SourceNotFoundException();
        }
        return resource;
    }

    public static <T>void checkNotNull(T resource) {
        if (resource == null) throw new NullableRequest();
    }
}
