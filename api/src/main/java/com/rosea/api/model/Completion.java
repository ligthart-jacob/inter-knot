package com.rosea.api.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Completion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant date;
    private boolean completed;

    public Completion() {
    }

    public Completion(Instant date, boolean completed) {
        this.date = date;
        this.completed = completed;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
