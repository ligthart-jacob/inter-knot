package com.rosea.api.mapper;

import com.rosea.api.dto.DailyTaskDto;
import com.rosea.api.dto.RegularTaskDto;
import com.rosea.api.dto.TaskDto;
import com.rosea.api.model.DailyTask;
import com.rosea.api.model.RegularTask;
import com.rosea.api.model.Task;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        config = GlobalConfig.class
)
public interface TaskMapper {

    @SubclassMapping(source = RegularTaskDto.class, target = RegularTask.class)
    @SubclassMapping(source = DailyTaskDto.class, target = DailyTask.class)
    Task toEntity(TaskDto dto);

    @SubclassMapping(source = RegularTask.class, target = RegularTaskDto.class)
    @SubclassMapping(source = DailyTask.class, target = DailyTaskDto.class)
    TaskDto toDto(Task entity);

    @Named("mapChildren")
    default List<Task> mapChildren(List<TaskDto> children) {
        if (children == null) return null;
        return children.stream()
                .map(this::toEntity)
                .toList();
    }

    @Named("mapChildrenDto")
    default List<TaskDto> mapChildrenDto(List<Task> children) {
        if (children == null) return null;
        return children.stream()
                .map(this::toDto)
                .toList();
    }

    @AfterMapping
    default void setParentRecursively(@MappingTarget Task parent) {
        if (parent.getChildren() == null) return;
        for (Task child : parent.getChildren()) {
            child.setParent(parent);
            setParentRecursively(child);
        }
    }
}
