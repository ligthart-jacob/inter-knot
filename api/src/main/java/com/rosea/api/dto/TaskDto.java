package com.rosea.api.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rosea.api.model.Task;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DailyTaskDto.class, name = "daily"),
        @JsonSubTypes.Type(value = RegularTaskDto.class, name = "regular")
})
public sealed class TaskDto permits DailyTaskDto, RegularTaskDto {
    private int id;
    @NotNull(message = "A task needs a name")
    private String name;
    private List<TaskDto> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getChildren() {
        return children;
    }

    public void setChildren(List<TaskDto> children) {
        this.children = children;
    }
}
