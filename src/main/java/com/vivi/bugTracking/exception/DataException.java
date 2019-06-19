package com.vivi.bugTracking.exception;

public class DataException extends RuntimeException {
    private String type;

    public DataException(String message, Throwable cause, String type) {
        super(message, cause);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static final String EMPLOYEE = "Employee";
    public static final String BUG = "Bug";
}
