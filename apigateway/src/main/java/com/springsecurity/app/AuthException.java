package com.springsecurity.app;

/**
 * AuthException class
 *
 * @author BGH58082
 */
public class AuthException extends ApiException {
    public AuthException(String message, String errorCode) {
        super(message, errorCode);
    }
}
