package com.rosea.api.dto;

import com.rosea.api.model.RegularTask;
import com.rosea.api.model.Task;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.Instant;

public final class RegularTaskDto extends TaskDto {
    private boolean completed = false;
    private Instant date;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
