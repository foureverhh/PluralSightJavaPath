package com.foureverhh.wiredbrain.friends.utils;

public class FieldErrorMessage {
    private String field;
    private String message;

    public FieldErrorMessage(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getError() {
        return field;
    }

    public void setError(String error) {
        this.field = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
