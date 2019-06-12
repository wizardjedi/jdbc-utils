package com.a1s.jdbcutils.exceptions;

public class NoIdFieldException extends RuntimeException {
    public NoIdFieldException() {
    }

    public NoIdFieldException(String message) {
        super(message);
    }

    public NoIdFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoIdFieldException(Throwable cause) {
        super(cause);
    }

    public NoIdFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
