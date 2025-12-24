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

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Completion() {
    }

    public Completion(Task task, Instant date) {
        this.task = task;
        this.date = date;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
