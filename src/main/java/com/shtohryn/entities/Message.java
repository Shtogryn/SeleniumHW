package com.shtohryn.entities;

public class Message {
    private String email;
    private String subject;
    private String message;

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public Message() {
        this.email = "pavlo.stogryn@gmail.com";
        this.subject = "Test  message";
        this.message = "Hello";
    }
}
