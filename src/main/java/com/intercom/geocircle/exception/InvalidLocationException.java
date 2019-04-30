package com.intercom.geocircle.exception;

/**
 * Thrown when latitude or longitude of a location is wrong.
 */
public class InvalidLocationException extends RuntimeException {
    public InvalidLocationException(String message) {
        super(message);
    }

    public InvalidLocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
