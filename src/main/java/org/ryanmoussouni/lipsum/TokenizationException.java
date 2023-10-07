package org.ryanmoussouni.lipsum;

public class TokenizationException extends Exception {
    public TokenizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenizationException(Throwable cause) {
        super(cause);
    }
}
