package org.quizard.services.domain;

public class Status {
    private String status = "OK";
    private String message = "Running on Port 8080";

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
