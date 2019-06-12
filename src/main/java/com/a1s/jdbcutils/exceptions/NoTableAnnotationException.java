package com.a1s.jdbcutils.exceptions;

public class NoTableAnnotationException extends RuntimeException {
    public NoTableAnnotationException() {
        super();
    }

    public NoTableAnnotationException(String message) {
        super(message);
    }

    public NoTableAnnotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoTableAnnotationException(Throwable cause) {
        super(cause);
    }

    protected NoTableAnnotationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
