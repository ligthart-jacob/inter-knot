package com.rosea.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@DiscriminatorValue("REGULAR")
public class RegularTask extends Task {

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean completed = false;

    @Temporal(TemporalType.TIMESTAMP)
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

    @Override
    public RegularTask complete(Instant _date) {
        this.setCompleted(!this.isCompleted());
        return this;
    }
}
