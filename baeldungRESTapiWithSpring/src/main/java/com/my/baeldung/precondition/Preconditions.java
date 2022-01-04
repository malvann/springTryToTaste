package com.my.baeldung.precondition;

import com.my.baeldung.exception.NullableRequest;

public class Preconditions {
    public static <T> void checkNotNull(T resource) {
        if (resource == null) throw new NullableRequest();
    }
}
