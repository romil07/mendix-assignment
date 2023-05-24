package com.mendix.exceptions;

public class MendixBadDataException extends RuntimeException {
    public MendixBadDataException(String message) {
        super(message);
    }

    public MendixBadDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
