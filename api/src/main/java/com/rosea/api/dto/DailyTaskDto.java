package com.rosea.api.dto;

import com.rosea.api.model.Completion;

import java.util.ArrayList;
import java.util.List;


public final class DailyTaskDto extends TaskDto {
    private List<Completion> completions = new ArrayList<>();

    public List<Completion> getCompletions() {
        return completions;
    }

    public void setCompletions(List<Completion> completions) {
        this.completions = completions;
    }
}
