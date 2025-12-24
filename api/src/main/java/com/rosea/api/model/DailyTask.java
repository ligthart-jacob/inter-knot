package com.rosea.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.JoinFormula;

import java.time.Instant;
import java.util.List;

@Entity
@DiscriminatorValue("DAILY")
public class DailyTask extends Task {
    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
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
        // Try to get the completion matching the date from the list of completions
        Completion completion = getCompletions().stream()
                .filter(c -> c.getDate().compareTo(date) == 0)
                .findFirst()
                .orElse(null);
        // If there are no matching completions, create a new one
        if (completion == null) {
            // Add the completion to the list of completions
            getCompletions().add(new Completion(this, date));
        }
        else {
            getCompletions().remove(completion);
        }
        return this;
    }
}
