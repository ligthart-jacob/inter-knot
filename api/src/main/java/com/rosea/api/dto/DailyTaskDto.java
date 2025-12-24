package com.rosea.api.dto;

import java.util.ArrayList;
import java.util.List;


public final class DailyTaskDto extends TaskDto {
    private List<CompletionDto> completions = new ArrayList<>();

    public List<CompletionDto> getCompletions() {
        return completions;
    }

    public void setCompletions(List<CompletionDto> completions) {
        this.completions = completions;
    }
}
