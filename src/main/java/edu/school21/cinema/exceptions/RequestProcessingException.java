package edu.school21.cinema.exceptions;

public class RequestProcessingException extends RuntimeException{
    private final int errorCode;

    public RequestProcessingException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
