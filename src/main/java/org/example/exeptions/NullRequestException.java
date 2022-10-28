package org.example.exeptions;

public class NullRequestException extends RuntimeException {
    public NullRequestException() {
    }

    public NullRequestException(String message) {
        super(message);
    }

    public NullRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullRequestException(Throwable cause) {
        super(cause);
    }

    public NullRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
