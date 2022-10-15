package org.example.exeptions;

public class OutOfListSizeException extends RuntimeException {
    public OutOfListSizeException() {
    }

    public OutOfListSizeException(String message) {
        super(message);
    }

    public OutOfListSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfListSizeException(Throwable cause) {
        super(cause);
    }

    public OutOfListSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
