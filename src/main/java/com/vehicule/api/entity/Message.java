package com.vehicule.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private User sender;
    private User receiver;
    private String message;
    private LocalDateTime date;

    // Constructors
    public Message() {
    }

    public Message(User sender, User receiver, String message, LocalDateTime date) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
    }

    // Getters
    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
