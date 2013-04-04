package com.jci.server.email;

public class IllegalEmailException extends IllegalArgumentException {
    private static final String MESSAGE = "Email construction: Parameters Error: to=%s from=%s subject=%s body=%s";

    public IllegalEmailException(String to, String from, String subject, String body) {
        super(String.format(MESSAGE, to, from, subject, body));
    }
}
