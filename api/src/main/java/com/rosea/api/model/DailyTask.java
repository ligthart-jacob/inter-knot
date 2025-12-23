package com.rosea.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.JoinFormula;

import java.time.Instant;
import java.util.List;

@Entity
@DiscriminatorValue("DAILY")
public class DailyTask extends Task {
    @OneToMany(fetch = FetchType.EAGER)
    private List<Completion> completions;

    public boolean isCompleted(Instant date) {
        return getCompletions().stream().anyMatch(c -> c.getDate() == date);
    }

    public List<Completion> getCompletions() {
        return completions;
    }

    public void setCompletions(List<Completion> completions) {
        this.completions = completions;
    }

    @Override
    public Task complete(Instant date) {
        // Add the completion to the list of completions
        getCompletions().add(new Completion(
                date,
                !isCompleted(date)
        ));
        return this;
    }
}
