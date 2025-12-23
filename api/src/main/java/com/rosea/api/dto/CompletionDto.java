package com.rosea.api.dto;

import java.time.Instant;

public class CompletionDto {
    private Instant date;
    private boolean completed;

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
